package View;

import Control.DBAccess;
import Model.Doctor;
import Model.Emergency_Contacts;
import java.util.ArrayList;

public class Emergency extends javax.swing.JFrame {

    /**
     * Creates new form Emergency
     */
    public Emergency() {
        initComponents();
        fillDoctors();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        phnb = new javax.swing.JTextField();
        rel = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        next = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        doctor = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)), "Emergency Contact", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 24), new java.awt.Color(0, 51, 204))); // NOI18N

        jLabel2.setText("Name");

        jLabel4.setText("Relationship");

        jLabel3.setText("Phone Number");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phnb, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(name)
                    .addComponent(rel))
                .addContainerGap(366, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(phnb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 76, -1, -1));

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 670, -1, -1));

        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        getContentPane().add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 670, -1, -1));

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel9.setText("HealthTracker");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(727, 14, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)), "Choose Your Doctor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 24), new java.awt.Color(0, 51, 204))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorActionPerformed(evt);
            }
        });
        jPanel2.add(doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 56, 417, 81));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 790, 200));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/741800-safeimagekit.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        Newfile2 nf2 = new Newfile2();
        nf2.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_backActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        Emergency_Contacts ec = getEmergencyInfo();
        DBAccess d = new DBAccess();
        d.addEmergencyContactToMRN(ec, patientpage.getMRNOfPatient());
        d.addDRtoMedicalFile(patientpage.getMRNOfPatient(), getChosenDR());
        main_page main = new main_page();
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nextActionPerformed

    private void doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doctorActionPerformed

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
            java.util.logging.Logger.getLogger(Emergency.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Emergency.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Emergency.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Emergency.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Emergency().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JComboBox<String> doctor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField name;
    private javax.swing.JButton next;
    private javax.swing.JTextField phnb;
    private javax.swing.JTextField rel;
    // End of variables declaration//GEN-END:variables

    private Emergency_Contacts getEmergencyInfo() {
        Emergency_Contacts e = new Emergency_Contacts();
        e.setName(name.getText().toString());
        e.setPhoneNumber(phnb.getText().toString());
        e.setRelationship(rel.getText().toString());
        DBAccess d = new DBAccess();
        int SSN = d.getSSNFromMRN(patientpage.getMRNOfPatient());
        e.setPatientSSN(SSN);
        return e;
    }

    private ArrayList<Doctor> fillDoctors() {
        DBAccess d = new DBAccess();
        ArrayList<Doctor> drs =  d.getDoctors();
        doctor.removeAllItems();
        for (Doctor dr : drs)
            doctor.addItem(dr.toString());
        return drs;
    }
    public int getChosenDR(){
        ArrayList<Doctor> drs = fillDoctors();
        int index = doctor.getSelectedIndex();
        Doctor d = drs.get(index);
        int id = d.getDoctorId();
        return id;
    }
}
