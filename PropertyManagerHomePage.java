import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

// Naim Farhat Bin Mahmad Zulhasnan (1191101830)
// property manager home page, will be loaded after login
// Generated using Eclipse
public class PropertyManagerHomePage extends JPanel{
	private JPanel slideMenu; // side bar contains navigation buttons
	private JLabel menuIcon; // press to view the side bar
	private JLabel closeMenu; // press to close the side bar
	private JScrollPane mainScrollPane; // scroll pane contains the properties listing
	private JPanel header; // panel contains the filters
	private JComboBox<String> propertTypeComboBox; // combo box to select a property type filter
	private JLabel minPriceLabel;
	private JLabel maxPriceLabel;
	private JComboBox<String> minPriceComboBox; // combo box to select property min price filter
	private JComboBox<String> maxPriceComboBox; // combo box to select property max price filter
	private JLabel maxSizeLabel;
	private JLabel minSizeLabel;
	private JComboBox<String> minSizeCombobox; // combo box to select property min size filter
	private JComboBox<String> maxSizeCombobox;  // combo box to select property max sizefilter
	private JComboBox<String> projectsCombobox; // combo box to select property project filter
	private JComboBox<String> furnishingCombobox;
	private JLabel maxBedLabel;
	private JLabel minBedLabel;
	private JComboBox<String> minBedCombobox;
	private JComboBox<String> maxBedCombobox;
	private JButton searchButton;  // search according to filters
	private JButton resetButton; // reset filters
	private JPanel panelInsideScrollPane; // main panel inside scroll pane
	private JLabel logoIcon; // app logo
	private ArrayList<JButton> propertiesViewDetailsButtons = new ArrayList<>(); // stores view details buttons on listings, to set listeners in controller
	private ArrayList<Property> propertyList = new ArrayList<>(); // list of properties to be listed
	private JLabel logOutLabel;// log out label on the side bar
	private JButton moreFiltersButton; // show additional filters panel
	private JPanel moreFiltersPanel; // additional filters panel
	private JComboBox<String> activationStatusCombobox; // combo box to select property activation status filter
	private JLabel minRentRateLabel;
	private JLabel maxRentRateLabel;
	private JComboBox<String> maxRentalRateCombobox;// combo box to select property max rent rate filter
	private JComboBox<String> minRentalRateCombobox;
	private JLabel facilitiesCheckBoxLabel; 
	private JCheckBox securityCheckbox; // facilities / features checkboxes filters
	private JCheckBox parkingCheckbox; 
	private JCheckBox supermarketCheckbox;
	private JCheckBox gymCheckbox;
	private JCheckBox playgroundCheckbox;
	private JCheckBox poolCheckbox;
	private JCheckBox sportCheckbox;
	private JLabel featuresChaeckBoxLabel;
	private JCheckBox conditionerCheckbox;
	private JCheckBox kitchenCheckbox;
	private JCheckBox gardenCheckbox;
	private JCheckBox garageCheckbox;
	private JLabel homeLabel; 
	private JLabel rentRequestLabel;
	private JLabel newPropertyLabel;
	private JLabel managePropertiesLabel;
	private JCheckBox[] facilitiesCheckboxList = new JCheckBox[7]; // stores facilities / features checkboxes to facilitate using them in filtering
	private JCheckBox[] featuresCheckboxList = new JCheckBox[4];
		

	public PropertyManagerHomePage() {
		initializeHeader();
		initializeSideMenu();
		initialize();
	}
	
	public PropertyManagerHomePage(ArrayList<Property> propertyList) {
		this.propertyList = propertyList; 
		initializeHeader();
		initializeSideMenu();
		
		initialize();
		setPropertiesPanels();
		
	}
	
	// used to set properties listings that matched filters
	public void setNewProperties(ArrayList<Property> propertyList) {
		this.propertyList = propertyList;
		setPropertiesPanels();
	}
	
	//initialize header, filters and their buttons
	private void initializeHeader() {
		header = new JPanel();
		header.setBackground(new Color(29, 27, 27));
		header.setBounds(0, 0, 1008, 134);
		header.setLayout(null);
		add(header);
        
        
        menuIcon = new JLabel();
        menuIcon.setBounds(10, 58, 55, 25);
        menuIcon.setIcon(loadImage("Images/menu.png", 25, 25));
        header.add(menuIcon);
        
        
        propertTypeComboBox = new JComboBox<String>();
        propertTypeComboBox.setBounds(100, 23, 166, 22);
        propertTypeComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"All Resedential", "Apartment", "Flat", "Condominium", "Serviced Residence", "Link House", "Cluster House", "Bungalow", "Semi Detached House", "Villa", "Residential Land"}));
		propertTypeComboBox.setBackground(new Color(236, 77, 55));
		header.add(propertTypeComboBox);
		
		
		minPriceLabel = new JLabel("Min. Price");
		minPriceLabel.setForeground(UIManager.getColor("Button.background"));
		minPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		minPriceLabel.setBounds(100, 56, 78, 14);
		header.add(minPriceLabel);
		
		maxPriceLabel  = new JLabel("Max. Price");
		maxPriceLabel.setForeground(UIManager.getColor("Button.background"));
		maxPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		maxPriceLabel.setBounds(187, 56, 79, 14);
		header.add(maxPriceLabel);
		
		minPriceComboBox = new JComboBox<String>();
		minPriceComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"200", "400", "600", "800", "1000", "1500", "2000", "3000", "4000", "5000", "6000", "8000", "10000", "20000", "30000", "40000", "50000"}));
		minPriceComboBox.setBounds(100, 81, 78, 22);
		minPriceComboBox.setBackground(new Color(236, 77, 55));
		header.add(minPriceComboBox);
		
		maxPriceComboBox = new JComboBox<String>();
		maxPriceComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"200", "400", "600", "800", "1000", "1500", "2000", "3000", "4000", "5000", "6000", "8000", "10000", "20000", "30000", "40000", "50000"}));
		maxPriceComboBox.setSelectedIndex(maxPriceComboBox.getModel().getSize()-1);
		maxPriceComboBox.setBounds(188, 81, 78, 22);
		maxPriceComboBox.setBackground(new Color(236, 77, 55));
		header.add(maxPriceComboBox);
		
		maxSizeLabel = new JLabel("Max. Size sq. ft.");
		maxSizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		maxSizeLabel.setForeground(SystemColor.menu);
		maxSizeLabel.setBounds(401, 56, 100, 14);
		header.add(maxSizeLabel);
		
		minSizeLabel = new JLabel("Min. Size sq. ft.");
		minSizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		minSizeLabel.setForeground(SystemColor.menu);
		minSizeLabel.setBounds(300, 56, 100, 14);
		header.add(minSizeLabel);
		
		minSizeCombobox = new JComboBox<String>();
		minSizeCombobox.setModel(new DefaultComboBoxModel<String>(new String[] {"0", "250", "500", "750", "1000", "1250", "1500", "2000", "2500", "3000", "4000", "5000", "6000", "8000", "10000", "20000", "50000", "100000"}));
		minSizeCombobox.setBounds(310, 81, 78, 22);
		minSizeCombobox.setBackground(new Color(236, 77, 55));
		header.add(minSizeCombobox);
		
		maxSizeCombobox = new JComboBox<String>();
		maxSizeCombobox.setModel(new DefaultComboBoxModel<String>(new String[] {"0", "250", "500", "750", "1000", "1250", "1500", "2000", "2500", "3000", "4000", "5000", "6000", "8000", "10000", "20000", "50000", "100000"}));
		maxSizeCombobox.setBounds(411, 81, 78, 22);
		maxSizeCombobox.setSelectedIndex(maxSizeCombobox.getModel().getSize()-1);
		maxSizeCombobox.setBackground(new Color(236, 77, 55));
		header.add(maxSizeCombobox);
		
		projectsCombobox = new JComboBox<String>();
		projectsCombobox.setFocusable(false);
		projectsCombobox.setModel(new DefaultComboBoxModel<String>(new String[] {"All Projects"}));
		projectsCombobox.setBounds(302, 23, 200, 22);
		projectsCombobox.setBackground(new Color(236, 77, 55));
		header.add(projectsCombobox);
		
		furnishingCombobox = new JComboBox<String>();
		furnishingCombobox.setModel(new DefaultComboBoxModel<String>(new String[] {"All Furnishing", "Fully Furnished", "Partially Furnished", "Unfurnished"}));
		furnishingCombobox.setBounds(542, 23, 200, 22);
		furnishingCombobox.setBackground(new Color(236, 77, 55));
		header.add(furnishingCombobox);
		
		maxBedLabel = new JLabel("Max. Bedrooms");
		maxBedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		maxBedLabel.setForeground(SystemColor.menu);
		maxBedLabel.setBounds(642, 56, 100, 14);
		header.add(maxBedLabel);
		
		minBedLabel = new JLabel("Min. Bedrooms");
		minBedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		minBedLabel.setForeground(SystemColor.menu);
		minBedLabel.setBounds(542, 56, 100, 14);
		header.add(minBedLabel);
		
		minBedCombobox = new JComboBox<String>();
		minBedCombobox.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		minBedCombobox.setBounds(552, 81, 78, 22);
		minBedCombobox.setBackground(new Color(236, 77, 55));
		header.add(minBedCombobox);
		
		maxBedCombobox = new JComboBox<String>();
		maxBedCombobox.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		maxBedCombobox.setSelectedIndex(maxBedCombobox.getModel().getSize()-1);
		maxBedCombobox .setBounds(652, 81, 78, 22);
		maxBedCombobox.setBackground(new Color(236, 77, 55));
		header.add(maxBedCombobox);
		
		searchButton = new JButton("Search");
		searchButton.setBackground(new Color(255,240,149));
		searchButton.setFocusable(false);
		searchButton.setBounds(798, 11, 120, 47);
		header.add(searchButton);
		
		resetButton = new JButton("Reset");
		resetButton.setBackground(new Color(255,240,149));
		resetButton.setFocusable(false);
		resetButton.setBounds(798, 69, 120, 23);
		header.add(resetButton);
		
		moreFiltersButton = new JButton("More Filters");
		moreFiltersButton.setBackground(new Color(255,240,149));
		moreFiltersButton.setFocusable(false);
		moreFiltersButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		moreFiltersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(moreFiltersButton.getText().equals("More Filters")) {
					mainScrollPane.setLocation(0, 268);
					mainScrollPane.setSize(1008, 393);
					moreFiltersButton.setText("Less Filters");
					menuIcon.setEnabled(false);
				}
				else {
					mainScrollPane.setLocation(0, 134);
					mainScrollPane.setSize(1008, 527);
					moreFiltersButton.setText("More Filters");
					menuIcon.setEnabled(true);
				}
			}
		});
		moreFiltersButton.setBounds(798, 103, 120, 23);
		header.add(moreFiltersButton);
	}
	
	// initialize side bar
	private void initializeSideMenu() {
		slideMenu = new JPanel();
		slideMenu.setBackground(new Color(236, 77, 55));
		slideMenu.setBounds(0, 134, 242, 527);
		slideMenu.setLayout(null);
		slideMenu.setVisible(false);
		
		closeMenu = new JLabel();
		closeMenu.setBounds(207, 11, 25, 25);
		closeMenu.setIcon(loadImage("Images/close.png",25,25));
		closeMenu.setVisible(false);
		slideMenu.add(closeMenu);
		
		add(slideMenu);
		
		logOutLabel = new JLabel("Log Out");
		
		logOutLabel.setForeground(Color.WHITE);
		logOutLabel.setFont(new Font("Source Serif Pro", Font.PLAIN, 25));
		logOutLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logOutLabel.setBounds(46, 360, 150, 30);
		slideMenu.add(logOutLabel);
		
		homeLabel = new JLabel("Home");
		homeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		homeLabel.setForeground(Color.WHITE);
		homeLabel.setFont(new Font("Source Serif Pro", Font.PLAIN, 25));
		homeLabel.setBounds(46, 50, 150, 30);
		slideMenu.add(homeLabel);
		
		rentRequestLabel = new JLabel("Tenant Rent Request");
		rentRequestLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rentRequestLabel.setForeground(Color.WHITE);
		rentRequestLabel.setFont(new Font("Source Serif Pro", Font.PLAIN, 25));
		rentRequestLabel.setBounds(0, 120, 242, 30);
		slideMenu.add(rentRequestLabel);
		
		newPropertyLabel = new JLabel("Add New Property");
		newPropertyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newPropertyLabel.setForeground(Color.WHITE);
		newPropertyLabel.setFont(new Font("Source Serif Pro", Font.PLAIN, 25));
		newPropertyLabel.setBounds(0, 200, 242, 30);
		slideMenu.add(newPropertyLabel);
		
		managePropertiesLabel = new JLabel("Manage Properties");
		managePropertiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		managePropertiesLabel.setForeground(Color.WHITE);
		managePropertiesLabel.setFont(new Font("Source Serif Pro", Font.PLAIN, 25));
		managePropertiesLabel.setBounds(0, 280, 242, 30);
		slideMenu.add(managePropertiesLabel);
	}

	// initialize properties listing panels
	public void setPropertiesPanels() {
		panelInsideScrollPane.removeAll();
		propertiesViewDetailsButtons.clear();
		if(propertyList.size() == 0) {
			noResultFoundMessage(); // if no properties matched the search filters, show "not found" panel
		}
			
		for(int i = 0; i < propertyList.size(); i++){
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			if(propertyList.get(i).getPropertyActivationStatus().equals("Deactivated"))
				panel.setBackground(Color.LIGHT_GRAY);
			
			panel.setPreferredSize(new Dimension(800,400));
			panel.setLayout(null);
			
			JLabel priceHolder = new JLabel("Price");
			priceHolder.setFont(new Font("Source Serif Pro Black", Font.BOLD, 23));
			priceHolder.setBounds(430, 11, 160, 24);
			panel.add(priceHolder);
			
			JLabel priceLabel = new JLabel("RM " + Double.toString(propertyList.get(i).getPrice()));
			priceLabel.setFont(new Font("Source Serif Pro Black", Font.BOLD, 23));
			priceLabel.setBounds(590, 11, 160, 24);
			panel.add(priceLabel);
			
			JLabel propertyTitleLabel = new JLabel();
			propertyTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
			propertyTitleLabel.setBounds(430, 46, 320, 21);
			panel.add(propertyTitleLabel);
			if(propertyList.get(i).getPropertyAddress().getProject().equals(null))
				propertyTitleLabel.setText(propertyList.get(i).getPropertyName());
			else
				propertyTitleLabel.setText(propertyList.get(i).getPropertyAddress().getProject());
			
			JLabel propertyTypeLabel = new JLabel(propertyList.get(i).getPropertyType());
			propertyTypeLabel.setBounds(430, 76, 300, 24);
			panel.add(propertyTypeLabel);
			
			JLabel rentRateLabel = new JLabel("RM " + Double.toString(propertyList.get(i).getRentalRate()) + " per sq. ft.");
			rentRateLabel.setBounds(580, 76, 300, 24);
			panel.add(rentRateLabel);
			
			JLabel propertySizeLabel = new JLabel("Size: " + Double.toString(propertyList.get(i).getSize()) + " sq. ft.");
			propertySizeLabel.setBounds(430, 102, 150, 24);
			panel.add(propertySizeLabel);
			
			JLabel propertyFurnishLabel = new JLabel(propertyList.get(i).getFurnishing());
			propertyFurnishLabel.setBounds(580, 102, 150, 24);
			panel.add(propertyFurnishLabel);
			
			JLabel bedIconLabel = new JLabel();
			bedIconLabel.setIcon(loadImage("Images/bed.png", 50, 50));
			bedIconLabel.setBounds(430, 148, 50, 50);
			panel.add(bedIconLabel);
			
			JLabel bedNumLabel = new JLabel(Integer.toString(propertyList.get(i).getBedRoomsNum()));
			bedNumLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bedNumLabel.setBounds(500, 148, 50, 50);
			panel.add(bedNumLabel);
			
			JLabel bathIconLabel = new JLabel();
			bathIconLabel.setIcon(loadImage("Images/bath.png", 50, 50));
			bathIconLabel.setBounds(600, 148, 50, 50);
			panel.add(bathIconLabel);
			
			JLabel bathNumLabel = new JLabel(Integer.toString(propertyList.get(i).getBathRoomsNum()));
			bathNumLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bathNumLabel.setBounds(670, 148, 50, 50);
			panel.add(bathNumLabel);
			
			JButton propertyViewDetailsButton = new JButton("View Details");
			propertyViewDetailsButton.setBackground(new Color(255,240,149));
			propertyViewDetailsButton.setFocusable(false);
			propertyViewDetailsButton.setBounds(565, 329, 165, 40);
			panel.add(propertyViewDetailsButton);
			propertiesViewDetailsButtons.add(propertyViewDetailsButton);
			
			JLabel propertyPicLabel = new JLabel("");
			propertyPicLabel.setBounds(0, 0, 400, 400);
			panel.add(propertyPicLabel);
			propertyPicLabel.setIcon(loadImage(propertyList.get(i).getPropertyPicturePath()[0], 400, 400));
			panelInsideScrollPane.setPreferredSize(new Dimension(800,410 * (i+1)));
			panelInsideScrollPane.add(panel);
		}
	}
	// initialize additional filters panel
	public void initializeMoreFiltersPanels() {
		
		moreFiltersPanel = new JPanel();
        moreFiltersPanel.setBackground(new Color(29, 27, 27));
        moreFiltersPanel.setBounds(0, 134, 1008, 134);
        add(moreFiltersPanel);
        moreFiltersPanel.setLayout(null);
        
        activationStatusCombobox = new JComboBox<String>();
        activationStatusCombobox.setModel(new DefaultComboBoxModel(new String[] {"All Activation Status", "Activated", "Deactivated"}));
        activationStatusCombobox.setToolTipText("");
        activationStatusCombobox.setBackground(new Color(236, 77, 55));
        activationStatusCombobox.setBounds(50, 23, 200, 22);
        moreFiltersPanel.add(activationStatusCombobox);
        
        minRentRateLabel = new JLabel("Min Rental Rate");
        minRentRateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        minRentRateLabel.setForeground(SystemColor.menu);
        minRentRateLabel.setBounds(41, 56, 100, 14);
        moreFiltersPanel.add(minRentRateLabel);
        
        maxRentRateLabel = new JLabel("Max Rental Rate");
        maxRentRateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        maxRentRateLabel.setForeground(SystemColor.menu);
        maxRentRateLabel.setBounds(163, 56, 100, 14);
        moreFiltersPanel.add(maxRentRateLabel);
        
        maxRentalRateCombobox = new JComboBox<String>();
        maxRentalRateCombobox.setModel(new DefaultComboBoxModel<String>(new String[] {"0", "0.5", "1", "1.5", "2", "2.5", "3", "3.5", "4", "4.5", "5"}));
        maxRentalRateCombobox.setBackground(new Color(236, 77, 55));
        maxRentalRateCombobox.setBounds(172, 81, 78, 22);
        maxRentalRateCombobox.setSelectedIndex(maxRentalRateCombobox.getModel().getSize()-1);
        moreFiltersPanel.add(maxRentalRateCombobox);
        
        minRentalRateCombobox = new JComboBox<String>();
        minRentalRateCombobox.setModel(new DefaultComboBoxModel<String>(new String[] {"0", "0.5", "1", "1.5", "2", "2.5", "3", "3.5", "4", "4.5", "5"}));
        minRentalRateCombobox.setBackground(new Color(236, 77, 55));
        minRentalRateCombobox.setBounds(50, 82, 78, 22);
        moreFiltersPanel.add(minRentalRateCombobox);
        
        facilitiesCheckBoxLabel = new JLabel("Facilities: ");
        facilitiesCheckBoxLabel.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 22));
        facilitiesCheckBoxLabel.setForeground(Color.WHITE);
        facilitiesCheckBoxLabel.setBounds(269, 15, 200, 22);
        moreFiltersPanel.add(facilitiesCheckBoxLabel);
        
        securityCheckbox = new JCheckBox("24-Hour Security");
        securityCheckbox.setForeground(Color.WHITE);
        securityCheckbox.setBackground(new Color(29, 27, 27));
        securityCheckbox.setBounds(269, 44, 129, 23);
        moreFiltersPanel.add(securityCheckbox);
        
        parkingCheckbox = new JCheckBox("Parking");
        parkingCheckbox.setForeground(Color.WHITE);
        parkingCheckbox.setBackground(new Color(29, 27, 27));
        parkingCheckbox.setBounds(269, 74, 129, 23);
        moreFiltersPanel.add(parkingCheckbox);
        
        supermarketCheckbox = new JCheckBox("Supermarket");
        supermarketCheckbox.setForeground(Color.WHITE);
        supermarketCheckbox.setBackground(new Color(29, 27, 27));
        supermarketCheckbox.setBounds(269, 104, 129, 23);
        moreFiltersPanel.add(supermarketCheckbox);
        
        gymCheckbox = new JCheckBox("Gym");
        gymCheckbox.setForeground(Color.WHITE);
        gymCheckbox.setBackground(new Color(29, 27, 27));
        gymCheckbox.setBounds(406, 44, 129, 23);
        moreFiltersPanel.add(gymCheckbox);
        
        playgroundCheckbox = new JCheckBox("Playground");
        playgroundCheckbox.setForeground(Color.WHITE);
        playgroundCheckbox.setBackground(new Color(29, 27, 27));
        playgroundCheckbox.setBounds(406, 74, 129, 23);
        moreFiltersPanel.add(playgroundCheckbox);
        
        poolCheckbox = new JCheckBox("Swimming Pool");
        poolCheckbox.setForeground(Color.WHITE);
        poolCheckbox.setBackground(new Color(29, 27, 27));
        poolCheckbox.setBounds(406, 104, 129, 23);
        moreFiltersPanel.add(poolCheckbox);
        
        featuresChaeckBoxLabel = new JLabel("Features:");
        featuresChaeckBoxLabel.setForeground(Color.WHITE);
        featuresChaeckBoxLabel.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 22));
        featuresChaeckBoxLabel.setBounds(704, 15, 200, 22);
        moreFiltersPanel.add(featuresChaeckBoxLabel);
        
        sportCheckbox = new JCheckBox("Sport Court");
        sportCheckbox.setForeground(Color.WHITE);
        sportCheckbox.setBackground(new Color(29, 27, 27));
        sportCheckbox.setBounds(543, 44, 129, 23);
        moreFiltersPanel.add(sportCheckbox);
        
        conditionerCheckbox = new JCheckBox("Air Conditioner");
        conditionerCheckbox.setForeground(Color.WHITE);
        conditionerCheckbox.setBackground(new Color(29, 27, 27));
        conditionerCheckbox.setBounds(704, 44, 129, 23);
        moreFiltersPanel.add(conditionerCheckbox);
        
        gardenCheckbox = new JCheckBox("Garden");
        gardenCheckbox.setForeground(Color.WHITE);
        gardenCheckbox.setBackground(new Color(29, 27, 27));
        gardenCheckbox.setBounds(841, 44, 129, 23);
        moreFiltersPanel.add(gardenCheckbox);
        
        garageCheckbox = new JCheckBox("Garage");
        garageCheckbox.setForeground(Color.WHITE);
        garageCheckbox.setBackground(new Color(29, 27, 27));
        garageCheckbox.setBounds(704, 104, 129, 23);
        moreFiltersPanel.add(garageCheckbox);
        
        kitchenCheckbox = new JCheckBox("Kitchen Cabinet");
        kitchenCheckbox.setForeground(Color.WHITE);
        kitchenCheckbox.setBackground(new Color(29, 27, 27));
        kitchenCheckbox.setBounds(704, 74, 129, 23);
        moreFiltersPanel.add(kitchenCheckbox);
        

        facilitiesCheckboxList[0] = securityCheckbox;
        facilitiesCheckboxList[1] = parkingCheckbox;
        facilitiesCheckboxList[2] = supermarketCheckbox;
        facilitiesCheckboxList[3] = playgroundCheckbox;
        facilitiesCheckboxList[4] = gymCheckbox;
        facilitiesCheckboxList[5] = poolCheckbox;
        facilitiesCheckboxList[6] = sportCheckbox;
        
        
        featuresCheckboxList[0] = conditionerCheckbox;
        featuresCheckboxList[1] = kitchenCheckbox;
        featuresCheckboxList[2] = gardenCheckbox;
        featuresCheckboxList[3] = garageCheckbox;
	}
	
	// initialize main panel
	private void initialize() {
		setLayout(null);
		
		closeMenu.addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseClicked(MouseEvent e){
				slideMenu.setVisible(false);
				closeMenu.setVisible(false);
				menuIcon.setVisible(true);
				mainScrollPane.setLocation(0, 134);
				mainScrollPane.setSize(1008, 527);
				setPanelEnabled((JPanel)getThisJPanel(),true);				
			}			
		});
		
				
        menuIcon.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	if(moreFiltersButton.getText().equals("More Filters")) {
            		slideMenu.setVisible(true);
    				closeMenu.setVisible(true);
    				menuIcon.setVisible(false);
    				mainScrollPane.setLocation(242, 134);
    				mainScrollPane.setSize(766, 527);
    		    	setPanelEnabled((JPanel)getThisJPanel(),false);
            	}				
			}			
		});
		
		panelInsideScrollPane = new JPanel();
		panelInsideScrollPane.setPreferredSize(new Dimension(800,400));
        
        mainScrollPane = new JScrollPane(panelInsideScrollPane,
                 JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                 JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        mainScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        if(!slideMenu.isVisible()) {
        	mainScrollPane.setLocation(0, 134);
        	mainScrollPane.setSize(1008, 527);
        }
		
        mainScrollPane.setPreferredSize(new Dimension(800,400));
        add(mainScrollPane);
        
        initializeMoreFiltersPanels();
       
		this.setSize(1024,700);
		this.setVisible(true); 
	}
	
	// no results found panel 
	private void noResultFoundMessage() {
		JPanel resultNotFoundPanel = new JPanel();
		add(resultNotFoundPanel);
		resultNotFoundPanel.setBackground(Color.WHITE);
		resultNotFoundPanel.setPreferredSize(new Dimension(992, 488));
		resultNotFoundPanel.setLayout(null);
		
		JLabel noResultsIconLabel = new JLabel("");
		noResultsIconLabel.setIcon(loadImage("Images/noResultsIcon.png", 200,200));
		noResultsIconLabel.setBounds(396, 54, 200, 200);
		resultNotFoundPanel.add(noResultsIconLabel);
		
		JLabel noResultsLabel = new JLabel("No results found");
		noResultsLabel.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 25));
		noResultsLabel.setBounds(396, 285, 200, 34);
		resultNotFoundPanel.add(noResultsLabel);
		
		JLabel noResultsDescLabel = new JLabel("Sorry, that filter combination has no results.");
		noResultsDescLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		noResultsDescLabel.setBounds(296, 334, 400, 25);
		resultNotFoundPanel.add(noResultsDescLabel);
		
		JLabel noResultsDescLabel2 = new JLabel("Please try different criteria");
		noResultsDescLabel2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		noResultsDescLabel2.setBounds(375, 370, 242, 25);
		resultNotFoundPanel.add(noResultsDescLabel2);

		panelInsideScrollPane.setPreferredSize(new Dimension(800,410));
		panelInsideScrollPane.add(resultNotFoundPanel);
	}
	// used to load images using their path and size
	private ImageIcon loadImage(String path, int x, int y){
        Image image = new ImageIcon(this.getClass().getResource(path)).getImage();
        Image scaledImage = image.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
	} 
	// called when side bar icon is opened
	private void setPanelEnabled(JComponent panel, boolean isEnabled) { // gray out main panel when side bar is open
		 panel.setEnabled(isEnabled);
		 Component[] components = panel.getComponents();

		    for(int i = 0; i < components.length; i++) {
		        if((components[i].getClass().getName() == "javax.swing.JPanel" || components[i].getClass().getName() == "javax.swing.JScrollPane") && (!components[i].equals(slideMenu))) {
		            setPanelEnabled((JComponent)components[i], isEnabled);
				}
				else if(components[i].getClass().getName() == "javax.swing.JViewport"){
					setPanelEnabled((JComponent)components[i], isEnabled);
				}
		        
		        if(components[i].getClass().getName() != "")
		        components[i].setEnabled(isEnabled);
		    }
		 
	 }
	public ArrayList<JButton> getPropertiesViewDetailsButtons() {
		return propertiesViewDetailsButtons;
	}
	
	public JButton getSearchButton() {
		return searchButton;
	}
	
	private JPanel getThisJPanel() {
		return this;
	}
	
	public JComboBox<String> getPropertTypeComboBox(){
		return propertTypeComboBox;
	}
	
	public JComboBox<String> getMinPriceComboBox(){
		return minPriceComboBox;
	}
	
	public JComboBox<String> getMaxPriceComboBox(){
		return maxPriceComboBox;
	}
	
	public JComboBox<String> getMinSizeComboBox(){
		return minSizeCombobox;
	}
	
	public JComboBox<String> getMaxSizeComboBox(){
		return maxSizeCombobox;
	}
	
	public JComboBox<String> getFurnishingCombobox(){
		return furnishingCombobox;
	}
	
	public JComboBox<String> getMinBedCombobox(){
		return minBedCombobox;
	}
	
	public JComboBox<String> getMaxBedCombobox(){
		return maxBedCombobox;
	}
	
	public JComboBox<String> getProjectsCombobox(){
		return projectsCombobox;
	}
	
	public void setPropertyList(ArrayList<Property> propertyList) {
		this.propertyList = propertyList;
		setPropertiesPanels();
	}
	
	public JButton getResetButton() {
		return resetButton;
	}
	
	
	public JLabel getHomeLabel() {
		return homeLabel;
	}
	
	public JLabel getRentRequestLabel() {
		return rentRequestLabel;
	}
	
	public JLabel getNewPropertyLabel() {
		return newPropertyLabel;
	}
	
	public JLabel getManagePropertiesLabel() {
		return managePropertiesLabel;
	}

	public JLabel getlogOutLabel() {
		return logOutLabel;
	}
	
	public JLabel getCloseMenu() {
		return closeMenu;
	}
	
	public JComboBox<String> getActivationStatusCombobox(){
		return activationStatusCombobox;
	}
	
	public JComboBox<String> getMinRentalRateCombobox(){
		return minRentalRateCombobox;
	}
	
	public JComboBox<String> getMaxRentalRateCombobox(){
		return maxRentalRateCombobox;
	}
	
	public JCheckBox[] getFacilitiesCheckboxList() {
		return facilitiesCheckboxList;
	}
	
	public JCheckBox[] getFeaturesCheckboxList() {
		return featuresCheckboxList;
	}

	public JLabel getMenuIcon(){
		return menuIcon;
	}
}
