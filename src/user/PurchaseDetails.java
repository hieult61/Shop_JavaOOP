package user;

import java.awt.EventQueue;
import dao.PurchaseDao;
import dao.StatisticsDao;
import dao.UserDao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PurchaseDetails extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JTextField textField_3;
	public static JTextField textField;
	public static JTable table;
	///////////////////////////////////
	private static PurchaseDetails frame;
	private static Color notEdit = new Color(204,204,204);
	private static Color edit = new Color(255,255,255);
	public static DefaultTableModel model;
	public static int rowIndex;
	public static Date date = new Date();
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
	public static int uId;
	public static UserDao user = new UserDao();
	public static PurchaseDao pd = new PurchaseDao();
	public static StatisticsDao staDao = new StatisticsDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new PurchaseDetails();
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
	public PurchaseDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 885, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_1_3_1_1 = new JLabel("PURCHASE DETAILS");
		lblNewLabel_1_1_3_1_1.setBounds(29, 11, 318, 46);
		lblNewLabel_1_1_3_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel_1_1_3_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Purchase ID");
		lblNewLabel_1_1.setBounds(69, 85, 90, 14);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(69, 110, 246, 35);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Receive Date");
		lblNewLabel_1_1_1.setBounds(69, 166, 101, 14);
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(69, 192, 246, 35);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Current Date");
		lblNewLabel_1_1_2.setBounds(69, 248, 101, 14);
		lblNewLabel_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1_1_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(69, 272, 246, 35);
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		JButton btnRefund = new JButton("REFUND");
		btnRefund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().isEmpty()||textField_2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Purchase ID or receive date is missing");
				}
				else {
					String receiveDate = textField_2.getText();
					String currentDate = textField_3.getText();
					try {
						Date d1 = df.parse(receiveDate);
						Date d2 = df.parse(currentDate);
						long dateReceiveInMs = d1.getTime();
						long dateCurrentInMs = d2.getTime();
						long timeDiff = dateCurrentInMs - dateReceiveInMs;
						long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
						
						if (daysDiff >30) {
							JOptionPane.showMessageDialog(null, "Sorry refund time is over!\nRefund applicable 30 days from receive day!");
						}
						else {
							int id = Integer.parseInt(textField_1.getText().toString());
							pd.refund(id);
							table.setModel(new DefaultTableModel(null,new Object[] {"Purchase ID", "Product ID", "Product Name", "Quantity", 
									"Price", "Total", "Purchase Date", "Receive Date", "Supplier Name", "Status"}));
							pd.getProductValue(table, textField.getText(),uId);
							staDao.user(user.getUserId(String.valueOf(UserDashboard.lblNewLabel_2.getText())));
							clear();
						}
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnRefund.setBounds(64, 338, 265, 59);
		btnRefund.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnRefund);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnClear.setBounds(69, 415, 257, 59);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnClear);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setBounds(812, 11, 49, 25);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.exit(0);
				setVisible(false);
				UserDashboard.panel_4_1.setBackground(Color.LIGHT_GRAY);
				UserDashboard.lblNewLabel_4_1.setForeground(Color.BLACK);
				UserDashboard.lblNewLabel_5_2.setVisible(true);
				UserDashboard.lblNewLabel_5_1_1.setVisible(false);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Search product");
		lblNewLabel_1_1_3.setBounds(439, 34, 106, 14);
		lblNewLabel_1_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1_1_3);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				table.setModel(new DefaultTableModel(null,new Object[] {"Purchase ID", "Product ID", "Product Name", "Quantity", 
						"Price", "Total", "Purchase Date", "Receive Date", "Supplier Name", "Status"}));
				pd.getProductValue(table, textField.getText(),uId);
			}
		});
		textField.setBounds(555, 25, 233, 35);
		textField.setColumns(10);
		contentPane.add(textField);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(405, 97, 456, 394);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model = (DefaultTableModel) table.getModel();
				rowIndex = table.getSelectedRow();
				textField_1.setText(model.getValueAt(rowIndex, 0).toString());
				if (model.getValueAt(rowIndex, 7)==null) {
					textField_2.setText(null);
				}
				else {
					textField_2.setText(model.getValueAt(rowIndex, 7).toString());
				}
			}
		});
		scrollPane_1.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Purchase ID", "Product ID", "Product Name", "Quantity", "Price", "Total", "Purchase Date", "Receive Date", "Supplier Name", "Status"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(71);
		table.getColumnModel().getColumn(1).setPreferredWidth(64);
		table.getColumnModel().getColumn(2).setPreferredWidth(93);
		table.getColumnModel().getColumn(3).setPreferredWidth(61);
		table.getColumnModel().getColumn(4).setPreferredWidth(51);
		table.getColumnModel().getColumn(5).setPreferredWidth(52);
		table.getColumnModel().getColumn(6).setPreferredWidth(83);
		table.getColumnModel().getColumn(7).setPreferredWidth(82);
		table.getColumnModel().getColumn(8).setPreferredWidth(82);
		
		////////////////////////////////////////////////////////
		init();
	}
	
	/**
	 * Sub functions
	 */
	public static void init() {
		textField_3.setText(df.format(date));
		uId = user.getUserId(UserDashboard.lblNewLabel_2.getText());
		productTable();
	}
	
	public static void productTable() {
		pd.getProductValue(table, "", uId);
		model = (DefaultTableModel) table.getModel();
		table.setRowHeight(30);
		table.setShowGrid(true);
		table.setGridColor(Color.BLACK);
		table.setBackground(Color.WHITE);
		table.setSelectionBackground(Color.LIGHT_GRAY);
	}
	
	//clear all textFields
	public static void clear() {
		textField_1.setText("");
		textField_2.setText("");
		table.clearSelection();
	}
}
