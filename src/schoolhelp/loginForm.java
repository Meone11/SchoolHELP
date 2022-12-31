/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package schoolhelp;

//Library yang digunkanan dalam program ini
import javax.swing.JOptionPane;
import MyClass.SchoolHELP;
import MyClass.Volunteer;
import MyClass.SchoolAdmin;
import MyClass.School;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author meone
 */
public class loginForm extends javax.swing.JFrame {

    /**
     * Creates new form loginForm
     */
    
    //Array list untuk mengambil data yang ada di dalam file 
    ArrayList<Volunteer> V;
    ArrayList<SchoolAdmin> SA;
    ArrayList<School> s;
    
    public loginForm() {
        
        V = new ArrayList<Volunteer>();
        SA = new ArrayList<SchoolAdmin>();
        s = new ArrayList<School>();
        initComponents();
        
        //Panggil regis Array List
        regisArrayList();
    }
    
    //Fungsi ini untuk mengembalikan nilai benar ketika tidak ada lagi JTextField yang kosong
    //Akan mereturn nilai salah jika masih ada yang kosong
    public boolean validateText(){
        if (lUser.getText().isEmpty() || lPass.getText().isEmpty() || lProfile.getItemAt(lProfile.getSelectedIndex()).equals("-")){
            JOptionPane.showMessageDialog(null, "Tolong Diisi Semua!", "Failed Login", 2);
            return false;
        }else{
            return true;
        }
    }
    
    //Fungsi yang digunakan untuk membaca isi dari file .dat 
    //lalu dimasukan kedalam ArrayList yang bersangkutan
    public void regisArrayList(){
        //try catch berguna untuk menangkap error apabila terjadi kesalahan dalam menjalankan program ini
        try{
            FileInputStream file = new FileInputStream("regis.dat");
            ObjectInputStream inputfile = new ObjectInputStream(file);
            
            boolean endoffile = false;
            
            while(!endoffile){
                try {
                    V.add((Volunteer) inputfile.readObject());
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
        
        try{
            FileInputStream file2 = new FileInputStream("school.dat");
            ObjectInputStream inputfile2 = new ObjectInputStream(file2);
            
            boolean endoffile = false;
            
            while(!endoffile){
                try {
                    s.add((School) inputfile2.readObject());
                }catch (EOFException e){
                    endoffile = true;
                }catch (Exception f){
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
            
            inputfile2.close();
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        try{
            FileInputStream file3 = new FileInputStream("schoolAdmin.dat");
            ObjectInputStream inputfile3 = new ObjectInputStream(file3);
            
            boolean endoffile = false;
            
            while(!endoffile){
                try {
                    SA.add((SchoolAdmin) inputfile3.readObject());
                }catch (EOFException e){
                    endoffile = true;
                }catch (Exception f){
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
            
            inputfile3.close();
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    //Fungsi ini berguna untuk ngecek pada saat login sebagai VOlunteer
    //Apakah Username & PAssword yang di input benar / tidak
    public boolean cekVolunteer(String User, String Pass){
        boolean cek = false;
        for (int i = 0; i < V.size(); i++) {
            if (User.equals(V.get(i).getUsername()) && Pass.equals(V.get(i).getPassword())) {
                cek = true;
            }
        }
        return cek;
    }
    
    //Fungsi ini bekerja hampir sama seperti cekVolunteer namun mengmbalikan indeks nya 
    //agar bisa diakses di form selanjutnnya untuk menampilkan nama dari USer
    public int getVolunteerIndex(String User, String Pass){
        int Indek = 0;
        for (int i = 0; i < V.size(); i++) {
            if (User.equals(V.get(i).getUsername()) && Pass.equals(V.get(i).getPassword())) {
                Indek = i;
            }
        }
        return Indek;
    }
    
    //Fungsi ini berguna untuk ngecek pada saat login sebagai School Admin
    //Apakah Username & PAssword yang di input benar / tidak
    public boolean cekSchoolAdmin(String User, String Pass){
        boolean cek = false;
        for (int i = 0; i < SA.size(); i++) {
            if (User.equals(SA.get(i).getUsername()) && Pass.equals(SA.get(i).getPassword())) {
                cek = true;
            }
        }
        return cek;
    }
    
    //Fungsi ini bekerja hampir sama seperti cekSchoolAdmin namun mengmbalikan indeks nya 
    //agar bisa diakses di form selanjutnnya untuk menampilkan nama dari USer
    public int getSchoolAdminIndex(String SchoolName){
        int Indek = 0;
        for (int i = 0; i < s.size(); i++) {
            if (SchoolName.equals(s.get(Indek).getSchoolName())) {
                Indek = i;
            }
        }
        return Indek;
    }
    
    //Fungsi ini untuk emndapatkan indeks dari array list schooladmin
    public int cekindex(String Username){
        int cek = 0;
        for (int i = 0; i < SA.size(); i++){
            if (SA.get(i).getUsername().equals(Username)) {
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lUser = new javax.swing.JTextField();
        lPass = new javax.swing.JPasswordField();
        lProfile = new javax.swing.JComboBox<>();
        loginButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImage/School.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, -1));

        jLabel6.setFont(new java.awt.Font("Bitstream Charter", 0, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("School HELP");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 600, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyImage/Back.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 650));

        jLabel1.setFont(new java.awt.Font("Bitstream Charter", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 600, 100));

        jLabel2.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, -1, -1));

        jLabel4.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel4.setText("Username");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, -1, -1));

        lUser.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jPanel1.add(lUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 240, 340, -1));

        lPass.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jPanel1.add(lPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 300, 340, -1));

        lProfile.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        lProfile.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "SchoolHELP Admin", "School Admin", "Volunteer" }));
        jPanel1.add(lProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, 460, -1));

        loginButton.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        loginButton.setText("Login");
        loginButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        loginButton.setContentAreaFilled(false);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jPanel1.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 410, 100, 30));

        jLabel3.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Daftar Sebagai Volunterr!");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 600, 600, 40));

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

    //Fungsi ini akan bekerja ketika kita mengklik tombol Login Button
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        //Menyalin semua yang ada di JTextField kedalam Variabel baru
        String Username = lUser.getText().trim();
        String Password = lPass.getText().trim();
        String Profile = lProfile.getItemAt(lProfile.getSelectedIndex());
        
        //cek apakah masih ada JTextField yang masih kosong 
        if (validateText()){
            //cek profile yang input untuk memilih login sebagai apa dan siapa
            if (Profile.equals("SchoolHELP Admin")){
                SchoolHELP s = new SchoolHELP();
                if (s.Login(Username, Password)){
                    //maka Form SchoolHELPAdmin Akan ditampilkan
                    SchoolHELPAdmin sh = new SchoolHELPAdmin();
                    sh.setVisible(true);
                    sh.Display("SchoolHELP Admin");
                    this.dispose();
                }
            }else if (Profile.equals("School Admin")){
                if (cekSchoolAdmin(Username, Password)){
                    int indeks = cekindex(Username);
                    int indeksSchool = getSchoolAdminIndex(SA.get(indeks).getSchoolName());
                    //maka Form SchoolAdmin Akan ditampilkan
                    SchoolAdmin_1 sa = new SchoolAdmin_1();
                    sa.setVisible(true);
                    sa.DisplayInfo(SA.get(indeks).getFullname(), SA.get(indeks).getPosition(), s.get(indeksSchool).getSchoolID(), s.get(indeksSchool).getSchoolName());
                    this.dispose();
                    JOptionPane.showMessageDialog(null, "Successfully Login!", "Success Login", 2);
                }
            }else{
                if (cekVolunteer(Username, Password)){
                    //maka Form Volunteer Akan ditampilkan
                    int indeks = getVolunteerIndex(Username, Password); 
                    Volunteer_1 v = new Volunteer_1();
                    v.setVisible(true);

                    v.Display(V.get(indeks).getFullname());
                    this.dispose();
                }                
            }
        }
        
    }//GEN-LAST:event_loginButtonActionPerformed
    
    //Fungsi ini akan bekerja ketika kita mengklik untuk register sebagai volunteer
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // Maka Form Regis akan ditampilkan
        regisForm r = new regisForm();
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked
    
    //Fungsi ini bekerja untuk keluar dari aplikasi yang kita jalankan
    //akan terjadi jika kita mengkliknya
    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel7MouseClicked

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
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField lPass;
    private javax.swing.JComboBox<String> lProfile;
    private javax.swing.JTextField lUser;
    private javax.swing.JButton loginButton;
    // End of variables declaration//GEN-END:variables
}
