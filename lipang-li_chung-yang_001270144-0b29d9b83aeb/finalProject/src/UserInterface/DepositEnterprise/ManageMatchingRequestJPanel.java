/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DepositEnterprise;

import Business.ConfigureEcoSystem;
import Business.EcoSystem;
import Business.Enterprise.CustodyEnterprise;
import Business.Enterprise.DepositEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.InvestmentEnterprise;
import Business.Organization.InvestmentOrg;
import Business.Organization.CustomerServiceOrg;
import Business.Organization.Organization;
import Business.Organization.TransactionOrg;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InvestmentWorkRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.CommonUse.CheckProgress;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chung-Yang Li
 */
public class ManageMatchingRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AccountingAssistantWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private TransactionOrg matchingOrg;
    private DepositEnterprise enterprise;
    private EcoSystem ecoSystem;
    private Boolean alreadyMatched;
    public ManageMatchingRequestJPanel(JPanel userProcessContainer, UserAccount account, TransactionOrg matchingOrg, Enterprise enterprise, EcoSystem ecoSystem) {
        initComponents();
        setSize(800,600);
        this.account = account;
        this.userProcessContainer =userProcessContainer;
        this.matchingOrg = matchingOrg;
        this.enterprise = (DepositEnterprise)enterprise;
        this.ecoSystem = ecoSystem;
        populateBuyTable();
        populateSellTable();
//        populateAveragePrice();
        this.alreadyMatched = false;
    }
    private void populateBuyTable(){
    DefaultTableModel model = (DefaultTableModel) marketBuyJTable.getModel();   
    model.setRowCount(0);

    for (WorkRequest request : matchingOrg.getWorkQueue().getWorkRequestList()){
        InvestmentWorkRequest workRequest = (InvestmentWorkRequest)request;
        if(workRequest.getType().equalsIgnoreCase("Buy")){
            Object[] row = new Object[7];
            row[0] = workRequest;
            row[1] = workRequest.getType();
            row[2] = workRequest.getPrice();
            row[3] = workRequest.getInitialAmount();
            row[4] = workRequest.getAmount();
            row[5] = workRequest.getRequestDate();
            row[6] = workRequest.getStatus();           
            model.addRow(row);
        }
    }
    }
        
    private void populateSellTable(){
    DefaultTableModel model = (DefaultTableModel) marketSellJTable.getModel();   
    model.setRowCount(0);

        for (WorkRequest request : matchingOrg.getWorkQueue().getWorkRequestList()){
            InvestmentWorkRequest workRequest = (InvestmentWorkRequest)request;
            if(workRequest.getType().equalsIgnoreCase("Sell")){
                Object[] row = new Object[7];
                row[0] = workRequest;
                row[1] = workRequest.getType();
                row[2] = workRequest.getPrice();
                row[3] = workRequest.getInitialAmount();
                row[4] = workRequest.getAmount();
                row[5] = workRequest.getRequestDate();
                row[6] = workRequest.getStatus();         
                model.addRow(row);
            }
        }
    }  
    
//    private void populateAveragePrice(){
//        Double averagePrice = matchingOrg.calculateAveragePrice();
//        if(Double.isNaN(averagePrice)) txtMarketPrice.setText("Undefined");
//        else txtMarketPrice.setText(String.valueOf(averagePrice));
//        if(Double.isNaN(averagePrice)) txtMarketDailyPrice.setText("Undefined");
//        else {
//            if(!matchingOrg.getPricehistory().getDailyTransactionPriceList().isEmpty())
//            txtMarketDailyPrice.setText(String.valueOf(matchingOrg.getPricehistory().getDailyTransactionPriceList().get(matchingOrg.getPricehistory().getDailyTransactionPriceList().size()-1).getDealPrice()));
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        marketBuyJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnMatch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        marketSellJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMarketPrice = new javax.swing.JTextField();
        btnMatch1 = new javax.swing.JButton();
        btnMatch2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtMarketDailyPrice = new javax.swing.JTextField();
        checkBtn = new javax.swing.JButton();
        back = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        jLabel4.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel4.setText("Transaction Manager Work Area");

        marketBuyJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Work Number", "Type", "Price", "Initial Amount", "Amount", "Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(marketBuyJTable);

        jLabel1.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        jLabel1.setText("Sell:");

        btnMatch.setBackground(new java.awt.Color(255, 255, 255));
        btnMatch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnMatch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/BitCoinMall/picture/match.png"))); // NOI18N
        btnMatch.setText("Match");
        btnMatch.setIconTextGap(10);
        btnMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatchActionPerformed(evt);
            }
        });

        marketSellJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Work Number", "Type", "Price", "Initial Amount", "Amount", "Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(marketSellJTable);

        jLabel2.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        jLabel2.setText("Buy:");

        jLabel3.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        jLabel3.setText("Market Average Price:");

        txtMarketPrice.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        txtMarketPrice.setText("Undefined");
        txtMarketPrice.setEnabled(false);
        txtMarketPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarketPriceActionPerformed(evt);
            }
        });

        btnMatch1.setBackground(new java.awt.Color(255, 255, 255));
        btnMatch1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnMatch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/BitCoinMall/picture/OK.png"))); // NOI18N
        btnMatch1.setText("Suspend/Unsuspend");
        btnMatch1.setIconTextGap(10);
        btnMatch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatch1ActionPerformed(evt);
            }
        });

        btnMatch2.setBackground(new java.awt.Color(255, 255, 255));
        btnMatch2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnMatch2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/BitCoinMall/picture/OK - green.png"))); // NOI18N
        btnMatch2.setText("Suspend/Unsuspend");
        btnMatch2.setIconTextGap(10);
        btnMatch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatch2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        jLabel5.setText("Daily Average Price:");

        txtMarketDailyPrice.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        txtMarketDailyPrice.setText("Undefined");
        txtMarketDailyPrice.setEnabled(false);

        checkBtn.setBackground(new java.awt.Color(255, 255, 255));
        checkBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        checkBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/BitCoinMall/picture/confrim.png"))); // NOI18N
        checkBtn.setText("check");
        checkBtn.setIconTextGap(10);
        checkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBtnActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(255, 255, 255));
        back.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/BitCoinMall/picture/back.png"))); // NOI18N
        back.setText("Back");
        back.setIconTextGap(22);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/BitCoinMall/picture/update.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setIconTextGap(25);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMatch2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMatch1))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMarketPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMarketDailyPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMatch, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(checkBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(268, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(back))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMarketDailyPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMarketPrice)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMatch1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMatch2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatchActionPerformed
           for(int i = 0; i<marketBuyJTable.getRowCount(); i++){
            InvestmentWorkRequest buyRequest = (InvestmentWorkRequest) marketBuyJTable.getValueAt(i, 0);
            if(buyRequest.getStatus().matches("Ready to trade|Trading")){
                for(int j = 0; j<marketSellJTable.getRowCount(); j++){
                    InvestmentWorkRequest sellRequest = (InvestmentWorkRequest) marketSellJTable.getValueAt(j, 0);
                    if(sellRequest.getStatus().matches("Ready to trade|Trading"))                    
                    enterprise.matchTradingRequest(buyRequest, sellRequest, ecoSystem);
	            populateBuyTable();
                    populateSellTable();
                }
            }
        }
        /** calculateAverageTransactionPrice **/
        matchingOrg.calculateAveragePrice();     
        for(Enterprise enterprise: ecoSystem.getEnterpriseNetwork().getEnterpriseList()){            
            if (enterprise instanceof InvestmentEnterprise) {
                /** calculateTotalDealPrice **/
                matchingOrg.getWorkQueue().calculateTotalBuyDealPrice((InvestmentEnterprise)enterprise);
                /** calculateSpentAndEarnEachMatch **/
                InvestmentEnterprise ie = (InvestmentEnterprise)enterprise;
                ie.calculateSpentAndEarnEachMatch();
            }
        } 
        populateBuyTable();
        populateSellTable();
//        populateAveragePrice();
        alreadyMatched = true;
        JOptionPane.showMessageDialog(null, "Matched successfully");
    }//GEN-LAST:event_btnMatchActionPerformed

    private void btnMatch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatch1ActionPerformed
        int selectedrow = marketBuyJTable.getSelectedRow();
        if(selectedrow < 0){
            JOptionPane.showMessageDialog(null, "Please select any row");}       
        else{           
            InvestmentWorkRequest workRequest = (InvestmentWorkRequest) marketBuyJTable.getValueAt(selectedrow, 0);
            if(workRequest.getStatus().equalsIgnoreCase("Ready to trade")){
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Suspend selected workrequest?", "Warning", dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    workRequest.setStatus("Suspended");
                    populateBuyTable();
                    populateSellTable();
                }
            }
            else if(workRequest.getStatus().equalsIgnoreCase("Suspended")){
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Unsuspend selected workrequest?", "Warning", dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    workRequest.setStatus("Ready to trade");
                    populateBuyTable();
                    populateSellTable();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Unable to suspend selected workrequest", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
      // TODO add your handling code here:
    }//GEN-LAST:event_btnMatch1ActionPerformed

    private void btnMatch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatch2ActionPerformed
        int selectedrow = marketSellJTable.getSelectedRow();
        if(selectedrow < 0){
            JOptionPane.showMessageDialog(null, "Please select any row");}       
        else{           
            InvestmentWorkRequest workRequest = (InvestmentWorkRequest) marketSellJTable.getValueAt(selectedrow, 0);
            if(workRequest.getStatus().equalsIgnoreCase("Ready to trade")){
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Suspend selected workrequest?", "Warning", dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    workRequest.setStatus("Suspended");
                    populateBuyTable();
                    populateSellTable();
                }
            }
            else if(workRequest.getStatus().equalsIgnoreCase("Suspended")){
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Unsuspend selected workrequest?", "Warning", dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    workRequest.setStatus("Ready to trade");
                    populateBuyTable();
                    populateSellTable();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Unable to suspend selected workrequest", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }   // TODO add your handling code here:
    }//GEN-LAST:event_btnMatch2ActionPerformed

    private void txtMarketPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarketPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarketPriceActionPerformed

    private void checkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBtnActionPerformed
        int selectedRow = marketBuyJTable.getSelectedRow();
        WorkRequest workRequest = (WorkRequest) marketBuyJTable.getValueAt(selectedRow, 0);
        CheckProgress checkProgress = new CheckProgress(workRequest);
       checkProgress.setVisible(true);
    }//GEN-LAST:event_checkBtnActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
       userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        
         Organization io = null;
        for(Enterprise enterprise: ecoSystem.getEnterpriseNetwork().getEnterpriseList()){
            if(enterprise instanceof CustodyEnterprise && enterprise.getName().equalsIgnoreCase("custodyEnterprise 1")){
                for(Organization investOrg: enterprise.getOrganizationDirectory().getOrganizationList()){
                        if(investOrg instanceof CustomerServiceOrg) {
                            io = investOrg;
                        }
                }
            }
        }
        for(Enterprise enterprise: ecoSystem.getEnterpriseNetwork().getEnterpriseList()){
            if(enterprise instanceof InvestmentEnterprise && enterprise.getName().equalsIgnoreCase("Mogan")){
                for(Organization investOrg: enterprise.getOrganizationDirectory().getOrganizationList()){
                    if(investOrg instanceof InvestmentOrg) {
                        ConfigureEcoSystem.uploadExistedOrder2(matchingOrg, investOrg, io);
                        JOptionPane.showMessageDialog(null, "Update successfully", "Warning", JOptionPane.WARNING_MESSAGE);           
                    }
                }               
            }
        }        
        populateBuyTable();
        populateSellTable();
    }//GEN-LAST:event_btnUpdateActionPerformed
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton btnMatch;
    private javax.swing.JButton btnMatch1;
    private javax.swing.JButton btnMatch2;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton checkBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable marketBuyJTable;
    private javax.swing.JTable marketSellJTable;
    private javax.swing.JTextField txtMarketDailyPrice;
    private javax.swing.JTextField txtMarketPrice;
    // End of variables declaration//GEN-END:variables
}
