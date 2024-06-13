package ConnectDB;
import java.sql.Connection;

import java.sql.DriverManager;
public class ConnectDB {
	private Connection con ;
	private static ConnectDB instance = null;	
	public static ConnectDB getInstance() {
		if (instance==null)
			instance = new ConnectDB();
		return instance;
	}
	public ConnectDB() {				
		try {
			String url = "jdbc:sqlserver://localhost:1433;databasename=QLTT;trustSeverCertificate=true";
			String user = "sa";
			String password = "123456";
			con = DriverManager.getConnection(url, user, password);		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}	
	
	public Connection getConnection() {
		return con;
	}
}
