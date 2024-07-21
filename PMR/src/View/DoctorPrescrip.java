package View;

import Control.DBAccess;
import Model.Surgeries;
import javax.swing.table.DefaultTableModel;

public class DoctorPrescrip extends javax.swing.JFrame {

    /**
     * Creates new form DoctorPrescrip
     */
    public DoctorPrescrip() {
        initComponents();
        fillPresofPatient(doctor_homepage.getPatientMRN());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        pres = new java.awt.TextField();
        UPDATE = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        prescription = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(718, 738, -1, -1));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Prescription");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 6, -1, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel2.setText("HealthTracker");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 18, -1, -1));

        label1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        label1.setText("Prescription");

        UPDATE.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        UPDATE.setText("UPDATE");
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(UPDATE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(pres, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(UPDATE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 540, 110));

        prescription.setAutoCreateRowSorter(true);
        prescription.setForeground(new java.awt.Color(0, 0, 0));
        prescription.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Prescription"
            }
        ));
        jScrollPane2.setViewportView(prescription);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 317, 718, 386));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/741800-safeimagekit.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 790));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("PRESCRIPTION OVERVIEW");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 330, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
        DBAccess d = new DBAccess();
        if(pres.getText().toString() != ""){
            d.updateMedicalFileWithNewPrescriptionUsingMRN(doctor_homepage.getPatientMRN(), pres.getText().toString());
            DefaultTableModel model = (DefaultTableModel) prescription.getModel();
            model.setRowCount(0);
            fillPresofPatient(doctor_homepage.getPatientMRN());
        }
        
    }//GEN-LAST:event_UPDATEActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        doctortopatient dh = new doctortopatient();
        dh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DoctorPrescrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorPrescrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorPrescrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorPrescrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorPrescrip().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton UPDATE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private java.awt.TextField pres;
    private javax.swing.JTable prescription;
    // End of variables declaration//GEN-END:variables

    private void fillPresofPatient(int patientMRN) {
        DBAccess d = new DBAccess();
        String s = d.retrievePrescriptionFromMedicalFile(patientMRN);
        DefaultTableModel model = (DefaultTableModel) prescription.getModel();
        model.setRowCount(0);

        if (s != null){
            Object[] rowData = {
                s
            };
            model.addRow(rowData); 
        }
    }
}
