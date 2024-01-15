package user;

import java.awt.EventQueue;
import dao.ProductDao;
import dao.PurchaseDao;
import dao.StatisticsDao;
import dao.UserDao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import admin.Transaction;
import dao.ProductDao;

import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Purchase extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	public static JTable table;
	public static JTable table_1;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JTextField textField_3;
	///////////////////////////////////
	public static JLabel lblNewLabel_1_1_3_1;
	private static Purchase frame;
	private static Color notEdit = new Color(204,204,204);
	private static Color edit = new Color(255,255,255);
	public static PurchaseDao purchaseDao = new PurchaseDao();
	public static ProductDao productDao = new ProductDao();
	public static DefaultTableModel model;
	public static int rowIndex;
	public static int qty=0;
	public static double price=0.0;
	public static double total=0.0;
	public static int pId;
	public static Date date = new Date();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
	public static StatisticsDao staDao = new StatisticsDao();
	public static UserDao user = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Purchase();
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
	public Purchase() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 652);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setBounds(847, 11, 49, 25);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.exit(0);
				setVisible(false);
				UserDashboard.panel_4.setBackground(Color.LIGHT_GRAY);
				UserDashboard.lblNewLabel_4.setForeground(Color.BLACK);
				UserDashboard.lblNewLabel_5.setVisible(true);
				UserDashboard.lblNewLabel_5_1.setVisible(false);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				table.setModel(new DefaultTableModel(null,new Object[] {"Product ID", 
						"Product name", "Category", "Quantity", "Price"}));
				productDao.getProductValue(table, textField.getText());
			}
		});
		textField.setBounds(590, 31, 233, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(90, 102, 246, 35);
		textField_1.setEditable(false);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(90, 176, 246, 35);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())){
					e.consume();
					JOptionPane.showMessageDialog(null, "Quantity contains numbers only", "Warning", 2);
				}
			}
		});
		textField_3.setBounds(90, 250, 246, 35);
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please select a product", "Warning", 2);
				}
				else if(textField_3.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Quantity required", "Warning", 2);
				}
				else {
					model = (DefaultTableModel) table.getModel();
					int proId = Integer.parseInt(model.getValueAt(rowIndex,0).toString());
					if (!isProductExist(proId)) {
						if (!(qty<=0)) {
							int newQty = Integer.parseInt(textField_3.getText());
							if (newQty!=0) {
								if (!(newQty>qty)) {
									String pname = textField_2.getText();
									String t = String.format("%.2f", price*(double)newQty);
									Object[] data = {pId, proId, pname, newQty, price,t};
									model = (DefaultTableModel) table_1.getModel();
									model.addRow(data);
									total += price*(double)newQty;
									lblNewLabel_1_1_3_1.setText(String.format("Total: "+"%.2f", total));
									pId++;
									clear();
								}
								else {
									JOptionPane.showMessageDialog(null, "Not enough stock", "Warning", 2);
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Please increase quantity", "Warning", 2);
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Stock is empty", "Warning", 2);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Product already purchased", "Warning", 2);
					}
				}
			}
		});
		btnAdd.setBounds(22, 343, 147, 59);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnAdd);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = UserDashboard.lblNewLabel_2.getText();
				MessageFormat header = new MessageFormat("Receipt -->   "+"Email: "+email+"   Total: "+total);
				MessageFormat footer = new MessageFormat("Page{0, number,integer}");
				try {
					table_1.print(JTable.PrintMode.FIT_WIDTH, header,footer);
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPrint.setBounds(22, 425, 147, 59);
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnPrint);
		
		JButton btnPurchase = new JButton("PURCHASE");
		btnPurchase.setBounds(193, 343, 160, 59);
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel) table_1.getModel();
				if (model.getRowCount()>0) {
					String[] value = new String[5];
					String email = UserDashboard.lblNewLabel_2.getText();
					value = purchaseDao.getUserValue(email);
					int uid = Integer.parseInt(value[0]);
					String uname = value[1];
					String uphone = value[2];
					String uaddress = value[3]+", "+value[4];
					String purchaseDate = df.format(date);
					String receiveDate = null;
					for (int i = 0; i<model.getRowCount(); i++) {
						int id = Integer.parseInt(model.getValueAt(i,0).toString());
						int pid = Integer.parseInt(model.getValueAt(i,1).toString());
						String pname = model.getValueAt(i,2).toString();
						int q = Integer.parseInt(model.getValueAt(i,3).toString());
						double pri = Double.parseDouble(model.getValueAt(i,4).toString());
						double tot = Double.parseDouble(model.getValueAt(i,5).toString());
						purchaseDao.insert(id, uid, uname, uphone, pid, pname, q, pri, tot, purchaseDate, uaddress, receiveDate, null, "Pending");
						int newQuantity = purchaseDao.getQty(pid) - q;
						purchaseDao.qtyUpdate(pid, newQuantity);
					}
					staDao.user(user.getUserId(email));
					JOptionPane.showMessageDialog(null, "Purchase success!");
					setVisible(false);
					UserDashboard.panel_4.setBackground(Color.LIGHT_GRAY);
					UserDashboard.lblNewLabel_4.setForeground(Color.BLACK);
					UserDashboard.lblNewLabel_5.setVisible(true);
					UserDashboard.lblNewLabel_5_1.setVisible(false);
					total = 0.0;
				}
				else {
					JOptionPane.showMessageDialog(null, "You have not purchased any product", "Warning", 2);
				}
			}
		});
		btnPurchase.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnPurchase);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(193, 425, 160, 59);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnClear);
		
		JLabel lblNewLabel_1_1 = new JLabel("Purchase ID");
		lblNewLabel_1_1.setBounds(90, 77, 90, 14);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Product name");
		lblNewLabel_1_1_1.setBounds(90, 151, 101, 14);
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Quantity");
		lblNewLabel_1_1_2.setBounds(90, 223, 79, 14);
		lblNewLabel_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Search product");
		lblNewLabel_1_1_3.setBounds(474, 40, 106, 14);
		lblNewLabel_1_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1_1_3);
		
		lblNewLabel_1_1_3_1 = new JLabel("Total: 0.0");
		lblNewLabel_1_1_3_1.setBounds(451, 333, 129, 25);
		lblNewLabel_1_1_3_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_1_3_1);
		
		JLabel lblNewLabel_1_1_3_1_1 = new JLabel("PURCHASE PAGE");
		lblNewLabel_1_1_3_1_1.setBounds(36, 11, 287, 46);
		lblNewLabel_1_1_3_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel_1_1_3_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(439, 77, 423, 243);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model = (DefaultTableModel) table.getModel();
				rowIndex = table.getSelectedRow();
				textField_2.setText(model.getValueAt(rowIndex, 1).toString());
				String s1 = model.getValueAt(rowIndex,3).toString();
				String s2 = model.getValueAt(rowIndex,4).toString();
				qty = Integer.parseInt(s1);
				price = Double.parseDouble(s2);  
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Produce ID", "Produce Name", "Category", "Quantity", "Price"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(89);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(439, 373, 430, 154);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Purchase ID", "Product ID", "Product Name", "Quantity", "Price", "Total"
			}
		));
		table_1.getColumnModel().getColumn(2).setPreferredWidth(93);
		
		/////////////////////////////////////////////////
		init();
	}
	
	/**
	 * Sub functions
	 */
	public static void init() {
		textField_1.setBackground(notEdit);
		textField_1.setText(String.valueOf(purchaseDao.getMaxRow()));
		productsTable();
		purchaseTable();
		pId = purchaseDao.getMaxRow();
	}
	
	//clear all textFields
	public static void clear() {
		textField_1.setText(String.valueOf(purchaseDao.getMaxRow()));
		textField_2.setText("");
		textField_3.setText("0");
		table.clearSelection();
		table_1.clearSelection();
		price = 0.0;
		qty = 0;
	}
	
	public static void productsTable() {
		productDao.getProductValue(table, "");
		model = (DefaultTableModel) table.getModel();
		table.setRowHeight(30);
		table.setShowGrid(true);
		table.setGridColor(Color.BLACK);
		table.setBackground(Color.WHITE);
		table.setSelectionBackground(Color.LIGHT_GRAY);
	}
	
	public static void purchaseTable() {
		model = (DefaultTableModel) table_1.getModel();
		table_1.setRowHeight(30);
		table_1.setShowGrid(true);
		table_1.setGridColor(Color.BLACK);
		table_1.setBackground(Color.WHITE);
		table_1.setSelectionBackground(Color.LIGHT_GRAY);
	}
	
	public static boolean isProductExist(int proId) {
		model = (DefaultTableModel) table_1.getModel();
		if (model.getRowCount()>0) {
			for (int i = 0; i<model.getRowCount(); i++) {
				int newProId = Integer.parseInt(model.getValueAt(i,1).toString());
				if (newProId == proId) {
					return true;
				}
			}
		}
		return false;
	}
}
