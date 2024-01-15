package user;

import java.awt.EventQueue;
import dao.ForgotPasswordDao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import admin.Transaction;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ForgotPassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JPasswordField passwordField;
	///////////////////////////////////
	private static ForgotPassword frame;
	private static JButton btnSave;
	private static JButton btnBack;
	private static JLabel lblNewLabel_5;
	private static JLabel lblNewLabel_5_1;
	private static Color notEdit = new Color(204,204,204);
	private static Color edit = new Color(255,255,255);
	private static ForgotPasswordDao fg = new ForgotPasswordDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ForgotPassword();
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
	public ForgotPassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 535);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Forgot Password");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(21, 10, 381, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(55, 98, 78, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(55, 123, 309, 30);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Security Question");
		lblNewLabel_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_1.setBounds(55, 179, 125, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(55, 204, 309, 30);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("Answer");
		lblNewLabel_1_1_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_2.setBounds(55, 262, 125, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_2);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(55, 287, 309, 30);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("New password");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1.setBounds(55, 340, 108, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setEditable(false);
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		passwordField.setBounds(55, 365, 309, 30);
		contentPane.add(passwordField);
		
		btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isEmpty()) {
					String email = textField.getText();
					String ans = textField_2.getText();
					if (fg.getAns(email, ans)) {
						String password = String.valueOf(passwordField.getPassword());
						fg.setPassword(email, password);
						new LogIn().setVisible(true);
						dispose();
					}
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSave.setBounds(80, 421, 100, 52);
		contentPane.add(btnSave);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LogIn().setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBounds(214, 421, 100, 52);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(392, 10, 49, 25);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setEchoChar((char)0);
				lblNewLabel_5.setVisible(false);
				lblNewLabel_5_1.setVisible(true);
			}
		});
		lblNewLabel_5.setIcon(new ImageIcon(ForgotPassword.class.getResource("/icons/hide.png")));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(374, 365, 33, 21);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setEchoChar('*');
				lblNewLabel_5.setVisible(true);
				lblNewLabel_5_1.setVisible(false);
			}
		});
		lblNewLabel_5_1.setIcon(new ImageIcon(ForgotPassword.class.getResource("/icons/visible.png")));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setBounds(374, 365, 33, 21);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("");
		lblNewLabel_5_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (emailValidation()) {
					if (fg.isEmailExist(textField.getText())) {
						textField.setBackground(notEdit);
						textField.setEditable(false);
						textField_2.setBackground(edit);
						textField_2.setEditable(true);
						passwordField.setBackground(edit);
						passwordField.setEditable(true);
						btnSave.setEnabled(true);
					}
				}
			}
		});
		lblNewLabel_5_2.setIcon(new ImageIcon(ForgotPassword.class.getResource("/icons/search.png")));
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2.setBounds(369, 123, 33, 21);
		contentPane.add(lblNewLabel_5_2);
		
		init();
	}

	/**
	 * Sub functions
	 */
	public static void init() {
		textField_1.setBackground(notEdit);
		textField_2.setBackground(notEdit);
		passwordField.setBackground(notEdit);
		btnSave.setEnabled(false);
	}
	
	public static boolean isEmpty() {
		if (textField_2.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Answer is required", "Warning", 2);
			return false;
		}
		if (String.valueOf(passwordField.getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter new password", "Warning", 2);
			return false;
		}
		return true;
	}
	
	public boolean emailValidation() {
		if (textField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter email address", "Warning", 2);
			return false;
		}
		if (!textField.getText().matches("^.+@.+\\..+$")) {
			JOptionPane.showMessageDialog(null, "Invalid email", "Warning", 2);
			return false;
		}
		return true;
	}
}
