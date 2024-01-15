package admin;

import java.awt.EventQueue;
import dao.ProductDao;
import dao.StatisticsDao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.Text;

import dao.CategoryDao;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManageProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	public static JTable table;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JTextField textField_3;
	public static JTextField textField_4;
	public static JComboBox comboBox;
	///////////////////////////////////
	private static ManageProduct frame;
	private static Color notEdit = new Color(204,204,204);
	private static Color edit = new Color(255,255,255);
	public static ProductDao product = new ProductDao();
	public StatisticsDao staDao = new StatisticsDao();
	public static DefaultTableModel model;
	public static int rowIndex;
	public static String[] categories;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ManageProduct();
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
	public ManageProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 636);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(344, 119, 536, 454);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model = (DefaultTableModel) table.getModel();
				rowIndex = table.getSelectedRow();
				textField_1.setText(model.getValueAt(rowIndex, 0).toString());
				textField_2.setText(model.getValueAt(rowIndex, 1).toString());
				String category = model.getValueAt(rowIndex, 2).toString();
				for(int i = 0; i<comboBox.getItemCount(); i++) {
					if (comboBox.getItemAt(i).equals(category)) {
						comboBox.setSelectedIndex(i);
						break;
					}
				}
				textField_3.setText(model.getValueAt(rowIndex, 3).toString());
				textField_4.setText(model.getValueAt(rowIndex, 4).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product ID", "Product name", "Category", "Quantity", "Price"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.exit(0);
				setVisible(false);
				AdminDashboard.panel_4_1.setBackground(Color.LIGHT_GRAY);
				AdminDashboard.lblNewLabel_4_1.setForeground(Color.BLACK);
				AdminDashboard.lblNewLabel_5_2.setVisible(true);
				AdminDashboard.lblNewLabel_5_1_1.setVisible(false);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(847, 11, 49, 25);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				table.setModel(new DefaultTableModel(null,new Object[] {"Product ID", 
						"Product name", "Category", "Quantity", "Price"}));
				product.getProductValue(table, textField.getText());
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(639, 74, 241, 27);
		contentPane.add(textField);
		
		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(561, 73, 68, 25);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(51, 131, 249, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Product ID");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(51, 102, 105, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Product name");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(51, 169, 146, 20);
		contentPane.add(lblNewLabel_2_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(51, 190, 249, 27);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Category");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1_1.setBounds(51, 228, 146, 20);
		contentPane.add(lblNewLabel_2_1_1);
		
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
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(51, 299, 249, 27);
		contentPane.add(textField_3);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isEmpty()) {
					int id = Integer.parseInt(textField_1.getText());
					String pname = textField_2.getText();
					String cat = comboBox.getSelectedItem().toString();
					int qty = Integer.parseInt(textField_3.getText());
					if (isNumeric(textField_4.getText())) {
						double price = Double.parseDouble(textField_4.getText());
						if (!product.isIDExist(id)) {
							if (!product.isProCatExist(pname, cat)) {
								product.insert(id, pname, cat, qty, price);
								table.setModel(new DefaultTableModel(null,new Object[] {"Product ID", 
										"Product name", "Category", "Quantity", "Price"}));
								product.getProductValue(table, "");
								clear();
							}
							else {
								JOptionPane.showMessageDialog(null, "Product and category already exists");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Product already exists");
						}
					}
					staDao.admin();
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSave.setBounds(32, 439, 125, 52);
		contentPane.add(btnSave);
		
		JButton btnUpdate_1 = new JButton("UPDATE");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isEmpty()) {
					int id = Integer.parseInt(textField_1.getText());
					String pname = textField_2.getText();
					String cat = comboBox.getSelectedItem().toString();
					int qty = Integer.parseInt(textField_3.getText());
					if (isNumeric(textField_4.getText())) {
						double price = Double.parseDouble(textField_4.getText());
						if (product.isIDExist(id)) {
							if (!check()) {
								product.update(id, pname, cat, qty, price);
								table.setModel(new DefaultTableModel(null,new Object[] {"Product ID", 
										"Product name", "Category", "Quantity", "Price"}));
								product.getProductValue(table, "");
								clear();
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Product already exists");
						}
					}
					staDao.admin();
				}
			}
		});
		btnUpdate_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUpdate_1.setBounds(185, 439, 125, 52);
		contentPane.add(btnUpdate_1);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textField_1.getText());
				if (product.isIDExist(id)) {
					product.delete(id);
					table.setModel(new DefaultTableModel(null,new Object[] {"Product ID", 
							"Product name", "Category", "Quantity", "Price"}));
					product.getProductValue(table, "");
					clear();
				}
				else {
					JOptionPane.showMessageDialog(null, "Product dose not exist");
				}
				staDao.admin();
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBounds(32, 521, 125, 52);
		contentPane.add(btnDelete);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				staDao.admin();
				clear();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear.setBounds(185, 521, 125, 52);
		contentPane.add(btnClear);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(142, 228, 155, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Quantity");
		lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1_1_1.setBounds(51, 268, 146, 20);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Price");
		lblNewLabel_2_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1_1_1_1.setBounds(51, 337, 146, 20);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())){
					e.consume();
					JOptionPane.showMessageDialog(null, "Price contains numbers only", "Warning", 2);
				}
			}
		});
		textField_4.setText("0.0");
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(51, 368, 249, 27);
		contentPane.add(textField_4);
		
		////////////////////////////////////////////////
		init();
	}
	
	/**
	 * Sub functions
	 */
	public static void init() {
		textField_1.setBackground(notEdit);
		textField_1.setText(String.valueOf(product.getMaxRow()));
		categories = new String[product.countCategories()];
		setCat();
		productTable();
	}
	
	public static void productTable() {
		product.getProductValue(table, "");
		model = (DefaultTableModel) table.getModel();
		table.setRowHeight(30);
		table.setShowGrid(true);
		table.setGridColor(Color.BLACK);
		table.setBackground(Color.WHITE);
		table.setSelectionBackground(Color.LIGHT_GRAY);
	}
	
	public static void setCat() {
		categories = product.getCat();
		for (String s : categories) {
			comboBox.addItem(s);
		}
	}
	
	//clear all textFields
	public static void clear() {
		textField_1.setText(String.valueOf(product.getMaxRow()));
		textField_2.setText("");
		comboBox.setSelectedIndex(0);
		textField_3.setText("0");
		textField_4.setText("0.0");
		table.clearSelection();
	}
	
	public static boolean isEmpty() {
		if (textField_2.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Product name is required", "Warning", 2);
			return false;
		}
		if (textField_3.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Quantity is required", "Warning", 2);
			return false;
		}
		if (Integer.parseInt(textField_3.getText())<=0) {
			JOptionPane.showMessageDialog(null, "Quantity is required", "Warning", 2);
			return false;
		}
		if (textField_4.getText().equals("0.0") || textField_4.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Product price is required", "Warning", 2);
			return false;
		}
		return true;
	}
	
	public static boolean isNumeric(String s) {
		try {
			double d = Double.parseDouble(s);
			return true;
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null,""+e+"\n Numeric value required for price!");
		}
		return false;
	}
	
	public static boolean check() {
		String newProduct = textField_2.getText();
		String newCategory = comboBox.getSelectedItem().toString();
		String oldProduct = model.getValueAt(rowIndex, 1).toString();
		String oldCategory = model.getValueAt(rowIndex, 2).toString();
		
		if (newProduct.equals(oldProduct) && newCategory.equals(oldCategory)) {
			return false;
		}
		else {
			boolean x = product.isProCatExist(newProduct, newCategory);
			if (x) {
				JOptionPane.showMessageDialog(null, "Product and category already exist", "Warning", 2);
				return x;
			}
		}
		return false;
	}
}
