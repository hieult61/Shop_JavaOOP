package admin;

import java.awt.EventQueue;

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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.StatisticsDao;
import dao.UserDao;
import user.UserDashboard;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManageUsers extends JFrame {

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
	public static JTextField textField_8;
	public static JTable table;
	///////////////////////////////////
	private static ManageUsers frame;
	public static UserDao user = new UserDao();
	public StatisticsDao staDao = new StatisticsDao();
	public static DefaultTableModel model;
	public static int rowIndex;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ManageUsers();
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
	public ManageUsers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 948, 644);
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
				AdminDashboard.panel_4_2.setBackground(Color.LIGHT_GRAY);
				AdminDashboard.lblNewLabel_4_2.setForeground(Color.BLACK);
				AdminDashboard.lblNewLabel_5_3.setVisible(true);
				AdminDashboard.lblNewLabel_5_1_2.setVisible(false);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(875, 11, 49, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUserAccount = new JLabel("Manage Users");
		lblUserAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserAccount.setForeground(Color.WHITE);
		lblUserAccount.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUserAccount.setBounds(35, -4, 778, 46);
		contentPane.add(lblUserAccount);
		
		JLabel lblNewLabel_1_1 = new JLabel("User ID");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(35, 57, 49, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(35, 73, 309, 36);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Username");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(35, 120, 78, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(35, 134, 309, 33);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1.setBounds(35, 178, 78, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(35, 199, 309, 40);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1.setBounds(35, 250, 78, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		passwordField.setBounds(35, 275, 309, 36);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Phone");
		lblNewLabel_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_1.setBounds(35, 322, 78, 14);
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
		textField_3.setBounds(35, 347, 309, 36);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Security Question");
		lblNewLabel_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(388, 57, 125, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("Answer");
		lblNewLabel_1_1_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_2.setBounds(388, 120, 125, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(389, 134, 309, 33);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_1_1_1_1_1_3 = new JLabel("Address 1 (State & Region)");
		lblNewLabel_1_1_1_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_3.setBounds(388, 178, 193, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_3);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(389, 203, 309, 36);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_1_1_1_1_1_4 = new JLabel("Address 2 (Country)");
		lblNewLabel_1_1_1_1_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_4.setBounds(388, 250, 193, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_4);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(389, 276, 309, 33);
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
						
						table.setModel(new DefaultTableModel(null,new Object[] {"User ID", "Username", "Email", " Password",
								"Phone","Security Question", "Answer", "Address 1", "Address 2"}));
						user.getUserValue(table, "");
						clear();
					}
					staDao.admin();
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUpdate.setBounds(750, 98, 125, 52);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isEmpty()) {
					int id = Integer.parseInt(textField.getText());
					user.delete(id);
					table.setModel(new DefaultTableModel(null,new Object[] {"User ID", "Username", "Email", " Password",
							"Phone","Security Question", "Answer", "Address 1", "Address 2"}));
					user.getUserValue(table, "");
					clear();  //clear all textFields
					staDao.admin();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBounds(750, 171, 125, 52);
		contentPane.add(btnDelete);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_7.setColumns(10);
		textField_7.setBounds(388, 74, 309, 33);
		contentPane.add(textField_7);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				staDao.admin();
				clear();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear.setBounds(750, 250, 125, 52);
		contentPane.add(btnClear);
		
		textField_8 = new JTextField();
		textField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				table.setModel(new DefaultTableModel(null,new Object[] {"User ID", "Username", "Email", " Password",
						"Phone","Security Question", "Answer", "Address 1", "Address 2"}));
				user.getUserValue(table, textField_8.getText());
			}
		});
		textField_8.setBounds(667, 356, 241, 27);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(601, 358, 68, 25);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 412, 854, 161);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model = (DefaultTableModel) table.getModel();
				rowIndex = table.getSelectedRow();
				textField.setText(model.getValueAt(rowIndex, 0).toString());
				textField_1.setText(model.getValueAt(rowIndex, 1).toString());
				textField_2.setText(model.getValueAt(rowIndex, 2).toString());
				passwordField.setText(model.getValueAt(rowIndex, 3).toString());
				textField_3.setText(model.getValueAt(rowIndex, 4).toString());
				textField_4.setText(model.getValueAt(rowIndex, 6).toString());
				textField_5.setText(model.getValueAt(rowIndex, 7).toString());
				textField_6.setText(model.getValueAt(rowIndex, 8).toString());
				textField_7.setText(model.getValueAt(rowIndex, 5).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"User ID", "Username", "Email", "Password", "Phone", "Security Question", "Answer", "Address 1", "Address 2"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		//////////////////////////////////////
		usersTable();
	}

	/**
	 * Sub functions
	 */
	public static void usersTable() {
		user.getUserValue(table, "");
		model = (DefaultTableModel) table.getModel();
		table.setRowHeight(30);
		table.setShowGrid(true);
		table.setGridColor(Color.BLACK);
		table.setBackground(Color.WHITE);
		table.setSelectionBackground(Color.LIGHT_GRAY);
	}
	
	public static boolean check() {
		String newEmail = textField_2.getText();
		String newPhone = textField_3.getText();
		String oldEmail = model.getValueAt(rowIndex, 2).toString();
		String oldPhone = model.getValueAt(rowIndex, 4).toString();
		if (newEmail.equals(oldEmail) && newPhone.equals(oldPhone)) {
			return false;
		}
		else {
			if (!newEmail.equals(oldEmail)) {
				boolean x = user.isEmailExist(newEmail);
				if (x) {
					JOptionPane.showMessageDialog(null, "Email exists", "Warning", 2);
				}
				return x;
			}
			if (!newPhone.equals(oldPhone)) {
				boolean x = user.isPhoneExist(newPhone);
				if (x) {
					JOptionPane.showMessageDialog(null, "Phone number exists", "Warning", 2);
				}
				return x;
			}
		}
		return false;
	}
	
	public static boolean isEmpty() {
		if (textField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please select an user", "Warning", 2);
			return false;
		}
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
	
	//clear all textFields
	public static void clear() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		passwordField.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
		textField_7.setText("");
		table.clearSelection();
	}
}
