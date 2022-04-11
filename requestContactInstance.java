
// Muhammad Luqman Bin Zainon @ Mohd Rastam (1191100953)
public class requestContactInstance extends javax.swing.JPanel {    //View class for individual request contact instances, displayed inside larger Request Contact Page panel.
    
    /**
     * Creates new form requestContactInstance
     */
    public requestContactInstance() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TenantNameLabel = new javax.swing.JLabel();
        TenantEmailLabel = new javax.swing.JLabel();
        TenantContantNumLabel = new javax.swing.JLabel();
        PropertyTextLabel = new javax.swing.JLabel();
        PropertyImageLabel = new javax.swing.JLabel();
        PropertyTextEntryLabel = new javax.swing.JLabel();
        TenantNameEntryLabel = new javax.swing.JLabel();
        TenantEmailEntryLabel = new javax.swing.JLabel();
        TenantContactNumEntryLabel = new javax.swing.JLabel();
        DenyRequestButton = new javax.swing.JButton();
        ApproveRequestButton = new javax.swing.JButton();

        
        TenantNameLabel.setText("Tenant name:");

        TenantEmailLabel.setText("Tenant email:");

        TenantContantNumLabel.setText("Tenant contact number:");

        PropertyTextLabel.setFont(new java.awt.Font("Source Serif Pro Black", 0, 14));
        PropertyTextLabel.setText("Property requested:");

        PropertyTextEntryLabel.setFont(new java.awt.Font("Source Serif Pro Black", 0, 11));
        PropertyTextEntryLabel.setText("property");

        TenantNameEntryLabel.setText("name");

        TenantEmailEntryLabel.setText("email");

        TenantContactNumEntryLabel.setText("contact num");

        DenyRequestButton.setBackground(new java.awt.Color(255, 95, 43));
        DenyRequestButton.setFont(new java.awt.Font("Source Serif Pro Black", 0, 11));
        DenyRequestButton.setText("Deny");

        ApproveRequestButton.setBackground(new java.awt.Color(0, 190, 165));
        ApproveRequestButton.setFont(new java.awt.Font("Source Serif Pro Black", 0, 11));
        ApproveRequestButton.setText("Approve");
        ApproveRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApproveRequestButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TenantEmailLabel)
                            .addComponent(TenantContantNumLabel))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(TenantEmailEntryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TenantContactNumEntryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))))
                    .addComponent(PropertyTextEntryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PropertyTextLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TenantNameLabel)
                        .addGap(56, 56, 56)
                        .addComponent(TenantNameEntryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                        .addGap(34, 34, 34)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PropertyImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ApproveRequestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DenyRequestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(PropertyTextLabel)
                .addGap(5, 5, 5)
                .addComponent(PropertyTextEntryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TenantNameLabel)
                    .addComponent(TenantNameEntryLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TenantEmailEntryLabel)
                    .addComponent(TenantEmailLabel))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TenantContantNumLabel)
                    .addComponent(TenantContactNumEntryLabel)))
            .addComponent(PropertyImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ApproveRequestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DenyRequestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

    }// </editor-fold>//GEN-END:initComponents

    private void ApproveRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApproveRequestButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApproveRequestButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private String username;
    private javax.swing.JButton ApproveRequestButton;
    private javax.swing.JButton DenyRequestButton;
    private javax.swing.JLabel PropertyImageLabel;
    private javax.swing.JLabel PropertyTextEntryLabel;
    private javax.swing.JLabel PropertyTextLabel;
    private javax.swing.JLabel TenantContactNumEntryLabel;
    private javax.swing.JLabel TenantContantNumLabel;
    private javax.swing.JLabel TenantEmailEntryLabel;
    private javax.swing.JLabel TenantEmailLabel;
    private javax.swing.JLabel TenantNameEntryLabel;
    private javax.swing.JLabel TenantNameLabel;
    // End of variables declaration//GEN-END:variables

    //Getters for all components
    public javax.swing.JButton getApproveRequestButton() {
        return ApproveRequestButton;
    }
    public javax.swing.JButton getDenyRequestButton() {
        return DenyRequestButton;
    }
    public javax.swing.JLabel getPropertyImageLabel() {
        return PropertyImageLabel;
    }
    public javax.swing.JLabel getPropertyTextEntryLabel() {
        return PropertyTextEntryLabel;
    }
    public javax.swing.JLabel getPropertyTextLabel() {
        return PropertyTextLabel;
    }
    public javax.swing.JLabel getTenantContactNumEntryLabel() {
        return TenantContactNumEntryLabel;
    }
    public javax.swing.JLabel getTenantContantNumLabel() {
        return TenantContantNumLabel;
    }
    public javax.swing.JLabel getTenantEmailEntryLabel() {
        return TenantEmailEntryLabel;
    }
    public javax.swing.JLabel getTenantEmailLabel() {
        return TenantEmailLabel;
    }
    public javax.swing.JLabel getTenantNameEntryLabel() {
        return TenantNameEntryLabel;
    }
    public javax.swing.JLabel getTenantNameLabel() {
        return TenantNameLabel;
    }
    
    public String getUsername() {
    	return username;
    }
    
    public void setUsername(String username) {
    	this.username = username;
    }
    
}
