package dao;
import connection.MyConnection;

import java.awt.JobAttributes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductDao {
	private static Connection con = MyConnection.getConnection();
	private static PreparedStatement ps;
	private static Statement st;
	private static ResultSet rs;
	
	// get product table max row
		public static int getMaxRow() {
			int row = 0;
			try {
				st = con.createStatement();
				rs = st.executeQuery("select max(pid) from product");
				while (rs.next()){
					row = rs.getInt(1);
				}
			}catch(SQLException ex) {
				Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null,ex);
			}
			return row+1;
		}
	
		public static int countCategories() {
			int total = 0;
			try {
				st = con.createStatement();
				rs = st.executeQuery("select count(*) as 'total' from category");
				if (rs.next()) {
					total = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return total;
		}
		
		public static String[] getCat() {
			String[] categories = new String[countCategories()];
			try {
				st = con.createStatement();
				rs = st.executeQuery("select * from category");
				int i = 0;
				while (rs.next()) {
					categories[i] = rs.getString(2);
					i++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return categories;
		}
		
		//check product id already exist
		public static boolean isIDExist(int id) {
			try {
				ps = con.prepareStatement("select * from product where pid=?");
				ps.setInt(1, id);
				rs = ps.executeQuery();
				if (rs.next()) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
		
		//check product and category existed
		public static boolean isProCatExist(String pro, String cat) {
			try {
				ps = con.prepareStatement("select * from product where pname=? and cname=?");
				ps.setString(1, pro);
				ps.setString(2, cat);
				rs = ps.executeQuery();
				if (rs.next()) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
		
		//insert data to product table
				public static void insert(int id, String pname, String cname, int qty, double price) {
					String sql = "insert into product values(?,?,?,?,?)";
					try {
						ps = con.prepareStatement(sql);
						ps.setInt(1, id);
						ps.setString(2, pname);
						ps.setString(3, cname);
						ps.setInt(4, qty);
						ps.setDouble(5, price);
						if (ps.executeUpdate()>0) {
							JOptionPane.showMessageDialog(null, "Product added successfully");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
				//get product data in table (search by pid, pname, cname)
				public static void getProductValue(JTable table, String search) {
					String sql = "select * from product where concat (pid, pname, cname) like ? order by pid desc";
					try {
						ps = con.prepareStatement(sql);
						ps.setString(1, "%"+search+"%");
						rs = ps.executeQuery();
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						Object[] row;
						while (rs.next()) {
							row = new Object[5];
							row[0] = rs.getInt(1);
							row[1] = rs.getString(2);
							row[2] = rs.getString(3);
							row[3] = rs.getInt(4);
							row[4] = rs.getDouble(5);
							model.addRow(row);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				//update product data
				public static void update(int id, String pname, String cname, int qty, double price){
					String sql = "update product set pname=?, cname=?, pqty=?, pprice=? where pid=?";
					try {
						ps = con.prepareStatement(sql);
						ps.setString(1, pname);
						ps.setString(2, cname);
						ps.setInt(3, qty);
						ps.setDouble(4, price);
						ps.setInt(5, id);
						if (ps.executeUpdate()>0) {
							JOptionPane.showMessageDialog(null, "Product updated successfully");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				//delete product
				public static void delete(int pid) {
					int x = JOptionPane.showConfirmDialog(null, "Do you want to completely delete product?", "Delete product",JOptionPane.OK_CANCEL_OPTION,0);
					if (x == JOptionPane.OK_OPTION) {
						try {
							ps = con.prepareStatement("delete from product where pid = ?");
							ps.setInt(1, pid);
							if (ps.executeUpdate()>0) {
								JOptionPane.showMessageDialog(null, "Product deleted");
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
}
