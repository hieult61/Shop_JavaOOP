package dao;
import connection.MyConnection;
import user.ForgotPassword;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ForgotPasswordDao {
	private static Connection con = MyConnection.getConnection();
	private static PreparedStatement ps;
	private static Statement st;
	private static ResultSet rs;
	
	//check email already exist
	public static boolean isEmailExist(String email) {
		try {
			ps = con.prepareStatement("select * from user where uemail=?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				ForgotPassword.textField_1.setText(rs.getString(6));
				return true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Email address does not exist");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//get answer
	public static boolean getAns(String email, String newAns) {
		try {
			ps = con.prepareStatement("select * from user where uemail=?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				String oldAns = rs.getString(7);
				if (newAns.equals(oldAns)) {
					return true;
				}
				else {
					JOptionPane.showMessageDialog(null, "Answer did not match");
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//set new password
	public static void setPassword(String email, String pass) {
		String sql = "update user set upassword=? where uemail=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setString(2, email);
			if (ps.executeUpdate()>0) {
				JOptionPane.showMessageDialog(null, "Password updated successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
