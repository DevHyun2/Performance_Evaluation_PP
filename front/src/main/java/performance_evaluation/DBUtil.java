package performance_evaluation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	public static Connection dbConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "project";
		String passwod = "project";
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, userid, passwod);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void dbDisconnect(Connection conn, Statement st, ResultSet rs) {
		try {
			if (rs != null)	rs.close();
			if (st != null)	st.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
