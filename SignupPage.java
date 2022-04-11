import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

// Harannesh A/L Arul Ananthan (1191101646)
// signup panel
public class SignupPage extends JPanel{
	private JTextField usernameTextField; // username text field
	private JTextField emailTextField; // email text field
	private JTextField fullNameTextField; // full name text field
	private JTextField mobileNoTextField;// mobile text field
	private JToggleButton agentToggleButton; // toggle button detects user type
	private JToggleButton ownerToggleButton;
	private JToggleButton tenantToggleButton;
	private JTextField licenseOrGrantIDTextField; // license / grant text field
	private JLabel licenseOrGrantIDLabel;
	private JPasswordField passwordTextField; // password text field
	private JPasswordField repeatPasswordTextField; // password 2 text field
	private JPanel mainPanel;// main sign up panel, holds all fields, labels and buttons
	private JLabel usernameLabel;
	private JLabel emailLabel;
	private JLabel passwordLabel;
	private JLabel fullNameLabel;
	private JLabel mobilNoLabel;
	private JLabel repeatPasswordLabel;
	private JLabel accountTypeLabel;
	private JButton signupButton;
	private JLabel errorLabel;
	private JLabel orLabel;
	private JLabel loginLabel;
	
	public SignupPage() {
		initialize();
	}

	// initialize the panels
	private void initialize() {
		setLayout(null);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(150, 0, 708, 661);
		add(mainPanel);
		mainPanel.setLayout(null);
		
		usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Source Serif Pro Black", Font.BOLD, 16));
		usernameLabel.setBounds(36, 81, 150, 21);
		mainPanel.add(usernameLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		usernameTextField.setColumns(10);
		usernameTextField.setBackground(SystemColor.menu);
		usernameTextField.setBounds(36, 113, 300, 50);
		mainPanel.add(usernameTextField);
		
		emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Source Serif Pro Black", Font.BOLD, 16));
		emailLabel.setBounds(36, 183, 150, 21);
		mainPanel.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		emailTextField.setColumns(10);
		emailTextField.setBackground(SystemColor.menu);
		emailTextField.setBounds(36, 215, 300, 50);
		mainPanel.add(emailTextField);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Source Serif Pro Black", Font.BOLD, 16));
		passwordLabel.setBounds(36, 285, 150, 21);
		mainPanel.add(passwordLabel);
		
		fullNameTextField = new JTextField();
		fullNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		fullNameTextField.setColumns(10);
		fullNameTextField.setBackground(SystemColor.menu);
		fullNameTextField.setBounds(372, 113, 300, 50);
		mainPanel.add(fullNameTextField);
		
		fullNameLabel = new JLabel("Full Name");
		fullNameLabel.setFont(new Font("Source Serif Pro Black", Font.BOLD, 16));
		fullNameLabel.setBounds(372, 81, 150, 21);
		mainPanel.add(fullNameLabel);
		
		mobilNoLabel = new JLabel("Mobile No");
		mobilNoLabel.setFont(new Font("Source Serif Pro Black", Font.BOLD, 16));
		mobilNoLabel.setBounds(372, 183, 150, 21);
		mainPanel.add(mobilNoLabel);
		
		mobileNoTextField = new JTextField();
		mobileNoTextField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		mobileNoTextField.setColumns(10);
		mobileNoTextField.setBackground(SystemColor.menu);
		mobileNoTextField.setBounds(372, 215, 300, 50);
		mainPanel.add(mobileNoTextField);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordTextField.setBackground(SystemColor.menu);
		passwordTextField.setBounds(36, 317, 300, 50);
		mainPanel.add(passwordTextField);

		repeatPasswordTextField = new JPasswordField();
		repeatPasswordTextField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		repeatPasswordTextField.setBackground(SystemColor.menu);
		repeatPasswordTextField.setBounds(372, 317, 300, 50);
		mainPanel.add(repeatPasswordTextField);

		repeatPasswordLabel = new JLabel("Repeat Password");
		repeatPasswordLabel.setFont(new Font("Source Serif Pro Black", Font.BOLD, 16));
		repeatPasswordLabel.setBounds(372, 285, 150, 21);
		mainPanel.add(repeatPasswordLabel);
		
		accountTypeLabel = new JLabel("Account Type");
		accountTypeLabel.setFont(new Font("Source Serif Pro Black", Font.BOLD, 16));
		accountTypeLabel.setBounds(36, 387, 150, 21);
		mainPanel.add(accountTypeLabel);
		
		agentToggleButton = new JToggleButton("Property Agent");
		agentToggleButton.setForeground(Color.WHITE);
		agentToggleButton.setFocusPainted(false);
		agentToggleButton.setBackground(new Color(0, 0, 205));
		agentToggleButton.addActionListener(new ActionListener() { // toggle button listener, used only to change the view
			public void actionPerformed(ActionEvent e) {
				if(agentToggleButton.isSelected()) {
					ownerToggleButton.setSelected(false);
					licenseOrGrantIDLabel.setVisible(true);
					licenseOrGrantIDTextField.setVisible(true);
					licenseOrGrantIDLabel.setText("Enter your estate license number");
				}
				else {
					licenseOrGrantIDLabel.setVisible(false);
					licenseOrGrantIDTextField.setVisible(false);
				}
				
			}
		});
		agentToggleButton.setBounds(36, 419, 145, 40);
		mainPanel.add(agentToggleButton);
		
		ownerToggleButton = new JToggleButton("Property Owner");
		ownerToggleButton.setForeground(Color.WHITE);
		ownerToggleButton.setFocusPainted(false);
		ownerToggleButton.setBackground(new Color(0, 0, 205));
		ownerToggleButton.addActionListener(new ActionListener() { // toggle button listener, used only to change the view
			public void actionPerformed(ActionEvent e) {
				if(ownerToggleButton.isSelected()) {
					agentToggleButton.setSelected(false);
					licenseOrGrantIDLabel.setVisible(true);
					licenseOrGrantIDTextField.setVisible(true);
					licenseOrGrantIDLabel.setText("Enter your property grant number");
				}
				else {
					licenseOrGrantIDLabel.setVisible(false);
					licenseOrGrantIDTextField.setVisible(false);
				}
				
			}
		});
		ownerToggleButton.setBounds(191, 419, 145, 40);
		mainPanel.add(ownerToggleButton);

		tenantToggleButton = new JToggleButton("Tenant");
		tenantToggleButton.setForeground(Color.WHITE);
		tenantToggleButton.setFocusPainted(false);
		tenantToggleButton.setBackground(new Color(0, 0, 205));
		tenantToggleButton.addActionListener(new ActionListener() { // toggle button listener, used only to change the view
			public void actionPerformed(ActionEvent e) {
				if(tenantToggleButton.isSelected()) {
					agentToggleButton.setSelected(false);
					licenseOrGrantIDLabel.setVisible(false);
					licenseOrGrantIDTextField.setVisible(false);
				}
				else {
					licenseOrGrantIDLabel.setVisible(false);
					licenseOrGrantIDTextField.setVisible(false);
				}
				
			}
		});
		tenantToggleButton.setBounds(36, 479, 145, 40);
		mainPanel.add(tenantToggleButton);
		
		licenseOrGrantIDLabel = new JLabel("");
		licenseOrGrantIDLabel.setFont(new Font("Source Serif Pro Black", Font.BOLD, 16));
		licenseOrGrantIDLabel.setBounds(372, 387, 300, 21);
		licenseOrGrantIDLabel.setVisible(false);
		mainPanel.add(licenseOrGrantIDLabel);
		
		licenseOrGrantIDTextField = new JTextField();
		licenseOrGrantIDTextField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		licenseOrGrantIDTextField.setColumns(10);
		licenseOrGrantIDTextField.setBackground(SystemColor.menu);
		licenseOrGrantIDTextField.setBounds(372, 419, 300, 50);
		licenseOrGrantIDTextField.setVisible(false);
		mainPanel.add(licenseOrGrantIDTextField);
		
		
		signupButton = new JButton("Sign up");
		signupButton.setForeground(Color.BLACK);
		signupButton.setBackground(new Color(152, 251, 152));
		signupButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signupButton.setBounds(224, 535, 120, 50);
		signupButton.setFocusPainted(false);
		mainPanel.add(signupButton);
		
		errorLabel = new JLabel("");
		errorLabel.setForeground(new Color(255, 0, 0));
		errorLabel.setBounds(36, 21, 636, 42);
		mainPanel.add(errorLabel);
		
		orLabel = new JLabel("or");
		orLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		orLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orLabel.setBounds(343, 550, 28, 20);
		mainPanel.add(orLabel);
		
		loginLabel = new JLabel("Log in");
		loginLabel.setForeground(new Color(0, 0, 0));
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		loginLabel.setBounds(371, 545, 64, 30);
		mainPanel.add(loginLabel);
		this.setSize(1024,700);
		this.setVisible(true);
	}
	// used to load images using their path and size
	private ImageIcon loadImage(String path, int x, int y){
        Image image = new ImageIcon(this.getClass().getResource(path)).getImage();
        Image scaledImage = image.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
	}
	
	public JButton getSignupButton() {
		return signupButton;
	}
	
	public JLabel getLoginLabel() {
		return loginLabel;
	}
	// used after signup is done successfully, resets all fields
	public void resetSignupFields() {
		usernameTextField.setText("");
		emailTextField.setText("");
		fullNameTextField.setText("");
		mobileNoTextField.setText("");
		passwordTextField.setText("");
		repeatPasswordTextField.setText("");
		agentToggleButton.setSelected(false);
		ownerToggleButton.setSelected(false);
		licenseOrGrantIDTextField.setText("");
	}
	
	public JTextField getUsernameTextField() {
		return usernameTextField;
	}
	
	public JTextField getEmailTextField() {
		return emailTextField;
	}
	
	public JTextField getFullNameTextField() {
		return fullNameTextField;
	}
	
	public JTextField getMobileNoTextField() {
		return mobileNoTextField;
	}
	
	public JPasswordField getPasswordTextField() {
		return passwordTextField;
	}
	
	public JPasswordField getRepeatPasswordTextField() {
		return repeatPasswordTextField;
	}
	
	public JToggleButton getAgentToggleButton() {
		return agentToggleButton;
	}
	
	public JToggleButton getOwnerToggleButton() {
		return ownerToggleButton;
	}
	
	public JToggleButton getTenantToggleButton() {
		return tenantToggleButton;
	}

	public JTextField getLicenseOrGrantIDTextField() {
		return licenseOrGrantIDTextField;
	}
	
	public JLabel getErrorLabel() {
		return errorLabel;
	}
	
}
