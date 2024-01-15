package admin;

import java.awt.EventQueue;

import dao.StatisticsDao;
import dao.SupplierDao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddSupplier extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JPasswordField passwordField;
	public static JTextField textField_3;
	public static JTextField textField_4;
	public static JTextField textField_5;
	public static JLabel lblNewLabel_1_1_1_1_1_3;
	public static JLabel lblNewLabel_1_1_1_1_1_4;
	public static JButton btnSave;
	public static JLabel lblNewLabel_2;
	public static JButton btnClear;
	////////////////////////////////////
	private static AddSupplier frame;
	private static Color notEdit = new Color(204,204,204);
	private static SupplierDao supplier = new SupplierDao();
	public StatisticsDao staDao = new StatisticsDao();
	//int xx,xy;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AddSupplier();
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
	public AddSupplier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 658);
		contentPane = new JPanel();
//		contentPane.addMouseListener(new MouseAdapter() {           //two events used when main frame undecorated
//			@Override
//			public void mousePressed(MouseEvent e) {
//				xx = e.getX();
//				xy = e.getY();
//			}
//		});
//		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseDragged(MouseEvent e) {
//				int x = e.getXOnScreen();
//				int y = e.getYOnScreen();
//				frame.setLocation(x-xx, y-xy);
//			}
//		});
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Supplier");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 398, 42);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setBounds(61, 96, 309, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setBounds(61, 160, 309, 33);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_2.setBounds(61, 221, 309, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		passwordField.setBounds(61, 278, 309, 30);
		contentPane.add(passwordField);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())){
					e.consume();
					JOptionPane.showMessageDialog(null, "Phone contains numbers only", "Warning", 2);
				}
			}
		});
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_3.setBounds(61, 338, 309, 30);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_4.setBounds(61, 412, 309, 36);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_5.setBounds(61, 484, 309, 33);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Supplier ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(61, 80, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Supplier name");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(61, 143, 93, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(61, 204, 78, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1.setBounds(61, 262, 78, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Phone");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1.setBounds(61, 319, 78, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		lblNewLabel_1_1_1_1_1_3 = new JLabel("Address 1 (State & Region)");
		lblNewLabel_1_1_1_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_3.setBounds(61, 387, 193, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_3);
		
		lblNewLabel_1_1_1_1_1_4 = new JLabel("Address 2 (Country)");
		lblNewLabel_1_1_1_1_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_4.setBounds(61, 459, 193, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_4);
		
		btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isEmpty()) {
					int id = Integer.parseInt(textField.getText());
					String username = textField_1.getText();
					String email = textField_2.getText();
					String password = String.valueOf(passwordField.getPassword());
					String phone = textField_3.getText();
					String address1 = textField_4.getText();
					String address2 = textField_5.getText();
					if (!supplier.isUsernameExist(username)) {
						if (!supplier.isEmailExist(email)) {
							if (!supplier.isPhoneExist(phone)) {
								supplier.insert(id, username, email, password, phone, address1, address2);
								clear();
							}
							else {
								JOptionPane.showMessageDialog(null, "This supplier phone number already exists");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "This supplier email already exists");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "This supplier username already exists");
					}
					staDao.admin();
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSave.setBounds(73, 544, 100, 52);
		contentPane.add(btnSave);
		
		lblNewLabel_2 = new JLabel("X");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.exit(0);
				setVisible(false);
				AdminDashboard.panel_4_2_1.setBackground(Color.LIGHT_GRAY);
				AdminDashboard.lblNewLabel_4_2_1.setForeground(Color.BLACK);
				AdminDashboard.lblNewLabel_5_3_1.setVisible(true);
				AdminDashboard.lblNewLabel_5_1_2_1.setVisible(false);
			}
		});
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(403, 11, 49, 36);
		contentPane.add(lblNewLabel_2);
		
		btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				staDao.admin();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear.setBounds(223, 544, 100, 52);
		contentPane.add(btnClear);
		
		////////////////////////////////
		init();
	}
	
	/**
	 * Sub functions
	 */
	public static void init(){
		textField.setBackground(notEdit);
		textField.setText(String.valueOf(supplier.getMaxRow()));
	}
	
	//clear all textFields
	public static void clear() {
		textField.setText(String.valueOf(supplier.getMaxRow()));
		textField_1.setText("");
		textField_2.setText("");
		passwordField.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
	}
	
	public static boolean isEmpty() {
		if (textField_1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Supplier name is required", "Warning", 2);
			return false;
		}
		if (textField_2.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Supplier email is required", "Warning", 2);
			return false;
		}
		if (!textField_2.getText().matches("^.+@.+\\..+$")) {
			JOptionPane.showMessageDialog(null, "Invalid email", "Warning", 2);
			return false;
		}
		if (String.valueOf(passwordField.getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(null, "Password is required", "Warning", 2);
			return false;
		}
		if (textField_3.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Phone is required", "Warning", 2);
			return false;
		}
		if (textField_3.getText().length()>15) {
			JOptionPane.showMessageDialog(null, "Phone is too long", "Warning", 2);
			return false;
		}
		if (textField_3.getText().length()<10) {
			JOptionPane.showMessageDialog(null, "Phone is too short", "Warning", 2);
			return false;
		}
		if (textField_4.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Address 1 is required", "Warning", 2);
			return false;
		}
		if (textField_5.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Address 2 is required", "Warning", 2);
			return false;
		}
		return true;
	}
}
