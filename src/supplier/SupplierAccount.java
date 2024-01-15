package supplier;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.UserDao;
import user.LogIn;
import user.UserDashboard;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import dao.SupplierDao;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class SupplierAccount extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JPasswordField passwordField;
	public static JTextField textField_3;
	public static JTextField textField_4;
	public static JTextField textField_5;
	///////////////////////////////////
	private static SupplierAccount frame;
	private static Color notEdit = new Color(204,204,204);
	private static Color edit = new Color(255,255,255);
	private static SupplierDao supplier = new SupplierDao();
	private static String[] value = new String[7];
	private static int sId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SupplierAccount();
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
	public SupplierAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 569);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.exit(0);
				setVisible(false);
				SupplierDashboard.panel_4_2.setBackground(Color.LIGHT_GRAY);
				SupplierDashboard.lblNewLabel_4_2.setForeground(Color.BLACK);
				SupplierDashboard.lblNewLabel_5_3.setVisible(true);
				SupplierDashboard.lblNewLabel_5_1_2.setVisible(false);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(729, 11, 49, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUserAccount = new JLabel("Supplier Account");
		lblUserAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserAccount.setForeground(Color.WHITE);
		lblUserAccount.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUserAccount.setBounds(35, 11, 663, 46);
		contentPane.add(lblUserAccount);
		
		JLabel lblNewLabel_1_1 = new JLabel("Supplier ID");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(35, 83, 78, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(35, 108, 309, 36);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Supplier name");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(35, 165, 118, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(35, 190, 309, 33);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1.setBounds(35, 244, 78, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(35, 269, 309, 40);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1.setBounds(35, 320, 78, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		passwordField.setBounds(35, 345, 309, 36);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Phone");
		lblNewLabel_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_1.setBounds(388, 83, 78, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
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
		textField_3.setColumns(10);
		textField_3.setBounds(388, 108, 309, 36);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1_1_1_1_1_3 = new JLabel("Address 1 (State & Region)");
		lblNewLabel_1_1_1_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_3.setBounds(388, 165, 193, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(388, 189, 309, 36);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_1_1_1_1_1_4 = new JLabel("Address 2 (Country)");
		lblNewLabel_1_1_1_1_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_4.setBounds(388, 244, 193, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(388, 272, 309, 33);
		contentPane.add(textField_5);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isEmpty()) {
					if (!check()) {
						int id = Integer.parseInt(textField.getText());
						String username = textField_1.getText();
						String email = textField_2.getText();
						String password = String.valueOf(passwordField.getPassword());
						String phone = textField_3.getText();
						String address1 = textField_4.getText();
						String address2 = textField_5.getText();
						supplier.update(id, username, email, password, phone, address1, address2);
						dispose();
						
						SupplierDashboard.panel_4_2.setBackground(Color.LIGHT_GRAY);
						SupplierDashboard.lblNewLabel_4_2.setForeground(Color.BLACK);
						SupplierDashboard.lblNewLabel_5_3.setVisible(true);
						SupplierDashboard.lblNewLabel_5_1_2.setVisible(false);
					}
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUpdate.setBounds(412, 334, 125, 52);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supplier.delete(sId);
				System.exit(0);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBounds(564, 334, 113, 52);
		contentPane.add(btnDelete);
		
		//////////////////////////////////
		init();
	}
	
	/**
	 * Sub functions
	 */
	public static void init() {
		sId = supplier.getSupplierId(SupplierDashboard.lblNewLabel_2.getText());
		value = supplier.getSupplierValue(sId);
		setValue();
	}
	
	public static void setValue() {
		textField.setText(value[0]);
		textField_1.setText(value[1]);
		textField_2.setText(value[2]);
		passwordField.setText(value[3]);
		textField_3.setText(value[4]);
		textField_4.setText(value[5]);
		textField_5.setText(value[6]);
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
	
	public static boolean check() {
		String newUsername = textField_1.getText();
		String newEmail = textField_2.getText();
		String newPhone = textField_3.getText();
		if (newUsername.equals(value[1]) && newEmail.equals(value[2]) && newPhone.equals(value[4])) {
			return false;
		}
		else {
			if (!newUsername.equals(value[1])) {
				boolean x = supplier.isUsernameExist(newUsername);
				if (x) {
					JOptionPane.showMessageDialog(null, "Supplier username exists", "Warning", 2);
				}
				return x;
			}
			if (!newEmail.equals(value[2])) {
				boolean x = supplier.isEmailExist(newEmail);
				if (x) {
					JOptionPane.showMessageDialog(null, "Email exists", "Warning", 2);
				}
				return x;
			}
			if (!newPhone.equals(value[4])) {
				boolean x = supplier.isPhoneExist(newPhone);
				if (x) {
					JOptionPane.showMessageDialog(null, "Phone number exists", "Warning", 2);
				}
				return x;
			}
		}
		return false;
	}
}
