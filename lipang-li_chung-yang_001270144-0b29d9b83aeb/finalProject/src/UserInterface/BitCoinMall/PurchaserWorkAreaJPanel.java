/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.BitCoinMall;




import Business.BitCoinMall.MasterOrderCatalog;
import Business.BitCoinMall.Order;
import Business.EcoSystem;
import Business.Enterprise.DepositEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.InvestmentEnterprise;
import Business.Enterprise.MallEnterprise;
import Business.Organization.AccountingOrg;
import Business.Organization.LogisticsOrg;
import Business.UserAccount.UserAccount;
import UserInterface.ShortMessage.ShortMessageJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;
/**
 *
 * @author JIN
 */
public class PurchaserWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminWorkAreaJPanel
     */
    private JPanel upc;
    private UserAccount account;
    private LogisticsOrg logisticsorg;
    private InvestmentEnterprise enterprise;
    private EcoSystem ecoSystem;
    private MallEnterprise mallenterprise;
    public PurchaserWorkAreaJPanel(JPanel upc, UserAccount account, LogisticsOrg logisticsorg, Enterprise enterprise, EcoSystem ecoSystem) {
        initComponents();
        setSize(800,600);
        this.account = account;
        this.upc =upc;
        this.logisticsorg = logisticsorg;
        this.enterprise = (InvestmentEnterprise) enterprise;
        this.ecoSystem = ecoSystem;          
        setBackground(new java.awt.Color(204, 255, 204));

        
        for(Enterprise search:ecoSystem.getEnterpriseNetwork().getEnterpriseList()){
            if(search.getName().equals("BitCoinMall"))
            {
                mallenterprise=(MallEnterprise)search;                           
                }
        }
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBrowseProduct = new javax.swing.JButton();
        btnViewOrderHistory = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbl_show_thephoto = new javax.swing.JLabel();
        btnViewOrderHistory1 = new javax.swing.JButton();

        btnBrowseProduct.setText("Browse Product");
        btnBrowseProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseProductActionPerformed(evt);
            }
        });

        btnViewOrderHistory.setText("View Order History");
        btnViewOrderHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOrderHistoryActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel4.setText("Purchaser Work Area");

        lbl_show_thephoto.setBackground(new java.awt.Color(255, 255, 204));
        lbl_show_thephoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/purchaser.jpg"))); // NOI18N
        lbl_show_thephoto.setOpaque(true);

        btnViewOrderHistory1.setText("InMail");
        btnViewOrderHistory1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOrderHistory1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnViewOrderHistory1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBrowseProduct, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnViewOrderHistory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(lbl_show_thephoto)
                .addGap(107, 107, 107))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBrowseProduct)
                        .addGap(18, 18, 18)
                        .addComponent(btnViewOrderHistory)
                        .addGap(18, 18, 18)
                        .addComponent(btnViewOrderHistory1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lbl_show_thephoto)))
                .addContainerGap(293, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseProductActionPerformed
        DepositEnterprise de = (DepositEnterprise) ecoSystem.getEnterpriseNetwork().searchByName("Universal Bank");
        BitCoinMallJPanel bcjp = new BitCoinMallJPanel(upc,logisticsorg,mallenterprise,enterprise,de);
        upc.add("BitCoinMallJPanel", bcjp);
        CardLayout cardLayout = (CardLayout) upc.getLayout();
        cardLayout.next(upc);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBrowseProductActionPerformed

    private void btnViewOrderHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOrderHistoryActionPerformed
        DepositEnterprise de = (DepositEnterprise) ecoSystem.getEnterpriseNetwork().searchByName("Universal Bank");
        PurchaserViewOrderHistoryJPanel pvohjp = new PurchaserViewOrderHistoryJPanel(upc, logisticsorg,mallenterprise,enterprise,de);
        upc.add("PurchaserViewOrderHistoryJPanel",pvohjp);
        CardLayout cardLayout = (CardLayout) upc.getLayout();
        cardLayout.next(upc);
    }//GEN-LAST:event_btnViewOrderHistoryActionPerformed

    private void btnViewOrderHistory1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOrderHistory1ActionPerformed
        ShortMessageJPanel smjp = new ShortMessageJPanel(upc, account, ecoSystem);
        upc.add("ShortMessageJPanel_SysAdmin", smjp);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.next(upc);        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewOrderHistory1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseProduct;
    private javax.swing.JButton btnViewOrderHistory;
    private javax.swing.JButton btnViewOrderHistory1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbl_show_thephoto;
    // End of variables declaration//GEN-END:variables
}
