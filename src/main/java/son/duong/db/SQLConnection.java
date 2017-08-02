package son.duong.db;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SQLConnection {
	public static Connection getConnection() throws Exception{
		Connection conn = null;
		InitialContext context = new InitialContext();
		DataSource dataSource = (DataSource) context.lookup("java:/MySqlDS");
		conn = dataSource.getConnection();
		return conn;
	}
}
