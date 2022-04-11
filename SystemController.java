import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;


public class SystemController {
	 private MyJFrame view;
	 private ArrayList<Property> modelPropertyList;
	 private ArrayList<File> propertyPics = new ArrayList<>();
	 private User user;
	 private ArrayList<requestContactInstance> rentRequestList = new ArrayList<>();
	 private Property selectedProperty;
	 //	 int i = 0;
	 public static void replaceLines(File f, String replacementString, int lineNumber)  throws IOException {         //Used to edit lines in text files
			StringBuffer replacementLine = new StringBuffer(replacementString);
			Scanner readFile = new Scanner(f);
			ArrayList <String> fileLines = new ArrayList<String>(); //ArrayList where lines are stored; line number corresponds with index number
			while (readFile.hasNextLine()) {            //copies file contents into arraylist
				fileLines.add(readFile.nextLine());
			}
			readFile.close();
			Object [] lineArray = fileLines.toArray();
			lineArray[lineNumber-1] = replacementLine;  // Replaces desired line
			PrintWriter clearFile = new PrintWriter(f); //clears old file contents
			clearFile.print("");
			clearFile.close();
			
			PrintWriter printFile = new PrintWriter(f);     
			StringBuffer output = new StringBuffer("");
			for (int i = 0; i<lineArray.length; i++) {      //Combines new lines into a StringBuffer
				output.append(lineArray[i]);
				output.append("\n");
			}
			printFile.println(output);      //Prints combined StringBuffer to file
			printFile.close();
	}
	 public SystemController(ArrayList<Property> modelPropertyList, MyJFrame view) {
		  this.modelPropertyList = modelPropertyList;
		  this.view = view;
	}

	void deleteDir(File file) {
		File[] contents = file.listFiles();
		if (contents != null) {
			for (File f : contents) {
				deleteDir(f);
			}
		}
		file.delete();
	}

	public void initLoginPage(){
			view.setPanelToLogin();
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.getLoginPage().getLoginButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if(view.getLoginPage().getUsernameField().getText().isBlank() || new String(view.getLoginPage().getPasswordField().getPassword()).isBlank())
							view.getLoginPage().getErrorLabel().setText("Please Fill in Required Fields");
						else if(validateLogin(view.getLoginPage().getUsernameField().getText(), new String(view.getLoginPage().getPasswordField().getPassword()))) {
							if(user.getRole().equals("Admin")){
								view.setVisible(false);
								new AdminDashboardFrame().setVisible(true);
							}else if(user.getRole().equals("Property Agent") || user.getRole().equals("Property Owner")){
								if(user.getStatus().equals("Approved")) {
									initHomePage();
									initController(); // after the login, set the listeners to homePage buttons
									System.out.print(new String(view.getLoginPage().getUsernameField().getText()) + " ");
									System.out.println(new String(view.getLoginPage().getPasswordField().getPassword()));
								}
								else
									view.getLoginPage().getErrorLabel().setText("Your account is not active , Please wait for admin approval");
								
							}else if (user.getRole().equals("Tenant")){
								if(user.getStatus().equals("Approved")) {
								initHomePage();
								initController();
								// Only display the property rental list
								// Set the other menu bar button not visible to Tenant user and only logout button applicable
								view.getPropertyManagerHomePage().getHomeLabel().setVisible(false);
								view.getPropertyManagerHomePage().getRentRequestLabel().setVisible(false);
								view.getPropertyManagerHomePage().getManagePropertiesLabel().setVisible(false);
								view.getPropertyManagerHomePage().getNewPropertyLabel().setVisible(false);
								view.getPropertyManagerHomePage().getlogOutLabel().setBounds(0, 120, 242, 30);
								System.out.print(new String(view.getLoginPage().getUsernameField().getText()) + " ");
								System.out.println(new String(view.getLoginPage().getPasswordField().getPassword()));
								}
								else
								view.getLoginPage().getErrorLabel().setText("Your account is not active , Please wait for admin approval");
							}
						}
						else
							view.getLoginPage().getErrorLabel().setText("The username or password is incorrect, Try again.");
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			view.getLoginPage().getCreateNewAccountLabel().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// System.out.println("s");// resolve setting multiple unwanted listeners 
					view.getLoginPage().getLoginButton().removeActionListener(view.getLoginPage().getLoginButton().getActionListeners()[0]);
					view.getLoginPage().getCreateNewAccountLabel().removeMouseListener(view.getLoginPage().getCreateNewAccountLabel().getMouseListeners()[0]);
					initSignupPage();
					
				}
			});	
	} 
	public void initSignupPage(){
		view.setPanelToSignup();
		view.getSignupPage().getLoginLabel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				initLoginPage(); // resolve setting nultiple unwanted listeners 
				view.getSignupPage().getLoginLabel().removeMouseListener(view.getSignupPage().getLoginLabel().getMouseListeners()[0]);
				view.getSignupPage().getSignupButton().removeActionListener(view.getSignupPage().getSignupButton().getActionListeners()[0]);
			}
		});
		
		view.getSignupPage().getSignupButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getSignupPage().getErrorLabel().setForeground(Color.RED);
				if(view.getSignupPage().getUsernameTextField().getText().isBlank() || view.getSignupPage().getEmailTextField().getText().isBlank() || view.getSignupPage().getFullNameTextField().getText().isBlank() || view.getSignupPage().getMobileNoTextField().getText().isBlank() || new String(view.getSignupPage().getPasswordTextField().getPassword()).isBlank() || new String(view.getSignupPage().getRepeatPasswordTextField().getPassword()).isBlank()) {
					view.getSignupPage().getErrorLabel().setText("Please Fill all Required Fields");
				}
				else if(!Arrays.equals(view.getSignupPage().getPasswordTextField().getPassword(),view.getSignupPage().getRepeatPasswordTextField().getPassword())) {
					view.getSignupPage().getErrorLabel().setText("Password doesn't match");
				}
				else if(!view.getSignupPage().getOwnerToggleButton().isSelected() && !view.getSignupPage().getAgentToggleButton().isSelected() && !view.getSignupPage().getTenantToggleButton().isSelected()) {
					view.getSignupPage().getErrorLabel().setText("Please Choose an Account Type");
				}
				// else if(view.getSignupPage().getLicenseOrGrantIDTextField().getText().isBlank()) {
				// 	view.getSignupPage().getErrorLabel().setText("Please Enter Your License or Grant Number");
				// }
				else {
					File propertyManagers = new File("System/Property Manager/");
					File tenants = new File("System/Tenant/");
					if(Arrays.asList(propertyManagers.list()).contains(view.getSignupPage().getUsernameTextField().getText()) || Arrays.asList(tenants.list()).contains(view.getSignupPage().getUsernameTextField().getText())){
						view.getSignupPage().getErrorLabel().setForeground(Color.RED);
						view.getSignupPage().getErrorLabel().setText("This username is already taken, please choose another username ");
					}
					else {
						if(view.getSignupPage().getAgentToggleButton().isSelected()) {
							new Agent(view.getSignupPage().getUsernameTextField().getText(), new String(view.getSignupPage().getPasswordTextField().getPassword()), view.getSignupPage().getFullNameTextField().getText(), view.getSignupPage().getMobileNoTextField().getText(), view.getSignupPage().getEmailTextField().getText(), "Property Agent", "Pending", Integer.parseInt(view.getSignupPage().getLicenseOrGrantIDTextField().getText()));
							view.getSignupPage().getErrorLabel().setForeground(Color.BLACK);
							view.getSignupPage().getErrorLabel().setText("Your account has been created successfully, please wait for admin approval ");
							JOptionPane.showMessageDialog(view, "Your account has been created successfully, please wait for admin approval", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
						}
						else if(view.getSignupPage().getOwnerToggleButton().isSelected()) {
							Owner owner = new Owner(view.getSignupPage().getUsernameTextField().getText(), new String(view.getSignupPage().getPasswordTextField().getPassword()), view.getSignupPage().getFullNameTextField().getText(), view.getSignupPage().getMobileNoTextField().getText(), view.getSignupPage().getEmailTextField().getText(), "Property Owner", "Pending");
							owner.addToGrantList(view.getSignupPage().getLicenseOrGrantIDTextField().getText());
							view.getSignupPage().getErrorLabel().setForeground(Color.BLACK);
							view.getSignupPage().getErrorLabel().setText("Your account has been created successfully, please wait for admin approval");
							JOptionPane.showMessageDialog(view, "Your account has been created successfully, please wait for admin approval", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
						}
						else if(view.getSignupPage().getTenantToggleButton().isSelected()) {
							Tenant tenant = new Tenant(view.getSignupPage().getUsernameTextField().getText(), new String(view.getSignupPage().getPasswordTextField().getPassword()), view.getSignupPage().getFullNameTextField().getText(), view.getSignupPage().getMobileNoTextField().getText(), view.getSignupPage().getEmailTextField().getText(), "Tenant", "Pending");
							//owner.addToGrantList(view.getSignupPage().getLicenseOrGrantIDTextField().getText());
							view.getSignupPage().getErrorLabel().setForeground(Color.BLACK);
							view.getSignupPage().getErrorLabel().setText("Your account has been created successfully, please wait for admin approval");
							JOptionPane.showMessageDialog(view, "Your account has been created successfully, please wait for admin approval", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
						}
						view.getSignupPage().resetSignupFields();
					}
				}
			}
		});
	} 
	public void initHomePage(){
		view.setPanelToHomeAndSearch(modelPropertyList);
		view.getPropertyManagerHomePage().getSearchButton().doClick();
		try {
			setProjectsComboboxFromFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void initController() {
		view.getPropertyManagerHomePage().getResetButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetComboBoxes();
			}
		});
		
		initViewDetails(modelPropertyList); // when first login
		view.getPropertyManagerHomePage().getSearchButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Property> searchPropertyList = new ArrayList<>();
				for(int j = 0; j < modelPropertyList.size(); ++j) {
//					if(modelPropertyList.get(j).getPropertyApprovalStatus().equals("Approved")) {
						if(view.getPropertyManagerHomePage().getPropertTypeComboBox().getSelectedItem().equals("All Resedential") || modelPropertyList.get(j).getPropertyType().equals(view.getPropertyManagerHomePage().getPropertTypeComboBox().getSelectedItem())) {
							if(modelPropertyList.get(j).getPrice()>= Double.parseDouble((String)view.getPropertyManagerHomePage().getMinPriceComboBox().getSelectedItem()) && modelPropertyList.get(j).getPrice() <= Double.parseDouble((String)view.getPropertyManagerHomePage().getMaxPriceComboBox().getSelectedItem())){						
								if(view.getPropertyManagerHomePage().getProjectsCombobox().getSelectedItem().equals("All Projects") || modelPropertyList.get(j).getPropertyAddress().getProject().equals(view.getPropertyManagerHomePage().getProjectsCombobox().getSelectedItem())){
									if(modelPropertyList.get(j).getSize() >= Integer.parseInt((String)view.getPropertyManagerHomePage().getMinSizeComboBox().getSelectedItem()) && modelPropertyList.get(j).getSize() <= Integer.parseInt((String)view.getPropertyManagerHomePage().getMaxSizeComboBox().getSelectedItem())){
										 if(view.getPropertyManagerHomePage().getFurnishingCombobox().getSelectedItem().equals("All Furnishing") || view.getPropertyManagerHomePage().getFurnishingCombobox().getSelectedItem().equals(modelPropertyList.get(j).getFurnishing())) {
											if(modelPropertyList.get(j).getBedRoomsNum() >= Integer.parseInt((String)view.getPropertyManagerHomePage().getMinBedCombobox().getSelectedItem()) && modelPropertyList.get(j).getBedRoomsNum() <= Integer.parseInt((String)view.getPropertyManagerHomePage().getMaxBedCombobox().getSelectedItem())){
												if(view.getPropertyManagerHomePage().getActivationStatusCombobox().getSelectedItem().equals("All Activation Status") || modelPropertyList.get(j).getPropertyActivationStatus().equals(view.getPropertyManagerHomePage().getActivationStatusCombobox().getSelectedItem())) {
													if(modelPropertyList.get(j).getRentalRate()>= Double.parseDouble((String)view.getPropertyManagerHomePage().getMinRentalRateCombobox().getSelectedItem()) && modelPropertyList.get(j).getRentalRate() <= Double.parseDouble((String)view.getPropertyManagerHomePage().getMaxRentalRateCombobox().getSelectedItem())){
														if(checkCheckbox(j)) {
															searchPropertyList.add(modelPropertyList.get(j));
														}
															
													}
												}
												
											}
										 }
									}
								}
							}
						}
//					}
					else
						System.out.println(modelPropertyList.get(j).getPropertyID());
				}
				view.setPanelToHomeAndSearch(searchPropertyList); // set panel to show the properties that matches the search
				initViewDetails(searchPropertyList); // for new buttons on new panels
			}
		});
		
		view.getPropertyManagerHomePage().getlogOutLabel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				view.logOut();
//				initController();// after the logout, set the listeners to login buttons
				initLoginPage();
			}
		});	
		view.getPropertyManagerHomePage().getHomeLabel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				view.logOut();
//				initController();// after the logout, set the listeners to login buttons
			}
		});	
		view.getPropertyManagerHomePage().getRentRequestLabel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				view.setPanelToRequestsPage();
				initRequestsPage();
			
//				initController();// after the logout, set the listeners to login buttons
			}
		});	
		view.getPropertyManagerHomePage().getNewPropertyLabel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				initNewPropertyPage();
				// view.setPanelToNewPropertyPage();
//				initController();// after the logout, set the listeners to login buttons
			}
		});	
		view.getPropertyManagerHomePage().getManagePropertiesLabel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// view.setPanelToManagePropertiesPage();
				initManagePropertyPage();
//				initController();// after the logout, set the listeners to login buttons
			}
		});		

		
		// Remove me later
		initExtra();
		
//		.getSignupButton()
		
	}
	public void initViewDetails(ArrayList<Property> propertyList) { // view details buttons
		for(int i = 0; i < view.getPropertyManagerHomePage().getPropertiesViewDetailsButtons().size(); ++i) {
			view.getPropertyManagerHomePage().getPropertiesViewDetailsButtons().get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					view.setPanelToProperty(propertyList.get(view.getPropertyManagerHomePage().getPropertiesViewDetailsButtons().indexOf(e.getSource())));
					if(view.getCurrentPropertyView().getCurrentProperty().getAgentName().equals(user.getUserName())) {
						view.getCurrentPropertyView().getRentRequestButton().setEnabled(false);
						view.getCurrentPropertyView().getRentRequestLabel().setText("You cant rent your property");
					}
					view.getBackIconLabel().addMouseListener(new MouseAdapter() { // back button inside property details page
						@Override
						public void mouseClicked(MouseEvent e) {
							view.setPanelToHomeAndSearch(propertyList);
							initViewDetails(propertyList);
							
						}
					});
					view.getCurrentPropertyView().getRentRequestButton().addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							view.getCurrentPropertyView().getManagerInfoPanel().setVisible(true);
							view.getCurrentPropertyView().getRentRequestButton().setFont(new Font("Source Serif Pro Black", Font.PLAIN, 15));
							view.getCurrentPropertyView().getRentRequestButton().setText("The property manager will contact you soon!");
							view.getCurrentPropertyView().getRentRequestButton().setEnabled(false);
							try {
								sendRentRequestToFile();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
				}
			});
		}
	}
	
	public void resetComboBoxes() {
		view.getPropertyManagerHomePage().getPropertTypeComboBox().setSelectedIndex(0);
		view.getPropertyManagerHomePage().getMinPriceComboBox().setSelectedIndex(0);
		view.getPropertyManagerHomePage().getMaxPriceComboBox().setSelectedIndex(view.getPropertyManagerHomePage().getMaxPriceComboBox().getModel().getSize()-1);
		view.getPropertyManagerHomePage().getProjectsCombobox().setSelectedIndex(0);
		view.getPropertyManagerHomePage().getMinSizeComboBox().setSelectedIndex(0);
		view.getPropertyManagerHomePage().getMaxSizeComboBox().setSelectedIndex(view.getPropertyManagerHomePage().getMaxSizeComboBox().getModel().getSize()-1);
		view.getPropertyManagerHomePage().getFurnishingCombobox().setSelectedIndex(0);
		view.getPropertyManagerHomePage().getMinBedCombobox().setSelectedIndex(0);
		view.getPropertyManagerHomePage().getMaxBedCombobox().setSelectedIndex(view.getPropertyManagerHomePage().getMaxBedCombobox().getModel().getSize()-1);
		view.getPropertyManagerHomePage().getActivationStatusCombobox().setSelectedIndex(0);
		view.getPropertyManagerHomePage().getMinRentalRateCombobox().setSelectedIndex(0);
		view.getPropertyManagerHomePage().getMaxRentalRateCombobox().setSelectedIndex(view.getPropertyManagerHomePage().getMaxRentalRateCombobox().getModel().getSize()-1);
		for(int i = 0; i < view.getPropertyManagerHomePage().getFacilitiesCheckboxList().length; ++i)
			view.getPropertyManagerHomePage().getFacilitiesCheckboxList()[i].setSelected(false);
		for(int i = 0; i < view.getPropertyManagerHomePage().getFeaturesCheckboxList().length; ++i)
			view.getPropertyManagerHomePage().getFeaturesCheckboxList()[i].setSelected(false);
		
	}
	
	public void setProjectsComboboxFromFile() throws FileNotFoundException{ // read the projects names from their file
		File projectsNamesFile = new File("System/Property Manager/Projects.txt");
		Scanner projectsNamesFileScannner = new Scanner(projectsNamesFile); 
		while(projectsNamesFileScannner.hasNext())
			view.getPropertyManagerHomePage().getProjectsCombobox().addItem(projectsNamesFileScannner.nextLine());
		projectsNamesFileScannner.close();
	}
	
	private boolean checkCheckbox(int index) {
//		for(int j = 0; j < modelPropertyList.size(); ++j) {
			ArrayList<String> facilitiesList = new ArrayList<>(Arrays.asList(modelPropertyList.get(index).getAvailableFacilities()));
			ArrayList<String> featuresList= new ArrayList<>(Arrays.asList(modelPropertyList.get(index).getAvailableFeatures()));
			for(int i = 0; i < view.getPropertyManagerHomePage().getFacilitiesCheckboxList().length; ++i) {
				if(view.getPropertyManagerHomePage().getFacilitiesCheckboxList()[i].isSelected() && !facilitiesList.contains(view.getPropertyManagerHomePage().getFacilitiesCheckboxList()[i].getText())){
					return false;
				}
			}
			for(int i = 0; i < view.getPropertyManagerHomePage().getFeaturesCheckboxList().length; ++i) {
				if(view.getPropertyManagerHomePage().getFeaturesCheckboxList()[i].isSelected() && !featuresList.contains(view.getPropertyManagerHomePage().getFeaturesCheckboxList()[i].getText())){
					return false;
				}
			}
			return true;
//		}
	}
	
	public boolean validateLogin(String username, String password) throws FileNotFoundException {
		String path = "";
		for(int x = 0; x < 3 ; x++){
			if(x == 0)
				path = "System/Admin/";
			else if(x == 1)
				path = "System/Property Manager/";
			else if(x == 2)
				path = "System/Tenant/";
				
			File mainDir = new File(path);
			File[] listOfManagersDir = mainDir.listFiles();
			for(int i = 0; i < listOfManagersDir.length; ++i) {
				if(listOfManagersDir[i].getName().equals(username)) {
					File managerDir = new File(mainDir.getPath() + "/" + listOfManagersDir[i].getName());
					File accountInfoFile = new File(managerDir.getPath() + "/accountInfo.txt");
					Scanner accountInfoScanner = new Scanner(accountInfoFile);
					user = new User(Integer.parseInt(accountInfoScanner.nextLine()), accountInfoScanner.nextLine(), accountInfoScanner.nextLine(), accountInfoScanner.nextLine(), accountInfoScanner.nextLine(), accountInfoScanner.nextLine(), accountInfoScanner.nextLine(), accountInfoScanner.nextLine());
					accountInfoScanner.close();
					if(user.getPassword().equals(password))
						return true;
				}
			}
		}
		return false;
		
	}
	
	private void sendRentRequestToFile() throws IOException {
		FileWriter fileWriter  = new FileWriter("System/Property Manager/" + view.getCurrentPropertyView().getCurrentProperty().getAgentName() + "/Properties/" + view.getCurrentPropertyView().getCurrentProperty().getPropertyID() + "/rentRequests.txt", true); 
		PrintWriter outputNames =  new PrintWriter(fileWriter);

		if (user.getRole().equals("Property Agent") || user.getRole().equals("Property Owner")){
			outputNames.println("Property Manager");
			outputNames.println(user.getUserName());
		}
		else{
			outputNames.println(user.getRole());
			outputNames.println(user.getUserName());
		}

		outputNames.close();
	}

	private ArrayList<requestContactInstance> readRentRequests() throws FileNotFoundException {
		ArrayList<requestContactInstance> requestList = new ArrayList<>();
		File propertiesDir = new File("System/Property Manager/" + user.getUserName() + "/Properties/");
		File[] propertiesOfManager = propertiesDir.listFiles();
		for(File property : propertiesOfManager) {
			File propertyRentRequests = new File(property.getPath() + "/rentRequests.txt"); // Get the tenant information from property rent request file using Scanner
			if(propertyRentRequests.exists()) {
				Scanner propertyInfoScanner = new Scanner(propertyRentRequests);
				while(propertyInfoScanner.hasNext()) {
					requestContactInstance request = new requestContactInstance();
					File tenant = new File("System/" + propertyInfoScanner.nextLine() + "/" + propertyInfoScanner.nextLine() + "/accountInfo.txt");
					Scanner tenantScanner = new Scanner(tenant);
					tenantScanner.nextLine();
					request.setUsername(tenantScanner.nextLine());
					tenantScanner.nextLine();
					
					request.getTenantNameEntryLabel().setText(tenantScanner.nextLine());
					request.getTenantContactNumEntryLabel().setText(tenantScanner.nextLine());
					request.getTenantEmailEntryLabel().setText(tenantScanner.nextLine());
					request.getPropertyTextEntryLabel().setText(property.getName());
					requestList.add(request);
					tenantScanner.close();
					
				}
				propertyInfoScanner.close();
			}					
		}
		return requestList;
	}
	
	private void initRequestsButtons() {
		for(int i = 0; i < view.getRequestsPage().getApproveButtons().size(); ++i) {
			view.getRequestsPage().getApproveButtons().get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					approveRentRequest(rentRequestList.get(view.getRequestsPage().getApproveButtons().indexOf(e.getSource())));
					initRequestsPage();
					//					view.setPanelToProperty(propertyList.get(view.getPropertyManagerHomePage().getPropertiesViewDetailsButtons().indexOf(e.getSource())));
				}
			});
			view.getRequestsPage().getDenyButtons().get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					denyRentRequest(rentRequestList.get(view.getRequestsPage().getDenyButtons().indexOf(e.getSource())));
					initRequestsPage();
					//					view.setPanelToProperty(propertyList.get(view.getPropertyManagerHomePage().getPropertiesViewDetailsButtons().indexOf(e.getSource())));
				}
			});
			
		}
	}
	private void approveRentRequest(requestContactInstance request) {
		File propertyRequestsFile = new File("System/Property Manager/" + user.getUserName() + "/Properties/" + request.getPropertyTextEntryLabel().getText() + "/rentRequests.txt");
		for(int i = 0; i < modelPropertyList.size(); ++i) {
			if(modelPropertyList.get(i).getPropertyID() == Integer.parseInt(request.getPropertyTextEntryLabel().getText())) {
				modelPropertyList.get(i).setTenantName(request.getTenantNameEntryLabel().getText());
				modelPropertyList.get(i).setPropertyActivationStatus("Deactivated");
				try {
					modelPropertyList.get(i).savePropertyFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		}
		System.out.println(propertyRequestsFile.delete());
	}
	
	private void denyRentRequest(requestContactInstance request) {
		File propertyRequestsFile = new File("System/Property Manager/" + user.getUserName() + "/Properties/" + request.getPropertyTextEntryLabel().getText() + "/rentRequests.txt");
		try {
			PrintWriter propertyRequestsWriter = new PrintWriter(propertyRequestsFile);
			for(int i = 0; i < rentRequestList.size(); ++i) {
				if(!rentRequestList.get(i).getTenantNameEntryLabel().getText().equals(request.getTenantNameEntryLabel().getText())) {
					propertyRequestsWriter.println(rentRequestList.get(i).getUsername());
				}
					
			}
			propertyRequestsWriter.close();
			rentRequestList = readRentRequests();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
		
    
	private ArrayList<Property> readManageProperties() throws FileNotFoundException {
		ArrayList<Property> propertyList = new ArrayList<>();
		File mainDir = new File("System/Property Manager/"+ user.getUserName() + "/Properties");
		File[] listOfProperties = mainDir.listFiles();
//		for(File file : listOfProperties) {
//			File propertiesDir = new File(file.getPath() + "/Properties/");
//				File[] propertiesOfManager = propertiesDir.listFiles();
				for(File property : listOfProperties) {
					File propertyInfo = new File(property.getPath() + "/propertyInfo.txt");
					File propertyPic = new File(property.getPath()+ "/propertyPics");
					String[] propertyPicPath = new String[propertyPic.list().length];
					for(int i = 0; i < propertyPicPath.length; ++i){
						 propertyPicPath[i] = "System/Property Manager/" + user.getUserName() + "/Properties/" + property.getName() + "/propertyPics/" + propertyPic.list()[i];
						System.out.println(propertyPicPath[i]);
					}

					Scanner propertyInfoScanner = new Scanner(propertyInfo);
					propertyList.add(new Property(Integer.parseInt(propertyInfoScanner.nextLine()), //using the reading constructor (without incrementing the lastID)
										  propertyInfoScanner.nextLine(), 
										  Double.parseDouble(propertyInfoScanner.nextLine()), 
										  Integer.parseInt(propertyInfoScanner.nextLine()),
										  propertyPicPath,
										  new Address (propertyInfoScanner.nextLine(), propertyInfoScanner.nextLine()),
										  Integer.parseInt(propertyInfoScanner.nextLine()),
										  Integer.parseInt(propertyInfoScanner.nextLine()),
										  propertyInfoScanner.nextLine(),
										  propertyInfoScanner.nextLine(),
										  propertyInfoScanner.nextLine(),
										  propertyInfoScanner.nextLine(),
										  propertyInfoScanner.nextLine().split("\\|"),
										  propertyInfoScanner.nextLine().split("\\|"),
										  propertyInfoScanner.nextLine(),
										  propertyInfoScanner.nextLine(),
										  propertyInfoScanner.nextLine()
										  ));
					propertyInfoScanner.close();
				}
		
//		}
		return propertyList;
	}
	public void setManagePropertyListings(){
		try {
//			ArrayList<Property> properties = readManageProperties();
			ArrayList<Property> properties = readManageProperties();
			ArrayList<ManagePropertyListing> propertyListing = new ArrayList<>();
			for(int i = 0; i < properties.size(); ++i) {
				ManagePropertyListing instance = new ManagePropertyListing();
				instance.getProjectNameLabel().setText(properties.get(i).getPropertyAddress().getProject());
				instance.getPropertyNameLabel().setText(properties.get(i).getPropertyName());
				instance.getPropertyActivationLabel().setText(properties.get(i).getPropertyActivationStatus());
				instance.getAddressLine1Label().setText(properties.get(i).getPropertyAddress().getFullAddress());
				instance.getPriceLabel().setText(Double.toString(properties.get(i).getPrice()));
				instance.getPropertyImageLabel().setIcon(loadImage(properties.get(i).getPropertyPicturePath()[0], 121,189));
				if(properties.get(i).getPropertyActivationStatus().equals("Deactivated"))
					instance.setBackground(Color.LIGHT_GRAY);
				propertyListing.add(instance);
				
			}
			view.getManagePropertiesPage().setPropertiesList(propertyListing);
//			view.getManagePropertiesPage().setPropertiesList(properties);
			initViewPropertyDetails();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void initViewPropertyDetails() {
		for(int i = 0; i < view.getManagePropertiesPage().getViewDetailsButtons().size(); ++i) {
			view.getManagePropertiesPage().getViewDetailsButtons().get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						ArrayList<Property> properties = readManageProperties();
						initSpecificManagerPropertyView(properties.get(view.getManagePropertiesPage().getViewDetailsButtons().indexOf(e.getSource())));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		}
	}
	public void initNewPropertyPage(){
		// view.getNewPropertyPage() = new NewPropertyPage();
		propertyPics.clear();
		view.setPanelToNewPropertyPage();
		view.getNewPropertyPage().getHomeButton().addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				initHomePage();
				initViewDetails(modelPropertyList);
			}
		});
	
		view.getNewPropertyPage().getRentRequestsButton().addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				initRequestsPage();
			}
		});
		
		view.getNewPropertyPage().getManagePropertiesButton().addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				initManagePropertyPage();
			}
		});
		
		view.getNewPropertyPage().getNewPropertyPageButton().addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				initNewPropertyPage();
			}
		});
		
		view.getNewPropertyPage().getLogOutButton().addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				view.logOut();
	//			initController();
				initLoginPage();
			}
		});
		view.getNewPropertyPage().getAddButton().addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//TODO add AddButton action
				if (
					view.getNewPropertyPage().getNameTextField().getText().isEmpty() ||
					view.getNewPropertyPage().getPriceTextField().getText().isEmpty() ||
					view.getNewPropertyPage().getSizeTextField().getText().isEmpty() ||
					view.getNewPropertyPage().getAddressTextArea().getText().isEmpty() ||
					(view.getNewPropertyPage().getProjectNameTextField().getText().isEmpty() && (((String)view.getNewPropertyPage().getProjectComboBox().getSelectedItem()).equals("New Project")))||
					view.getNewPropertyPage().getjTextArea1().getText().isEmpty() || propertyPics.isEmpty())

				{
					JOptionPane.showMessageDialog(view,"Please ensure all fields are filled and image has been added");
					}
				
					else {
					String propertyName = view.getNewPropertyPage().getNameTextField().getText();
					double price = Double.parseDouble(view.getNewPropertyPage().getPriceTextField().getText());
					int size = Integer.parseInt(view.getNewPropertyPage().getSizeTextField().getText());
					
					String projectName;
					String fullAddress = view.getNewPropertyPage().getAddressTextArea().getText();
					if (view.getNewPropertyPage().getProjectNameTextField().getText().isEmpty()){
						projectName = (String) view.getNewPropertyPage().getProjectComboBox().getSelectedItem(); //if existing project is selected
					
					} else {
						projectName = (String) view.getNewPropertyPage().getProjectNameTextField().getText();
					}
					
						//Retrieving information from form
						Address propertyAddress = new Address(projectName, fullAddress);
						int bedRoomsNum = Integer.parseInt((String)view.getNewPropertyPage().getBedsComboBox().getSelectedItem());
						int bathRoomsNum = Integer.parseInt((String)view.getNewPropertyPage().getBathsComboBox().getSelectedItem());
						String propertyType = (String) view.getNewPropertyPage().getPropertyTypeComboBox().getSelectedItem();
						String furnishing = (String) view.getNewPropertyPage().getFurnishingComboBox().getSelectedItem();
						String propertyActivationStatus = "Activated";
						String propertyApprovalStatus = "Pending";
						String description =  (String) view.getNewPropertyPage().getjTextArea1().getText().replaceAll("\n","|");
						String tenantName = "";
						String agentName = user.getUserName();
						ArrayList<String> facilityList = new ArrayList<String>();
						ArrayList<String> featureList = new ArrayList<String>();

						
						// Features checking
						if (view.getNewPropertyPage().getSecurityCheckBox().isSelected()) {
							facilityList.add("24-Hour Security");
						}
						if (view.getNewPropertyPage().getParkingCheckBox().isSelected()) {
							facilityList.add("Parking");
						}
						if (view.getNewPropertyPage().getGymCheckBox().isSelected()) {
							facilityList.add("Gym");
						}
						if (view.getNewPropertyPage().getPlaygroundCheckBox().isSelected()) {
							facilityList.add("Playground");
						}
						if (view.getNewPropertyPage().getPoolCheckBox().isSelected()) {
							facilityList.add("Swimming Pool");
						}
						if (view.getNewPropertyPage().getSportCheckBox().isSelected()) {
							facilityList.add("Sport Court");
						}
						if (view.getNewPropertyPage().getSupermarketCheckBox().isSelected()) {
							facilityList.add("Supermarket");
						}
						

						//Facilities checking
						if (view.getNewPropertyPage().getAirConditionerCheckBox().isSelected()) {
							featureList.add("Air Conditioner");
						}
						if (view.getNewPropertyPage().getKitchenCabinetCheckBox().isSelected()) {
							featureList.add("Kitchen Cabinet");
						}
						if (view.getNewPropertyPage().getGardenCheckBox().isSelected()) {
							featureList.add("Garden");
						}
						if (view.getNewPropertyPage().getGarageCheckBox().isSelected()) {
							featureList.add("Garage");
						}

						//Convert arraylists to arrays
						String[] availableFacilities = new String[facilityList.size()];
						String[] availableFeatures = new String[featureList.size()];

						availableFeatures = featureList.toArray(availableFeatures);
						availableFacilities = facilityList.toArray(availableFacilities);

						Property p = new Property(propertyName, price, size, propertyAddress, bedRoomsNum, bathRoomsNum, propertyType, furnishing, propertyActivationStatus, propertyApprovalStatus, availableFacilities, availableFeatures, description, tenantName, agentName);
						JOptionPane.showMessageDialog(view, "Your property has been added, please wait for admin approval", "New Property Added", JOptionPane.INFORMATION_MESSAGE);

						if (view.getNewPropertyPage().getProjectNameTextField().isVisible()){
							try{
								FileWriter ProjectNamesFile = new FileWriter("System/Property Manager/Projects.txt", true);
								PrintWriter outputNames =  new PrintWriter(ProjectNamesFile);	
								outputNames.println(view.getNewPropertyPage().getProjectNameTextField().getText());
								outputNames.close();
								ProjectNamesFile.close();

							}
							catch(IOException ex){
								System.out.println(ex.getMessage());
							}
						} 

						BufferedImage image = null; 
						

						for (int i =0; i<propertyPics.size();i++){
							// Path source = Paths.get("c:/temp/testoriginal.txt");
							// Path destination = Paths.get("c:/temp/testcopied.txt");
					
							// Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
							try{ 
								File input_file = propertyPics.get(i);
					
								image = new BufferedImage(1000, 1000,BufferedImage.TYPE_INT_ARGB); 
					
								image = ImageIO.read(input_file); 
							} 
							catch(IOException e) 
							{ 
								System.out.println("Error: "+e); 
							} 
					
							// WRITE IMAGE 
							try
							{ 
								// Output file path 
								File output_file = new File("System\\Property Manager\\" + user.getUserName() + "\\Properties\\"+ p.getPropertyID() + "\\propertyPics\\"+i+".png"); 
					
								// Writing to file taking type and path as 
								ImageIO.write(image, "png", output_file); 
					
								System.out.println("Writing complete."); 
							} 
							catch(IOException e) 
							{ 
								System.out.println("Error: "+e); 
							} 
						}

						initHomePage();
						initManagePropertyPage();
					}
				}
		});
		
		view.getNewPropertyPage().getNameTextField().addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
		
		
			}
		});
		
		view.getNewPropertyPage().getPropertyTypeComboBox().addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
		
		
		
			}
		});
		
		view.getNewPropertyPage().getKitchenCabinetCheckBox().addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
		
		
		
			}
		});
		
		view.getNewPropertyPage().getaddImagesButton().addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
			//TODO add image picking behavior
			JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
	
			j.setMultiSelectionEnabled(true); 
			int r = j.showOpenDialog(null); 
			if (r == JFileChooser.APPROVE_OPTION) { 
				// get the selelcted files 
				File files[] = j.getSelectedFiles(); 
				propertyPics = new ArrayList<File>(Arrays.asList(files));
				}
			}
		});
		
		view.getNewPropertyPage().getProjectComboBox().addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (view.getNewPropertyPage().getProjectComboBox().getSelectedItem().equals("New Project")){
					view.getNewPropertyPage().getProjectNameTextField().setVisible(true);
					view.getNewPropertyPage().getProjectNameTextField().setSize(122, 30);
				} 
				else {
					view.getNewPropertyPage().getProjectNameTextField().setVisible(false);
				}
			
			}
		});
	}
	public void initManagePropertyPage(){
		setManagePropertyListings();
		view.setPanelToManagePropertiesPage();
	}
	public void initEditPropertyPage(Property p){
		view.setPanelToEditPage();
		selectedProperty = p;
		view.getEditPage().getPropertyNameLabel().setText(p.getPropertyName());
		view.getEditPage().getPriceTextField().setText(Double.toString(p.getPrice()));
		view.getEditPage().getPropertyTypeComboBox().setSelectedItem(p.getPropertyType());
		view.getEditPage().getAddressTextArea().setText(p.getPropertyAddress().getProject() +", " +p.getPropertyAddress().getFullAddress());
		view.getEditPage().getjTextArea1().setText(p.getDescription());
		for (String s : p.getAvailableFacilities()){
			if (s.equals("24-Hour Security")) {
				view.getEditPage().getSecurityCheckBox().setSelected(true);
			}
			else if (s.equals("Parking")) {
				view.getEditPage().getParkingCheckBox().setSelected(true);
			}
			else if (s.equals("Gym")) {
				view.getEditPage().getGymCheckBox().setSelected(true);
			}
			if (s.equals("Playground")) {
				view.getEditPage().getPlaygroundCheckBox().setSelected(true);
			}
			if (s.equals("Swimming Pool")) {
				view.getEditPage().getPoolCheckBox().setSelected(true);
			}
			if (s.equals("Sport Court") ){
				view.getEditPage().getSportCheckBox().setSelected(true);
			}
			if (s.equals("Supermarket")) {
				view.getEditPage().getSupermarketCheckBox().setSelected(true);
			}
		}

		//Features checking
		for (String st : p.getAvailableFeatures()) {
			if (st.equals("Air Conditioner")) {
				view.getEditPage().getAirConditionerCheckBox().setSelected(true);
			}
			if (st.equals("Kitchen Cabinet") ){
				view.getEditPage().getKitchenCabinetCheckBox().setSelected(true);
			}
			if (st.equals("Garden")) {
				view.getEditPage().getGardenCheckBox().setSelected(true);
			}
			if (st.equals("Garage")) {
				view.getEditPage().getGarageCheckBox().setSelected(true);
			}
		}

		view.getEditPage().getSizeTextField().setText(Integer.toString(p.getSize()));
		view.getEditPage().getBedsComboBox().setSelectedItem(Integer.toString(p.getBedRoomsNum()));
		view.getEditPage().getBathsComboBox().setSelectedItem(Integer.toString(p.getBathRoomsNum()));

	}
	public void initRequestsPage(){
		try {
			rentRequestList = readRentRequests();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		view.getRequestsPage().setRentRequest(rentRequestList);
		initRequestsButtons();
		view.setPanelToRequestsPage();
	
	}
	public void initSpecificManagerPropertyView(Property p){
		view.setPanelToSpecificManagerPropertyView(p);
		selectedProperty = p;
		
		view.getSpecificManagerPropertyView().getEditButton().addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				initEditPropertyPage(p);
			}
		});
		
		view.getSpecificManagerPropertyView().getDeleteButton().addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//TODO add delete property behaviour
//				File fileToDelete = new File("System\\Property Manager\\" + user.getUserName() + "\\Properties\\" + selectedProperty.getPropertyID());
//				deleteDir(fileToDelete);
				try {
				Files.walk( Paths.get("System\\Property Manager\\" + user.getUserName() + "\\Properties\\" + selectedProperty.getPropertyID()))
			    .sorted(Comparator.reverseOrder())
			    .map(Path::toFile)
			    .forEach(File::delete);
				}catch (Exception ex) {ex.printStackTrace();}
				initManagePropertyPage();
			}
		});
		if(p.getPropertyActivationStatus().equals("Activated"))
			view.getSpecificManagerPropertyView().getActivationButton().setText("Deactivate");
		else
			view.getSpecificManagerPropertyView().getActivationButton().setText("Activate");
		view.getSpecificManagerPropertyView().getActivationButton().addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//TODO add toggle behaviour
				try {
					if (view.getSpecificManagerPropertyView().getActivationButton().getText().equals("Activate")){
						replaceLines(new File("System\\Property Manager\\" + user.getUserName() + "\\Properties\\" + p.getPropertyID() + "\\propertyInfo.txt"), "Activated", 11);
						initSpecificManagerPropertyView(p);
						view.getSpecificManagerPropertyView().getActivationButton().setText("Deactivate");
						modelPropertyList =  MainDriver.readPropertiesFromFiles();
					}else{
						replaceLines(new File("System\\Property Manager\\" + user.getUserName() + "\\Properties\\" + p.getPropertyID() + "\\propertyInfo.txt"), "Deactivated", 11);
						initSpecificManagerPropertyView(p);
						view.getSpecificManagerPropertyView().getActivationButton().setText("Activate");
						modelPropertyList =  MainDriver.readPropertiesFromFiles();
					}
				}catch(Exception ex){ex.printStackTrace();}
			}
		});
		
		view.getSpecificManagerPropertyView().getBackIconLabel().addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				initHomePage();
//				initViewDetails(modelPropertyList);
				initManagePropertyPage();
			}
		});
		// view.setPanelToSpecificManagerPropertyView(p);
	
	}
	public void initExtra(){
	
	//Edit Property Page////////////////
	view.getEditPage().getLogOutButton().addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			view.logOut();
			initLoginPage();
			//TODO enable this after initExtra() is done
		}
	});
	
	view.getEditPage().getAddButton().addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			Property p = selectedProperty; //TODO set selected property when page is opened
			//TODO add edit behaviour
			String propertyName = view.getEditPage().getPropertyNameLabel().getText();
			double price = Double.parseDouble(view.getEditPage().getPriceTextField().getText());
			int size = Integer.parseInt(view.getEditPage().getSizeTextField().getText());
			
			// String projectName;
			String fullAddress = view.getEditPage().getAddressTextArea().getText();
			// if (view.getEditPage().getProjectNameTextField().getText() == ""){
			// 	projectName = (String) view.getEditPage().getProjectComboBox().getSelectedItem(); //if existing project is selected
			
			// } else {
			// 	projectName = (String) view.getEditPage().getProjectNameTextField().getText();
			// }
			
			//Retrieving information from form
			Address propertyAddress = p.getPropertyAddress();
			int bedRoomsNum = Integer.parseInt((String)view.getEditPage().getBedsComboBox().getSelectedItem());
			int bathRoomsNum = Integer.parseInt((String)view.getEditPage().getBathsComboBox().getSelectedItem());
			String propertyType = (String) view.getEditPage().getPropertyTypeComboBox().getSelectedItem();
			// String furnishing;
			// String propertyActivationStatus = "Activated";
			// String propertyApprovalStatus;
			String description =  (String) view.getEditPage().getjTextArea1().getText().replaceAll("\n","|");
			// String tenantName;
			String agentName = user.getUserName();
			ArrayList<String> facilityList = new ArrayList<String>();
			ArrayList<String> featureList = new ArrayList<String>();

			
			// Features checking
			if (view.getEditPage().getSecurityCheckBox().isSelected()) {
				facilityList.add("24-Hour Security");
			}
			if (view.getEditPage().getParkingCheckBox().isSelected()) {
				facilityList.add("Parking");
			}
			if (view.getEditPage().getGymCheckBox().isSelected()) {
				facilityList.add("Gym");
			}
			if (view.getEditPage().getPlaygroundCheckBox().isSelected()) {
				facilityList.add("Playground");
			}
			if (view.getEditPage().getPoolCheckBox().isSelected()) {
				facilityList.add("Swimming Pool");
			}
			if (view.getEditPage().getSportCheckBox().isSelected()) {
				facilityList.add("Sport Court");
			}
			if (view.getEditPage().getSupermarketCheckBox().isSelected()) {
				facilityList.add("Supermarket");
			}
			
			//Facilities checking
			if (view.getEditPage().getAirConditionerCheckBox().isSelected()) {
				featureList.add("Air Conditioner");
			}
			if (view.getEditPage().getKitchenCabinetCheckBox().isSelected()) {
				featureList.add("Kitchen Cabinet");
			}
			if (view.getEditPage().getGardenCheckBox().isSelected()) {
				featureList.add("Garden");
			}
			if (view.getEditPage().getGarageCheckBox().isSelected()) {
				featureList.add("Garage");
			}
			//Convert arraylists to arrays
			String[] availableFacilities = new String[4];
			String[] availableFeatures = new String[facilityList.size()];
			availableFeatures = featureList.toArray(availableFeatures);
			availableFacilities = facilityList.toArray(availableFacilities);

			try {

			// Property p = new Property(propertyID, propertyName, price, size, propertyPicturePath, propertyAddress, bedRoomsNum, bathRoomsNum, propertyType, furnishing, propertyActivationStatus, propertyApprovalStatus, availableFacilities, availableFeatures, description, tenantName, agentName);
			new File("System\\Property Manager\\" + agentName + "\\Properties\\"+ p.getPropertyID() + "\\propertyPics\\").mkdirs();                                              // code for making order file in restaurant directory
		    File propertyInfo = new File("System\\Property Manager\\" + agentName + "\\Properties\\" + p.getPropertyID() + "\\propertyInfo.txt"); //Adds order filename to names.txt file. Used to fetch order file names later.
		    FileWriter propertyFileWriter = new FileWriter(propertyInfo, false);
		    PrintWriter propertyPrintWriter = new PrintWriter(propertyFileWriter);
		
		    propertyPrintWriter.println(p.getPropertyID());
		    propertyPrintWriter.println(propertyName);
		    propertyPrintWriter.println(price);
		    propertyPrintWriter.println(size);
		    propertyPrintWriter.println(propertyAddress.getProject());
		    propertyPrintWriter.println(fullAddress);
		    propertyPrintWriter.println(bedRoomsNum);
		    propertyPrintWriter.println(bathRoomsNum);
		    propertyPrintWriter.println(propertyType);
		    propertyPrintWriter.println(p.getFurnishing());
		    propertyPrintWriter.println(p.getPropertyActivationStatus());
		    propertyPrintWriter.println(p.getPropertyApprovalStatus());
		    
		    for (String s : facilityList){
		            propertyPrintWriter.print(s + "|");
		    }
		    propertyPrintWriter.print("\n");
		    
		    for (String s : featureList){
		            propertyPrintWriter.print(s + "|");
		    }
		    propertyPrintWriter.print("\n");
		    
		    propertyPrintWriter.println(description);
		    propertyPrintWriter.println(p.getTenantName());
		    propertyPrintWriter.println(p.getAgentName());      
		
		    propertyPrintWriter.close();
			propertyFileWriter.close();
		}catch(Exception ex ){ex.printStackTrace();}

			initManagePropertyPage();
		
		}
	});
	
	view.getEditPage().getPropertyTypeComboBox().addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
		
		}
	});
	
	view.getEditPage().getCancelButton().addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			initManagePropertyPage();
		}
	});
	
	view.getEditPage().getHomeButton().addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			initHomePage();
			initViewDetails(modelPropertyList);
		}
	});
	
	view.getEditPage().getRentRequestsButton().addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			initRequestsPage();
		}
	});
	
	view.getEditPage().getManagePropertiesButton().addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			initManagePropertyPage();
		}
	});
	
	view.getEditPage().getNewPropertyPageButton().addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			initNewPropertyPage();
		}
	});
	

	//Manage Property Page/////////////////
	view.getManagePropertiesPage().getHomeButton().addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			initHomePage();
			initViewDetails(modelPropertyList);
		}
	});
	
	view.getManagePropertiesPage().getRentRequestsButton().addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			initRequestsPage();
		}
	});
	
	view.getManagePropertiesPage().getManagePropertiesButton().addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			initManagePropertyPage();
		}
	});
	
	view.getManagePropertiesPage().getNewPropertyPageButton().addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			initNewPropertyPage();
		}
	});
	
	view.getManagePropertiesPage().getLogOutButton().addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			view.logOut();
//			initController();
			initLoginPage();
		}
	});
	
	//Rent request page////////////////////
	
	view.getRequestsPage().getHomeButton().addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			initHomePage();
			initViewDetails(modelPropertyList);
		}
	});
	
	view.getRequestsPage().getRentRequestsButton().addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			initRequestsPage();
		}
	});
	
	view.getRequestsPage().getManagePropertiesButton().addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			initManagePropertyPage();
		}
	});
	
	view.getRequestsPage().getNewPropertyPageButton().addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			initNewPropertyPage();
		}
	});
	
	view.getRequestsPage().getLogOutButton().addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			view.logOut();
//			initController();
			initLoginPage();
		}
	});
	
	}
	private ImageIcon loadImage(String path, int x, int y){
        Image image = new ImageIcon(this.getClass().getResource(path)).getImage();
        Image scaledImage = image.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
	} 
	
	public MyJFrame getView(){
		return view;
	}
}
