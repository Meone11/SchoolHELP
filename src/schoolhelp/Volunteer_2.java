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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author meone
 */
public class Volunteer_2 extends javax.swing.JFrame {

    /**
     * Creates new form Volunteer_2
     */
    //array list untuk menyimpan data dari object 
    ArrayList<Tutorial> t;
    ArrayList<Resource> r;
    ArrayList<Offers> o;
    
    public Volunteer_2() {
        //deklarsikan arraylist         
        t = new ArrayList<Tutorial>();
        r = new ArrayList<Resource>();
        o = new ArrayList<Offers>();
        initComponents();
        
        //panggil regisarraylist dari masing2 arraylist
        regisArrayList();
        regisArrayListOffers();        
        regisArrayListTutor();
    }
    
    //fungsi utuk menampilkan nama dari volunteer di sudut kiri atas form
    public void Display(String nama){
        NamaDisplay.setText(nama);
    }
    
    //fungsi untuk menyimpan data dari array list ke dalam file.dat
    public void savetoFile(){
        
        try{
            
            FileOutputStream file = new FileOutputStream("offers.dat");
            ObjectOutputStream outputfile = new ObjectOutputStream(file);
            
            for (int i = 0; i < o.size(); i++){
                outputfile.writeObject(o.get(i));
            }
            
            outputfile.close();
            
            JOptionPane.showMessageDialog(null, "Successfully Saved!!");
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    //fungsi untuk membaca file.dat lalu disimpan didalam arraylist
    public void regisArrayListOffers(){
        try{
            FileInputStream file = new FileInputStream("offers.dat");
            ObjectInputStream inputfile = new ObjectInputStream(file);
            
            boolean endoffile = false;
            
            while(!endoffile){
                try {
                    o.add((Offers) inputfile.readObject());
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
    
    //fungsi untuk membaca file.dat lalu disimpan didalam arraylist
    public void regisArrayList(){
        try{
            FileInputStream file = new FileInputStream("resource.dat");
            ObjectInputStream inputfile = new ObjectInputStream(file);
            
            boolean endoffile = false;
            
            while(!endoffile){
                try {
                    r.add((Resource) inputfile.readObject());
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
    
    //fungsi untuk membaca file.dat lalu disimpan didalam arraylist
    public void regisArrayListTutor(){
        try{
            FileInputStream file = new FileInputStream("tutorial.dat");
            ObjectInputStream inputfile = new ObjectInputStream(file);
            
            boolean endoffile = false;
            
            while(!endoffile){
                try {
                    t.add((Tutorial) inputfile.readObject());
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
    
    //fungsi untuk mengisi formulir penawaran berdasarkan yang kit apilih dari tabel
    public void filltoForm(String req){
        if(req.substring(0, 2).equals("RR")){
            for (int i = 0; i < r.size(); i++) {
                if (req.equals(r.get(i).getRequestID())) {
                    reqID.setText(req);
                    propDate.setText("-");
                    propTime.setText("-");
                    oLevel.setText("-");
                    oSumS.setText("-");
                    oType.setText(r.get(i).getResourceType());
                    oSumR.setText(r.get(i).getNumRequired());
                }
            }
        }else{
            for (int i = 0; i < t.size(); i++) {
                if (req.equals(t.get(i).getRequestID())) {
                    reqID.setText(req);
                    propDate.setText(t.get(i).getProposedDate());
                    propTime.setText(t.get(i).getProposedTime());
                    oLevel.setText(t.get(i).getStudentLevel());
                    oSumS.setText(t.get(i).getStudentNum());
                    oType.setText("-");
                    oSumR.setText("-");
                }
            }          
        }
    }
    
    //fungsi untuk melihat apakah semua data sudah terisi atau belum
    public boolean validateText(){
        if (oDate.getDate().equals(null) || oRemarks.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Tolong Isi Semua Data");
            return false;
        }else{
            return true;
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        ViewRequest = new javax.swing.JButton();
        SubmitOffer = new javax.swing.JButton();
        LogOut = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NamaDisplay = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Submit = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        propTime = new javax.swing.JTextField();
        oLevel = new javax.swing.JTextField();
        oSumS = new javax.swing.JTextField();
        oType = new javax.swing.JTextField();
        oSumR = new javax.swing.JTextField();
        propDate = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        reqID = new javax.swing.JTextField();
        oRemarks = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        oDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));

        ViewRequest.setFont(new java.awt.Font("Bitstream Charter", 0, 24)); // NOI18N
        ViewRequest.setText("View Request");
        ViewRequest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ViewRequest.setContentAreaFilled(false);
        ViewRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewRequestActionPerformed(evt);
            }
        });
        jPanel2.add(ViewRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 300, 50));

        SubmitOffer.setFont(new java.awt.Font("Bitstream Charter", 0, 24)); // NOI18N
        SubmitOffer.setText("Submit Offers");
        SubmitOffer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SubmitOffer.setContentAreaFilled(false);
        SubmitOffer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitOfferActionPerformed(evt);
            }
        });
        jPanel2.add(SubmitOffer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 300, 50));

        LogOut.setFont(new java.awt.Font("Bitstream Charter", 0, 24)); // NOI18N
        LogOut.setText("Log Out");
        LogOut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LogOut.setContentAreaFilled(false);
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });
        jPanel2.add(LogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 300, 50));

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
        jLabel5.setText("Submit Offers");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 900, 60));

        Submit.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        Submit.setText("Submit");
        Submit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Submit.setContentAreaFilled(false);
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });
        jPanel1.add(Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 580, 100, 30));

        Cancel.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        Cancel.setText("Cancel");
        Cancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Cancel.setContentAreaFilled(false);
        jPanel1.add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 580, 100, 30));

        jLabel6.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel6.setText("Proposed Date");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 140, -1));

        jLabel7.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel7.setText("Proposed Time");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 140, -1));

        jLabel8.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel8.setText("Student Level");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 180, -1));

        jLabel11.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel11.setText("Sum of Student");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 150, -1));

        jLabel9.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel9.setText("Resource Type");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, 160, -1));

        jLabel10.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel10.setText("Sum of Resource");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 430, 180, -1));

        propTime.setEditable(false);
        propTime.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jPanel1.add(propTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 430, -1));

        oLevel.setEditable(false);
        oLevel.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jPanel1.add(oLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, 430, -1));

        oSumS.setEditable(false);
        oSumS.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jPanel1.add(oSumS, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, 430, -1));

        oType.setEditable(false);
        oType.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jPanel1.add(oType, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, 430, -1));

        oSumR.setEditable(false);
        oSumR.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jPanel1.add(oSumR, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, 430, -1));

        propDate.setEditable(false);
        propDate.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jPanel1.add(propDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 430, -1));

        jLabel12.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel12.setText("Offer Date");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 480, 140, -1));

        jLabel13.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel13.setText("Request ID");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 140, -1));

        reqID.setEditable(false);
        reqID.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jPanel1.add(reqID, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 430, -1));

        oRemarks.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jPanel1.add(oRemarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 530, 430, -1));

        jLabel14.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        jLabel14.setText("Remarks");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 530, 140, -1));

        oDate.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
        jPanel1.add(oDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 480, 430, 30));

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

    //fungsi untuk merefresh halaman
    private void SubmitOfferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitOfferActionPerformed
        // TODO add your handling code here:
        Volunteer_2 v2 = new Volunteer_2();
        v2.setVisible(true);
        v2.Display(NamaDisplay.getText());
        this.dispose();
    }//GEN-LAST:event_SubmitOfferActionPerformed

    //fungsi untuk log otu atau kembali ke halaman login
    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        // TODO add your handling code here:
        loginForm l = new loginForm();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogOutActionPerformed

    //fungsi untuk ke halaman view request
    private void ViewRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewRequestActionPerformed
        // TODO add your handling code here:        
        Volunteer_1 v1 = new Volunteer_1();
        v1.setVisible(true);
        v1.Display(NamaDisplay.getText());
        this.dispose();
    }//GEN-LAST:event_ViewRequestActionPerformed

    //fungsi untuk mengajukan penawaran kepada schooladmin
    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        // cek apakah data sudah terisi
        if (validateText()){
            //fungsi untuk memformat date ke string
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
            String Date = dt.format(oDate.getDate());
            String Status = "PENDING";
            String Remarks = oRemarks.getText();
            String ReqID = reqID.getText();
            
            //panggil contructor dan data akan disimpan
            Offers O = new Offers(ReqID, Date, Remarks, Status);
            
            //oabject akan disimpan ke dalam arraylist
            o.add(O);
            
            //data dari arraylist akan disimpan kedalam file.dat
            savetoFile();
        }        
    }//GEN-LAST:event_SubmitActionPerformed

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
            java.util.logging.Logger.getLogger(Volunteer_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Volunteer_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Volunteer_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Volunteer_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Volunteer_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JButton LogOut;
    private javax.swing.JLabel NamaDisplay;
    private javax.swing.JButton Submit;
    private javax.swing.JButton SubmitOffer;
    private javax.swing.JButton ViewRequest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private com.toedter.calendar.JDateChooser oDate;
    private javax.swing.JTextField oLevel;
    private javax.swing.JTextField oRemarks;
    private javax.swing.JTextField oSumR;
    private javax.swing.JTextField oSumS;
    private javax.swing.JTextField oType;
    private javax.swing.JTextField propDate;
    private javax.swing.JTextField propTime;
    private javax.swing.JTextField reqID;
    // End of variables declaration//GEN-END:variables
}
