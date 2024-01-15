package dao;
import connection.MyConnection;
import supplier.SupplierDashboard;
import user.UserDashboard;

import java.awt.JobAttributes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import admin.AdminDashboard;

public class StatisticsDao {
	private static Connection con = MyConnection.getConnection();
	private static PreparedStatement ps;
	private static Statement st;
	private static ResultSet rs;
	public static Date date = new Date();
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
	
	//return statistic total of database tables (admin)
	public static int total(String tableName) {
		int total = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select count(*) as 'total' from "+tableName+"");
			if (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	
	public static double totalSale() {
		double total = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select sum(total) as 'total' from purchase");
			if (rs.next()) {
				total = rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	
	public static double todaySale() {
		String today = df.format(date);
		double total = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select sum(total) as 'total' from purchase where p_date='"+today+"'");
			if (rs.next()) {
				total = rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	
	//admin dashboard
	public static void admin() {
		AdminDashboard.lblNewLabel_cat.setText(String.valueOf(total("category")));
		AdminDashboard.lblNewLabel_product.setText(String.valueOf(total("product")));
		AdminDashboard.lblNewLabel_user.setText(String.valueOf(total("user")));
		AdminDashboard.lblNewLabel_supplier.setText(String.valueOf(total("supplier")));
		AdminDashboard.lblNewLabel_todaysale.setText(String.valueOf(todaySale()));
		AdminDashboard.lblNewLabel_totalsale.setText(String.valueOf(totalSale()));
	}
	
	
	//supplier
	public static int totalDeliveries(String name) {
		int total = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select count(*) as 'total' from purchase where supplier='"+name+"' and status='Received'");
			if (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	
	//supplier dashboard
	public static void supplier(String name) {
		SupplierDashboard.lblNewLabel_deli.setText(String.valueOf(totalDeliveries(name)));
	}
	
	//user
	public static double totalPurchase(int id) {
		double total = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select sum(total) as 'total' from purchase where uid="+id+"");
			if (rs.next()) {
				total = rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	
	//user dashboard 
	public static void user(int id) {
		UserDashboard.lblNewLabel_cat.setText(String.valueOf(total("category")));
		UserDashboard.lblNewLabel_product.setText(String.valueOf(total("product")));
		UserDashboard.lblNewLabel_purchase.setText(String.valueOf(totalPurchase(id)));
	}
}
