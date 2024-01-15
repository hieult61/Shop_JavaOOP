package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


public class MyConnection {
	public static final String username = "root";   // mysql username
	public static final String password = "lehieu6102";   // mysql password
	public static final String url = "jdbc:mysql://192.168.1.134:3306/Linh_kien_dien_tu";   // mysql url
//	public static final String username = "root";   // mysql username
//	public static final String password = "ngubaly";   // mysql password
//	public static final String url = "jdbc:mysql://192.168.1.2:3306/linh_kien_dien_tu";   // mysql url
	//NOTE
	//1. Start the database
	//2. Replace the IP address of the host
	public static Connection con = null;
	
	public static Connection getConnection() {
		try {
			con = DriverManager.getConnection(url,username,password);
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, ""+ex, "", JOptionPane.WARNING_MESSAGE);
		}
		return con;
	}
}
