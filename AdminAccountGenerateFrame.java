import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

// Naim Farhat Bin Mahmad Zulhasnan (1191101830)
// View & Controller Class to create new account for admin
// Generated using Eclipse
public class AdminAccountGenerateFrame extends javax.swing.JFrame {

    //All the variable that use in the frame
    private javax.swing.JLabel adminAcountGenerationLabel;
    private javax.swing.JPanel adminPanelBackGroundPanel;
    private javax.swing.JLabel dashBoardLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel pendingToApproveAdsLabel;
    private javax.swing.JLabel pendingToApproveAdsTittleLabel;
    private javax.swing.JPanel redPanelBackGroundPanel;
    private javax.swing.JLabel reportLabel;
    private javax.swing.JTextField txtField1;
    private javax.swing.JTextField txtField2;
    private javax.swing.JLabel userApplicationLabel;
    private javax.swing.JLabel userNameLabel;
	
	String selectedRowUserID = "";      //to store the userid of the row that is selected by the user in user application table
    ArrayList<User> userInfo = new ArrayList<User>();   // to store all user into a arrayList
	ArrayList<Property> propertyInfo = new ArrayList<Property>();  // to store all property info in arrayList
	
	
    public AdminAccountGenerateFrame() {
        initComponents();
        //scaleIconImage();
        this.setLocationRelativeTo(null);
        try {                                 // to read all the user into the userInfo arrayLIst
                 readUserFile("System/");
            } catch (IOException ex) {
                Logger.getLogger(AdminAccountGenerateFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    // this method is mainly use for the design of the component in this generate new admin account frame
    private void initComponents() {

        adminPanelBackGroundPanel = new javax.swing.JPanel();
        redPanelBackGroundPanel = new javax.swing.JPanel();
        dashBoardLabel = new javax.swing.JLabel();
        pendingToApproveAdsLabel = new javax.swing.JLabel();
        userApplicationLabel = new javax.swing.JLabel();
        reportLabel = new javax.swing.JLabel();
        adminAcountGenerationLabel = new javax.swing.JLabel();
        pendingToApproveAdsTittleLabel = new javax.swing.JLabel();
        logoutLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        txtField2 = new javax.swing.JTextField();
        txtField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        adminPanelBackGroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        adminPanelBackGroundPanel.setPreferredSize(new java.awt.Dimension(1024, 700));

        redPanelBackGroundPanel.setBackground(new java.awt.Color(255, 0, 51));

        dashBoardLabel.setBackground(new java.awt.Color(255, 0, 51));
        dashBoardLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dashBoardLabel.setForeground(new java.awt.Color(255, 255, 255));
        dashBoardLabel.setText("Dashboard");
        dashBoardLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashBoardLabel.setOpaque(true);
        dashBoardLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashBoardLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashBoardLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashBoardLabelMouseExited(evt);
            }
        });

        pendingToApproveAdsLabel.setBackground(new java.awt.Color(255, 0, 51));
        pendingToApproveAdsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pendingToApproveAdsLabel.setForeground(new java.awt.Color(255, 255, 255));
        pendingToApproveAdsLabel.setText("Pending to Approve Ads");
        pendingToApproveAdsLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pendingToApproveAdsLabel.setOpaque(true);
        pendingToApproveAdsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pendingToApproveAdsLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pendingToApproveAdsLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pendingToApproveAdsLabelMouseExited(evt);
            }
        });

        userApplicationLabel.setBackground(new java.awt.Color(255, 0, 51));
        userApplicationLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        userApplicationLabel.setForeground(new java.awt.Color(255, 255, 255));
        userApplicationLabel.setText("User Application");
        userApplicationLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userApplicationLabel.setOpaque(true);
        userApplicationLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userApplicationLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userApplicationLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userApplicationLabelMouseExited(evt);
            }
        });

        reportLabel.setBackground(new java.awt.Color(255, 0, 51));
        reportLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        reportLabel.setForeground(new java.awt.Color(255, 255, 255));
        reportLabel.setText("Report");
        reportLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportLabel.setOpaque(true);
        reportLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportLabelMouseExited(evt);
            }
        });

        adminAcountGenerationLabel.setBackground(new java.awt.Color(255, 0, 51));
        adminAcountGenerationLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        adminAcountGenerationLabel.setForeground(new java.awt.Color(255, 255, 255));
        adminAcountGenerationLabel.setText("Admin Account Generation");
        adminAcountGenerationLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adminAcountGenerationLabel.setOpaque(true);
        adminAcountGenerationLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminAcountGenerationLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                adminAcountGenerationLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                adminAcountGenerationLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout redPanelBackGroundPanelLayout = new javax.swing.GroupLayout(redPanelBackGroundPanel);
        redPanelBackGroundPanel.setLayout(redPanelBackGroundPanelLayout);
        redPanelBackGroundPanelLayout.setHorizontalGroup(
            redPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redPanelBackGroundPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(redPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(redPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(userApplicationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pendingToApproveAdsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                        .addComponent(dashBoardLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(adminAcountGenerationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        redPanelBackGroundPanelLayout.setVerticalGroup(
            redPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redPanelBackGroundPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(dashBoardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(userApplicationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(adminAcountGenerationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(pendingToApproveAdsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(reportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 346, Short.MAX_VALUE))
        );

        pendingToApproveAdsTittleLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        pendingToApproveAdsTittleLabel.setText("Admin Account Generation");

        logoutLabel.setBackground(new java.awt.Color(255, 255, 255));
        logoutLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        logoutLabel.setText("Logout");
        logoutLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutLabel.setOpaque(true);
        logoutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutLabelMouseExited(evt);
            }
        });

        passwordLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        passwordLabel.setText("New Admin Account Password  :");
        passwordLabel.setPreferredSize(new java.awt.Dimension(300, 20));

        userNameLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        userNameLabel.setText("New Admin Account Username :");
        userNameLabel.setPreferredSize(new java.awt.Dimension(280, 20));

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Generate");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adminPanelBackGroundPanelLayout = new javax.swing.GroupLayout(adminPanelBackGroundPanel);
        adminPanelBackGroundPanel.setLayout(adminPanelBackGroundPanelLayout);
        adminPanelBackGroundPanelLayout.setHorizontalGroup(
            adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelBackGroundPanelLayout.createSequentialGroup()
                .addComponent(redPanelBackGroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminPanelBackGroundPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(adminPanelBackGroundPanelLayout.createSequentialGroup()
                                .addComponent(pendingToApproveAdsTittleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                                .addComponent(logoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(adminPanelBackGroundPanelLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtField1)
                                    .addComponent(txtField2, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelBackGroundPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(257, 257, 257))))
            .addGroup(adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(adminPanelBackGroundPanelLayout.createSequentialGroup()
                    .addGap(346, 346, 346)
                    .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(368, Short.MAX_VALUE)))
        );
        adminPanelBackGroundPanelLayout.setVerticalGroup(
            adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(redPanelBackGroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(adminPanelBackGroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pendingToApproveAdsTittleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109)
                .addComponent(txtField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtField2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(adminPanelBackGroundPanelLayout.createSequentialGroup()
                    .addGap(177, 177, 177)
                    .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(563, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminPanelBackGroundPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminPanelBackGroundPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        pack();
    }

	    // the method that use to read user file
        private void readUserFile(String folderPath) throws FileNotFoundException, IOException{  
        File folder = new File(folderPath);
        File [] files = folder.listFiles();
        for(int i = 0; i < files.length;i++){
           if(files[i].isDirectory()){
  
             readUserFile(folderPath + "/" + files[i].getName());
           }else{
               if(files[i].getName().equals("accountInfo.txt")) {
                   String path = folderPath + "/" + files[i].getName();
                   Scanner s = new Scanner(new File(path));
                   ArrayList<String> list = new ArrayList<String> ();
        
                   while(s.hasNextLine())
                        list.add(s.nextLine());
                   int tempInt = Integer.valueOf(list.get(0));
       
                   userInfo.add(new User(tempInt, list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6), list.get(7)));
               }    
        }
    }
    }
    
    // the method that use to read property file
    private void readPropertyFile(String folderPath) throws FileNotFoundException, IOException{  
        File folder = new File(folderPath);
        File [] files = folder.listFiles();
        for(int i = 0; i < files.length;i++){
           if(files[i].isDirectory() && !(files[i].getName().equals("propertyPics"))){
               readPropertyFile(folderPath + "/" + files[i].getName());
           }else{
               if(files[i].getName().equals("propertyInfo.txt")) {
                   String path = folderPath + "/" + files[i].getName();
                   Scanner s = new Scanner(new File(path));
                   ArrayList<String> list = new ArrayList<String> ();
                   String path2 = folderPath + "/propertyPics";
                   File picFolder = new File(path2);
                   File [] picFiles = picFolder.listFiles();
                   String [] picPath = new String[picFiles.length];
                   for(int x = 0;x < picFiles.length;x++){
                       picPath[x] = picFiles[x].getPath();
                   }
        
                   while(s.hasNextLine())
                        list.add(s.nextLine());
                   int tempPropertyID = Integer.valueOf(list.get(0));
                   double tempPrice = Double.valueOf(list.get(2));
                   int tempSize = Integer.valueOf(list.get(3));
                   int tempBedRoomsNum = Integer.valueOf(list.get(6));
                   int tempBathRoomsNum = Integer.valueOf(list.get(7));
                   Address tempAddress = new Address(list.get(4),list.get(5));
                   String [] tempFacilities = list.get(12).split("\\|");
                   String [] tempFeatures = list.get(13).split("\\|");

                   propertyInfo.add(new Property(tempPropertyID, list.get(1), tempPrice, 
                           tempSize, picPath,tempAddress, tempBedRoomsNum, tempBathRoomsNum,
                           list.get(8),list.get(9),list.get(10),list.get(11),tempFacilities,
                           tempFeatures,list.get(14),list.get(15),list.get(16)));
               }    
        }
    }
    }
    
    // the method that use to save user info into their own txt file
    private void saveUserFile(String folderPath,String directoryName) throws FileNotFoundException{
        File folder = new File(folderPath);
        File [] files = folder.listFiles();
        for(int i = 0; i < files.length;i++){
           if(files[i].isDirectory()){
               saveUserFile(folderPath + "/" + files[i].getName(),files[i].getName());
           }else{
               if(files[i].getName().equals("accountInfo.txt")) {
 
                   for(int x = 0; x < userInfo.size();x++){
                       if(userInfo.get(x).getUserName().equals(directoryName)){
                           PrintWriter writer = new PrintWriter(folderPath + "/" + files[i].getName());
                           writer.println(userInfo.get(x).getUserID());
                           writer.println(userInfo.get(x).getUserName());
                           writer.println(userInfo.get(x).getPassword());
                           writer.println(userInfo.get(x).getFullName());
                           writer.println(userInfo.get(x).getContact());
                           writer.println(userInfo.get(x).getEmail());
                           writer.println(userInfo.get(x).getRole());
                           writer.println(userInfo.get(x).getStatus());
                           
                           writer.close();
                       }
                   }
               }    
           }
        } 
    }
	
	//the file use to update LastID.txt
	private void saveLastIDFile(String folderPath,int userID) throws FileNotFoundException{
        File folder = new File(folderPath);
        File [] files = folder.listFiles();
        for(int i = 0; i < files.length;i++){
           if(files[i].isDirectory()){
               saveLastIDFile(folderPath + "/" + files[i].getName(),userID);
           }else{
               if(files[i].getName().equals("LastID.txt")) {
 
                           PrintWriter writer = new PrintWriter(folderPath + "/" + files[i].getName());
                           writer.println(userID);
 
                           writer.close();
               }    
           }
        } 
    }
	
    
	// all the mouse enter, mouse exit, and mouse event is for all the the label to change color so the user will know when they reach specific panel
    private void dashBoardLabelMouseEntered(java.awt.event.MouseEvent evt) {
        dashBoardLabel.setBackground(new Color(204,0,0));
    }

    private void userApplicationLabelMouseEntered(java.awt.event.MouseEvent evt) {
        userApplicationLabel.setBackground(new Color(204,0,0));
    }

    private void userApplicationLabelMouseExited(java.awt.event.MouseEvent evt) {
        userApplicationLabel.setBackground(new Color(255,0,51));
    }

    private void pendingToApproveAdsLabelMouseEntered(java.awt.event.MouseEvent evt) {
        pendingToApproveAdsLabel.setBackground(new Color(204,0,0));
    }

    private void pendingToApproveAdsLabelMouseExited(java.awt.event.MouseEvent evt) {
        pendingToApproveAdsLabel.setBackground(new Color(255,0,51));
    }

    private void reportLabelMouseEntered(java.awt.event.MouseEvent evt) {
        reportLabel.setBackground(new Color(204,0,0));
    }

    private void reportLabelMouseExited(java.awt.event.MouseEvent evt) {
        reportLabel.setBackground(new Color(255,0,51));
    }

    private void dashBoardLabelMouseExited(java.awt.event.MouseEvent evt) {
        dashBoardLabel.setBackground(new Color(255,0,51));
    }

    private void logoutLabelMouseEntered(java.awt.event.MouseEvent evt) {
        logoutLabel.setBackground(new Color(204,204,204));
    }

    private void logoutLabelMouseExited(java.awt.event.MouseEvent evt) {
        logoutLabel.setBackground(new Color(255,255,255));
    }
	
	private void adminAcountGenerationLabelMouseEntered(java.awt.event.MouseEvent evt) {
        adminAcountGenerationLabel.setBackground(new Color(204,0,0));
    }

    private void adminAcountGenerationLabelMouseExited(java.awt.event.MouseEvent evt) {
        adminAcountGenerationLabel.setBackground(new Color(255,0,51));
    }

    // for admin to logout of the system
    private void logoutLabelMouseClicked(java.awt.event.MouseEvent evt) {
        int option = JOptionPane.showConfirmDialog(this,"Do you want to logout ?","Confirm",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        if(option == JOptionPane.YES_OPTION){
			this.setVisible(false);	
			SystemController controller = new SystemController(propertyInfo, MyJFrame.getMyJFrame());
			MyJFrame.getMyJFrame().setVisible(true);
			controller.initLoginPage();
        }
    }
    
	// the switch between frame 
    private void dashBoardLabelMouseClicked(java.awt.event.MouseEvent evt) {
        new AdminDashboardFrame().setVisible(true);
        this.setVisible(false);
    }

    private void userApplicationLabelMouseClicked(java.awt.event.MouseEvent evt) {
        new UserApplicationFrame().setVisible(true);
        this.setVisible(false);
    }

    private void pendingToApproveAdsLabelMouseClicked(java.awt.event.MouseEvent evt) {
        new PropertyAdsFrame().setVisible(true);
        this.setVisible(false);
    }

    private void reportLabelMouseClicked(java.awt.event.MouseEvent evt) {
        SystemController controller = new SystemController(propertyInfo, MyJFrame.getMyJFrame());
		MyJFrame.getMyJFrame().setVisible(true);
        MyJFrame.getMyJFrame().setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		controller.initHomePage();
		controller.initController();
		controller.getView().getPropertyManagerHomePage().getMenuIcon().setVisible(false);
    }
    
    private void adminAcountGenerationLabelMouseClicked(java.awt.event.MouseEvent evt) {
        new AdminAccountGenerateFrame().setVisible(true);
        this.setVisible(false);
    }

   
    // the method that use to generate new admin account
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        boolean textFieldInput = false;
        JFrame f=new JFrame();
        if(txtField1.getText().equals("") || txtField2.getText().equals("")){
            JOptionPane.showMessageDialog(f,"Your input is empty,please insert again!");
            textFieldInput = true;
        }
        
        if(textFieldInput == false){
            boolean same = false;
        for(int i = 0; i < userInfo.size();i++){
            if(userInfo.get(i).getUserName().equals(txtField1.getText())){
                same = true;
                i = userInfo.size();
            }
        }
        if(same == false){
			int newID = userInfo.size() + 1;
            User temp = new User(newID,txtField1.getText(),txtField2.getText(),"None","None","None","Admin","Approved");
            String path = "System/Admin/" + "/" + temp.getUserName();
            File folderForNewAdmin = new File(path);
            folderForNewAdmin.mkdir();
            path = path + "/" + "accountInfo.txt";
            File txtFileForNewAdmin = new File(path);
                try {
                    txtFileForNewAdmin.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(AdminAccountGenerateFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            userInfo.add(temp);
			
            String message = "Admin account " +txtField1.getText() +" is generated and added into the system";
            JOptionPane.showMessageDialog(f,message); 
            try {
            saveUserFile("System/","");
			saveLastIDFile("System/",newID);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else if(same){
            String message =  txtField1.getText() +" is used by other user please reinsert a new username";
            JOptionPane.showMessageDialog(f,message); 
        }
        }
        txtField1.setText("");
        txtField2.setText("");
	}
    // the main function that use to call this class
    // public static void main(String args[]) { 

    //     try {
    //         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    //             if ("Nimbus".equals(info.getName())) {
    //                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
    //                 break;
    //             }
    //         }
    //     } catch (ClassNotFoundException ex) {
    //         java.util.logging.Logger.getLogger(AdminAccountGenerateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (InstantiationException ex) {
    //         java.util.logging.Logger.getLogger(AdminAccountGenerateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (IllegalAccessException ex) {
    //         java.util.logging.Logger.getLogger(AdminAccountGenerateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //         java.util.logging.Logger.getLogger(AdminAccountGenerateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }

    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             new AdminAccountGenerateFrame().setVisible(true);
    //         }
    //     });
    // }

}
