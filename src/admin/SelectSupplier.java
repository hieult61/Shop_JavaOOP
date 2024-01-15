package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.PurchaseDao;
import dao.SupplierDao;
import supplier.SupplierDashboard;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SelectSupplier extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	public static JTable table;
	public static JTextField textField;
	///////////////////////////////////
	public static JComboBox comboBox;
	private static SelectSupplier frame;
	private static String[] supps;
	private static SupplierDao supplierDao = new SupplierDao();
	private static PurchaseDao purchaseDao = new PurchaseDao();
	public static DefaultTableModel model;
	public static int rowIndex=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SelectSupplier();
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
	public SelectSupplier() {
		setBackground(new Color(0, 153, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 0, 815, 544);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 196, 765, 337);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model = (DefaultTableModel) table.getModel();
				rowIndex = table.getSelectedRow();
			}
		});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Purchase ID", "User ID", "User name", "User phone", "Product ID", "Product name", "Quantity", "Price", "Total", "Purchase date", "Address", "Receive date", "Supplier name", "Status"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(3).setPreferredWidth(74);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(352, 159, 66, 25);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				table.setModel(new DefaultTableModel(null,new Object[] {"Purchase ID", "User ID", "User name", 
										"User phone", "Product ID", "Product name", "Quantity", "Price", "Total", 
										"Purchase date", "Address", "Receive date", "Supplier name", "Status"}));
				purchaseDao.getProductValue(table, textField.getText());
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(428, 159, 364, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.exit(0);
				setVisible(false);
				AdminDashboard.panel_4_2_3.setBackground(Color.LIGHT_GRAY);
				AdminDashboard.lblNewLabel_4_2_3.setForeground(Color.BLACK);
				AdminDashboard.lblNewLabel_5_3_3.setVisible(true);
				AdminDashboard.lblNewLabel_5_1_2_3.setVisible(false);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(756, 11, 49, 25);
		panel_1.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox.setBounds(27, 93, 200, 29);
		panel_1.add(comboBox);
		
		JLabel lblSupplier = new JLabel("Supplier");
		lblSupplier.setForeground(Color.WHITE);
		lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSupplier.setBounds(27, 57, 98, 25);
		panel_1.add(lblSupplier);
		
		JLabel lblUserAccount = new JLabel("Select Suppliers");
		lblUserAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserAccount.setForeground(Color.WHITE);
		lblUserAccount.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUserAccount.setBounds(0, 0, 778, 46);
		panel_1.add(lblUserAccount);
		
		JButton btnSelect = new JButton("SELECT");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel) table.getModel();
				if (table.getSelectedRow() >=0) {
					rowIndex = table.getSelectedRow();
					int id = Integer.parseInt(model.getValueAt(rowIndex, 0).toString());
					String supp = comboBox.getSelectedItem().toString();
					String status = "On the way";
					purchaseDao.setSuppStatus(id, supp, status);
					
					table.setModel(new DefaultTableModel(null,new Object[] {"Purchase ID", "User ID", "User name", 
							"User phone", "Product ID", "Product name", "Quantity", "Price", "Total", 
							"Purchase date", "Address", "Receive date", "Supplier name", "Status"}));
					purchaseDao.getProductValue(table, "");
				}
				else {
					JOptionPane.showMessageDialog(null, "Please select a purchase!","Warning",2);
				}
			}
		});
		btnSelect.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSelect.setBounds(260, 80, 125, 52);
		panel_1.add(btnSelect);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				table.clearSelection();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear.setBounds(406, 80, 125, 52);
		panel_1.add(btnClear);
		
		////////////////////////////////////////////
		init();
	}
	
	/**
	 * Sub functions
	 */
	public static void init() {
		supps = new String[supplierDao.countSuppliers()];
		setSuppliers();
		suppTable();
	}
	
	public static void setSuppliers() {
		supps = supplierDao.getSuppliers();
		for (String s : supps) {
			comboBox.addItem(s);
		}
	}
	
	public static void suppTable() {
		purchaseDao.getProductValue(table, "");
		model = (DefaultTableModel) table.getModel();
		table.setRowHeight(30);
		table.setShowGrid(true);
		table.setGridColor(Color.BLACK);
		table.setBackground(Color.WHITE);
		table.setSelectionBackground(Color.LIGHT_GRAY);
	}
}
