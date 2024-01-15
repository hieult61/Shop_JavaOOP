package admin;

import java.awt.EventQueue;
import dao.CategoryDao;
import dao.StatisticsDao;
import dao.UserDao;

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

public class ManageCategory extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	public static JTable table;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JTextField textField_3;
	///////////////////////////////////
	private static ManageCategory frame;
	private static Color notEdit = new Color(204,204,204);
	private static Color edit = new Color(255,255,255);
	public static CategoryDao cat = new CategoryDao();
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
					frame = new ManageCategory();
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
	public ManageCategory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 617);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(365, 119, 515, 405);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model = (DefaultTableModel) table.getModel();
				rowIndex = table.getSelectedRow();
				textField_1.setText(model.getValueAt(rowIndex, 0).toString());
				textField_2.setText(model.getValueAt(rowIndex, 1).toString());
				textField_3.setText(model.getValueAt(rowIndex, 2).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Category ID", "Category name", "Description"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.exit(0);
				setVisible(false);
				AdminDashboard.panel_4.setBackground(Color.LIGHT_GRAY);
				AdminDashboard.lblNewLabel_4.setForeground(Color.BLACK);
				AdminDashboard.lblNewLabel_5.setVisible(true);
				AdminDashboard.lblNewLabel_5_1.setVisible(false);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(847, 11, 49, 25);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel(null,new Object[] {"Category ID", "Category name", "Description"}));
				cat.getCategoryValue(table, textField.getText());
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
		textField_1.setBounds(51, 138, 249, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Category ID");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(51, 102, 105, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Category name");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(51, 186, 146, 20);
		contentPane.add(lblNewLabel_2_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(51, 217, 249, 27);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Description");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1_1.setBounds(51, 265, 146, 20);
		contentPane.add(lblNewLabel_2_1_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(51, 296, 249, 27);
		contentPane.add(textField_3);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isEmpty()) {
					int id = Integer.parseInt(textField_1.getText());
					String cname = textField_2.getText();
					String desc = textField_3.getText();
					if (!cat.isIDExist(id)) {
						if (!cat.isCategoryNameExist(cname)) {
							cat.insert(id, cname, desc);
							table.setModel(new DefaultTableModel(null,new Object[] {"Category ID", "Category name", "Description"}));
							cat.getCategoryValue(table, "");
							clear();
						}
						else {
							JOptionPane.showMessageDialog(null, "Category name already exists");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Category ID already exists");
					}
					staDao.admin();
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSave.setBounds(31, 371, 125, 52);
		contentPane.add(btnSave);
		
		JButton btnUpdate_1 = new JButton("UPDATE");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isEmpty()) {
					int cid = Integer.parseInt(textField_1.getText());
					if (cat.isIDExist(cid)) {
						if (!check()) {
							String cname = textField_2.getText();
							String desc = textField_3.getText();
							cat.update(cid, cname, desc);
							table.setModel(new DefaultTableModel(null,new Object[] {"Category ID", "Category name", "Description"}));
							cat.getCategoryValue(table, "");
							clear();
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Category ID does not exist");
					}
					staDao.admin();
				}
			}
		});
		btnUpdate_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUpdate_1.setBounds(184, 371, 125, 52);
		contentPane.add(btnUpdate_1);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter a category");
				}
				else {
					int cid = Integer.parseInt(textField_1.getText());
					if (cat.isIDExist(cid)) {
						cat.delete(cid);
						table.setModel(new DefaultTableModel(null,new Object[] {"Category ID", "Category name", "Description"}));
						cat.getCategoryValue(table, "");
						clear();  //clear all textFields
					}
					else {
						JOptionPane.showMessageDialog(null, "Category does not exist");
					}
					staDao.admin();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBounds(31, 453, 125, 52);
		contentPane.add(btnDelete);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				staDao.admin();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear.setBounds(184, 453, 125, 52);
		contentPane.add(btnClear);
		
		///////////////////////////////////////////
		init();
	}
	
	/**
	 * Sub functions
	 */
	public static void init() {
		textField_1.setBackground(notEdit);
		textField_1.setText(String.valueOf(cat.getMaxRow()));
		categoryTable();
	}
	
	public static void categoryTable() {
		cat.getCategoryValue(table, "");
		model = (DefaultTableModel) table.getModel();
		table.setRowHeight(30);
		table.setShowGrid(true);
		table.setGridColor(Color.BLACK);
		table.setBackground(Color.WHITE);
		table.setSelectionBackground(Color.LIGHT_GRAY);
	}
	
	public static boolean isEmpty() {
		if (textField_2.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Category name is required", "Warning", 2);
			return false;
		}
		if (textField_3.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Description is required", "Warning", 2);
			return false;
		}
		return true;
	}
	
	public static boolean check() {
		String newCategory = textField_2.getText();
		String oldCategory = model.getValueAt(rowIndex, 1).toString();
		if (newCategory.equals(oldCategory)) {
			return false;
		}
		else {
			if (!newCategory.equals(oldCategory)) {
				boolean x = cat.isCategoryNameExist(newCategory);
				if (x) {
					JOptionPane.showMessageDialog(null, "Category name exists", "Warning", 2);
				}
				return x;
			}
		}
		return false;
	}
	
	//clear all textFields
	public static void clear() {
		textField_1.setText(String.valueOf(cat.getMaxRow()));
		textField_2.setText("");
		textField_3.setText("");
		table.clearSelection();
	}
}
