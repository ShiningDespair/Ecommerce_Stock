package pckg1;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class MainPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	public static JPanel productPanel = new JPanel();
	public static Product test;
	public static int pageNumber = 1;
	public static int productNumber = 30;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 test = new Product("1","Test","Category",100,5);
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					MainPage frame = new MainPage();
					
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					int centerX = (screenSize.width - frame.getWidth()) / 2;
		            int centerY = (screenSize.height - frame.getHeight()) / 2;
		            frame.setLocation(centerX, centerY);
		            
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStoreName = new JLabel("OzStore");
		lblStoreName.setBounds(25, 25, 120, 35);
		lblStoreName.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contentPane.add(lblStoreName);
		
		textField = new JTextField();
		textField.setBounds(279, 41, 551, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnShoppingCart = new JButton("Shopping\r\n Cart");
		btnShoppingCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnShoppingCart.setBounds(840, 11, 141, 80);
		contentPane.add(btnShoppingCart);
		
		JPanel panelFilters = new JPanel();
		panelFilters.setBounds(25, 108, 204, 347);
		panelFilters.setBackground(new Color(192, 192, 192));
		panelFilters.setForeground(new Color(192, 192, 192));
		contentPane.add(panelFilters);
		panelFilters.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 35, 184, 22);
		panelFilters.add(comboBox);
		comboBox.addItem("Price (Quick Sort");
		comboBox.addItem("Product Name(Insertion Sort");
		
		JLabel lblNewLabel = new JLabel("Sort According to");
		lblNewLabel.setBounds(10, 11, 120, 14);
		panelFilters.add(lblNewLabel);
		
		JRadioButton rdbtnCAL = new JRadioButton("Computers And Laptops");
		rdbtnCAL.setBounds(10, 96, 184, 23);
		panelFilters.add(rdbtnCAL);
		
		JRadioButton rdBtnPhone = new JRadioButton("Cell Phones and Smart Phones");
		rdBtnPhone.setBounds(10, 122, 184, 23);
		panelFilters.add(rdBtnPhone);
		
		JRadioButton rdBtnTv = new JRadioButton("TVs and Home Cinema Systems");
		rdBtnTv.setBounds(10, 148, 184, 23);
		panelFilters.add(rdBtnTv);
		
		JRadioButton rdbtnElectronic = new JRadioButton("Electronic Accessories");
		rdbtnElectronic.setBounds(10, 174, 184, 23);
		panelFilters.add(rdbtnElectronic);
		
		//Radio button groups
		ButtonGroup catBtnGroup = new ButtonGroup();
		catBtnGroup.add(rdbtnElectronic);
		catBtnGroup.add(rdBtnTv);
		catBtnGroup.add(rdBtnPhone);
		catBtnGroup.add(rdbtnCAL);
		
		JLabel lblNewLabel_1 = new JLabel("Category");
		lblNewLabel_1.setBounds(10, 64, 120, 14);
		panelFilters.add(lblNewLabel_1);
		
		productPanel.setBackground(Color.LIGHT_GRAY);
		productPanel.setBounds(279, 108, 551, 347);
		contentPane.add(productPanel);
		productPanel.setLayout(new GridLayout(3,3,10,10));
		
		//page number logic
		//initial filling
		refill();
				
				JLabel lblPageNumber = new JLabel(String.valueOf(pageNumber));
				lblPageNumber.setBounds(520, 466, 45, 14);
				contentPane.add(lblPageNumber);
				
				//PREVIOUS  PAGE
				JButton btnPagePrev = new JButton("<");
				btnPagePrev.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(pageNumber>1) {
							pageNumber--;
							lblPageNumber.setText((String.valueOf(pageNumber)));
							productPanel.removeAll();
							refill();
						} else {
							return;
						}
					}
				});
				btnPagePrev.setBounds(460, 462, 50, 23);
				contentPane.add(btnPagePrev);
				
				//NEXT PAGE
				JButton btnPageNext = new JButton(">");
				btnPageNext.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(pageNumber<=Math.ceil(productNumber/9)) {
							pageNumber++;
							lblPageNumber.setText((String.valueOf(pageNumber)));
							productPanel.removeAll();
							refill();
						} else {
							return;
						}
					}
				});
				btnPageNext.setBounds(541, 462, 50, 23);
				contentPane.add(btnPageNext);			
				
				JButton btnAdminPanel = new JButton("Admin Panel");
				btnAdminPanel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnAdminPanel.setBounds(840, 102, 141, 80);
				contentPane.add(btnAdminPanel);
				
		
	}
	
	public void refill () {
		for(int i = 1 + 9*(pageNumber-1); i<= 9*pageNumber;i++) {
			
			if(i<=productNumber) {
				productPanel.add(new SingleProduct(test));
			} else {
				productPanel.add(new JPanel());
			}
		}
	}
}
