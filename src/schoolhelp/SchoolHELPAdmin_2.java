/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package schoolhelp;

import MyClass.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author meone
 */
public class SchoolHELPAdmin_2 extends javax.swing.JFrame {

    /**
     * Creates new form SchoolHELPAdmin_2
     */
    
    //Array list untuk menyimpan data yang ada pada school dan school admin
    ArrayList<SchoolAdmin> sa;
    ArrayList<School> s;
    
    public SchoolHELPAdmin_2() {
        //deklarsikan array list 
        sa = new ArrayList<SchoolAdmin>();
        s = new ArrayList<School>();
        initComponents();
        
        //panggil fungsi regis arraylist
        regisArrayList();
        regisArrayListSchool();
    }
    
    //fungsi untuk menampilkan nama schoolHELP Admin di sudut kiri atas pada form
    public void Display(String nama){
        NamaDisplay.setText(nama);
    }
    
    //fungsi untuk menyimpan data yang ada pada array list ke dalam file.dat
    public void savetoFile(){
        
        try{
            
            FileOutputStream file = new FileOutputStream("schoolAdmin.dat");
            ObjectOutputStream outputfile = new ObjectOutputStream(file);
            
            for (int i = 0; i < sa.size(); i++){
                outputfile.writeObject(sa.get(i));
            }
            
            outputfile.close();
            
            JOptionPane.showMessageDialog(null, "Successfully Register!!");
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Salah Disini!");
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    //fungsi untuk membaca file.dat lalu data yang ada disimpan ke dalam arraylist
    public void regisArrayList(){
        try{
            FileInputStream file = new FileInputStream("schoolAdmin.dat");
            ObjectInputStream inputfile = new ObjectInputStream(file);
            
            boolean endoffile = false;
            
            while(!endoffile){
                try {
                    sa.add((SchoolAdmin) inputfile.readObject());
                }catch (EOFException e){
                    endoffile = true;
                }catch (Exception f){
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
            
            inputfile.close();
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    //fungsi untuk membaca file.dat lalu data yang ada disimpan ke dalam arraylist
    public void regisArrayListSchool(){
        try{
            FileInputStream file = new FileInputStream("school.dat");
            ObjectInputStream inputfile = new ObjectInputStream(file);
            
            boolean endoffile = false;
            
            while(!endoffile){
                try {
                    s.add((School) inputfile.readObject());
                }catch (EOFException e){
                    endoffile = true;
                }catch (Exception f){
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
            
            inputfile.close();
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    //fungsi ngecek apakah semua data sudah teriisi atau masih ada yang kosong
    public boolean validateText(){
        if (saSchoolName.getText().isEmpty() || saUser.getText().isEmpty() || saPass.getText().isEmpty() || saName.getText().isEmpty()
                || saEmail.getText().isEmpty() || saPhone.getText().isEmpty() || saStaffID.getText().isEmpty() || saPosition.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Tolong Diisi Semua!", "Failed Login", 2);
            return false;
        }else{
            return true;
        }
    }
    
    //fungsi untuk ngecek apakah nama sekolah school admin terdaftar atau tidak 
    public boolean cekSchool(String schoolName){
        boolean cek = false;
        for (int i = 0; i < s.size(); i++){
            if (s.get(i).getSchoolName().equals(schoolName)) {
                cek = true;
                break;
            }
        }
        return cek;
    }
    
    //Lalu ambil indeksnya jika terdaftar, jika tidak maka akan mengembalikan 0
    public int cekindex(String schoolName){
        int cek = 0;
        for (int i = 0; i < s.size(); i++){
            if (s.get(i).getSchoolName().equals(schoolName)) {
                cek = i;
                break;
            }
        }
        return cek;
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
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        SchoolAdmin = new javax.swing.JButton();
        School = new javax.swing.JButton();
        LogOut = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NamaDisplay = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        regisButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        saUser = new javax.swing.JTextField();
        saPass = new javax.swing.JPasswordField();
        saName = new javax.swing.JTextField();
        saEmail = new javax.swing.JTextField();
        saPhone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        saStaffID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        saPosition = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        saSchoolName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));

        SchoolAdmin.setFont(new java.awt.Font("Bitstream Charter", 0, 24)); // NOI18N
        SchoolAdmin.setText("School Admin");
        SchoolAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SchoolAdmin.setContentAreaFilled(false);
        SchoolAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SchoolAdminActionPerformed(evt);
            }
        });
        jPanel2.add(SchoolAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 300, 50));

        School.setFont(new java.awt.Font("Bitstream Charter", 0, 24)); // NOI18N
        School.setText("School");
        School.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        School.setContentAreaFilled(false);
        School.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SchoolActionPerformed(evt);
            }
        });
        jPanel2.add(School, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 300, 50));

        LogOut.setFont(new java.awt.Font("Bitstream Charter", 0, 24)); // NOI18N
        LogOut.setText("Log Out");
        LogOut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LogOut.setContentAreaFilled(false);
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });
        jPanel2.add(LogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 300, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 300, 600));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImage/School[Dashboard].png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        jLabel2.setFont(new java.awt.Font("Bitstream Charter", 0, 24)); // NOI18N
        jLabel2.setText(" School HELP");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 250, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImage/UserProfile.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 2, -1, 50));

        NamaDisplay.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        NamaDisplay.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NamaDisplay.setText("jLabel4");
        jPanel3.add(NamaDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 300, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 50));

        jLabel5.setFont(new java.awt.Font("Bitstream Charter", 0, 48)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Register School Admin");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 900, 80));

        regisButton.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        regisButton.setText("Register");
        regisButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        regisButton.setContentAreaFilled(false);
        regisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regisButtonActionPerformed(evt);
            }
        });
        jPanel1.add(regisButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 570, 100, 30));

        jLabel6.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel6.setText("Username");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, -1, -1));

        jLabel7.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel7.setText("Password");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, -1, -1));

        saUser.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jPanel1.add(saUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 370, -1));

        saPass.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jPanel1.add(saPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, 370, -1));

        saName.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jPanel1.add(saName, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 320, 370, -1));

        saEmail.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jPanel1.add(saEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, 370, -1));

        saPhone.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jPanel1.add(saPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 370, -1));

        jLabel8.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel8.setText("Email");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, -1, -1));

        jLabel9.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel9.setText("Full Name");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, -1, -1));

        jLabel10.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel10.setText("Telepon");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, -1, -1));

        jLabel11.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel11.setText("ID Staff");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 470, -1, -1));

        saStaffID.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jPanel1.add(saStaffID, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 470, 370, -1));

        jLabel12.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel12.setText("Position");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 520, -1, -1));

        saPosition.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jPanel1.add(saPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 520, 370, -1));

        jLabel13.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel13.setText("School Name");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, -1, -1));

        saSchoolName.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jPanel1.add(saSchoolName, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 370, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Fungsi untuk menampilkan halaman daftar school
    private void SchoolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchoolActionPerformed
        // TODO add your handling code here:
        SchoolHELPAdmin sh = new SchoolHELPAdmin();
        sh.setVisible(true);
        sh.Display(NamaDisplay.getText());
        this.dispose();
    }//GEN-LAST:event_SchoolActionPerformed

    //fungsi untuk log out
    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        // TODO add your handling code here:
        loginForm l = new loginForm();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogOutActionPerformed

    //fungsi untuk regis school admin
    private void regisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regisButtonActionPerformed
        // jika data sudah terisi semua maka
        if (validateText()){
            //simpan semua data ke dalam variabel
            String schoolName = saSchoolName.getText().trim();
            String user = saUser.getText().trim();
            String pass = saPass.getText().trim();
            String Name = saName.getText().trim();
            String Email = saEmail.getText().trim();
            String Phone = saPhone.getText().trim();
            String StaffID = saStaffID.getText().trim();
            String Position = saPosition.getText().trim();
            
            //jika sekolah terdaftar 
            if (cekSchool(schoolName)){
                int indeks = cekindex(schoolName);
                //maka data akan disimpan kedalam constructor 
                SchoolAdmin SA = new SchoolAdmin(schoolName, StaffID, Position, user, pass, Name, Email, Phone);
                
                //dan data diadd ke dalam arraylist
                sa.add(SA);
                
                //lalu disimpan ke dalam file.dat
                savetoFile();
            }
        }
    }//GEN-LAST:event_regisButtonActionPerformed

    //fungsi untuk merefresh halaman
    private void SchoolAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchoolAdminActionPerformed
        // TODO add your handling code here:
        SchoolHELPAdmin_2 sh2 = new SchoolHELPAdmin_2();
        sh2.setVisible(true);
        sh2.Display(NamaDisplay.getText());
        this.dispose();
    }//GEN-LAST:event_SchoolAdminActionPerformed

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
            java.util.logging.Logger.getLogger(SchoolHELPAdmin_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchoolHELPAdmin_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchoolHELPAdmin_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchoolHELPAdmin_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchoolHELPAdmin_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogOut;
    private javax.swing.JLabel NamaDisplay;
    private javax.swing.JButton School;
    private javax.swing.JButton SchoolAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton regisButton;
    private javax.swing.JTextField saEmail;
    private javax.swing.JTextField saName;
    private javax.swing.JPasswordField saPass;
    private javax.swing.JTextField saPhone;
    private javax.swing.JTextField saPosition;
    private javax.swing.JTextField saSchoolName;
    private javax.swing.JTextField saStaffID;
    private javax.swing.JTextField saUser;
    // End of variables declaration//GEN-END:variables
}
