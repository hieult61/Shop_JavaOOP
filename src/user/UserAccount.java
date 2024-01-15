package user;

import java.awt.EventQueue;
import dao.UserDao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserAccount extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JPasswordField passwordField;
	public static JTextField textField_3;
	public static JTextField textField_4;
	public static JTextField textField_5;
	public static JTextField textField_6;
	public static JTextField textField_7;
	///////////////////////////////////
	private static UserAccount frame;
	//////////////////////////////////
	private static Color notEdit = new Color(204,204,204);
	private static Color edit = new Color(255,255,255);
	private static UserDao user = new UserDao();
	private static String[] value = new String[9];
	private static int uId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UserAccount();
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
	public UserAccount() {
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
				UserDashboard.panel_4_2.setBackground(Color.LIGHT_GRAY);
				UserDashboard.lblNewLabel_4_2.setForeground(Color.BLACK);
				UserDashboard.lblNewLabel_5_3.setVisible(true);
				UserDashboard.lblNewLabel_5_1_2.setVisible(false);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(729, 11, 49, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUserAccount = new JLabel("User Account");
		lblUserAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserAccount.setForeground(Color.WHITE);
		lblUserAccount.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUserAccount.setBounds(35, 11, 663, 46);
		contentPane.add(lblUserAccount);
		
		JLabel lblNewLabel_1_1 = new JLabel("User ID");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(35, 83, 49, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(35, 108, 309, 36);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Username");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(35, 165, 78, 14);
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
		lblNewLabel_1_1_1_1_1_1.setBounds(35, 392, 78, 14);
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
		textField_3.setBounds(35, 416, 309, 36);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Security Question");
		lblNewLabel_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(388, 84, 125, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("Answer");
		lblNewLabel_1_1_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_2.setBounds(388, 166, 125, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(389, 190, 309, 33);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_1_1_1_1_1_3 = new JLabel("Address 1 (State & Region)");
		lblNewLabel_1_1_1_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_3.setBounds(388, 245, 193, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_3);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(389, 275, 309, 36);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_1_1_1_1_1_4 = new JLabel("Address 2 (Country)");
		lblNewLabel_1_1_1_1_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_4.setBounds(388, 321, 193, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_4);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(388, 345, 309, 33);
		contentPane.add(textField_6);
		
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
						String seq = textField_7.getText();
						String ans = textField_4.getText();
						String address1 = textField_5.getText();
						String address2 = textField_6.getText();
						user.update(id, username, email, password, phone, seq, ans, address1, address2);
						dispose();
						UserDashboard.panel_4_2.setBackground(Color.LIGHT_GRAY);
						UserDashboard.lblNewLabel_4_2.setForeground(Color.BLACK);
						UserDashboard.lblNewLabel_5_3.setVisible(true);
						UserDashboard.lblNewLabel_5_1_2.setVisible(false);
					}
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUpdate.setBounds(413, 416, 125, 52);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.delete(uId);
				System.exit(0);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBounds(567, 416, 113, 52);
		contentPane.add(btnDelete);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_7.setColumns(10);
		textField_7.setBounds(388, 108, 309, 33);
		contentPane.add(textField_7);
		
		init();
	}
	
	/**
	 * Sub functions
	 */
	public static void init() {
		uId = user.getUserId(UserDashboard.lblNewLabel_2.getText());
		value = user.getUserValue(uId);
		setValue();
	}
	
	public static void setValue() {
		textField.setText(value[0]);
		textField_1.setText(value[1]);
		textField_2.setText(value[2]);
		passwordField.setText(value[3]);
		textField_3.setText(value[4]);
		textField_7.setText(value[5]);
		textField_4.setText(value[6]);
		textField_5.setText(value[7]);
		textField_6.setText(value[8]);
	}
	
	public static boolean isEmpty() {
		if (textField_1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Username is required", "Warning", 2);
			return false;
		}
		if (textField_2.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Email is required", "Warning", 2);
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
			JOptionPane.showMessageDialog(null, "Answer is required", "Warning", 2);
			return false;
		}
		if (textField_5.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Address 1 is required", "Warning", 2);
			return false;
		}
		if (textField_6.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Address 2 is required", "Warning", 2);
			return false;
		}
		return true;
	}
	
	public static boolean check() {
		String newEmail = textField_2.getText();
		String newPhone = textField_3.getText();
		if (newEmail.equals(value[2]) && newPhone.equals(value[4])) {
			return false;
		}
		else {
			if (!newEmail.equals(value[2])) {
				boolean x = user.isEmailExist(newEmail);
				if (x) {
					JOptionPane.showMessageDialog(null, "Email exists", "Warning", 2);
				}
				return x;
			}
			if (!newPhone.equals(value[4])) {
				boolean x = user.isPhoneExist(newPhone);
				if (x) {
					JOptionPane.showMessageDialog(null, "Phone number exists", "Warning", 2);
				}
				return x;
			}
		}
		return false;
	}
}
