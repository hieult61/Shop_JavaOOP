package supplier;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.PurchaseDao;
import dao.SupplierDao;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyDeliveries extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	public static  JTable table;
	public static  JTextField textField;
	///////////////////////////////////
	private static MyDeliveries frame;
	public static DefaultTableModel model;
	public static int rowIndex=0;
	public static PurchaseDao purchaseDao = new PurchaseDao();
	public static String supplierName;
	public static SupplierDao supplierDao = new SupplierDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MyDeliveries();
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
	public MyDeliveries() {
		setBackground(new Color(0, 153, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 0, 815, 480);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 100, 744, 357);
		panel_1.add(scrollPane);
		
		table = new JTable();
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
		
		JLabel lblNewLabel = new JLabel("Product search");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(306, 64, 131, 25);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				table.setModel(new DefaultTableModel(null,new Object[] {"Purchase ID", "User ID", "User name", 
						"User phone", "Product ID", "Product name", "Quantity", "Price", "Total", 
						"Purchase date", "Address", "Receive date", "Supplier name", "Status"}));
				purchaseDao.getDeliveredProductValue(table, textField.getText(), supplierName);
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(428, 64, 364, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.exit(0);
				setVisible(false);
				SupplierDashboard.panel_4_1.setBackground(Color.LIGHT_GRAY);
				SupplierDashboard.lblNewLabel_4_1.setForeground(Color.BLACK);
				SupplierDashboard.lblNewLabel_5_2.setVisible(true);
				SupplierDashboard.lblNewLabel_5_1_1.setVisible(false);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(756, 11, 49, 25);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblDelivery = new JLabel("My Deliveries");
		lblDelivery.setForeground(Color.WHITE);
		lblDelivery.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDelivery.setBounds(48, 11, 212, 37);
		panel_1.add(lblDelivery);
		
		/////////////////////////////////////////////////
		init();
	}
	
	/**
	 * Sub functions
	 */
	public static void init() {
		supplierName = supplierDao.getSupplierName(SupplierDashboard.lblNewLabel_2.getText());
		myDeliveredTable();
	}
	
	public static void myDeliveredTable() {
		purchaseDao.getDeliveredProductValue(table, "", supplierName);
		model = (DefaultTableModel) table.getModel();
		table.setRowHeight(30);
		table.setShowGrid(true);
		table.setGridColor(Color.BLACK);
		table.setBackground(Color.WHITE);
		table.setSelectionBackground(Color.LIGHT_GRAY);
	}
}
