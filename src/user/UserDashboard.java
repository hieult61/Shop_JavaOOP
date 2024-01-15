package user;

import java.awt.EventQueue;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import admin.Transaction;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class UserDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static UserDashboard frame;
	public static JLabel lblNewLabel_5;
	public static JLabel lblNewLabel_5_1;
	public static JLabel lblNewLabel_5_2;
	public static JLabel lblNewLabel_5_1_1;
	public static JLabel lblNewLabel_5_3;
	public static JLabel lblNewLabel_5_1_2;
	///////////////////////////////////////
	public static JPanel panel_4;
	public static JPanel panel_4_1;
	public static JPanel panel_4_2;
	///////////////////////////////////////
	public static JLabel lblNewLabel_4;
	public static JLabel lblNewLabel_4_1;
	public static JLabel lblNewLabel_4_2;
	public static JLabel lblNewLabel_2;
	///////////////////////////////////////
	public static JLabel lblNewLabel_cat;
	public static JLabel lblNewLabel_product;
	public static JLabel lblNewLabel_purchase;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UserDashboard();
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
	public UserDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1023, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 1009, 513);
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
		lblNewLabel_1.setIcon(new ImageIcon(UserDashboard.class.getResource("/icons/logout.png")));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(899, 11, 100, 44);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("user@gmail.com");
		lblNewLabel_2.setIcon(new ImageIcon(UserDashboard.class.getResource("/icons/user.png")));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(660, 19, 217, 27);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 65, 248, 448);
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
		
		lblNewLabel_4 = new JLabel("PURCHASE");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_4.setBackground(Color.GREEN);
				lblNewLabel_4.setForeground(Color.WHITE);
				lblNewLabel_5.setVisible(false);
				lblNewLabel_5_1.setVisible(true);
				Purchase purchase = new Purchase();
				purchase.setVisible(true);
			}
		});
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(77, 11, 97, 25);
		panel_4.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(UserDashboard.class.getResource("/icons/purchase_dark.png")));
		lblNewLabel_5.setBounds(29, 11, 41, 25);
		panel_4.add(lblNewLabel_5);
		
		lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon(UserDashboard.class.getResource("/icons/purchase_light.png")));
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
		
		lblNewLabel_4_1 = new JLabel("PURCHASE DETAILS");
		lblNewLabel_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_4_1.setBackground(Color.GREEN);
				lblNewLabel_4_1.setForeground(Color.WHITE);
				lblNewLabel_5_2.setVisible(false);
				lblNewLabel_5_1_1.setVisible(true);
				PurchaseDetails purchaseDetails = new PurchaseDetails();
				purchaseDetails.setVisible(true);
			}
		});
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_1.setBounds(77, 11, 161, 25);
		panel_4_1.add(lblNewLabel_4_1);
		
		lblNewLabel_5_2 = new JLabel("");
		lblNewLabel_5_2.setIcon(new ImageIcon(UserDashboard.class.getResource("/icons/purchasedetails_dark.png")));
		lblNewLabel_5_2.setBounds(29, 11, 41, 25);
		panel_4_1.add(lblNewLabel_5_2);
		
		lblNewLabel_5_1_1 = new JLabel("");
		lblNewLabel_5_1_1.setIcon(new ImageIcon(UserDashboard.class.getResource("/icons/purchasedetails_light.png")));
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
		
		lblNewLabel_4_2 = new JLabel("MY ACCOUNT");
		lblNewLabel_4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_4_2.setBackground(Color.GREEN);
				lblNewLabel_4_2.setForeground(Color.WHITE);
				lblNewLabel_5_3.setVisible(false);
				lblNewLabel_5_1_2.setVisible(true);
				UserAccount userAccount = new UserAccount();
				userAccount.setVisible(true);
			}
		});
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_2.setBounds(77, 11, 121, 25);
		panel_4_2.add(lblNewLabel_4_2);
		
		lblNewLabel_5_3 = new JLabel("");
		lblNewLabel_5_3.setIcon(new ImageIcon(UserDashboard.class.getResource("/icons/account_dark.png")));
		lblNewLabel_5_3.setBounds(29, 11, 41, 25);
		panel_4_2.add(lblNewLabel_5_3);
		
		lblNewLabel_5_1_2 = new JLabel("");
		lblNewLabel_5_1_2.setIcon(new ImageIcon(UserDashboard.class.getResource("/icons/account_light.png")));
		lblNewLabel_5_1_2.setBounds(29, 11, 49, 25);
		panel_4_2.add(lblNewLabel_5_1_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(276, 91, 700, 163);
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
		
		JLabel lblNewLabel_7_1_1 = new JLabel("Total Purchase");
		lblNewLabel_7_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7_1_1.setBounds(310, 47, 127, 24);
		panel_6.add(lblNewLabel_7_1_1);
		
		lblNewLabel_cat = new JLabel("0");
		lblNewLabel_cat.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_cat.setBounds(153, 52, 49, 14);
		panel_6.add(lblNewLabel_cat);
		
		lblNewLabel_product = new JLabel("0");
		lblNewLabel_product.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_product.setBounds(153, 87, 49, 14);
		panel_6.add(lblNewLabel_product);
		
		lblNewLabel_purchase = new JLabel("0.0");
		lblNewLabel_purchase.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_purchase.setBounds(447, 52, 49, 14);
		panel_6.add(lblNewLabel_purchase);
		
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
	}
}
