package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Dao
{
     protected Connection con;


     public Dao(Connection con)
     {
        this.con = con;
     }


    public static Connection getConnection() throws SQLException, ClassNotFoundException
     {
        String user = "train2018";
        String pass = "train2018";
        String servername = "localhost:3306";
        String dbname = "new_schema";

        Class.forName("com.mysql.jdbc.Driver");

        Connection c = DriverManager.getConnection(
                    "jdbc:mysql://"
                    + servername
                    + "/"
                    + dbname,
                    user,
                    pass);

        return c;
     }

}
