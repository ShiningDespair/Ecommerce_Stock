package pckg1;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.*; 
import java.awt.*; 
import java.awt.GridLayout;

public class ShoppingCartPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Product test = new Product("1","Test","Category",100,5);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingCartPage frame = new ShoppingCartPage();
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
	public ShoppingCartPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(1, 1, 972, 649);
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
		        
	        for (int i = 1; i <= 50; i++) { 
	            
	            panel.add(new SingleProduct(test)); 
	        }
	        contentPane.setLayout(null);
	        
	        JScrollPane scrollPane = new JScrollPane(panel);
	        scrollPane.setBounds(378, 92, 297, 440);
	        contentPane.add(scrollPane); 
	        
	        JButton btnNewButton = new JButton("Buy All");
	        btnNewButton.setBounds(480, 558, 109, 49);
	        contentPane.add(btnNewButton);

		
	}
}
