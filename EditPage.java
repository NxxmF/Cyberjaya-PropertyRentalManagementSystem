import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

// Harannesh A/L Arul Ananthan (1191101646)
public class EditPage extends javax.swing.JPanel { //View class for edit page, generated using NetBeans

    /**
     * Creates new form EditPage
     */
    public EditPage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        sideBarPanel = new javax.swing.JPanel();
        sidebarPanel = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        rentRequestsButton = new javax.swing.JButton();
        managePropertiesButton = new javax.swing.JButton();
        newPropertyPageButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        gardenCheckBox = new javax.swing.JCheckBox();
        garageCheckBox = new javax.swing.JCheckBox();
        securityCheckBox = new javax.swing.JCheckBox();
        parkingCheckBox = new javax.swing.JCheckBox();
        propertyNameLabel = new javax.swing.JLabel();
        supermarketCheckBox = new javax.swing.JCheckBox();
        priceLabel = new javax.swing.JLabel();
        gymCheckBox = new javax.swing.JCheckBox();
        descLabel = new javax.swing.JLabel();
        playgroundCheckBox = new javax.swing.JCheckBox();
        facilitiesLabel = new javax.swing.JLabel();
        featuresLabel = new javax.swing.JLabel();
        sizeTextField = new javax.swing.JTextField();
        sizeLabel = new javax.swing.JLabel();
        bedsLabel = new javax.swing.JLabel();
        bedsComboBox = new javax.swing.JComboBox<>();
        bathsComboBox = new javax.swing.JComboBox<>();
        bathsLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        propertyTypeLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        priceTextField = new javax.swing.JTextField();
        propertyTypeComboBox = new javax.swing.JComboBox<>();
        descScrollPane = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        poolCheckBox = new javax.swing.JCheckBox();
        sportCheckBox = new javax.swing.JCheckBox();
        airConditionerCheckBox = new javax.swing.JCheckBox();
        kitchenCabinetCheckBox = new javax.swing.JCheckBox();
        addressLabel = new javax.swing.JLabel();
        addressScrollPane = new javax.swing.JScrollPane();
        addressTextArea = new javax.swing.JTextArea();

        sideBarPanel.setPreferredSize(new java.awt.Dimension(255, 684));

        sidebarPanel.setBackground(new Color(236, 77, 55));
        sidebarPanel.setPreferredSize(new java.awt.Dimension(255, 684));

        homeButton.setBackground(new Color(236, 77, 55));
        homeButton.setFont(new java.awt.Font("Source Serif Pro Black", 0, 25)); // NOI18N
        homeButton.setForeground(new java.awt.Color(255, 255, 255));
        homeButton.setText("Home");
        homeButton.setBorder(null);

        rentRequestsButton.setBackground(new Color(236, 77, 55));
        rentRequestsButton.setFont(new java.awt.Font("Source Serif Pro Black", 0, 25)); // NOI18N
        rentRequestsButton.setForeground(new java.awt.Color(255, 255, 255));
        rentRequestsButton.setText("Rent requests");
        rentRequestsButton.setBorder(null);

        managePropertiesButton.setBackground(new Color(236, 77, 55));
        managePropertiesButton.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 23)); // NOI18N
        managePropertiesButton.setForeground(new java.awt.Color(255, 255, 255));
        managePropertiesButton.setText("Manage Properties");
        managePropertiesButton.setBorder(null);

        newPropertyPageButton.setBackground(new Color(236, 77, 55));
        newPropertyPageButton.setFont(new java.awt.Font("Source Serif Pro Black", 0, 25)); // NOI18N
        newPropertyPageButton.setForeground(new java.awt.Color(255, 255, 255));
        newPropertyPageButton.setText("New Property");
        newPropertyPageButton.setBorder(null);

        logOutButton.setBackground(new Color(236, 77, 55));
        logOutButton.setFont(new java.awt.Font("Source Serif Pro Black", 0, 25)); // NOI18N
        logOutButton.setForeground(new java.awt.Color(255, 255, 255));
        logOutButton.setText("Log Out");
        logOutButton.setBorder(null);

        javax.swing.GroupLayout sidebarPanelLayout = new javax.swing.GroupLayout(sidebarPanel);
        sidebarPanelLayout.setHorizontalGroup(
        	sidebarPanelLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(sidebarPanelLayout.createSequentialGroup()
        			.addGap(27)
        			.addGroup(sidebarPanelLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(newPropertyPageButton)
        				.addComponent(managePropertiesButton)
        				.addComponent(logOutButton)
        				.addComponent(rentRequestsButton)
        				.addComponent(homeButton))
        			.addContainerGap(59, Short.MAX_VALUE))
        );
        sidebarPanelLayout.setVerticalGroup(
        	sidebarPanelLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(sidebarPanelLayout.createSequentialGroup()
        			.addGap(38)
        			.addComponent(homeButton)
        			.addGap(18)
        			.addComponent(rentRequestsButton)
        			.addGap(28)
        			.addComponent(managePropertiesButton)
        			.addGap(32)
        			.addComponent(newPropertyPageButton)
        			.addGap(27)
        			.addComponent(logOutButton)
        			.addContainerGap(384, Short.MAX_VALUE))
        );
        sidebarPanel.setLayout(sidebarPanelLayout);

        javax.swing.GroupLayout sideBarPanelLayout = new javax.swing.GroupLayout(sideBarPanel);
        sideBarPanel.setLayout(sideBarPanelLayout);
        sideBarPanelLayout.setHorizontalGroup(
            sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebarPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
        );
        sideBarPanelLayout.setVerticalGroup(
            sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarPanelLayout.createSequentialGroup()
                .addComponent(sidebarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        titleLabel.setFont(new java.awt.Font("Source Serif Pro Black", 0, 24));
        titleLabel.setText("Edit Property");

        gardenCheckBox.setText("Garden");

        garageCheckBox.setText("Garage");

        securityCheckBox.setText("24-Hour Security");

        parkingCheckBox.setText("Parking");

        propertyNameLabel.setText("Property name goes here");

        supermarketCheckBox.setText("Supermarket");

        priceLabel.setText("Price(RM):");

        gymCheckBox.setText("Gym");

        descLabel.setText("Description:");

        playgroundCheckBox.setText("Playground");

        facilitiesLabel.setText("Features:");

        featuresLabel.setText("Facilities:");

        sizeTextField.setToolTipText("Enter size");

        sizeLabel.setText("Size (sq ft. ):");

        bedsLabel.setText("Bedrooms:");

        bedsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10+" }));

        bathsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10+" }));

        bathsLabel.setText("Bathrooms:");

        cancelButton.setText("Cancel");

        propertyTypeLabel.setText("Property type:");

        addButton.setText("Confirm Edit");


        priceTextField.setToolTipText("Enter price");

        propertyTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Apartment", "Flat", "Condominium", "Serviced Residence", "Link House", "Cluster House", "Bungalow", "Semi Detached House", "Villa", "Residentia lLand" }));


        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("Enter description");
        descScrollPane.setViewportView(jTextArea1);

        poolCheckBox.setText("Swimming Pool");

        sportCheckBox.setText("Sport Court");

        airConditionerCheckBox.setText("Air Conditioner");
        airConditionerCheckBox.setMaximumSize(new java.awt.Dimension(369, 219));
        airConditionerCheckBox.setMinimumSize(new java.awt.Dimension(369, 219));

        kitchenCabinetCheckBox.setText("Kitchen Cabinet");


        addressLabel.setText("Address:");

        addressTextArea.setColumns(20);
        addressTextArea.setRows(5);
        addressScrollPane.setViewportView(addressTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(sideBarPanel, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(titleLabel)
        				.addComponent(descLabel)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(sizeLabel)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(sizeTextField, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(propertyTypeLabel)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(propertyTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addComponent(addButton)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(propertyNameLabel)
        						.addComponent(priceLabel))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(priceTextField, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE))
        				.addComponent(facilitiesLabel)
        				.addComponent(airConditionerCheckBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(featuresLabel)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(bedsLabel)
        						.addComponent(bathsLabel))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(bathsComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(bedsComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(10)
        					.addComponent(descScrollPane, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(securityCheckBox)
        						.addComponent(poolCheckBox))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(parkingCheckBox)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(supermarketCheckBox)
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(gymCheckBox))
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(kitchenCabinetCheckBox)
        									.addGap(8)
        									.addComponent(gardenCheckBox)))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(garageCheckBox)
        								.addComponent(playgroundCheckBox)))
        						.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        							.addComponent(cancelButton)
        							.addComponent(sportCheckBox))))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(addressLabel)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(addressScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(sideBarPanel, GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(titleLabel)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(propertyNameLabel)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(priceLabel))
        				.addComponent(priceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(propertyTypeLabel)
        				.addComponent(propertyTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(17)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(addressLabel)
        				.addComponent(addressScrollPane, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(descLabel)
        			.addGap(1)
        			.addComponent(descScrollPane, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(facilitiesLabel)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(airConditionerCheckBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(kitchenCabinetCheckBox)
        				.addComponent(gardenCheckBox)
        				.addComponent(garageCheckBox))
        			.addGap(23)
        			.addComponent(featuresLabel)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(securityCheckBox)
        				.addComponent(parkingCheckBox)
        				.addComponent(supermarketCheckBox)
        				.addComponent(gymCheckBox)
        				.addComponent(playgroundCheckBox))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(poolCheckBox)
        				.addComponent(sportCheckBox))
        			.addGap(22)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(sizeLabel)
        				.addComponent(sizeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(bedsLabel)
        				.addComponent(bedsComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(bathsLabel)
        				.addComponent(bathsComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(addButton)
        				.addComponent(cancelButton))
        			.addContainerGap(78, Short.MAX_VALUE))
        );
        setLayout(layout);
        setSize(1024, 700);
        //pack();
    }

    /**
     * @param args the command line arguments
     */
    // public static void main(String args[]) {    //Main method used for testing panel
    //     /* Set the Nimbus look and feel */
    //     //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    //     /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
    //      * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
    //      */
    //     try {
    //         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    //             if ("Nimbus".equals(info.getName())) {
    //                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
    //                 break;
    //             }
    //         }
    //     } catch (ClassNotFoundException ex) {
    //         java.util.logging.Logger.getLogger(EditPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (InstantiationException ex) {
    //         java.util.logging.Logger.getLogger(EditPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (IllegalAccessException ex) {
    //         java.util.logging.Logger.getLogger(EditPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //         java.util.logging.Logger.getLogger(EditPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }
    //     //</editor-fold>

    //     /* Create and display the form */
    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             new EditPage().setVisible(true);
    //         }
    //     });
    // }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JScrollPane addressScrollPane;
    private javax.swing.JTextArea addressTextArea;
    private javax.swing.JCheckBox airConditionerCheckBox;
    private javax.swing.JComboBox<String> bathsComboBox;
    private javax.swing.JLabel bathsLabel;
    private javax.swing.JComboBox<String> bedsComboBox;
    private javax.swing.JLabel bedsLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel descLabel;
    private javax.swing.JScrollPane descScrollPane;
    private javax.swing.JLabel facilitiesLabel;
    private javax.swing.JLabel featuresLabel;
    private javax.swing.JCheckBox garageCheckBox;
    private javax.swing.JCheckBox gardenCheckBox;
    private javax.swing.JCheckBox gymCheckBox;
    private javax.swing.JButton homeButton;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JCheckBox kitchenCabinetCheckBox;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton managePropertiesButton;
    private javax.swing.JButton newPropertyPageButton;
    private javax.swing.JCheckBox parkingCheckBox;
    private javax.swing.JCheckBox playgroundCheckBox;
    private javax.swing.JCheckBox poolCheckBox;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JLabel propertyNameLabel;
    private javax.swing.JComboBox<String> propertyTypeComboBox;
    private javax.swing.JLabel propertyTypeLabel;
    private javax.swing.JButton rentRequestsButton;
    private javax.swing.JCheckBox securityCheckBox;
    private javax.swing.JPanel sideBarPanel;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JLabel sizeLabel;
    private javax.swing.JTextField sizeTextField;
    private javax.swing.JCheckBox sportCheckBox;
    private javax.swing.JCheckBox supermarketCheckBox;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables


    //Getters and setters for all components

    public javax.swing.JButton getAddButton() {
        return addButton;
    }
    public javax.swing.JLabel getAddressLabel() {
        return addressLabel;
    }
    public javax.swing.JScrollPane getAddressScrollPane() {
        return addressScrollPane;
    }
    public javax.swing.JTextArea getAddressTextArea() {
        return addressTextArea;
    }
    public javax.swing.JScrollPane getDescScrollPane() {
        return descScrollPane;
    }
    public javax.swing.JCheckBox getAirConditionerCheckBox() {
        return airConditionerCheckBox;
    }
    public javax.swing.JCheckBox getGymCheckBox() {
        return gymCheckBox;
    }
    public javax.swing.JCheckBox getPoolCheckBox() {
        return poolCheckBox;
    }
    public javax.swing.JCheckBox getSportCheckBox() {
        return sportCheckBox;
    }
    public javax.swing.JCheckBox getGarageCheckBox() {
        return garageCheckBox;
    }
    public javax.swing.JCheckBox getGardenCheckBox() {
        return gardenCheckBox;
    }
    public javax.swing.JCheckBox getParkingCheckBox() {
        return parkingCheckBox;
    }
    public javax.swing.JCheckBox getSecurityCheckBox() {
        return securityCheckBox;
    }
    public javax.swing.JCheckBox getPlaygroundCheckBox() {
        return playgroundCheckBox;
    }
    public javax.swing.JCheckBox getSupermarketCheckBox() {
        return supermarketCheckBox;
    }
    public javax.swing.JCheckBox getKitchenCabinetCheckBox() {
        return kitchenCabinetCheckBox;
    }
    public javax.swing.JLabel getBedsLabel() {
        return bedsLabel;
    }
    public javax.swing.JLabel getDescLabel() {
        return descLabel;
    }
    public javax.swing.JLabel getSizeLabel() {
        return sizeLabel;
    }
    public javax.swing.JLabel getBathsLabel() {
        return bathsLabel;
    }
    public javax.swing.JLabel getPriceLabel() {
        return priceLabel;
    }
    public javax.swing.JLabel getTitleLabel() {
        return titleLabel;
    }
    public javax.swing.JLabel getFeaturesLabel() {
        return featuresLabel;
    }
    public javax.swing.JLabel getFacilitiesLabel() {
        return facilitiesLabel;
    }
    public javax.swing.JLabel getPropertyNameLabel() {
        return propertyNameLabel;
    }
    public javax.swing.JLabel getPropertyTypeLabel() {
        return propertyTypeLabel;
    }
    public javax.swing.JTextField getSizeTextField() {
        return sizeTextField;
    }
    public javax.swing.JTextField getPriceTextField() {
        return priceTextField;
    }
    public javax.swing.JTextArea getjTextArea1() {
        return jTextArea1;
    }
    public javax.swing.JComboBox<String> getPropertyTypeComboBox() {
        return propertyTypeComboBox;
    }
    public javax.swing.JComboBox<String> getBedsComboBox() {
        return bedsComboBox;
    }
    public javax.swing.JComboBox<String> getBathsComboBox() {
        return bathsComboBox;
    }
    public javax.swing.JButton getHomeButton() {
        return homeButton;
    }
    public javax.swing.JButton getCancelButton() {
        return cancelButton;
    }
    public javax.swing.JButton getLogOutButton() {
        return logOutButton;
    }
    public javax.swing.JButton getRentRequestsButton() {
        return rentRequestsButton;
    }
    public javax.swing.JButton getNewPropertyPageButton() {
        return newPropertyPageButton;
    }
    public javax.swing.JButton getManagePropertiesButton() {
        return managePropertiesButton;
    }
}
