package admin;

import java.awt.EventQueue;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import user.LogIn;

public class AdminDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static AdminDashboard frame;
	public static JLabel lblNewLabel_5;
	public static JLabel lblNewLabel_5_1;
	public static JLabel lblNewLabel_5_2;
	public static JLabel lblNewLabel_5_1_1;
	public static JLabel lblNewLabel_5_3;
	public static JLabel lblNewLabel_5_1_2;
	public static JLabel lblNewLabel_5_3_1;
	public static JLabel lblNewLabel_5_1_2_1;
	public static JLabel lblNewLabel_5_3_2;
	public static JLabel lblNewLabel_5_1_2_2;
	public static JLabel lblNewLabel_5_3_3;
	public static JLabel lblNewLabel_5_1_2_3;
	public static JLabel lblNewLabel_5_3_4;
	public static JLabel lblNewLabel_5_1_2_4;
	////////////////////////////////////////
	public static JPanel panel_4;
	public static JPanel panel_4_1;
	public static JPanel panel_4_2;
	public static JPanel panel_4_2_1;
	public static JPanel panel_4_2_2;
	public static JPanel panel_4_2_3;
	public static JPanel panel_4_2_4;
	////////////////////////////////////////
	public static JLabel lblNewLabel_4;
	public static JLabel lblNewLabel_4_1;
	public static JLabel lblNewLabel_4_2;
	public static JLabel lblNewLabel_4_2_1;
	public static JLabel lblNewLabel_4_2_2;
	public static JLabel lblNewLabel_4_2_3;
	public static JLabel lblNewLabel_4_2_4;
	public static JLabel lblNewLabel_2;
	///////////////////////////////////////
	public static JLabel lblNewLabel_cat;
	public static JLabel lblNewLabel_product;
	public static JLabel lblNewLabel_user;
	public static JLabel lblNewLabel_todaysale;
	public static JLabel lblNewLabel_supplier;
	public static JLabel lblNewLabel_totalsale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminDashboard();
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
	public AdminDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1023, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 11, 1009, 563);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1009, 66);
		panel_1.setBackground(new Color(60, 179, 113));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THT COMPANY");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(20, 11, 227, 44);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Log Out");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "Do you want to log out now?", "Log Out", JOptionPane.YES_NO_OPTION);
				if (a==0) {
					new LogIn().setVisible(true);
					//System.exit(0);
					dispose();
				}
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(AdminDashboard.class.getResource("/icons/logout.png")));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(899, 11, 100, 44);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("admin@gmail.com");
		lblNewLabel_2.setIcon(new ImageIcon(AdminDashboard.class.getResource("/icons/user.png")));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(660, 19, 217, 27);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 65, 248, 498);
		panel_2.setBackground(new Color(0, 0, 0));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 255));
		panel_3.setBounds(0, 26, 248, 48);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("DASHBOARD");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setBounds(0, 11, 248, 26);
		panel_3.add(lblNewLabel_3);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(0, 118, 248, 48);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 19, 48);
		panel_4.add(panel_5);
		panel_5.setBackground(Color.GREEN);
		
		lblNewLabel_4 = new JLabel("MANAGE CATEGORIES");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_4.setBackground(Color.GREEN);
				lblNewLabel_4.setForeground(Color.WHITE);
				lblNewLabel_5.setVisible(false);
				lblNewLabel_5_1.setVisible(true);
				ManageCategory manageCategory = new ManageCategory();
				manageCategory.setVisible(true);
				//manageCategory.pack();
			}
		});
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(65, 11, 173, 25);
		panel_4.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(AdminDashboard.class.getResource("/icons/category_dark.png")));
		lblNewLabel_5.setBounds(29, 11, 41, 25);
		panel_4.add(lblNewLabel_5);
		
		lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon(AdminDashboard.class.getResource("/icons/category_light.png")));
		lblNewLabel_5_1.setBounds(29, 11, 49, 25);
		panel_4.add(lblNewLabel_5_1);
		
		panel_4_1 = new JPanel();
		panel_4_1.setBackground(Color.LIGHT_GRAY);
		panel_4_1.setLayout(null);
		panel_4_1.setBounds(0, 165, 248, 48);
		panel_2.add(panel_4_1);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBackground(Color.GREEN);
		panel_5_1.setBounds(0, 0, 19, 48);
		panel_4_1.add(panel_5_1);
		
		lblNewLabel_4_1 = new JLabel("MANAGE PRODUCTS");
		lblNewLabel_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_4_1.setBackground(Color.GREEN);
				lblNewLabel_4_1.setForeground(Color.WHITE);
				lblNewLabel_5_2.setVisible(false);
				lblNewLabel_5_1_1.setVisible(true);
				ManageProduct manageProduct = new ManageProduct();
				manageProduct.setVisible(true);
			}
		});
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_1.setBounds(68, 11, 170, 25);
		panel_4_1.add(lblNewLabel_4_1);
		
		lblNewLabel_5_2 = new JLabel("");
		lblNewLabel_5_2.setIcon(new ImageIcon(AdminDashboard.class.getResource("/icons/product_dark.png")));
		lblNewLabel_5_2.setBounds(29, 11, 41, 25);
		panel_4_1.add(lblNewLabel_5_2);
		
		lblNewLabel_5_1_1 = new JLabel("");
		lblNewLabel_5_1_1.setIcon(new ImageIcon(AdminDashboard.class.getResource("/icons/product_light.png")));
		lblNewLabel_5_1_1.setBounds(29, 11, 49, 25);
		panel_4_1.add(lblNewLabel_5_1_1);
		
		panel_4_2 = new JPanel();
		panel_4_2.setBackground(Color.LIGHT_GRAY);
		panel_4_2.setLayout(null);
		panel_4_2.setBounds(0, 211, 248, 48);
		panel_2.add(panel_4_2);
		
		JPanel panel_5_2 = new JPanel();
		panel_5_2.setBackground(Color.GREEN);
		panel_5_2.setBounds(0, 0, 19, 48);
		panel_4_2.add(panel_5_2);
		
		lblNewLabel_4_2 = new JLabel("MANAGE USERS");
		lblNewLabel_4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_4_2.setBackground(Color.GREEN);
				lblNewLabel_4_2.setForeground(Color.WHITE);
				lblNewLabel_5_3.setVisible(false);
				lblNewLabel_5_1_2.setVisible(true);
				ManageUsers manageUsers = new ManageUsers();
				manageUsers.setVisible(true);
			}
		});
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_2.setBounds(67, 11, 171, 25);
		panel_4_2.add(lblNewLabel_4_2);
		
		lblNewLabel_5_3 = new JLabel("");
		lblNewLabel_5_3.setIcon(new ImageIcon(AdminDashboard.class.getResource("/icons/user_dark.png")));
		lblNewLabel_5_3.setBounds(29, 11, 41, 25);
		panel_4_2.add(lblNewLabel_5_3);
		
		lblNewLabel_5_1_2 = new JLabel("");
		lblNewLabel_5_1_2.setIcon(new ImageIcon(AdminDashboard.class.getResource("/icons/edit_user.png")));
		lblNewLabel_5_1_2.setBounds(29, 11, 49, 25);
		panel_4_2.add(lblNewLabel_5_1_2);
		
		panel_4_2_1 = new JPanel();
		panel_4_2_1.setLayout(null);
		panel_4_2_1.setBackground(Color.LIGHT_GRAY);
		panel_4_2_1.setBounds(0, 258, 248, 48);
		panel_2.add(panel_4_2_1);
		
		JPanel panel_5_2_1 = new JPanel();
		panel_5_2_1.setBackground(Color.GREEN);
		panel_5_2_1.setBounds(0, 0, 19, 48);
		panel_4_2_1.add(panel_5_2_1);
		
		lblNewLabel_4_2_1 = new JLabel("ADD SUPPLIER");
		lblNewLabel_4_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_4_2_1.setBackground(Color.GREEN);
				lblNewLabel_4_2_1.setForeground(Color.WHITE);
				lblNewLabel_5_3_1.setVisible(false);
				lblNewLabel_5_1_2_1.setVisible(true);
				AddSupplier addSupplier = new AddSupplier();
				addSupplier.setVisible(true);
			}
		});
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_2_1.setBounds(66, 11, 156, 25);
		panel_4_2_1.add(lblNewLabel_4_2_1);
		
		lblNewLabel_5_3_1 = new JLabel("");
		lblNewLabel_5_3_1.setIcon(new ImageIcon(AdminDashboard.class.getResource("/icons/supplier_dark.png")));
		lblNewLabel_5_3_1.setBounds(29, 11, 41, 25);
		panel_4_2_1.add(lblNewLabel_5_3_1);
		
		lblNewLabel_5_1_2_1 = new JLabel("");
		lblNewLabel_5_1_2_1.setIcon(new ImageIcon(AdminDashboard.class.getResource("/icons/supplier_light.png")));
		lblNewLabel_5_1_2_1.setBounds(29, 11, 49, 25);
		panel_4_2_1.add(lblNewLabel_5_1_2_1);
		
		panel_4_2_2 = new JPanel();
		panel_4_2_2.setLayout(null);
		panel_4_2_2.setBackground(Color.LIGHT_GRAY);
		panel_4_2_2.setBounds(0, 306, 248, 48);
		panel_2.add(panel_4_2_2);
		
		JPanel panel_5_2_2 = new JPanel();
		panel_5_2_2.setBackground(Color.GREEN);
		panel_5_2_2.setBounds(0, 0, 19, 48);
		panel_4_2_2.add(panel_5_2_2);
		
		lblNewLabel_4_2_2 = new JLabel("MANAGE SUPPLIERS");
		lblNewLabel_4_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_4_2_2.setBackground(Color.GREEN);
				lblNewLabel_4_2_2.setForeground(Color.WHITE);
				lblNewLabel_5_3_2.setVisible(false);
				lblNewLabel_5_1_2_2.setVisible(true);
				ManageSuppliers manageSuppliers = new ManageSuppliers();
				manageSuppliers.setVisible(true);
			}
		});
		lblNewLabel_4_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_2_2.setBounds(67, 11, 161, 25);
		panel_4_2_2.add(lblNewLabel_4_2_2);
		
		lblNewLabel_5_3_2 = new JLabel("");
		lblNewLabel_5_3_2.setIcon(new ImageIcon(AdminDashboard.class.getResource("/icons/edit_supplier_dark.png")));
		lblNewLabel_5_3_2.setBounds(29, 11, 41, 25);
		panel_4_2_2.add(lblNewLabel_5_3_2);
		
		lblNewLabel_5_1_2_2 = new JLabel("");
		lblNewLabel_5_1_2_2.setIcon(new ImageIcon(AdminDashboard.class.getResource("/icons/edit_supplier_light.png")));
		lblNewLabel_5_1_2_2.setBounds(29, 11, 49, 25);
		panel_4_2_2.add(lblNewLabel_5_1_2_2);
		
		panel_4_2_3 = new JPanel();
		panel_4_2_3.setLayout(null);
		panel_4_2_3.setBackground(Color.LIGHT_GRAY);
		panel_4_2_3.setBounds(0, 352, 248, 48);
		panel_2.add(panel_4_2_3);
		
		JPanel panel_5_2_3 = new JPanel();
		panel_5_2_3.setBackground(Color.GREEN);
		panel_5_2_3.setBounds(0, 0, 19, 48);
		panel_4_2_3.add(panel_5_2_3);
		
		lblNewLabel_4_2_3 = new JLabel("SELECT SUPPLIERS");
		lblNewLabel_4_2_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_4_2_3.setBackground(Color.GREEN);
				lblNewLabel_4_2_3.setForeground(Color.WHITE);
				lblNewLabel_5_3_3.setVisible(false);
				lblNewLabel_5_1_2_3.setVisible(true);
				SelectSupplier selectSupplier = new SelectSupplier();
				selectSupplier.setVisible(true);
			}
		});
		lblNewLabel_4_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_2_3.setBounds(67, 11, 155, 25);
		panel_4_2_3.add(lblNewLabel_4_2_3);
		
		lblNewLabel_5_3_3 = new JLabel("");
		lblNewLabel_5_3_3.setIcon(new ImageIcon(AdminDashboard.class.getResource("/icons/supplier_dark.png")));
		lblNewLabel_5_3_3.setBounds(29, 11, 41, 25);
		panel_4_2_3.add(lblNewLabel_5_3_3);
		
		lblNewLabel_5_1_2_3 = new JLabel("");
		lblNewLabel_5_1_2_3.setIcon(new ImageIcon(AdminDashboard.class.getResource("/icons/supplier_light.png")));
		lblNewLabel_5_1_2_3.setBounds(29, 11, 49, 25);
		panel_4_2_3.add(lblNewLabel_5_1_2_3);
		
		panel_4_2_4 = new JPanel();
		panel_4_2_4.setBounds(0, 399, 248, 48);
		panel_2.add(panel_4_2_4);
		panel_4_2_4.setLayout(null);
		panel_4_2_4.setBackground(Color.LIGHT_GRAY);
		
		JPanel panel_5_2_4 = new JPanel();
		panel_5_2_4.setBackground(Color.GREEN);
		panel_5_2_4.setBounds(0, 0, 19, 48);
		panel_4_2_4.add(panel_5_2_4);
		
		lblNewLabel_4_2_4 = new JLabel("TRANSACTION");
		lblNewLabel_4_2_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_4_2_4.setBackground(Color.GREEN);
				lblNewLabel_4_2_4.setForeground(Color.WHITE);
				lblNewLabel_5_3_4.setVisible(false);
				lblNewLabel_5_1_2_4.setVisible(true);
				Transaction transaction = new Transaction();
				transaction.setVisible(true);
			}
		});
		lblNewLabel_4_2_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_2_4.setBounds(64, 11, 163, 25);
		panel_4_2_4.add(lblNewLabel_4_2_4);
		
		lblNewLabel_5_3_4 = new JLabel("");
		lblNewLabel_5_3_4.setIcon(new ImageIcon(AdminDashboard.class.getResource("/icons/transaction_dark.png")));
		lblNewLabel_5_3_4.setBounds(29, 11, 41, 25);
		panel_4_2_4.add(lblNewLabel_5_3_4);
		
		lblNewLabel_5_1_2_4 = new JLabel("");
		lblNewLabel_5_1_2_4.setIcon(new ImageIcon(AdminDashboard.class.getResource("/icons/transaction_light.png")));
		lblNewLabel_5_1_2_4.setBounds(29, 11, 49, 25);
		panel_4_2_4.add(lblNewLabel_5_1_2_4);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(276, 91, 723, 163);
		panel_6.setBackground(Color.WHITE);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Statistics");
		lblNewLabel_6.setBounds(0, 11, 700, 20);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Total Categories");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(10, 47, 151, 24);
		panel_6.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("Total Products");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7_1.setBounds(10, 82, 127, 24);
		panel_6.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("Total Users");
		lblNewLabel_7_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7_1_1.setBounds(254, 52, 127, 24);
		panel_6.add(lblNewLabel_7_1_1);
		
		lblNewLabel_cat = new JLabel("0");
		lblNewLabel_cat.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_cat.setBounds(153, 52, 49, 14);
		panel_6.add(lblNewLabel_cat);
		
		lblNewLabel_product = new JLabel("0");
		lblNewLabel_product.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_product.setBounds(153, 87, 49, 14);
		panel_6.add(lblNewLabel_product);
		
		lblNewLabel_user = new JLabel("0");
		lblNewLabel_user.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_user.setBounds(391, 57, 49, 14);
		panel_6.add(lblNewLabel_user);
		
		JLabel lblNewLabel_7_1_1_1 = new JLabel("Today Sales");
		lblNewLabel_7_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7_1_1_1.setBounds(480, 47, 127, 24);
		panel_6.add(lblNewLabel_7_1_1_1);
		
		JLabel lblNewLabel_7_1_1_2 = new JLabel("Total Suppliers");
		lblNewLabel_7_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7_1_1_2.setBounds(254, 82, 127, 24);
		panel_6.add(lblNewLabel_7_1_1_2);
		
		lblNewLabel_todaysale = new JLabel("0.0");
		lblNewLabel_todaysale.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_todaysale.setBounds(603, 54, 49, 14);
		panel_6.add(lblNewLabel_todaysale);
		
		lblNewLabel_supplier = new JLabel("0");
		lblNewLabel_supplier.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_supplier.setBounds(391, 87, 49, 14);
		panel_6.add(lblNewLabel_supplier);
		
		JLabel lblNewLabel_7_1_1_1_1 = new JLabel("Total Sales");
		lblNewLabel_7_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7_1_1_1_1.setBounds(480, 82, 127, 24);
		panel_6.add(lblNewLabel_7_1_1_1_1);
		
		lblNewLabel_totalsale = new JLabel("0.0");
		lblNewLabel_totalsale.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_totalsale.setBounds(603, 89, 49, 14);
		panel_6.add(lblNewLabel_totalsale);
		
		//////////////////////////////
		init();
	}
	
	/**
	 * Sub functions
	 */
	public static void init() {
		icons();
	}

	public static void icons() {
		lblNewLabel_5.setVisible(true);
		lblNewLabel_5_1.setVisible(false);
		lblNewLabel_5_2.setVisible(true);
		lblNewLabel_5_1_1.setVisible(false);
		lblNewLabel_5_3.setVisible(true);
		lblNewLabel_5_1_2.setVisible(false);
		lblNewLabel_5_3_1.setVisible(true);
		lblNewLabel_5_1_2_1.setVisible(false);
		lblNewLabel_5_3_2.setVisible(true);
		lblNewLabel_5_1_2_2.setVisible(false);
		lblNewLabel_5_3_3.setVisible(true);
		lblNewLabel_5_1_2_3.setVisible(false);
		lblNewLabel_5_3_4.setVisible(true);
		lblNewLabel_5_1_2_4.setVisible(false);
	}
}
