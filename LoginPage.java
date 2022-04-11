import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

// Harannesh A/L Arul Ananthan (1191101646)
public class LoginPage extends JPanel{      //View class for Login Page, generated using NetBeans
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel errorLabel;
	private JPanel loginPanel;
	private JLabel iconLabel;
	private JLabel usernameLabel;
	private JLabel appnameLabel;
	private JLabel passwordLabel;
	private JButton loginBtn;
	private JLabel createNewAccountLabel;
	private JPanel InfoPanel;	

	public LoginPage() {
		initialize();
	}

	// initialize login panel
	private void initialize() {
		setLayout(null);
		loginPanel = new JPanel();
		loginPanel.setBackground(Color.WHITE);
		loginPanel.setBounds(230, 0, 609, 671);
		add(loginPanel);
		loginPanel.setLayout(null);

		appnameLabel = new JLabel("Cyberjaya Online Rental Management System");
		appnameLabel.setFont(new Font("Source Serif Pro Black", Font.BOLD, 16));
		appnameLabel.setBounds(84, 213, 385, 21);
		loginPanel.add(appnameLabel);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		usernameField.setBackground(SystemColor.control);
		usernameField.setBounds(104, 315, 300, 50);
		loginPanel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		passwordField.setBackground(SystemColor.control);
		passwordField.setBounds(104, 409, 300, 50);
		loginPanel.add(passwordField);
		
		iconLabel = new JLabel();
		iconLabel.setIcon(loadImage("Images/logo2.png",150,150));
		iconLabel.setBounds(205, 48, 150, 150);
		loginPanel.add(iconLabel);
		
		usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Source Serif Pro Black", Font.BOLD, 16));
		usernameLabel.setBounds(104, 283, 150, 21);
		loginPanel.add(usernameLabel);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Source Serif Pro Black", Font.BOLD, 16));
		passwordLabel.setBounds(104, 377, 150, 21);
		loginPanel.add(passwordLabel);
		
		loginBtn = new JButton("LOGIN");
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setBackground(new Color(236, 77, 55));
		loginBtn.setBounds(200, 512, 100, 50);
		loginPanel.add(loginBtn);
		
		createNewAccountLabel = new JLabel("Create Account");
		createNewAccountLabel.setForeground(SystemColor.windowBorder);
		createNewAccountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		createNewAccountLabel.setFont(new Font("Source Serif Pro Black", Font.BOLD, 16));
		createNewAccountLabel.setBounds(179, 591, 150, 21);
		loginPanel.add(createNewAccountLabel);
		
		errorLabel = new JLabel();
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(10, 229, 489, 43);
		loginPanel.add(errorLabel);
		
		InfoPanel = new JPanel();
		InfoPanel.setBounds(0, 0, 509, 671);
		add(InfoPanel);
		InfoPanel.setLayout(null);
		
	}
	// used to load images using their path and size
	private ImageIcon loadImage(String path, int x, int y){
        Image image = new ImageIcon(this.getClass().getResource(path)).getImage();
        Image scaledImage = image.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
	}
		
	public JButton getLoginButton() {
		return loginBtn;
	}
	
	public JTextField getUsernameField() {
		return usernameField;
	}
	
	public JPasswordField getPasswordField() {
		return passwordField;
	}
	
	public JLabel getErrorLabel() {
		return errorLabel;
	}
	
	public JLabel getCreateNewAccountLabel() {
		return createNewAccountLabel;
	}
	
}
