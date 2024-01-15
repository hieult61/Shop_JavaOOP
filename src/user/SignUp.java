package user;

import java.awt.EventQueue;

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
import dao.UserDao;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SignUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JPasswordField passwordField;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_6;
	private static JLabel lblNewLabel_1_1_1_1_1_2;
	private static JLabel lblNewLabel_1_1_1_1_1_3;
	private static JLabel lblNewLabel_1_1_1_1_1_4;
	private static JButton btnSave;
	private static JLabel lblNewLabel_2;
	private static JButton btnBack;
	private static JComboBox comboBox;
	///////////////////////////////////
	private static SignUp frame;
	///////////////////////////////////
	private static Color notEdit = new Color(204,204,204);
	private static UserDao user = new UserDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 658);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 788, 42);
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
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"What is your favourite color ?", "Where do you live ?"}));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.setBounds(61, 403, 309, 33);
		contentPane.add(comboBox);
		
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
		textField_4.setBounds(61, 474, 309, 33);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_5.setBounds(435, 159, 309, 36);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_6.setBounds(435, 221, 309, 33);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(61, 80, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Username");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(61, 143, 78, 14);
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
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Security Question");
		lblNewLabel_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_1.setBounds(61, 378, 125, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		lblNewLabel_1_1_1_1_1_2 = new JLabel("Answer");
		lblNewLabel_1_1_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_2.setBounds(61, 449, 125, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_2);
		
		lblNewLabel_1_1_1_1_1_3 = new JLabel("Address 1 (State & Region)");
		lblNewLabel_1_1_1_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_3.setBounds(435, 134, 193, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_3);
		
		lblNewLabel_1_1_1_1_1_4 = new JLabel("Address 2 (Country)");
		lblNewLabel_1_1_1_1_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_4.setBounds(435, 205, 193, 14);
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
					String seq = comboBox.getSelectedItem().toString();
					String ans = textField_4.getText();
					String address1 = textField_5.getText();
					String address2 = textField_6.getText();
					if (!user.isEmailExist(email)) {
						if (!user.isPhoneExist(phone)) {
							user.insert(id, username, email, password, phone, seq, ans, address1, address2);
							new LogIn().setVisible(true);
							dispose();
						}
						else{
							JOptionPane.showMessageDialog(null, "This phone number already exists", "Warning", 2);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "This email already exists", "Warning", 2);
					}
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSave.setBounds(465, 297, 100, 52);
		contentPane.add(btnSave);
		
		lblNewLabel_2 = new JLabel("X");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.exit(0);
				new LogIn().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(774, 11, 49, 36);
		contentPane.add(lblNewLabel_2);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LogIn().setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBounds(603, 297, 100, 52);
		contentPane.add(btnBack);
		
		init();
	}
	/**
	 * Sub functions
	 */
	public static void init() {
		textField.setBackground(notEdit);
		textField.setText(String.valueOf(user.getMaxRow()));
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
		if (comboBox.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Question is required", "Warning", 2);
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
}
