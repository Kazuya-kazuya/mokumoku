package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Sex;
import vo.KaiinVo;

public class KaiinManager
{
    private Connection connection;


    public KaiinManager(Connection connection)
    {
        this.connection = connection;
    }


    private static final String KAIINNLIST_SQL =
            "select "
                    + "   id "
                    + "  ,name "
                    + "  ,date "
                    + "  ,sex "
                    + "from   "
                    + "   member ";

    private static final String KAIINN_SQL =
            "select "
                    + "   id "
                    + "  ,name "
                    + "  ,date "
                    + "  ,sex "
                    + "from   "
                    + "   member "
                    + "WHERE "
                    + " id = ? ";

    private static final String REGIIST_SQL =
            "insert " +
                    "into member( " +
                    "	id, " +
                    "    name ," +
                    "    date, " +
                    "    sex " +
                    ") " +
                    "values (" +
                    "	?, " +
                    "    ?, " +
                    "    ?, " +
                    "    ? " +
                    ")";


    public void doRegist(KaiinVo kaiin) throws SQLException
    {
        PreparedStatement stmt = null;

        stmt = this.connection.prepareStatement(REGIIST_SQL);

        stmt.setInt(1,kaiin.getId());
        stmt.setString(2,kaiin.getName());
        stmt.setDate(3,kaiin.getDate());
        stmt.setString(4, kaiin.getSex().toString());

        stmt.executeUpdate();

    }

    public KaiinVo doSearch(int id) throws SQLException
    {
        PreparedStatement stmt = null;
        ResultSet rset = null;
        KaiinVo kaiin = new KaiinVo();

        stmt = this.connection.prepareStatement(KAIINN_SQL);

        stmt.setInt(1,id);

        rset = stmt.executeQuery();

        while(rset.next())
        {
            kaiin.setId(rset.getInt(1));
            kaiin.setName(rset.getString(2));
            kaiin.setDate(rset.getDate(3));
            kaiin.setSex(Sex.valueOf(rset.getString(4)));
        }

        return kaiin;
    }

    public List<KaiinVo> doListout() throws SQLException
    {
        PreparedStatement stmt = null;
        ResultSet rset = null;
        List<KaiinVo> list = new ArrayList<KaiinVo>();;

        stmt = this.connection.prepareStatement(KAIINNLIST_SQL);

        rset = stmt.executeQuery();

        while(rset.next())
        {
            KaiinVo kaiin = new KaiinVo();
            kaiin.setId(rset.getInt(1));
            kaiin.setName(rset.getString(2));
            kaiin.setDate(rset.getDate(3));
            kaiin.setSex(Sex.valueOf(rset.getString(4)));
            list.add(kaiin);
        }

        return list;
    }
}
