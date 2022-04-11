import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JSeparator;

// Harannesh A/L Arul Ananthan (1191101646)
public class HomePagePropertyView extends JFrame{  //View class for Home Page Property View, generated using NetBeans

	private JPanel slideMenu;
	private JLabel menuIcon;
	private JLabel closeMenu;
	private JPanel mainPanel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	int currentPicIndex = 0;
	
	public HomePagePropertyView() {
		getContentPane().setLayout(null);
		
		initialize();
	}
	
	// public static void main(String[] args) {
	// 	new HomePagePropertyView();
	// }
	
	private void initialize() {
		File propertyPics = new File("propertyImages/");
		File[] propertyPictureFiles = propertyPics.listFiles();
		String[] propertyPicturePath = propertyPics.list();
		for(int i = 0; i < propertyPicturePath.length; ++i) {
			StringBuilder path = new StringBuilder("propertyImages/");
			propertyPicturePath[i] = path + propertyPicturePath[i];
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(84, 92, 800, 400);
		getContentPane().add(panel);
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(800,400));
		panel.setLayout(null);
		
		JLabel priceLabel = new JLabel("Price");
		priceLabel.setFont(new Font("Source Serif Pro Black", Font.BOLD, 23));
		priceLabel.setBounds(430, 11, 320, 24);
		panel.add(priceLabel);
		
		JLabel propertyTitleLabel = new JLabel("Property / project name");
		propertyTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		propertyTitleLabel.setBounds(430, 46, 320, 21);
		panel.add(propertyTitleLabel);
		
		JLabel propertyTypeLabel = new JLabel("Type");
		propertyTypeLabel.setBounds(430, 76, 300, 24);
		panel.add(propertyTypeLabel);
		
		JLabel PropertySizeLabel = new JLabel("Size");
		PropertySizeLabel.setBounds(430, 102, 150, 24);
		panel.add(PropertySizeLabel);
		
		JLabel PropertyFurnishLabel = new JLabel("furnishing");
		PropertyFurnishLabel.setBounds(580, 102, 150, 24);
		panel.add(PropertyFurnishLabel);
		
		JLabel bedIconLabel = new JLabel("bed icon");
		bedIconLabel.setBounds(430, 148, 46, 14);
		panel.add(bedIconLabel);
		
		JLabel bedNumLabel = new JLabel("bednum");
		bedNumLabel.setBounds(488, 148, 46, 14);
		panel.add(bedNumLabel);
		
		JLabel bathIconLabel = new JLabel("bath icon");
		bathIconLabel.setBounds(554, 148, 46, 14);
		panel.add(bathIconLabel);
		
		JLabel bathNumLabel = new JLabel("bathnum");
		bathNumLabel.setBounds(612, 148, 46, 14);
		panel.add(bathNumLabel);
		
		JButton btnNewButton_2 = new JButton("View Details");
		btnNewButton_2.setBounds(565, 329, 165, 40);
		panel.add(btnNewButton_2);
		
		JLabel propertyPicLabel = new JLabel("");
		propertyPicLabel.setBounds(0, 0, 400, 400);
		panel.add(propertyPicLabel);
		this.setVisible(true);
		this.setSize(1024,700);
	 }
	private ImageIcon loadImage(String path, int x, int y){
        Image image = new ImageIcon(this.getClass().getResource(path)).getImage();
        Image scaledImage = image.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
	} 
}
