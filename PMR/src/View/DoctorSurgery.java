package View;

import Control.DBAccess;
import Model.Surgeries;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class DoctorSurgery extends javax.swing.JFrame {

    /**
     * Creates new form DoctorSurgery
     */
    public DoctorSurgery() {
        initComponents();
        addSurgeriesofPatients(getSurgeriesOfPatients());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label8 = new java.awt.Label();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        doc = new java.awt.TextField();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        name = new java.awt.TextField();
        aim = new java.awt.TextField();
        label4 = new java.awt.Label();
        success = new javax.swing.JComboBox<>();
        date = new java.awt.TextField();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        price = new java.awt.TextField();
        label7 = new java.awt.Label();
        DELETE = new javax.swing.JButton();
        UPDATE = new javax.swing.JButton();
        ADD = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        shawn = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        label8.setText("label8");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Patient Surgery  ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 6, -1, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel2.setText("HealthTracker");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 6, -1, -1));

        label5.setText("Price");

        label6.setText("Date");

        aim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aimActionPerformed(evt);
            }
        });

        label4.setText("Aim");

        success.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "True", "False" }));
        success.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                successActionPerformed(evt);
            }
        });

        label2.setText("Name");

        label3.setText("Doctor");

        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });

        label7.setText("IsSuccessful");

        DELETE.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        DELETE.setText("DELETE");

        UPDATE.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        UPDATE.setText("UPDATE");
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });

        ADD.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        ADD.setText("ADD");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(aim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(doc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(success, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ADD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UPDATE)
                        .addGap(16, 16, 16)
                        .addComponent(DELETE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(success, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(doc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(DELETE)
                                .addComponent(UPDATE))))
                    .addComponent(ADD, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(aim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 103, -1, -1));

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(774, 778, -1, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("SURGERY OVERVIEW");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 357, -1, 48));

        shawn.setAutoCreateRowSorter(true);
        shawn.setForeground(new java.awt.Color(0, 0, 0));
        shawn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Doctor ", "Aim", "Price", "Date", "IsSuccessfull"
            }
        ));
        jScrollPane2.setViewportView(shawn);

        jScrollPane1.setViewportView(jScrollPane2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 423, 889, 337));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/741800-safeimagekit.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        Surgeries s = getSurgeryInfo();
        DBAccess d = new DBAccess();
        d.addNewSurgery(doctor_homepage.getPatientMRN(), s);
        addSurgeriesofPatients(getSurgeriesOfPatients());
    }//GEN-LAST:event_ADDActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void successActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_successActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_successActionPerformed

    private void aimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aimActionPerformed

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UPDATEActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        this.dispose();
        doctor_homepage dh = new doctor_homepage();
        dh.setVisible(true);
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
            java.util.logging.Logger.getLogger(DoctorSurgery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorSurgery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorSurgery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorSurgery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorSurgery().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JButton Back;
    private javax.swing.JButton DELETE;
    private javax.swing.JButton UPDATE;
    private java.awt.TextField aim;
    private java.awt.TextField date;
    private java.awt.TextField doc;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.TextField name;
    private java.awt.TextField price;
    private javax.swing.JTable shawn;
    private javax.swing.JComboBox<String> success;
    // End of variables declaration//GEN-END:variables

    private void addSurgeriesofPatients(ArrayList<Surgeries> s) {
        DefaultTableModel model = (DefaultTableModel) shawn.getModel();
        model.setRowCount(0);

        if (s.size()>0){
            for (Surgeries surgery : s) {
                Object[] rowData = {
                    surgery.getSurgery_ID(),
                    surgery.getSurgery_Name(),
                    surgery.getDoctor_ID(),
                    surgery.getAim(),
                    surgery.getPrice(),
                    surgery.getDate(),
                    surgery.isSuccessful()
                };
                model.addRow(rowData);
            }
        }
    }
   
     public ArrayList<Surgeries> getSurgeriesOfPatients(){
        DBAccess d = new DBAccess();
        ArrayList<Surgeries> s = d.getSurgeriesFromMRN(doctor_homepage.getPatientMRN());
        return s;
    }

    private Surgeries getSurgeryInfo() {
        Surgeries s = new Surgeries();
        s.setAim(aim.getText().toString());
        s.setDate(date.getText().toString());
        s.setDoctor_ID(Integer.parseInt(doc.getText().toString()));
        s.setPatient_ID(doctor_homepage.getPatientMRN());
        if (success.getSelectedItem().toString() == "True")
            s.setSuccessful(true);
        else
            s.setSuccessful(false);
        s.setSurgery_Name(name.getText().toString());
        return s;
    }
}
