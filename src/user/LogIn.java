package user;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import connection.MyConnection;
import dao.StatisticsDao;
import supplier.SupplierDashboard;
import admin.AdminDashboard;

public class LogIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField textField;
	private static JPasswordField passwordField;
	private static LogIn frame;
	//////////////////////////////
	public static JLabel lblNewLabel_5;
	public static JLabel lblNewLabel_5_1;
	//////////////////////////////
	public static JRadioButton rdbtnNewRadioButton;
	public static JRadioButton rdbtnNewRadioButton_1;
	public static JRadioButton rdbtnNewRadioButton_2;
	public static StatisticsDao staDao = new StatisticsDao();
	private static ButtonGroup bg = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public LogIn() {
//		addWindowListener(new WindowAdapter() {               //set sleep time for each main frame
//			@Override
//			public void windowOpened(WindowEvent e) {
//				for (double i = 0.1; i<=1.0; i+= 0.1) {
//					String s = ""+i;
//					float f = Float.parseFloat(s);
//					frame.setOpacity(f);
//					try {
//						Thread.sleep(40);
//					}catch(InterruptedException ex) {
//						Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE,null,ex);
//					}
//				}
//			}
//		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(103, 233, 230));
		panel.setBounds(0, 0, 231, 468);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(30, 40, 191, 211);
		lblNewLabel.setIcon(new ImageIcon(LogIn.class.getResource("/icons/logo.jpg")));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("THT");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(55, 262, 149, 50);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("COMPANY");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_1_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1_1.setBounds(55, 305, 149, 50);
		panel.add(lblNewLabel_1_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(230, 0, 405, 468);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("X");
		lblNewLabel_2.setBounds(348, 11, 33, 31);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		panel_1.setLayout(null);
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 30));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Login");
		lblNewLabel_3.setBounds(117, 61, 133, 61);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(121, 182, 224, 31);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(121, 233, 224, 31);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(passwordField);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(24, 186, 87, 27);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Password");
		lblNewLabel_4_1.setBounds(24, 241, 87, 23);
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_4_1);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setEchoChar((char)0);
				lblNewLabel_5.setVisible(false);
				lblNewLabel_5_1.setVisible(true);
			}
		});
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon(LogIn.class.getResource("/icons/hide.png")));
		lblNewLabel_5.setBounds(348, 243, 33, 21);
		panel_1.add(lblNewLabel_5);
		
		lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setEchoChar('*');
				lblNewLabel_5.setVisible(true);
				lblNewLabel_5_1.setVisible(false);
			}
		});
		lblNewLabel_5_1.setIcon(new ImageIcon(LogIn.class.getResource("/icons/visible.png")));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setBounds(348, 243, 33, 21);
		panel_1.add(lblNewLabel_5_1);
		
		rdbtnNewRadioButton = new JRadioButton("User");
		rdbtnNewRadioButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(24, 287, 65, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Supplier");
		rdbtnNewRadioButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		rdbtnNewRadioButton_1.setBounds(91, 287, 87, 23);
		panel_1.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Admin");
		rdbtnNewRadioButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		rdbtnNewRadioButton_2.setBounds(185, 287, 77, 23);
		panel_1.add(rdbtnNewRadioButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("Don't have an account ?");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(59, 396, 171, 23);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Sign Up!");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SignUp().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(236, 392, 67, 31);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Forgot password ?");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ForgotPassword().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(148, 434, 155, 23);
		panel_1.add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isEmpty()) {
					String email = textField.getText();
					String password = String.valueOf(passwordField.getPassword());
					if (rdbtnNewRadioButton.isSelected()) {
						try {
							Connection con = MyConnection.getConnection();
							PreparedStatement ps;
							ps = con.prepareStatement("select * from user where uemail=? and upassword=?");
							ps.setString(1, email);
							ps.setString(2, password);
							ResultSet rs = ps.executeQuery();
							if (rs.next()) {
								UserDashboard ud = new UserDashboard();
								ud.setVisible(true);
								UserDashboard.lblNewLabel_2.setText(email);
								staDao.user(rs.getInt(1));
								dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "Incorrect email or password", "Login failed", 2);
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					else if(rdbtnNewRadioButton_1.isSelected()){
						try {
							Connection con = MyConnection.getConnection();
							PreparedStatement ps;
							ps = con.prepareStatement("select * from supplier where semail=? and spassword=?");
							ps.setString(1, email);
							ps.setString(2, password);
							ResultSet rs = ps.executeQuery();
							if (rs.next()) {
								SupplierDashboard sd = new SupplierDashboard();
								sd.setVisible(true);
								SupplierDashboard.lblNewLabel_2.setText(email);
								staDao.supplier(rs.getString(2));
								dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "Incorrect email or password", "Login failed", 2);
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					else {
						try {
							Connection con = MyConnection.getConnection();
							PreparedStatement ps;
							ps = con.prepareStatement("select * from admin where email=? and password=?");
							ps.setString(1, email);
							ps.setString(2, password);
							ResultSet rs = ps.executeQuery();
							if (rs.next()) {
								AdminDashboard ad = new AdminDashboard();
								ad.setVisible(true);
								AdminDashboard.lblNewLabel_2.setText(email);
								staDao.admin();
								dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "Incorrect email or password", "Login failed", 2);
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(146, 333, 102, 40);
		panel_1.add(btnNewButton);
		
		//////////////////////////////
		init();
	}
	
	/**
	 * Sub functions
	 */
	public static void init() {
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton.setSelected(true);
	}
	
	public static boolean isEmpty() {
		if (textField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Email is required", "Warning", 2);
			return false;
		}
		if (!textField.getText().matches("^.+@.+\\..+$")) {
			JOptionPane.showMessageDialog(null, "Invalid email", "Warning", 2);
			return false;
		}
		if (String.valueOf(passwordField.getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(null, "Password is required", "Warning", 2);
			return false;
		}
		return true;
	}
}
