package pckg1;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AdminPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtCat;
	private JTextField txtPrice;
	private JTextField txtStock;

	/**
	 * Launch the application.
	 */
	
	ArrayList<Product> products = new ArrayList<Product>();
	
	public static void main(String[] args) {
		Product test = new Product("fsdhdfhh","fdhbdh","dfhfdh",5,2);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
					frame.setVisible(true);
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					int centerX = (screenSize.width - frame.getWidth()) / 2;
		            int centerY = (screenSize.height - frame.getHeight()) / 2;
		            frame.setLocation(centerX, centerY);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane =  new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel addProductLbl = new JLabel("Add Product");
		addProductLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addProductLbl.setBounds(93, 11, 98, 49);
		contentPane.add(addProductLbl);
		
		JLabel pNameLbl = new JLabel("Product Name");
		pNameLbl.setBounds(27, 109, 73, 14);
		contentPane.add(pNameLbl);
		
		JLabel pIdLbl = new JLabel("ProductID");
		pIdLbl.setBounds(27, 84, 73, 14);
		contentPane.add(pIdLbl);
		
		JLabel pCatLbl = new JLabel("Product Category");
		pCatLbl.setBounds(27, 134, 85, 14);
		contentPane.add(pCatLbl);
		
		JLabel pPriceLbl = new JLabel("Product Price");
		pPriceLbl.setBounds(27, 159, 85, 14);
		contentPane.add(pPriceLbl);
		
		JLabel pStockLbl = new JLabel("Product Stock");
		pStockLbl.setBounds(27, 184, 85, 14);
		contentPane.add(pStockLbl);
		
		txtID = new JTextField();
		txtID.setBounds(138, 78, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(138, 103, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtCat = new JTextField();
		txtCat.setBounds(138, 131, 86, 20);
		contentPane.add(txtCat);
		txtCat.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(138, 156, 86, 20);
		contentPane.add(txtPrice);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(138, 181, 86, 20);
		contentPane.add(txtStock);
		
		JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pID = txtID.getText();
				String pName = txtName.getText();
				String pCat = txtCat.getText();
				double pPrice = Double.parseDouble(txtPrice.getText());
				int pStock = Integer.parseInt(txtPrice.getText());
				
				Product newProduct = new Product(pID,pName,pCat,pPrice,pStock);
				products.add(newProduct);
				JOptionPane.showInputDialog(null,newProduct.name);
			}
		});
		btnAddProduct.setBounds(129, 237, 98, 23);
		contentPane.add(btnAddProduct);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(454, 27, 226, 22);
		contentPane.add(comboBox);
		comboBox.addItem("Sort by Price(Quick Sort)");
		comboBox.addItem("Sort by Name(Bubble Sort)");
		
		
		
		JButton btnAddStock = new JButton("Increase");
		btnAddStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddStock.setBounds(454, 325, 89, 23);
		contentPane.add(btnAddStock);
		
		JButton btnRmvStock = new JButton("Decrease");
		btnRmvStock.setBounds(569, 325, 89, 23);
		contentPane.add(btnRmvStock);
		
		JList<String> list = new JList<String>();
		list.setBounds(454, 60, 378, 254);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(743, 26, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
