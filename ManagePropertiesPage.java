import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Font;

// Uzair Naquib Bin Mukazul (1191101649)
public class ManagePropertiesPage extends javax.swing.JPanel {  //View class for Manage Properties Page, generated using NetBeans
	 private JPanel panelInsideScrollPane;
	 private ArrayList<JButton> viewDetailsButtons = new ArrayList<>();

    /**
     * Creates new form ManagePropertiesPage
     */
    public ManagePropertiesPage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        sideBarPanel = new javax.swing.JPanel();
        sideBarPanel.setBounds(0, 0, 246, 746);
        sidebarPanel = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        rentRequestsButton = new javax.swing.JButton();
        managePropertiesButton = new javax.swing.JButton();
        newPropertyPageButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        titleLabel.setBounds(252, 11, 276, 33);
        requestsScrollPane = new javax.swing.JScrollPane();
        requestsScrollPane.setBounds(252, 62, 750, 600);

        setSize(new java.awt.Dimension(1024, 700));

        setPreferredSize(new java.awt.Dimension(1024, 700));

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
        				.addComponent(managePropertiesButton)
        				.addComponent(logOutButton)
        				.addComponent(newPropertyPageButton)
        				.addComponent(rentRequestsButton)
        				.addComponent(homeButton))
        			.addContainerGap(30, Short.MAX_VALUE))
        );
        sidebarPanelLayout.setVerticalGroup(
        	sidebarPanelLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(sidebarPanelLayout.createSequentialGroup()
        			.addGap(38)
        			.addComponent(homeButton)
        			.addGap(18)
        			.addComponent(rentRequestsButton)
        			.addGap(38)
        			.addComponent(managePropertiesButton)
        			.addGap(34)
        			.addComponent(newPropertyPageButton)
        			.addGap(18)
        			.addComponent(logOutButton)
        			.addContainerGap(517, Short.MAX_VALUE))
        );
        sidebarPanel.setLayout(sidebarPanelLayout);

        javax.swing.GroupLayout sideBarPanelLayout = new javax.swing.GroupLayout(sideBarPanel);
        sideBarPanel.setLayout(sideBarPanelLayout);
        sideBarPanelLayout.setHorizontalGroup(
            sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
        );
        sideBarPanelLayout.setVerticalGroup(
            sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarPanelLayout.createSequentialGroup()
                .addComponent(sidebarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        titleLabel.setFont(new java.awt.Font("Source Serif Pro Black", 0, 24)); // NOI18N
        titleLabel.setText("Manage Properties");
        titleLabel.setPreferredSize(new java.awt.Dimension(276, 33));
        titleLabel.setRequestFocusEnabled(false);
        
        
        panelInsideScrollPane = new JPanel();
		panelInsideScrollPane.setPreferredSize(new Dimension(400,400));
        requestsScrollPane = new JScrollPane(panelInsideScrollPane,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        requestsScrollPane.getVerticalScrollBar().setUnitIncrement(16);

		panelInsideScrollPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		requestsScrollPane.setLocation(247, 82);
		requestsScrollPane.setSize(761, 575);
		setLayout(null);
        add(sideBarPanel);
        add(titleLabel);
        add(requestsScrollPane);
    }

    public void setPropertiesList(ArrayList<ManagePropertyListing> managePropertyListing) {
		panelInsideScrollPane.removeAll();
		viewDetailsButtons.clear();

		if(managePropertyListing.size() == 0) {
//			noResultFoundMessage();
		}
		for(int i = 0; i < managePropertyListing.size(); i++){

			viewDetailsButtons.add(managePropertyListing.get(i).getViewDetailsButton());
			
			panelInsideScrollPane.setPreferredSize(new Dimension(800,300 * (i+1)));
			panelInsideScrollPane.add(managePropertyListing.get(i));
		}
	}

    private void newPropertyPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPropertyPageButtonActionPerformed
        new NewPropertyPage().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_newPropertyPageButtonActionPerformed

    private void managePropertiesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePropertiesButtonActionPerformed
        new ManagePropertiesPage().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_managePropertiesButtonActionPerformed

    private void rentRequestsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentRequestsButtonActionPerformed
        new ManagePropertiesPage().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_rentRequestsButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    private ImageIcon loadImage(String path, int x, int y){
        Image image = new ImageIcon(this.getClass().getResource(path)).getImage();
        Image scaledImage = image.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
	} 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeButton;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton managePropertiesButton;
    private javax.swing.JButton newPropertyPageButton;
    private javax.swing.JButton rentRequestsButton;
    private javax.swing.JScrollPane requestsScrollPane;
    private javax.swing.JPanel sideBarPanel;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

    //Getters and setters for components
    public javax.swing.JButton getHomeButton() {
        return homeButton;
    }
    public javax.swing.JButton getLogOutButton() {
        return logOutButton;
    }
    public javax.swing.JButton getManagePropertiesButton() {
        return managePropertiesButton;
    }
    public javax.swing.JButton getNewPropertyPageButton() {
        return newPropertyPageButton;
    }
    public javax.swing.JButton getRentRequestsButton() {
        return rentRequestsButton;
    }
    public javax.swing.JScrollPane getRequestsScrollPane() {
        return requestsScrollPane;
    }
    public javax.swing.JPanel getSidebarPanel() {
        return sidebarPanel;
    }
    public javax.swing.JPanel getSideBarPanel() {
        return sideBarPanel;
    }
    public javax.swing.JLabel getTitleLabel() {
        return titleLabel;
    }
    public ArrayList<JButton> getViewDetailsButtons(){
    	return viewDetailsButtons;
    }
}
