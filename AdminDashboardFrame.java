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
import javax.swing.JOptionPane;

// Naim Farhat Bin Mahmad Zulhasnan (1191101830)
// View class for the dashboard for admin system
// Generated using Eclipse
public class AdminDashboardFrame extends javax.swing.JFrame {

    //All the variable that use in the frame
    private javax.swing.JLabel adminAcountGenerationLabel;
    private javax.swing.JPanel adminPanelBackGroundPanel;
    private javax.swing.JLabel dashBoardLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JLabel pendingToApproveAdsLabel;
    private javax.swing.JPanel redPanelBackGroundPanel;
    private javax.swing.JLabel reportLabel;
    private javax.swing.JLabel totalPendingToApproveAdsBlueLabel;
    private javax.swing.JPanel totalPendingToApproveAdsBluePanel;
    private javax.swing.JLabel totalPendingToApproveAdsTopBlueLabel;
    private javax.swing.JPanel totalPendingToApproveAdsTopBluePanel;
    private javax.swing.JPanel totalUploadedAdsBluePanel;
    private javax.swing.JLabel totalUploadedAdsBluePanelLabel;
    private javax.swing.JLabel totalUploadedAdsTopBlueLabel;
    private javax.swing.JPanel totalUploadedAdsTopBluePanel;
    private javax.swing.JLabel totalUserApplicationBlueLabel;
    private javax.swing.JPanel totalUserApplicationBluePanel;
    private javax.swing.JPanel totalUserApplicationTopBluePanel;
    private javax.swing.JLabel totalUserApplicationTopLabel;
    private javax.swing.JLabel totalUserBlueLabel;
    private javax.swing.JPanel totalUserBluePanel;
    private javax.swing.JPanel totalUserTopBluePanel;
    private javax.swing.JLabel totalUserTopLabel;
    private javax.swing.JLabel userApplicationLabel1;
	
    ArrayList<User> userInfo = new ArrayList<User>();   // to store all user into an arrayList
	ArrayList<Property> propertyInfo = new ArrayList<Property>();  // to store all property info in arrayList
	
    public AdminDashboardFrame() {
        initComponents();
        //scaleIconImage();
        this.setLocationRelativeTo(null);
        try {                                       // use to read the property info and user info to an arrayList
                readPropertyFile("System/");
                readUserFile("System/");
            } catch (IOException ex) {
                Logger.getLogger(UserApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        calculateAdminPanelInfor();  // to get and calculate all the user and property info 
    }
	
	// Method use to get and calculate all the user and property info 
	private void calculateAdminPanelInfor(){
		int numOfUser = 0;
        for(int i = 0; i < userInfo.size();i++){         
            if(userInfo.get(i).getStatus().equals("Approved"))
                numOfUser++;
        }
        int numOfPendingToApproveUser = 0;
        for(int i = 0; i < userInfo.size();i++){
            if(userInfo.get(i).getStatus().equals("Pending"))
                numOfPendingToApproveUser++;
        }
        int numOfPropertyAds = 0;
        for(int i = 0; i < propertyInfo.size();i++){
            if(propertyInfo.get(i).getPropertyApprovalStatus().equals("Approved"))
                numOfPropertyAds++;
        }
        int numOfPendingToApprovePropertyAds = 0;
        for(int i = 0; i < propertyInfo.size();i++){
            if(propertyInfo.get(i).getPropertyApprovalStatus().equals("Pending"))
                numOfPendingToApprovePropertyAds++;
        }
        totalUserBlueLabel.setText(String.valueOf(numOfUser));
        totalUploadedAdsBluePanelLabel.setText(String.valueOf(numOfPropertyAds));
        totalUserApplicationBlueLabel.setText(String.valueOf(numOfPendingToApproveUser));
        totalPendingToApproveAdsBlueLabel.setText(String.valueOf(numOfPendingToApprovePropertyAds));
		
	}
    
    
	// Method that use to read user file
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
    
    
    // Method that use to save user info into their own txt file
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

    // Method that use to read property file
    private void readPropertyFile(String folderPath) throws FileNotFoundException, IOException{  
        File folder = new File("" + folderPath);
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
    
   // Method that use to save property info into their own txt file
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


    // this method is mainly use to design the component in this dashboard frame
    private void initComponents() {

        adminPanelBackGroundPanel = new javax.swing.JPanel();
        redPanelBackGroundPanel = new javax.swing.JPanel();
        dashBoardLabel = new javax.swing.JLabel();
        pendingToApproveAdsLabel = new javax.swing.JLabel();
        adminAcountGenerationLabel = new javax.swing.JLabel();
        reportLabel = new javax.swing.JLabel();
        userApplicationLabel1 = new javax.swing.JLabel();
        totalUserBluePanel = new javax.swing.JPanel();
        totalUserTopBluePanel = new javax.swing.JPanel();
        totalUserTopLabel = new javax.swing.JLabel();
        totalUserBlueLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        totalUploadedAdsBluePanel = new javax.swing.JPanel();
        totalUploadedAdsTopBluePanel = new javax.swing.JPanel();
        totalUploadedAdsTopBlueLabel = new javax.swing.JLabel();
        totalUploadedAdsBluePanelLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        totalPendingToApproveAdsBluePanel = new javax.swing.JPanel();
        totalPendingToApproveAdsTopBluePanel = new javax.swing.JPanel();
        totalPendingToApproveAdsTopBlueLabel = new javax.swing.JLabel();
        totalPendingToApproveAdsBlueLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        totalUserApplicationBluePanel = new javax.swing.JPanel();
        totalUserApplicationTopBluePanel = new javax.swing.JPanel();
        totalUserApplicationTopLabel = new javax.swing.JLabel();
        totalUserApplicationBlueLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        logoutLabel = new javax.swing.JLabel();

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

        userApplicationLabel1.setBackground(new java.awt.Color(255, 0, 51));
        userApplicationLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        userApplicationLabel1.setForeground(new java.awt.Color(255, 255, 255));
        userApplicationLabel1.setText("User Application");
        userApplicationLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userApplicationLabel1.setOpaque(true);
        userApplicationLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userApplicationLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userApplicationLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userApplicationLabel1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout redPanelBackGroundPanelLayout = new javax.swing.GroupLayout(redPanelBackGroundPanel);
        redPanelBackGroundPanel.setLayout(redPanelBackGroundPanelLayout);
        redPanelBackGroundPanelLayout.setHorizontalGroup(
            redPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redPanelBackGroundPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(redPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pendingToApproveAdsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dashBoardLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reportLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userApplicationLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminAcountGenerationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        redPanelBackGroundPanelLayout.setVerticalGroup(
            redPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redPanelBackGroundPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(dashBoardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(userApplicationLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(adminAcountGenerationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(pendingToApproveAdsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(reportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        totalUserBluePanel.setBackground(new java.awt.Color(0, 204, 255));
        totalUserBluePanel.setPreferredSize(new java.awt.Dimension(400, 250));

        totalUserTopBluePanel.setBackground(new java.awt.Color(0, 153, 255));
        totalUserTopBluePanel.setForeground(new java.awt.Color(51, 0, 153));
        totalUserTopBluePanel.setPreferredSize(new java.awt.Dimension(400, 80));

        totalUserTopLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        totalUserTopLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalUserTopLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalUserTopLabel.setText("Total User ");

        javax.swing.GroupLayout totalUserTopBluePanelLayout = new javax.swing.GroupLayout(totalUserTopBluePanel);
        totalUserTopBluePanel.setLayout(totalUserTopBluePanelLayout);
        totalUserTopBluePanelLayout.setHorizontalGroup(
            totalUserTopBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalUserTopBluePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalUserTopLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );
        totalUserTopBluePanelLayout.setVerticalGroup(
            totalUserTopBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalUserTopBluePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalUserTopLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        totalUserBlueLabel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        totalUserBlueLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalUserBlueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("*total approved user in the system");

        javax.swing.GroupLayout totalUserBluePanelLayout = new javax.swing.GroupLayout(totalUserBluePanel);
        totalUserBluePanel.setLayout(totalUserBluePanelLayout);
        totalUserBluePanelLayout.setHorizontalGroup(
            totalUserBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(totalUserTopBluePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addGroup(totalUserBluePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(totalUserBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalUserBlueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(totalUserBluePanelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        totalUserBluePanelLayout.setVerticalGroup(
            totalUserBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalUserBluePanelLayout.createSequentialGroup()
                .addComponent(totalUserTopBluePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalUserBlueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel7.setText("Dashboard");

        totalUploadedAdsBluePanel.setBackground(new java.awt.Color(0, 204, 255));
        totalUploadedAdsBluePanel.setPreferredSize(new java.awt.Dimension(400, 250));

        totalUploadedAdsTopBluePanel.setBackground(new java.awt.Color(0, 153, 255));
        totalUploadedAdsTopBluePanel.setForeground(new java.awt.Color(51, 0, 153));
        totalUploadedAdsTopBluePanel.setPreferredSize(new java.awt.Dimension(400, 80));

        totalUploadedAdsTopBlueLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        totalUploadedAdsTopBlueLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalUploadedAdsTopBlueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalUploadedAdsTopBlueLabel.setText("Total Uploaded Ads");

        javax.swing.GroupLayout totalUploadedAdsTopBluePanelLayout = new javax.swing.GroupLayout(totalUploadedAdsTopBluePanel);
        totalUploadedAdsTopBluePanel.setLayout(totalUploadedAdsTopBluePanelLayout);
        totalUploadedAdsTopBluePanelLayout.setHorizontalGroup(
            totalUploadedAdsTopBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalUploadedAdsTopBluePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalUploadedAdsTopBlueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );
        totalUploadedAdsTopBluePanelLayout.setVerticalGroup(
            totalUploadedAdsTopBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalUploadedAdsTopBluePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalUploadedAdsTopBlueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        totalUploadedAdsBluePanelLabel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        totalUploadedAdsBluePanelLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalUploadedAdsBluePanelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("*total uploaded property ads in the system");

        javax.swing.GroupLayout totalUploadedAdsBluePanelLayout = new javax.swing.GroupLayout(totalUploadedAdsBluePanel);
        totalUploadedAdsBluePanel.setLayout(totalUploadedAdsBluePanelLayout);
        totalUploadedAdsBluePanelLayout.setHorizontalGroup(
            totalUploadedAdsBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(totalUploadedAdsTopBluePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addGroup(totalUploadedAdsBluePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(totalUploadedAdsBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalUploadedAdsBluePanelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(totalUploadedAdsBluePanelLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        totalUploadedAdsBluePanelLayout.setVerticalGroup(
            totalUploadedAdsBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalUploadedAdsBluePanelLayout.createSequentialGroup()
                .addComponent(totalUploadedAdsTopBluePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalUploadedAdsBluePanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        totalPendingToApproveAdsBluePanel.setBackground(new java.awt.Color(0, 204, 255));
        totalPendingToApproveAdsBluePanel.setPreferredSize(new java.awt.Dimension(400, 250));

        totalPendingToApproveAdsTopBluePanel.setBackground(new java.awt.Color(0, 153, 255));
        totalPendingToApproveAdsTopBluePanel.setForeground(new java.awt.Color(51, 0, 153));
        totalPendingToApproveAdsTopBluePanel.setPreferredSize(new java.awt.Dimension(400, 80));

        totalPendingToApproveAdsTopBlueLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        totalPendingToApproveAdsTopBlueLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalPendingToApproveAdsTopBlueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalPendingToApproveAdsTopBlueLabel.setText("Total Pending to Approve Ads");

        javax.swing.GroupLayout totalPendingToApproveAdsTopBluePanelLayout = new javax.swing.GroupLayout(totalPendingToApproveAdsTopBluePanel);
        totalPendingToApproveAdsTopBluePanel.setLayout(totalPendingToApproveAdsTopBluePanelLayout);
        totalPendingToApproveAdsTopBluePanelLayout.setHorizontalGroup(
            totalPendingToApproveAdsTopBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalPendingToApproveAdsTopBluePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalPendingToApproveAdsTopBlueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );
        totalPendingToApproveAdsTopBluePanelLayout.setVerticalGroup(
            totalPendingToApproveAdsTopBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalPendingToApproveAdsTopBluePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalPendingToApproveAdsTopBlueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        totalPendingToApproveAdsBlueLabel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        totalPendingToApproveAdsBlueLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalPendingToApproveAdsBlueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("*total pending to approve property ads in the system");

        javax.swing.GroupLayout totalPendingToApproveAdsBluePanelLayout = new javax.swing.GroupLayout(totalPendingToApproveAdsBluePanel);
        totalPendingToApproveAdsBluePanel.setLayout(totalPendingToApproveAdsBluePanelLayout);
        totalPendingToApproveAdsBluePanelLayout.setHorizontalGroup(
            totalPendingToApproveAdsBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(totalPendingToApproveAdsTopBluePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addGroup(totalPendingToApproveAdsBluePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(totalPendingToApproveAdsBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(totalPendingToApproveAdsBluePanelLayout.createSequentialGroup()
                        .addComponent(totalPendingToApproveAdsBlueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        totalPendingToApproveAdsBluePanelLayout.setVerticalGroup(
            totalPendingToApproveAdsBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalPendingToApproveAdsBluePanelLayout.createSequentialGroup()
                .addComponent(totalPendingToApproveAdsTopBluePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalPendingToApproveAdsBlueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        totalUserApplicationBluePanel.setBackground(new java.awt.Color(0, 204, 255));
        totalUserApplicationBluePanel.setPreferredSize(new java.awt.Dimension(300, 250));

        totalUserApplicationTopBluePanel.setBackground(new java.awt.Color(0, 153, 255));
        totalUserApplicationTopBluePanel.setForeground(new java.awt.Color(51, 0, 153));
        totalUserApplicationTopBluePanel.setPreferredSize(new java.awt.Dimension(261, 80));
        totalUserApplicationTopBluePanel.setRequestFocusEnabled(false);

        totalUserApplicationTopLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        totalUserApplicationTopLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalUserApplicationTopLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalUserApplicationTopLabel.setText("Total User Application");

        javax.swing.GroupLayout totalUserApplicationTopBluePanelLayout = new javax.swing.GroupLayout(totalUserApplicationTopBluePanel);
        totalUserApplicationTopBluePanel.setLayout(totalUserApplicationTopBluePanelLayout);
        totalUserApplicationTopBluePanelLayout.setHorizontalGroup(
            totalUserApplicationTopBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalUserApplicationTopBluePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalUserApplicationTopLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );
        totalUserApplicationTopBluePanelLayout.setVerticalGroup(
            totalUserApplicationTopBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalUserApplicationTopBluePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalUserApplicationTopLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        totalUserApplicationBlueLabel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        totalUserApplicationBlueLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalUserApplicationBlueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("*total pending to approve user in the system");

        javax.swing.GroupLayout totalUserApplicationBluePanelLayout = new javax.swing.GroupLayout(totalUserApplicationBluePanel);
        totalUserApplicationBluePanel.setLayout(totalUserApplicationBluePanelLayout);
        totalUserApplicationBluePanelLayout.setHorizontalGroup(
            totalUserApplicationBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(totalUserApplicationTopBluePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addGroup(totalUserApplicationBluePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(totalUserApplicationBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(totalUserApplicationBluePanelLayout.createSequentialGroup()
                        .addComponent(totalUserApplicationBlueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        totalUserApplicationBluePanelLayout.setVerticalGroup(
            totalUserApplicationBluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalUserApplicationBluePanelLayout.createSequentialGroup()
                .addComponent(totalUserApplicationTopBluePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalUserApplicationBlueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

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

        javax.swing.GroupLayout adminPanelBackGroundPanelLayout = new javax.swing.GroupLayout(adminPanelBackGroundPanel);
        adminPanelBackGroundPanel.setLayout(adminPanelBackGroundPanelLayout);
        adminPanelBackGroundPanelLayout.setHorizontalGroup(
            adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelBackGroundPanelLayout.createSequentialGroup()
                .addComponent(redPanelBackGroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, adminPanelBackGroundPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(392, 392, 392)
                        .addComponent(logoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, adminPanelBackGroundPanelLayout.createSequentialGroup()
                        .addGroup(adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(totalUserApplicationBluePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(totalUserBluePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalUploadedAdsBluePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalPendingToApproveAdsBluePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        adminPanelBackGroundPanelLayout.setVerticalGroup(
            adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(redPanelBackGroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(adminPanelBackGroundPanelLayout.createSequentialGroup()
                .addGroup(adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminPanelBackGroundPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(adminPanelBackGroundPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalUploadedAdsBluePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalUserBluePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(104, 104, 104)
                .addGroup(adminPanelBackGroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalPendingToApproveAdsBluePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalUserApplicationBluePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(97, Short.MAX_VALUE))
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

    // all the mouse enter and mouse exit mouse event is for all the the label to change color so the user will know when they reach specific panel
    private void dashBoardLabelMouseEntered(java.awt.event.MouseEvent evt) {
        dashBoardLabel.setBackground(new Color(204,0,0));
    }

    private void adminAcountGenerationLabelMouseEntered(java.awt.event.MouseEvent evt) {
        adminAcountGenerationLabel.setBackground(new Color(204,0,0));
    }

    private void adminAcountGenerationLabelMouseExited(java.awt.event.MouseEvent evt) {
        adminAcountGenerationLabel.setBackground(new Color(255,0,51));
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
	
	private void userApplicationLabel1MouseEntered(java.awt.event.MouseEvent evt) {
        userApplicationLabel1.setBackground(new Color(204,0,0));
    }

    private void userApplicationLabel1MouseExited(java.awt.event.MouseEvent evt) {
        userApplicationLabel1.setBackground(new Color(255,0,51));
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

    private void adminAcountGenerationLabelMouseClicked(java.awt.event.MouseEvent evt) {
        new AdminAccountGenerateFrame().setVisible(true);
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

    private void userApplicationLabel1MouseClicked(java.awt.event.MouseEvent evt) {
        new UserApplicationFrame().setVisible(true);
        this.setVisible(false);
    }

    // the main function that use to call this class for testing purpose
    // public static void main(String args[]) {
    //     try {
    //         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    //             if ("Nimbus".equals(info.getName())) {
    //                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
    //                 break;
    //             }
    //         }
    //     } catch (ClassNotFoundException ex) {
    //         java.util.logging.Logger.getLogger(AdminDashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (InstantiationException ex) {
    //         java.util.logging.Logger.getLogger(AdminDashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (IllegalAccessException ex) {
    //         java.util.logging.Logger.getLogger(AdminDashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //         java.util.logging.Logger.getLogger(AdminDashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }

    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             new AdminDashboardFrame().setVisible(true);
    //         }
    //     });
    // }

}
