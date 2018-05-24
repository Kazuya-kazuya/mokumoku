package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Dao
{
	 protected Connection con;

	 public Dao(Connection con) {
		super();
		this.con = con;
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException
	 {
		String user = "root";
		String pass = "root";
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

		//取得したコネクションの返却
		return c;
	 }

}
