import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Dimension;

// Uzair Naquib Bin Mukazul (1191101649)
public class ManagePropertyListing extends javax.swing.JPanel { //View class for individual property listings in Manage Property Page. Generated using NetBeans
	JLabel propertyActivationLabel = new JLabel();

    /**
     * Creates new form ManageSpecificPropertyPage
     */
    public ManagePropertyListing() {
    	setBackground(Color.WHITE);
        initComponents();
        
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        projectNameLabel = new javax.swing.JLabel();
        projectNameLabel.setBounds(127, 11, 201, 25);
        priceTitleLabel = new javax.swing.JLabel();
        priceTitleLabel.setBounds(127, 169, 39, 20);
        priceLabel = new javax.swing.JLabel();
        priceLabel.setBounds(176, 169, 81, 20);
        addressTitleLabel = new javax.swing.JLabel();
        addressTitleLabel.setBounds(127, 98, 115, 14);
        addressLine1Label = new javax.swing.JLabel();
        addressLine1Label.setBounds(127, 109, 563, 25);
        propertyImageLabel = new javax.swing.JLabel();
        propertyImageLabel.setBounds(0, 11, 121, 189);
        viewDetailsButton = new javax.swing.JButton();
        viewDetailsButton.setBounds(575, 164, 115, 32);
        propertyNameLabel = new javax.swing.JLabel();
        propertyNameLabel.setBounds(127, 42, 563, 17);

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(693, 200));
        //setResizable(false);

        projectNameLabel.setFont(new java.awt.Font("Source Serif Pro Black", 0, 18)); // NOI18N
        projectNameLabel.setText("Project name");

        priceTitleLabel.setFont(new java.awt.Font("Source Serif Pro Black", 0, 14)); // NOI18N
        priceTitleLabel.setText("Price:");

        priceLabel.setFont(new java.awt.Font("Source Serif Pro Black", 0, 14)); // NOI18N
        priceLabel.setText("price");

        addressTitleLabel.setText("Address:");

        addressLine1Label.setText("line 1");

        viewDetailsButton.setText("View details");

        propertyNameLabel.setFont(new java.awt.Font("Source Serif Pro Black", 0, 12)); // NOI18N
        propertyNameLabel.setText("Property name");
        setLayout(null);
        add(propertyImageLabel);
        add(projectNameLabel);
        add(addressLine1Label);
        add(priceTitleLabel);
        add(priceLabel);
        add(propertyNameLabel);
        add(addressTitleLabel);
        add(viewDetailsButton);
        propertyActivationLabel.setBounds(127, 98, 0, 0);
        add(propertyActivationLabel);

        //pack();
    }

    private void viewDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDetailsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewDetailsButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLine1Label;
    private javax.swing.JLabel addressTitleLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel priceTitleLabel;
    private javax.swing.JLabel projectNameLabel;
    private javax.swing.JLabel propertyImageLabel;
    private javax.swing.JLabel propertyNameLabel;
    private javax.swing.JButton viewDetailsButton;
    // End of variables declaration//GEN-END:variables
    
    //Getters and setters for components
    public javax.swing.JLabel getAddressLine1Label() {
        return addressLine1Label;
    }
    public javax.swing.JLabel getAddressTitleLabel() {
        return addressTitleLabel;
    }
    public javax.swing.JLabel getPriceLabel() {
        return priceLabel;
    }
    public javax.swing.JLabel getPriceTitleLabel() {
        return priceTitleLabel;
    }
    public javax.swing.JLabel getProjectNameLabel() {
        return projectNameLabel;
    }
    public javax.swing.JLabel getPropertyImageLabel() {
        return propertyImageLabel;
    }
    public javax.swing.JLabel getPropertyNameLabel() {
        return propertyNameLabel;
    }
    public JLabel getPropertyActivationLabel() {
    	return propertyActivationLabel;
    }
    public javax.swing.JButton getViewDetailsButton() {
        return viewDetailsButton;
    }
}
