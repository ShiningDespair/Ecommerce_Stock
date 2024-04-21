package pckg1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SingleProduct extends JPanel {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1;

	public SingleProduct(Product product) {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBounds(0, 0, 544, 115);
        setBackground(Color.WHITE);
        
        JPanel panelImage = new JPanel();
        panelImage.setBackground(Color.CYAN);
        panelImage.setPreferredSize(new Dimension(50, 50));
        add(panelImage);
        
        JPanel productInfoPanel = new JPanel();
        productInfoPanel.setLayout(new GridLayout(3, 1));
        add(productInfoPanel);
        
        JLabel lblProductName = new JLabel(product.name);
        productInfoPanel.add(lblProductName);
        
        JLabel lblNewLabel_2 = new JLabel(String.valueOf(product.price));
        productInfoPanel.add(lblNewLabel_2);
        
        JLabel lblStock = new JLabel(String.valueOf(product.stock));
        productInfoPanel.add(lblStock);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(buttonPanel);
        
        JButton btnBuy = new JButton("Buy");
        buttonPanel.add(btnBuy);
        
        JButton btnAdd = new JButton("Add");
        buttonPanel.add(btnAdd);
    }
}
