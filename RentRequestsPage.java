import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;

// Uzair Naquib Bin Mukazul (1191101649)
public class RentRequestsPage extends javax.swing.JPanel {      //View class for rent requests page, generated using NetBeans
	 private JPanel panelInsideScrollPane;
	 private ArrayList<JButton> approveButtons = new ArrayList<>();
		
	 private ArrayList<JButton> denyButtons = new ArrayList<>();
    /**
     * Creates new form RentRequestsPage
     */
    public RentRequestsPage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        requestScrollPane = new javax.swing.JScrollPane();
        requestScrollPane.setBounds(250, 62, 750, 600);
        rentRequestTitleLabel = new javax.swing.JLabel();
        rentRequestTitleLabel.setBounds(250, 23, 276, 33);
        requestSideBarPanel = new javax.swing.JPanel();
        requestSideBarPanel.setBounds(0, 0, 244, 700);
        sidebarPanel = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        rentRequestsButton = new javax.swing.JButton();
        managePropertiesButton = new javax.swing.JButton();
        newPropertyPageButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1024, 700));
        setSize(new java.awt.Dimension(1024, 700));

        requestScrollPane.setPreferredSize(null);

        rentRequestTitleLabel.setFont(new java.awt.Font("Source Serif Pro Black", 0, 24)); // NOI18N
        rentRequestTitleLabel.setText("Incoming Rent Requests");

        sidebarPanel.setBackground(new Color(236, 77, 55));
        sidebarPanel.setPreferredSize(new java.awt.Dimension(255, 684));

        homeButton.setBackground(new Color(236, 77, 55));
        homeButton.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 25)); // NOI18N
        homeButton.setForeground(new java.awt.Color(255, 255, 255));
        homeButton.setText("Home");
        homeButton.setBorder(null);

        rentRequestsButton.setBackground(new Color(236, 77, 55));
        rentRequestsButton.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 25)); // NOI18N
        rentRequestsButton.setForeground(new java.awt.Color(255, 255, 255));
        rentRequestsButton.setText("Rent requests");
        rentRequestsButton.setBorder(null);

        managePropertiesButton.setBackground(new Color(236, 77, 55));
        managePropertiesButton.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 23)); // NOI18N
        managePropertiesButton.setForeground(new java.awt.Color(255, 255, 255));
        managePropertiesButton.setText("Manage Properties");
        managePropertiesButton.setBorder(null);

        newPropertyPageButton.setBackground(new Color(236, 77, 55));
        newPropertyPageButton.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 25)); // NOI18N
        newPropertyPageButton.setForeground(new java.awt.Color(255, 255, 255));
        newPropertyPageButton.setText("New Property");
        newPropertyPageButton.setBorder(null);


        logOutButton.setBackground(new Color(236, 77, 55));
        logOutButton.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 25)); // NOI18N
        logOutButton.setForeground(new java.awt.Color(255, 255, 255));
        logOutButton.setText("Log Out");
        logOutButton.setBorder(null);
 
        javax.swing.GroupLayout sidebarPanelLayout = new javax.swing.GroupLayout(sidebarPanel);
        sidebarPanelLayout.setHorizontalGroup(
        	sidebarPanelLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(sidebarPanelLayout.createSequentialGroup()
        			.addGap(27)
        			.addGroup(sidebarPanelLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(logOutButton)
        				.addComponent(newPropertyPageButton)
        				.addComponent(managePropertiesButton)
        				.addComponent(rentRequestsButton)
        				.addComponent(homeButton))
        			.addContainerGap(14, Short.MAX_VALUE))
        );
        sidebarPanelLayout.setVerticalGroup(
        	sidebarPanelLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(sidebarPanelLayout.createSequentialGroup()
        			.addGap(38)
        			.addComponent(homeButton)
        			.addGap(18)
        			.addComponent(rentRequestsButton)
        			.addGap(36)
        			.addComponent(managePropertiesButton)
        			.addGap(29)
        			.addComponent(newPropertyPageButton)
        			.addGap(26)
        			.addComponent(logOutButton)
        			.addContainerGap(380, Short.MAX_VALUE))
        );
        sidebarPanel.setLayout(sidebarPanelLayout);

        javax.swing.GroupLayout requestSideBarPanelLayout = new javax.swing.GroupLayout(requestSideBarPanel);
        requestSideBarPanel.setLayout(requestSideBarPanelLayout);
        requestSideBarPanelLayout.setHorizontalGroup(
            requestSideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
        );
        requestSideBarPanelLayout.setVerticalGroup(
            requestSideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        
        panelInsideScrollPane = new JPanel();
		panelInsideScrollPane.setPreferredSize(new Dimension(400,400));
        
		requestScrollPane = new JScrollPane(panelInsideScrollPane,
                 JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                 JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		requestScrollPane.getVerticalScrollBar().setUnitIncrement(16);

		panelInsideScrollPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelInsideScrollPane.add(new JPanel());
		requestScrollPane.setLocation(247, 82);
		requestScrollPane.setSize(761, 575);
        setLayout(null);
        add(requestSideBarPanel);
        add(rentRequestTitleLabel);
        add(requestScrollPane);
        
    }
    // </editor-fold>//GEN-END:initComponents
    public void setRentRequest(ArrayList<requestContactInstance> requestsList) {
		panelInsideScrollPane.removeAll();
		approveButtons.clear();
		denyButtons.clear();
		if(requestsList.size() == 0) {
//			noResultFoundMessage();
		}
		
		for(int i = 0; i < requestsList.size(); i++){
			requestsList.get(i).setBackground(Color.white);
			approveButtons.add(requestsList.get(i).getApproveRequestButton());
			denyButtons.add(requestsList.get(i).getDenyRequestButton());

			panelInsideScrollPane.setPreferredSize(new Dimension(800,200 * (i+1)));
			panelInsideScrollPane.add(requestsList.get(i));
		}
	}
    
    private void managePropertiesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePropertiesButtonActionPerformed
        // TODO add your handling code here:
        new ManagePropertiesPage().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_managePropertiesButtonActionPerformed

    private void newPropertyPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPropertyPageButtonActionPerformed
        // TODO add your handling code here:
        new NewPropertyPage().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_newPropertyPageButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logOutButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeButton;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton managePropertiesButton;
    private javax.swing.JButton newPropertyPageButton;
    private javax.swing.JLabel rentRequestTitleLabel;
    private javax.swing.JButton rentRequestsButton;
    private javax.swing.JScrollPane requestScrollPane;
    private javax.swing.JPanel requestSideBarPanel;
    private javax.swing.JPanel sidebarPanel;
    // End of variables declaration//GEN-END:variables


    //Getters for all components
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
    public javax.swing.JLabel getRentRequestTitleLabel() {
        return rentRequestTitleLabel;
    }
    public javax.swing.JButton getRentRequestsButton() {
        return rentRequestsButton;
    }
    public javax.swing.JScrollPane getRequestScrollPane() {
        return requestScrollPane;
    }
    public javax.swing.JPanel getRequestSideBarPanel() {
        return requestSideBarPanel;
    }
    public javax.swing.JPanel getSidebarPanel() {
        return sidebarPanel;
    }
    
    public ArrayList<JButton> getApproveButtons() {
    	return approveButtons;
    }
    
    public ArrayList<JButton> getDenyButtons() {
    	return denyButtons;
    }
}
