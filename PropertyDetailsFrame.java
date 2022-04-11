import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

// Naim Farhat Bin Mahmad Zulhasnan
// View class that use to show the details of a property in the admin system
// Generated using Eclipse
public class PropertyDetailsFrame extends javax.swing.JFrame {
	
    //All the variable that use in the frame
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel facilityTittleLabel;
    private javax.swing.JLabel facilityTittleName;
    private javax.swing.JLabel facilityTittleName1;
    private javax.swing.JTextArea facilityTxt;
    private javax.swing.JTextArea featureTxt;
    private javax.swing.JLabel furnishingLabel;
    private javax.swing.JLabel furnishingTittleLabel;
    private javax.swing.JLabel furnishingTittleLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JLabel mainPicLabel;
    private javax.swing.JLabel numBathLabel;
    private javax.swing.JLabel numBathPicLabel;
    private javax.swing.JLabel numBedroomLabel;
    private javax.swing.JLabel numBedroomPicLabel;
    private javax.swing.JLabel picLabel1;
    private javax.swing.JLabel picLabel2;
    private javax.swing.JLabel picLabel3;
    private javax.swing.JLabel picLabel4;
    private javax.swing.JLabel picLabel5;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel projectNameLabel;
    private javax.swing.JLabel propertyTypeLabel;
    private javax.swing.JLabel rentalRateLabel;
    private javax.swing.JLabel sizeLabel;
    private javax.swing.JLabel tittleNameLabel;
    private javax.swing.JLabel typeLabel;
	
    private Property property;  // to store the data of the property info that are going to be printed in this frame
	
	
    public PropertyDetailsFrame(Property property) throws PrinterException {
        this.property = property;
        initComponents();
		setPropertyDetailsFrameInfo();  
    }
	
	// the method that used to display all the details in the property details frame
	private void setPropertyDetailsFrameInfo(){
		scaleIconImage(property.getPropertyPicturePath()[0],mainPicLabel);
        scaleIconImage("Images/bed.png",numBedroomLabel);
        scaleIconImage("Images/bath.png",numBathLabel);
        JLabel []label = {picLabel1,picLabel2,picLabel3,picLabel4,picLabel5};
        for(int i = 0; i < property.getPropertyPicturePath().length;i++){
            scaleIconImage(property.getPropertyPicturePath()[i],label[i]);
        }
        tittleNameLabel.setText(property.getPropertyName());
        priceLabel.setText("RM " + String.valueOf(property.getPrice()) + "0");
        sizeLabel.setText(String.valueOf(property.getSize()) + " sqrt");
        numBedroomPicLabel.setText(String.valueOf(property.getBedRoomsNum()));
        numBathPicLabel.setText(String.valueOf(property.getBathRoomsNum()));
        projectNameLabel.setText(property.getPropertyAddress().getProject());
        addressLabel.setText(property.getPropertyAddress().getFullAddress());
        propertyTypeLabel.setText(property.getPropertyType());
        furnishingLabel.setText(property.getFurnishing());
        
        rentalRateLabel.setText("RM " +String.valueOf(property.getRentalRate()));
        String facility = "";
        for(int i = 0; i < property.getAvailableFacilities().length;i++){
            if(i == property.getAvailableFacilities().length - 1)
               facility = facility + property.getAvailableFacilities()[i] ;
            else 
                facility = facility + property.getAvailableFacilities()[i] + ",";
        }
        facilityTxt.setText(facility);
        String feature = "";
        for(int i = 0; i < property.getAvailableFeatures().length;i++){
            if(i == property.getAvailableFeatures().length - 1)
               feature = feature + property.getAvailableFeatures()[i] ;
            else 
                feature = feature + property.getAvailableFeatures()[i] + ",";;}
        featureTxt.setText(feature);
        String [] description = property.getDescription().split("\\|");
        for(int i = 0; i < description.length;i++)
            jTextArea2.append(description[i] + "\n");
        
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
	}
    
	// the method use to scale the property image size to fit the label
    private void scaleIconImage(String path,JLabel label){
       ImageIcon icon = new ImageIcon(path);
       Image img = icon.getImage();
       Image imgScale = img.getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_SMOOTH);
       ImageIcon scaledIcon = new ImageIcon(imgScale);
       label.setIcon(scaledIcon);
       
  
    }
    
	// this method is mainly use for the design of the frame and store the action that will be execute in the frame
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        mainPicLabel = new javax.swing.JLabel();
        picLabel3 = new javax.swing.JLabel();
        picLabel1 = new javax.swing.JLabel();
        picLabel5 = new javax.swing.JLabel();
        picLabel2 = new javax.swing.JLabel();
        tittleNameLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        numBedroomLabel = new javax.swing.JLabel();
        numBathPicLabel = new javax.swing.JLabel();
        numBedroomPicLabel = new javax.swing.JLabel();
        numBathLabel = new javax.swing.JLabel();
        projectNameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        propertyTypeLabel = new javax.swing.JLabel();
        furnishingTittleLabel = new javax.swing.JLabel();
        furnishingLabel = new javax.swing.JLabel();
        facilityTittleName = new javax.swing.JLabel();
        facilityTittleLabel = new javax.swing.JLabel();
        sizeLabel = new javax.swing.JLabel();
        facilityTittleName1 = new javax.swing.JLabel();
        picLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        facilityTxt = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        featureTxt = new javax.swing.JTextArea();
        furnishingTittleLabel1 = new javax.swing.JLabel();
        rentalRateLabel = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        mainPicLabel.setBackground(new java.awt.Color(255, 153, 153));

        picLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                picLabel3MouseClicked(evt);
            }
        });

        picLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                picLabel1MouseClicked(evt);
            }
        });

        picLabel5.setToolTipText("");
        picLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                picLabel5MouseClicked(evt);
            }
        });

        picLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                picLabel2MouseClicked(evt);
            }
        });

        tittleNameLabel.setFont(new java.awt.Font("Tahoma", 1, 24));

        priceLabel.setFont(new java.awt.Font("Tahoma", 1, 18));

        numBathPicLabel.setFont(new java.awt.Font("Tahoma", 1, 24));

        numBedroomPicLabel.setFont(new java.awt.Font("Tahoma", 1, 24));

        projectNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Details");

        typeLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        typeLabel.setText("Type");

        propertyTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 12));
        propertyTypeLabel.setToolTipText("");

        furnishingTittleLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        furnishingTittleLabel.setText("Furnishing");

        furnishingLabel.setFont(new java.awt.Font("Tahoma", 0, 12));

        facilityTittleName.setFont(new java.awt.Font("Tahoma", 1, 12));
        facilityTittleName.setText("Facility");

        facilityTittleLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        facilityTittleLabel.setText("Feature");

        sizeLabel.setFont(new java.awt.Font("Tahoma", 1, 18));

        facilityTittleName1.setFont(new java.awt.Font("Tahoma", 1, 12));
        facilityTittleName1.setText("Description");

        picLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                picLabel4MouseClicked(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel2.setText("Property Details");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        facilityTxt.setColumns(20);
        facilityTxt.setRows(5);
        jScrollPane4.setViewportView(facilityTxt);

        featureTxt.setColumns(20);
        featureTxt.setRows(5);
        jScrollPane5.setViewportView(featureTxt);

        furnishingTittleLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        furnishingTittleLabel1.setText("Rental Rate");

        rentalRateLabel.setFont(new java.awt.Font("Tahoma", 0, 12));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(furnishingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(facilityTittleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(typeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(propertyTypeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(facilityTittleName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(131, 131, 131))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(furnishingTittleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(furnishingTittleLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rentalRateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(facilityTittleName1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mainPicLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(picLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(picLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(picLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(picLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(picLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 12, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(priceLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(numBedroomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(numBedroomPicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(numBathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(36, 36, 36)
                                            .addComponent(sizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(numBathPicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(tittleNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(projectNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(mainPicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(picLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(picLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(picLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(picLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(picLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tittleNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numBedroomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numBathPicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numBedroomPicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numBathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(projectNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(typeLabel)
                            .addComponent(facilityTittleName))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(propertyTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(furnishingTittleLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(facilityTittleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(furnishingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(furnishingTittleLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rentalRateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(facilityTittleName1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // the method that will be executed when any of the property picture selected and set them to the main picture so the user can see the picture clearer
    private void picLabel1MouseClicked(java.awt.event.MouseEvent evt) {
        scaleIconImage(property.getPropertyPicturePath()[0],mainPicLabel);
    }

    private void picLabel2MouseClicked(java.awt.event.MouseEvent evt) {
        if(property.getPropertyPicturePath().length >= 2)
        scaleIconImage(property.getPropertyPicturePath()[1],mainPicLabel);
    }

    private void picLabel3MouseClicked(java.awt.event.MouseEvent evt) {
        if(property.getPropertyPicturePath().length >= 3)
        scaleIconImage(property.getPropertyPicturePath()[2],mainPicLabel);
    }

    private void picLabel4MouseClicked(java.awt.event.MouseEvent evt) {
        if(property.getPropertyPicturePath().length >= 4)
        scaleIconImage(property.getPropertyPicturePath()[3],mainPicLabel);
    }

    private void picLabel5MouseClicked(java.awt.event.MouseEvent evt) {
        if(property.getPropertyPicturePath().length >= 5)
        scaleIconImage(property.getPropertyPicturePath()[4],mainPicLabel);
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
    //         java.util.logging.Logger.getLogger(PropertyDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (InstantiationException ex) {
    //         java.util.logging.Logger.getLogger(PropertyDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (IllegalAccessException ex) {
    //         java.util.logging.Logger.getLogger(PropertyDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //         java.util.logging.Logger.getLogger(PropertyDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }
    //        Property property = null;
    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             try {
    //                 new PropertyDetailsFrame(property).setVisible(true);
    //             } catch (PrinterException ex) {
    //                 Logger.getLogger(PropertyDetailsFrame.class.getName()).log(Level.SEVERE, null, ex);
    //             }
    //         }
    //     });
    // }

}
