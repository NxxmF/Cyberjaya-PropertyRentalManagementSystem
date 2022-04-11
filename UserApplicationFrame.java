import java.awt.Color;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

// Naim Farhat Bin Mahmad Zulhasnan (1191101830)
// Class for admin system to approve user application in the system
public class UserApplicationFrame extends javax.swing.JFrame {

    //All the variable that use in the frame
    private javax.swing.JLabel adminAcountGenerationLabel;
    private javax.swing.JPanel adminPanelBackGroundPanel;
    private javax.swing.JButton approveAllButton;
    private javax.swing.JButton approveButton;
    private javax.swing.JLabel dashBoardLabel;
    private javax.swing.JButton declineButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JLabel pendingToApproveAdsLabel;
    private javax.swing.JPanel redPanelBackGroundPanel;
    private javax.swing.JLabel reportLabel;
    private javax.swing.JLabel userApplicationLabel;
    private javax.swing.JTable userApplicationTable;
    private javax.swing.JLabel userApplicationTitleLabel;
    private javax.swing.JButton viewTable;
	
    int selectedRowUserID = -1;             //to store the property of the row that is selected by the user in pending to approve propety ads table
    ArrayList<User> userInfo = new ArrayList<User>();     
	ArrayList<Property> propertyInfo = new ArrayList<Property>();    // to store all property info in arrayList
	
	
    public UserApplicationFrame() {
        initComponents();
        //scaleIconImage();
        this.setLocationRelativeTo(null);
        try {                           
                readUserFile("System/");       // to read all the user info into an arrayList
            } catch (IOException ex) {
                Logger.getLogger(UserApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    // this method is mainly use for the design of the components in the user approved application frame
    private void initComponents() {

        adminPanelBackGroundPanel = new javax.swing.JPanel();
        redPanelBackGroundPanel = new javax.swing.JPanel();
        dashBoardLabel = new javax.swing.JLabel();
        pendingToApproveAdsLabel = new javax.swing.JLabel();
        userApplicationLabel = new javax.swing.JLabel();
        reportLabel = new javax.swing.JLabel();
        adminAcountGenerationLabel = new javax.swing.JLabel();
        userApplicationTitleLabel = new javax.swing.JLabel();
        logoutLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userApplicationTable = new javax.swing.JTable();
        approveButton = new javax.swing.JButton();
        approveAllButton = new javax.swing.JButton();
        viewTable = new javax.swing.JButton();
        declineButton1 = new javax.swing.JButton();

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
                    .addComponent(pendingToApproveAdsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(redPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(userApplicationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                        .addComponent(dashBoardLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reportLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(adminAcountGenerationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        redPanelBackGroundPanelLayout.setVerticalGroup(
            redPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redPanelBackGroundPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(dashBoardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(userApplicationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(adminAcountGenerationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pendingToApproveAdsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(reportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        userApplicationTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        userApplicationTitleLabel.setText("User Application");

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

        userApplicationTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        userApplicationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        userApplicationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userApplicationTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userApplicationTable);

        approveButton.setBackground(new java.awt.Color(0, 204, 102));
        approveButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        approveButton.setForeground(new java.awt.Color(255, 255, 255));
        approveButton.setText("Approve");
        approveButton.setBorderPainted(false);
        approveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveButtonActionPerformed(evt);
            }
        });

        approveAllButton.setBackground(new java.awt.Color(0, 153, 204));
        approveAllButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        approveAllButton.setForeground(new java.awt.Color(255, 255, 255));
        approveAllButton.setText("Approve All");
        approveAllButton.setBorderPainted(false);
        approveAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveAllButtonActionPerformed(evt);
            }
        });

        viewTable.setBackground(new java.awt.Color(255, 0, 255));
        viewTable.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        viewTable.setForeground(new java.awt.Color(255, 255, 255));
        viewTable.setText("View List");
        viewTable.setBorderPainted(false);
        viewTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTableActionPerformed(evt);
            }
        });

        declineButton1.setBackground(new java.awt.Color(255, 51, 51));
        declineButton1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        declineButton1.setForeground(new java.awt.Color(255, 255, 255));
        declineButton1.setText("Decline");
        declineButton1.setBorderPainted(false);
        declineButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declineButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adminPanelBackGroundPanelLayout = new javax.swing.GroupLayout(adminPanelBackGroundPanel);
        adminPanelBackGroundPanel.setLayout(adminPanelBackGroundPanelLayout);
        adminPanelBackGroundPanelLayout.setHorizontalGroup(
            adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelBackGroundPanelLayout.createSequentialGroup()
                .addComponent(redPanelBackGroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminPanelBackGroundPanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(approveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addComponent(declineButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(approveAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelBackGroundPanelLayout.createSequentialGroup()
                        .addComponent(userApplicationTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelBackGroundPanelLayout.createSequentialGroup()
                        .addGroup(adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelBackGroundPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(viewTable, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        adminPanelBackGroundPanelLayout.setVerticalGroup(
            adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(redPanelBackGroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(adminPanelBackGroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userApplicationTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(viewTable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminPanelBackGroundPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                        .addGap(176, 176, 176))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelBackGroundPanelLayout.createSequentialGroup()
                        .addGap(544, 544, 544)
                        .addGroup(adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(approveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(declineButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(approveAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81))))
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
    }// </editor-fold>//GEN-END:initComponents

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
                           PrintWriter writer = new PrintWriter(folderPath + "\\" + files[i].getName());
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
    
    
	// all the mouse enter and mouse exit mouse event is for all the the label to change color so the user will know when they reach specific panel
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

	// the switch between frame 
    private void logoutLabelMouseClicked(java.awt.event.MouseEvent evt) {
        int option = JOptionPane.showConfirmDialog(this,"Do you want to logout ?","Confirm",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        if(option == JOptionPane.YES_OPTION){
			this.setVisible(false);
			SystemController controller = new SystemController(propertyInfo, MyJFrame.getMyJFrame());
			MyJFrame.getMyJFrame().setVisible(true);
			controller.initLoginPage();
        }
    }

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
	
	private void adminAcountGenerationLabelMouseClicked(java.awt.event.MouseEvent evt) {
        new AdminAccountGenerateFrame().setVisible(true);
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

    // the button for admin to approve only the selected row user application
    private void approveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(selectedRowUserID != -1){
        boolean found = false;
        int i = 0;
        while(found == false){
            if(userInfo.get(i).getUserID() == selectedRowUserID){
                userInfo.get(i).setStatus("Approved");
                found = true;
            }
            i++;
        }
        try {
            saveUserFile("System/","");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JFrame f=new JFrame();
        JOptionPane.showMessageDialog(f,"Successfully Approved Selected Application.");  
        selectedRowUserID = -1;}
    }

   // the button for admin to approve all the user applications
    private void approveAllButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int i = 0;
        while(i < userInfo.size()){
            if(userInfo.get(i).getStatus().contains("Pending")){
                userInfo.get(i).setStatus("Approved");
            }
            i++;
        }
        try {
            saveUserFile("System/","");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFrame f=new JFrame();
        JOptionPane.showMessageDialog(f,"Successfully Approved All Applications.");
    }
    
	// the method that use to create the user application table
    private void viewTableActionPerformed(java.awt.event.ActionEvent evt) { 
            String[] columsName = {"User ID","Username","Full Name","Contact","Email","Role","Account Status"};
            
            DefaultTableModel model = (DefaultTableModel)userApplicationTable.getModel();
            model.setRowCount(0);
            model.setColumnIdentifiers(columsName);
            
        
        for(int i = 0; i < userInfo.size() ; i ++){
            Object[] data = new Object[7];
            data[0] = userInfo.get(i).getUserID();
            data[1] = userInfo.get(i).getUserName();
            data[2] = userInfo.get(i).getFullName();
            data[3] = userInfo.get(i).getContact();
            data[4] = userInfo.get(i).getEmail();
            data[5] = userInfo.get(i).getRole();
            data[6] = userInfo.get(i).getStatus();
            if(data[6].equals("Pending")){
                model.addRow(data);
                }
        }
        
    }

    // the button for admin to decline only the selected row user application
    private void declineButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if(selectedRowUserID != -1){
        boolean found = false;
        int i = 0;
        while(found == false){
            if(userInfo.get(i).getUserID() == selectedRowUserID){
                userInfo.get(i).setStatus("Declined");
                found = true;
            }
            i++;
        }
        try {
            saveUserFile("System/","");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFrame f=new JFrame();
        JOptionPane.showMessageDialog(f,"Successfully Declined Selected Application.");  
        selectedRowUserID = -1;
        }
    }

   // to set the selectedRowUserID to userID that the row of the admin selected
    private void userApplicationTableMouseClicked(java.awt.event.MouseEvent evt) {
        DefaultTableModel modelTemp = (DefaultTableModel)userApplicationTable.getModel();
        int userID = (int) modelTemp.getValueAt(userApplicationTable.getSelectedRow(),0);
        
        selectedRowUserID = userID;
    }

    // the main function to call this frame class
    // public static void main(String args[]) {
    //     try {
    //         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    //             if ("Nimbus".equals(info.getName())) {
    //                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
    //                 break;
    //             }
    //         }
    //     } catch (ClassNotFoundException ex) {
    //         java.util.logging.Logger.getLogger(UserApplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (InstantiationException ex) {
    //         java.util.logging.Logger.getLogger(UserApplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (IllegalAccessException ex) {
    //         java.util.logging.Logger.getLogger(UserApplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //         java.util.logging.Logger.getLogger(UserApplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }

    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             new UserApplicationFrame().setVisible(true);
    //         }
    //     });
    // }

}
