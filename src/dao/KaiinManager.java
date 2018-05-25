package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.KaiinBean;
import bean.ListoutBean;
import bean.SearchBean;
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

	public SearchBean doSearch(int id) throws SQLException
	{
		PreparedStatement stmt = null;
		ResultSet rset = null;
		SearchBean bean = new SearchBean();

		stmt = this.connection.prepareStatement(KAIINN_SQL);

		stmt.setInt(1,id);

		rset = stmt.executeQuery();

		while(rset.next())
		{
			bean.setId(rset.getInt(1));
			bean.setName(rset.getString(2));
			bean.setDate(rset.getDate(3));
			bean.setSex(Sex.valueOf(rset.getString(4)));
			bean.setMessege("検索しました");
		}

		return bean;
	}

	public ListoutBean doListout() throws SQLException
	{
		PreparedStatement stmt = null;
		ResultSet rset = null;
		ListoutBean bean = new ListoutBean();

		stmt = this.connection.prepareStatement(KAIINNLIST_SQL);

		rset = stmt.executeQuery();

		while(rset.next())
		{
			KaiinBean kaiin = new KaiinBean();
			kaiin.setId(rset.getInt(1));
			kaiin.setName(rset.getString(2));
			kaiin.setDate(rset.getDate(3));
			kaiin.setSex(Sex.valueOf(rset.getString(4)));
			bean.getList().add(kaiin);
		}

		return bean;
	}
}
