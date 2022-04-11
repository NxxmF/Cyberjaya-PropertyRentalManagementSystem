import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import javax.swing.Action;

// Muhammad Luqman Bin Zainon @ Mohd Rastam (1191100953)
// after clicking view more details in Manage Properties panel, this panel will show the property details
public class SpecificManagerPropertyView extends JPanel{

	private int currentPicIndex = 0;
	private JScrollPane scrollPane;
	private JPanel mainPanel;	
	private JPanel picSlider;
	private JLabel leftArrow;
	private JLabel rightArrow;
	private JLabel shownPictureLabel;
	private JLabel propertyPriceLabel;
	private JLabel PropertyTitleLabel;
	private JLabel propertyTypeLabel;
	private JLabel propertySizeLabel;
	private JLabel propertyFurnishLabel;
	private JLabel bedIcon;
	private JLabel bedNumLabel;
	private JLabel bathIcon;
	private JLabel bathNumLabel;
	private JPanel header;
	private JLabel backIconLabel;
	private JTextPane propertyDescriptionTextPane;
	private JScrollPane descriptionPanel;
	private JPanel facilitiesPanel;
	private JLabel facilitiesHeaderLabel;
	private JSeparator facilitiesSeparator;
	private JPanel featuresPanel;
	private JLabel featuresHeaderLabel;
	private JSeparator featuresSeparator;
	private JPanel applyToRentPanel;
	private JButton DeleteButton;
	private JPanel managerInfoPanel;
	private JLabel managerNameLabel;
	private JLabel managerNameHolder;
	private JLabel managerPhoneNumberLabel;
	private JLabel managerPhoneHolder;
	private JLabel propertyManagerEmail;
	private JLabel managerEmailHolder;
	private Property currentProperty;
	private JLabel rentRateLabel;
	private User propertyManager;
	private JButton activateButton;
	private JButton EditButton;
	private JLabel approvalStatusLabel;

	
	public SpecificManagerPropertyView() {
		initialize();
		initializePicSlider();
		initializePropertyInfo();
		initializeHeader();
		initializeApplyToRent();
	}
	public SpecificManagerPropertyView(Property currentProperty) {
		this.currentProperty = currentProperty;
		initialize();
		initializePicSlider();
		initializePropertyInfo();
		initializeHeader();
		initializeFeatures();
		initializeFacilities();
		initializeApplyToRent();
	}
	

	
	private void initializePicSlider() {
		picSlider = new JPanel();
		picSlider.setLayout(null);
		picSlider.setBackground(Color.BLACK);
		picSlider.setBounds(0, 71, 989, 376);
		mainPanel.add(picSlider);
		
		leftArrow = new JLabel("");
		leftArrow.setEnabled(false);
		leftArrow.setIcon(loadImage("Images/leftArrow.png",30,50));
		leftArrow.setBounds(0, 163, 50, 50);
		picSlider.add(leftArrow);
		
		rightArrow = new JLabel("");
		if(currentProperty.getPropertyPicturePath().length == 1)
			rightArrow.setEnabled(false);
		rightArrow.setIcon(loadImage("Images/rightArrow.png",30,50));
		rightArrow.setBounds(939, 163, 50, 50);
		picSlider.add(rightArrow);
		
		
		shownPictureLabel = new JLabel("");
		shownPictureLabel.setBounds(247, 0, 495, 376);
		shownPictureLabel.setIcon(loadImage(currentProperty.getPropertyPicturePath()[0],495,376));
		picSlider.add(shownPictureLabel);
		
		rightArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rightArrow.isEnabled())
					shownPictureLabel.setIcon(loadImage(currentProperty.getPropertyPicturePath()[++currentPicIndex],495,376));
				if(currentPicIndex == currentProperty.getPropertyPicturePath().length -1)
					rightArrow.setEnabled(false);
				if(currentPicIndex > 0)
					leftArrow.setEnabled(true);
			}
		});
		
		leftArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(leftArrow.isEnabled())
					shownPictureLabel.setIcon(loadImage(currentProperty.getPropertyPicturePath()[--currentPicIndex],495,376));
				if(currentPicIndex == 0)
					leftArrow.setEnabled(false);
				if(currentPicIndex > 0)
					rightArrow.setEnabled(true);
			}
		});
	}
	private void initializePropertyInfo() {
		
		propertyPriceLabel = new JLabel("Price RM " + Double.toString(currentProperty.getPrice()));
		propertyPriceLabel.setFont(new Font("Source Serif Pro Black", Font.BOLD, 23));
		propertyPriceLabel.setBounds(10, 490, 250, 24);
		mainPanel.add(propertyPriceLabel);
		
		rentRateLabel = new JLabel("(RM " + Double.toString(currentProperty.getRentalRate()) + " per sq. ft.)");
		rentRateLabel.setBounds(260, 490, 150, 24);
		mainPanel.add(rentRateLabel);
		
		PropertyTitleLabel = new JLabel(currentProperty.getPropertyName());
		PropertyTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		PropertyTitleLabel.setBounds(10, 525, 320, 21);
		mainPanel.add(PropertyTitleLabel);
		
		propertyTypeLabel = new JLabel(currentProperty.getPropertyType());
		propertyTypeLabel.setBounds(10, 575, 167, 24);
		mainPanel.add(propertyTypeLabel);
		
		propertySizeLabel = new JLabel("Built-up :" + Integer.toString(currentProperty.getSize()) + " sq. ft.");
		propertySizeLabel.setBounds(187, 575, 167, 24);
		mainPanel.add(propertySizeLabel);
		
		propertyFurnishLabel = new JLabel(currentProperty.getFurnishing());
		propertyFurnishLabel.setBounds(356, 575, 167, 24);
		mainPanel.add(propertyFurnishLabel);
		
		bedIcon = new JLabel();
		bedIcon.setIcon(loadImage("Images/bed.png", 40, 40));
		bedIcon.setBounds(20, 616, 40, 40);
		mainPanel.add(bedIcon);
		
		bedNumLabel = new JLabel(Integer.toString(currentProperty.getBedRoomsNum()));
		bedNumLabel.setBounds(80, 616, 40, 40);
		mainPanel.add(bedNumLabel);
		
		bathIcon = new JLabel("");
		bathIcon.setIcon(loadImage("Images/bath.png", 40, 40));
		bathIcon.setBounds(150, 616, 40, 40);
		mainPanel.add(bathIcon);
		
		bathNumLabel = new JLabel(Integer.toString(currentProperty.getBathRoomsNum()));
		bathNumLabel.setBounds(210, 616, 40, 40);
		mainPanel.add(bathNumLabel);
		
		propertyDescriptionTextPane = new JTextPane();
		propertyDescriptionTextPane.setFont(new Font("Tahoma", Font.PLAIN, 17));
		propertyDescriptionTextPane.setText(currentProperty.getDescription());
		propertyDescriptionTextPane.setEditable(false);
		
		descriptionPanel = new JScrollPane(propertyDescriptionTextPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                							JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		descriptionPanel.setBounds(0, 657, 989, 300);
		mainPanel.add(descriptionPanel);
	}
	private void initializeHeader(){
		header = new JPanel();
		header.setBackground(new Color(236, 77, 55));
		header.setBounds(0, 0, 989, 71);
		mainPanel.add(header);
		header.setLayout(null);
		
		backIconLabel = new JLabel();
		backIconLabel.setIcon(loadImage("Images/back.png", 75, 65));
		backIconLabel.setBounds(0, 0, 75, 65);
		backIconLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		header.add(backIconLabel);
		
	}
	private void initializeFacilities(){
		facilitiesPanel = new JPanel();
		facilitiesPanel.setBounds(0, 957, 494, 800);
		facilitiesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		mainPanel.add(facilitiesPanel);
		
		
		facilitiesHeaderLabel = new JLabel("Facilities: ");
		facilitiesHeaderLabel.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 30));
		facilitiesHeaderLabel.setVerticalAlignment(SwingConstants.TOP);
		facilitiesHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		facilitiesPanel.add(facilitiesHeaderLabel);
		
		facilitiesSeparator = new JSeparator();
		facilitiesSeparator.setForeground(Color.BLACK);
		facilitiesSeparator.setPreferredSize(new Dimension(494,1));
		facilitiesPanel.add(facilitiesSeparator);
		if(!currentProperty.getAvailableFacilities()[0].equals("")){
			for(int i = 0; i < currentProperty.getAvailableFacilities().length; ++i) {
				JPanel facilityHolder = new JPanel();
				facilityHolder.setPreferredSize(new Dimension(494,100));
				facilityHolder.setLayout(null);
				
				JLabel facilityNameLabel = new JLabel(currentProperty.getAvailableFacilities()[i]);
				facilityNameLabel.setFont(new Font("Source Sans Pro ExtraLight", Font.PLAIN, 23));
				facilityNameLabel.setBounds(100, 0, 394, 100);
				facilityHolder.add(facilityNameLabel);
				
				JLabel facilityIconLabel = new JLabel();
				facilityIconLabel.setBounds(10, 0, 100, 100);
				facilityIconLabel.setIcon(loadImage("Images/" + currentProperty.getAvailableFacilities()[i] + ".png", 50,50));
				facilityHolder.add(facilityIconLabel);
				facilitiesPanel.add(facilityHolder);
			}
		}
	}
	
	private void initializeFeatures(){
		featuresPanel = new JPanel();
		featuresPanel.setBounds(496, 957, 494, 800);
		featuresPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		mainPanel.add(featuresPanel);
		
		
		featuresHeaderLabel = new JLabel("Features: ");
		featuresHeaderLabel.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 30));
		featuresHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		featuresHeaderLabel.setVerticalAlignment(SwingConstants.TOP);
		featuresPanel.add(featuresHeaderLabel);
		
		featuresSeparator = new JSeparator();
		featuresSeparator.setPreferredSize(new Dimension(494, 1));
		featuresSeparator.setForeground(Color.BLACK);
		featuresPanel.add(featuresSeparator);
		
		if(!currentProperty.getAvailableFeatures()[0].equals("")){
			for(int i = 0; i < currentProperty.getAvailableFeatures().length;++i) {
				JPanel featureHolder = new JPanel();
				featureHolder.setPreferredSize(new Dimension(494,100));
				featureHolder.setLayout(null);
				
				JLabel featureNameLabel = new JLabel(currentProperty.getAvailableFeatures()[i]);
				featureNameLabel.setFont(new Font("Source Sans Pro ExtraLight", Font.PLAIN, 23));
				featureNameLabel.setBounds(100, 0, 394, 100);
				featureHolder.add(featureNameLabel);
				
				JLabel featureIconLabel = new JLabel();
				featureIconLabel.setBounds(10, 0, 100, 100);
				featureIconLabel.setIcon(loadImage("Images/" + currentProperty.getAvailableFeatures()[i] + ".png", 50,50));
				featureHolder.add(featureIconLabel);
				featuresPanel.add(featureHolder);
			}
		}
	}
	
	private void initializeApplyToRent() {
		applyToRentPanel = new JPanel();
		applyToRentPanel.setBounds(0, 1800, 989, 300);
		mainPanel.add(applyToRentPanel);
		applyToRentPanel.setLayout(null);
		
		DeleteButton = new JButton("Delete Property");
		DeleteButton.setBackground(new Color(204, 102, 51));
		DeleteButton.setFocusable(false);
		DeleteButton.setBounds(675, 30, 300, 40);
		DeleteButton.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 20));
		applyToRentPanel.add(DeleteButton);
		
		managerInfoPanel = new JPanel();
		managerInfoPanel.setBackground(Color.WHITE);
		managerInfoPanel.setBounds(251, 80, 509, 200);
		managerInfoPanel.setVisible(false);
		managerInfoPanel.setLayout(null);
		applyToRentPanel.add(managerInfoPanel);
		
		
		managerNameLabel = new JLabel("Property Manager Name: ");
		managerNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		managerNameLabel.setBounds(5, 5, 200, 20);
		managerInfoPanel.add(managerNameLabel);
		
		try {
			readPropertyManagerFromFile();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		managerNameHolder = new JLabel(propertyManager.getFullName());
		managerNameHolder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		managerNameHolder.setBounds(210, 5, 290, 20);
		managerInfoPanel.add(managerNameHolder);
		
		managerPhoneNumberLabel = new JLabel("Property Manager Contact Number:");
		managerPhoneNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		managerPhoneNumberLabel.setBounds(5, 30, 280, 20);
		managerInfoPanel.add(managerPhoneNumberLabel);
		
		managerPhoneHolder = new JLabel(propertyManager.getContact());
		managerPhoneHolder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		managerPhoneHolder.setBounds(290, 30, 239, 20);
		managerInfoPanel.add(managerPhoneHolder);
		
		propertyManagerEmail = new JLabel("Property Manager Email Address:");
		propertyManagerEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		propertyManagerEmail.setBounds(5, 55, 250, 20);
		managerInfoPanel.add(propertyManagerEmail);
		
		managerEmailHolder = new JLabel(propertyManager.getEmail());
		managerEmailHolder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		managerEmailHolder.setBounds(260, 55, 249, 20);
		managerInfoPanel.add(managerEmailHolder);
		
		activateButton = new JButton("Deactivate property");

		activateButton.setBounds(15, 30, 300, 40);
		applyToRentPanel.add(activateButton);
		
		EditButton = new JButton("Edit Property");

		EditButton.setBounds(345, 30, 300, 40);
		applyToRentPanel.add(EditButton);
		
		approvalStatusLabel = new JLabel("Property Approval Status: " + currentProperty.getPropertyApprovalStatus());
		approvalStatusLabel.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 25));
		approvalStatusLabel.setBounds(15, 100, 600, 40);
		applyToRentPanel.add(approvalStatusLabel);
		
		
	}
	
	private void initialize() {
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setPreferredSize(new Dimension(800, 2100));
		mainPanel.setBackground(Color.WHITE);

		scrollPane = new JScrollPane(mainPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setLocation(0, 0);
		scrollPane.setSize(1008, 660);
		
		
		this.add(scrollPane);
		this.setLayout(null);	
		this.setVisible(true);
		this.setSize(1024,700);
	 }
	
	private ImageIcon loadImage(String path, int x, int y){
        Image image = new ImageIcon(this.getClass().getResource(path)).getImage();
        Image scaledImage = image.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
	}
	
	public JLabel getBackIconLabel() {
		return backIconLabel;
	}
	
	public void setCurrentProperty(Property currentProperty) {
		this.currentProperty = currentProperty;
	}
	
	private void readPropertyManagerFromFile() throws FileNotFoundException {
		File managerInfoFile = new File("System/Property Manager/" + currentProperty.getAgentName() + "/accountInfo.txt");
		Scanner accountInfoScanner = new Scanner(managerInfoFile);
		propertyManager = new User(Integer.parseInt(accountInfoScanner.nextLine()), accountInfoScanner.nextLine(), accountInfoScanner.nextLine(), accountInfoScanner.nextLine(), accountInfoScanner.nextLine(), accountInfoScanner.nextLine(), accountInfoScanner.nextLine(), accountInfoScanner.nextLine());
		accountInfoScanner.close();
	}
	public JButton getDeleteButton() {
		return DeleteButton;
	}
	
	public JButton getEditButton() {
		return EditButton;
	}
	
	public JButton getActivationButton() {
		return activateButton;
	}
	public JPanel getManagerInfoPanel() {
		return managerInfoPanel;
	}
	
	public Property getCurrentProperty() {
		return currentProperty;
	}
	
}
