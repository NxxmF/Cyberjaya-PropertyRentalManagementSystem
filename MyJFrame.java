import java.awt.Container;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JOptionPane;

public class MyJFrame extends JFrame{
		// only MyJFrame object that will be created, using singleton design pattern
		// all tenant and property manager panels, will change between them using SystemController
		private static MyJFrame myJFrame = new MyJFrame();
		private PropertyManagerHomePage homePage = new PropertyManagerHomePage();
		private SpecificPropertyView currentProperty;
		private LoginPage loginPage = new LoginPage();
		private SignupPage signupPage = new SignupPage();
		private RentRequestsPage requestsPage = new RentRequestsPage();
		private NewPropertyPage newPropertyPage = new NewPropertyPage();
		private ManagePropertiesPage managePropertiesPage = new ManagePropertiesPage();
		private SpecificManagerPropertyView SpecificManagerPropertyView;
		private EditPage editPage = new EditPage();		
	
	// Singleton
	private MyJFrame() {
		homePage = new PropertyManagerHomePage();
		setContentPane(homePage);
		this.setSize(1024,700);
		this.setVisible(true);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
	public static MyJFrame getMyJFrame(){  
		  return myJFrame;  
	}  

	// set the JFrame panel to login panel
	public void setPanelToLogin() {
		setContentPane(loginPage);
	}
	// set the JFrame panel to sign up panel
	public void setPanelToSignup() {
		setContentPane(signupPage);
	}
	public LoginPage getLoginPage() {
		return loginPage;
	}
	
	public PropertyManagerHomePage getPropertyManagerHomePage() {
		return homePage;
	}
	
	
	// set the JFrame panel to property details panel using the passed property object
	public void setPanelToProperty(Property property) {
		currentProperty = new SpecificPropertyView(property);
		setContentPane(currentProperty);
	}
	// set the JFrame panel to home page using propertyList passed (used mainly for searching)
	public void setPanelToHomeAndSearch(ArrayList<Property> propertyList) {
		Collections.sort(propertyList, new propertyComparatorByActive()); // sort by active first
		homePage.setNewProperties(propertyList);
		setContentPane(homePage);
	}

	
	public JLabel getBackIconLabel() {
		return currentProperty.getBackIconLabel();
	}
	public SpecificPropertyView getCurrentPropertyView() {
		return currentProperty;
	}
	
	// reset panels when logout, and set JFrame panel to login
	public void logOut() {
		loginPage = new LoginPage();
		homePage = new PropertyManagerHomePage();
		signupPage = new SignupPage();
		requestsPage = new RentRequestsPage();
		newPropertyPage = new NewPropertyPage();
		managePropertiesPage = new ManagePropertiesPage();
		editPage = new EditPage();
		setPanelToLogin();

	}
	
	public SignupPage getSignupPage() {
		return signupPage;
	}
	
	public RentRequestsPage getRequestsPage()  {
		return requestsPage;
	}
	// set the JFrame panel to rent request panel
	public void setPanelToRequestsPage()  {
		setContentPane(requestsPage);
	}
	
	public NewPropertyPage getNewPropertyPage()  {
		return newPropertyPage;
	}
	// set the JFrame panel to new property form panel
	public void setPanelToNewPropertyPage()  {
		newPropertyPage = new NewPropertyPage();
		setContentPane(newPropertyPage);
	}
	
	public ManagePropertiesPage getManagePropertiesPage()  {
		return managePropertiesPage;
	}
	// set the JFrame panel to manage properties panel
	public void setPanelToManagePropertiesPage() {
		setContentPane(managePropertiesPage);
	}
	
	public SpecificManagerPropertyView getSpecificManagerPropertyView()  {
		return SpecificManagerPropertyView;
	}
	// set the JFrame panel to property details panel using the passed property 
	public void setPanelToSpecificManagerPropertyView(Property p)  {
		SpecificManagerPropertyView = new SpecificManagerPropertyView(p);
		setContentPane(SpecificManagerPropertyView);
	}
	
	public EditPage getEditPage() {
		return editPage;
	}
	// set the JFrame panel to edit property panel
	public void setPanelToEditPage() {
		setContentPane(editPage);
	}
	
}
