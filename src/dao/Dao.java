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

	public static Connection getConnection() throws SQLException
	 {
		String user = "train2018";
		String pass = "train2018";
		String servername = "localhost:3306";
		String dbname = "new_schema";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


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
