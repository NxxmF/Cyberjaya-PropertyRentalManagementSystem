import java.awt.Color;
import java.awt.Image;
import java.awt.print.PrinterException;
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
// View & Controller Class for admin system to approve property advertise by property agent/property owner
// Generated using Eclipse
public class PropertyAdsFrame extends javax.swing.JFrame {

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
    private javax.swing.JLabel pendingToApproveAdsTittleLabel;
    private javax.swing.JTable propertyAdsTable;
    private javax.swing.JPanel redPanelBackGroundPanel;
    private javax.swing.JLabel reportLabel;
    private javax.swing.JLabel userApplicationLabel;
    private javax.swing.JButton viewDetailsButton;
    private javax.swing.JButton viewTable;
    
	int selectedRowPropertyID = -1;         //to store the propertyif of the row that is selected by the user in pending to approve propety ads table
    ArrayList<Property> propertyInfo = new ArrayList<Property>();   // to store all property info in arrayList
	
    public PropertyAdsFrame() {
        initComponents();
        //scaleIconImage();
        this.setLocationRelativeTo(null);
        try {
                readPropertyFile("System/");       // use to read all property info into an arrayList
            } catch (IOException ex) {
                Logger.getLogger(UserApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }


    // this method is mainly use for the design of the frame and store the action that will be execute
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
        jScrollPane1 = new javax.swing.JScrollPane();
        propertyAdsTable = new javax.swing.JTable();
        viewDetailsButton = new javax.swing.JButton();
        approveAllButton = new javax.swing.JButton();
        viewTable = new javax.swing.JButton();
        declineButton1 = new javax.swing.JButton();
        approveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        adminPanelBackGroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        adminPanelBackGroundPanel.setPreferredSize(new java.awt.Dimension(1024, 700));

        redPanelBackGroundPanel.setBackground(new java.awt.Color(255, 0, 51));

        dashBoardLabel.setBackground(new java.awt.Color(255, 0, 51));
        dashBoardLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); 
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
        pendingToApproveAdsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); 
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
        userApplicationLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
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
        reportLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
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
        adminAcountGenerationLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
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
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pendingToApproveAdsTittleLabel.setFont(new java.awt.Font("Tahoma", 1, 36));
        pendingToApproveAdsTittleLabel.setText("Pending to Approve Ads");

        logoutLabel.setBackground(new java.awt.Color(255, 255, 255));
        logoutLabel.setFont(new java.awt.Font("Tahoma", 1, 24));
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

        propertyAdsTable.setFont(new java.awt.Font("Tahoma", 1, 12));
        propertyAdsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        propertyAdsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                propertyAdsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(propertyAdsTable);

        viewDetailsButton.setBackground(new java.awt.Color(0, 255, 102));
        viewDetailsButton.setFont(new java.awt.Font("Tahoma", 1, 16));
        viewDetailsButton.setForeground(new java.awt.Color(255, 255, 255));
        viewDetailsButton.setText("View Details");
        viewDetailsButton.setBorderPainted(false);
        viewDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDetailsButtonActionPerformed(evt);
            }
        });

        approveAllButton.setBackground(new java.awt.Color(0, 153, 204));
        approveAllButton.setFont(new java.awt.Font("Tahoma", 1, 16));
        approveAllButton.setForeground(new java.awt.Color(255, 255, 255));
        approveAllButton.setText("Approve All");
        approveAllButton.setBorderPainted(false);
        approveAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveAllButtonActionPerformed(evt);
            }
        });

        viewTable.setBackground(new java.awt.Color(255, 0, 255));
        viewTable.setFont(new java.awt.Font("Tahoma", 1, 16));
        viewTable.setForeground(new java.awt.Color(255, 255, 255));
        viewTable.setText("View List");
        viewTable.setBorderPainted(false);
        viewTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTableActionPerformed(evt);
            }
        });

        declineButton1.setBackground(new java.awt.Color(255, 51, 51));
        declineButton1.setFont(new java.awt.Font("Tahoma", 1, 16));
        declineButton1.setForeground(new java.awt.Color(255, 255, 255));
        declineButton1.setText("Decline");
        declineButton1.setBorderPainted(false);
        declineButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declineButton1ActionPerformed(evt);
            }
        });

        approveButton.setBackground(new java.awt.Color(0, 204, 102));
        approveButton.setFont(new java.awt.Font("Tahoma", 1, 16));
        approveButton.setForeground(new java.awt.Color(255, 255, 255));
        approveButton.setText("Approve");
        approveButton.setBorderPainted(false);
        approveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveButtonActionPerformed(evt);
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
                        .addComponent(viewDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(approveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(declineButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(approveAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelBackGroundPanelLayout.createSequentialGroup()
                        .addComponent(pendingToApproveAdsTittleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                        .addComponent(logoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelBackGroundPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(viewTable, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        adminPanelBackGroundPanelLayout.setVerticalGroup(
            adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(redPanelBackGroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(adminPanelBackGroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pendingToApproveAdsTittleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(viewTable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminPanelBackGroundPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                        .addGap(176, 176, 176))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelBackGroundPanelLayout.createSequentialGroup()
                        .addGap(544, 544, 544)
                        .addGroup(adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(declineButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(approveAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(approveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        
                   while(s.hasNextLine()){
                        list.add(s.nextLine());}
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
    
	
	// the method that use to save property info into their own txt file
   private void savePropertyFile(String folderPath,String directoryName) throws FileNotFoundException{
        File folder = new File(folderPath);
        File [] files = folder.listFiles();
        for(int i = 0; i < files.length;i++){
           if(files[i].isDirectory()){
               savePropertyFile(folderPath + "/" + files[i].getName(),files[i].getName());
           }else{
               if(files[i].getName().equals("propertyInfo.txt")) {
 
                   for(int x = 0; x < propertyInfo.size();x++){
                       if(propertyInfo.get(x).getPropertyID() == Integer.valueOf(directoryName)){
                           PrintWriter writer = new PrintWriter(folderPath + "\\" + files[i].getName());
                           writer.println(propertyInfo.get(x).getPropertyID());
                           writer.println(propertyInfo.get(x).getPropertyName());
                           writer.println(propertyInfo.get(x).getPrice());
                           writer.println(propertyInfo.get(x).getSize());
                           writer.println(propertyInfo.get(x).getPropertyAddress().getProject());
                           writer.println(propertyInfo.get(x).getPropertyAddress().getFullAddress());
                           writer.println(propertyInfo.get(x).getBedRoomsNum());
                           writer.println(propertyInfo.get(x).getBathRoomsNum());
                           writer.println(propertyInfo.get(x).getFurnishing());
                           writer.println(propertyInfo.get(x).getPropertyType());
                           writer.println(propertyInfo.get(x).getPropertyActivationStatus());
                           writer.println(propertyInfo.get(x).getPropertyApprovalStatus());
                           String facility = "";
                           for(int y = 0; y < propertyInfo.get(x).getAvailableFacilities().length;y++){
                               if(y == propertyInfo.get(x).getAvailableFacilities().length - 1){
                                   facility = facility + propertyInfo.get(x).getAvailableFacilities()[y];
                               }else{
                                   facility = facility + propertyInfo.get(x).getAvailableFacilities()[y] + "|";
                               }
                           }
                           writer.println(facility);
                           String feature = "";
                           for(int y = 0; y < propertyInfo.get(x).getAvailableFeatures().length;y++){
                               if(y == propertyInfo.get(x).getAvailableFeatures().length - 1){
                                   feature = feature + propertyInfo.get(x).getAvailableFeatures()[y];
                               }else{
                                   feature = feature + propertyInfo.get(x).getAvailableFeatures()[y] + "|";
                               }
                           }
                           writer.println(feature);
                           writer.println(propertyInfo.get(x).getDescription());
                           writer.println(propertyInfo.get(x).getTenantName());
                           writer.println(propertyInfo.get(x).getAgentName());
                           
                           
                           writer.close();
                       }
                   }
               }    
           }
        } 
    }
    
    
	// all the mouse enter and mouse exit mouse event is for all the the label to change color so the user will know when they reach specific panel that have a function
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

    // for user to logout of the system
    private void logoutLabelMouseClicked(java.awt.event.MouseEvent evt) {
        int option = JOptionPane.showConfirmDialog(this,"Do you want to logout ?","Confirm",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        if(option == JOptionPane.YES_OPTION){
			this.setVisible(false);
			SystemController controller = new SystemController(propertyInfo, MyJFrame.getMyJFrame());
			MyJFrame.getMyJFrame().setVisible(true);
			controller.initLoginPage();
        }
    }

	// Switch between frame/nav button from admin system
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
    
	// the method that use to create the property ads table
    private void viewTableActionPerformed(java.awt.event.ActionEvent evt) {
            String[] columsName = {"Property ID","Property Name","Agent ID","Property Status"};
            
            DefaultTableModel model = (DefaultTableModel)propertyAdsTable.getModel();
            model.setRowCount(0);
            model.setColumnIdentifiers(columsName);
        
        for(int i = 0; i < propertyInfo.size() ; i ++){
            Object[] data = new Object[4];
            data[0] = propertyInfo.get(i).getPropertyID();
            data[1] = propertyInfo.get(i).getPropertyName();
            data[2] = propertyInfo.get(i).getAgentName();
            data[3] = propertyInfo.get(i).getPropertyApprovalStatus();
            if(data[3].equals("Pending")){
                model.addRow(data);
                }
        }
        
        
    }

    // to set the selectedRowPropertyID to propertyID that the row of the user selected
    private void propertyAdsTableMouseClicked(java.awt.event.MouseEvent evt) {
        DefaultTableModel modelTemp = (DefaultTableModel)propertyAdsTable.getModel();
        int propertyID = (int) modelTemp.getValueAt(propertyAdsTable.getSelectedRow(),0);
        
        selectedRowPropertyID = propertyID;
    }

    // if the user wan to view the details of the pending to approve ads ,the user need to press this button so the table will be prited
    private void viewDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(selectedRowPropertyID != -1){
        boolean found = false;
        int i = 0;
        Property tempProperty = null;
        while(found == false){
            if(propertyInfo.get(i).getPropertyID() == selectedRowPropertyID){
                tempProperty = propertyInfo.get(i);
                found = true;
            }
            i++;
        }
        try {
            new PropertyDetailsFrame(tempProperty).setVisible(true);
        } catch (PrinterException ex) {
            Logger.getLogger(PropertyAdsFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        selectedRowPropertyID = -1;
        }
    }

    // the button for user to decline the selected row property ads 
    private void declineButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if(selectedRowPropertyID != -1){
        boolean found = false;
        int i = 0;
        while(found == false){
            if(propertyInfo.get(i).getPropertyID() == selectedRowPropertyID){
                propertyInfo.get(i).setPropertyApprovalStatus("Declined");
                found = true;
            }
            i++;
        }
        try {
            savePropertyFile("System/","");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JFrame f=new JFrame();
        JOptionPane.showMessageDialog(f,"Successfully Declined Selected Property Ads..");
        selectedRowPropertyID = -1;
        }
    }


    // the button for user to approve all property ads 
    private void approveAllButtonActionPerformed(java.awt.event.ActionEvent evt) {
        for(int i = 0;i < propertyInfo.size();i++){
                propertyInfo.get(i).setPropertyApprovalStatus("Approved");
                propertyInfo.get(i).setPropertyActivationStatus("Activated");
        }

        try {
            savePropertyFile("System/","");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFrame f=new JFrame();
        JOptionPane.showMessageDialog(f,"Successfully Approved All Property Ads.");
       
    }

    // the button for user to approve only the selected row property ads 
    private void approveButtonActionPerformed(java.awt.event.ActionEvent evt) {
         if(selectedRowPropertyID != -1){
        boolean found = false;
        int i = 0;
        while(found == false){
            if(propertyInfo.get(i).getPropertyID() == selectedRowPropertyID){
                propertyInfo.get(i).setPropertyApprovalStatus("Approved");
				propertyInfo.get(i).setPropertyActivationStatus("Activated");
                found = true;
            }
            i++;
        }
        try {
            savePropertyFile("System/","");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JFrame f=new JFrame();
        if(found)
        JOptionPane.showMessageDialog(f,"Successfully Approved Selected Property Ads.");
        selectedRowPropertyID = -1;
         }
    }//GEN-LAST:event_approveButtonActionPerformed

    // the main function this frame class
    // public static void main(String args[]) {
    //     try {
    //         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    //             if ("Nimbus".equals(info.getName())) {
    //                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
    //                 break;
    //             }
    //         }
    //     } catch (ClassNotFoundException ex) {
    //         java.util.logging.Logger.getLogger(PropertyAdsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (InstantiationException ex) {
    //         java.util.logging.Logger.getLogger(PropertyAdsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (IllegalAccessException ex) {
    //         java.util.logging.Logger.getLogger(PropertyAdsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //         java.util.logging.Logger.getLogger(PropertyAdsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }

    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             new PropertyAdsFrame().setVisible(true);
    //         }
    //     });
    // }

}
