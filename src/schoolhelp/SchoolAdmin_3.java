/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package schoolhelp;
import MyClass.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
/**
 *
 * @author meone
 */
public class SchoolAdmin_3 extends javax.swing.JFrame {

    /**
     * Creates new form SchoolAdmin_3
     */
    
    //Array list untuk menyimpan object dari class
    ArrayList<Tutorial> t;
    ArrayList<Resource> r;
    ArrayList<Offers> o;
    
    //fungsi untuk membuat tulisan yang ada didalam row dari table menjadi center
    CenterText center = new CenterText();
    //fungsi untuk nge get model table
    DefaultTableModel model;
    
    public SchoolAdmin_3() {
        //deklarasikan arraylist
        t = new ArrayList<Tutorial>();
        r = new ArrayList<Resource>();
        o = new ArrayList<Offers>();
        
        initComponents();
        
        //panggil fungsi regisArraylist dari masing2 array list
        regisArrayList();
        regisArrayListOffers();        
        regisArrayListTutor();
    }
    
    //fungsi untuk mendisplay nama dari admin di sudut kiri atas form
    public void Display(String nama){
        NamaDisplay.setText(nama);
    }
    
    //fungsi untuk menmpilkan info dari school admin
    public void DisplayInfo(String nama, String Position, String id, String schoolName){
        NameAdmin.setText(nama);
        NamaDisplay.setText(nama);
        PositionAdmin.setText(Position);
        IdSchool.setText(id);
        SchoolNameAdmin.setText(schoolName);
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
    
    //fungsi untuk mengisi data kedalam Jtable 
    public void fillTable(){
        
        //mendapatkan model default dari JTabel
        model = (DefaultTableModel) TableOffer.getModel();
        
        //Set VAlue to Center
        for (int i = 0; i < TableOffer.getColumnCount(); i++){
            TableOffer.getColumnModel().getColumn(i).setCellRenderer(center);
        }
        
        //set Tbale Header to Center
        JTableHeader header = TableOffer.getTableHeader();
        ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        
        //Set Column Width
        TableOffer.getColumnModel().getColumn(0).setPreferredWidth(50); //Kolom No
        TableOffer.getColumnModel().getColumn(1).setPreferredWidth(70); // Kolom Request ID
        TableOffer.getColumnModel().getColumn(2).setPreferredWidth(150); // Kolon Offer Date
        TableOffer.getColumnModel().getColumn(3).setPreferredWidth(250); // Kolom Remarks
        TableOffer.getColumnModel().getColumn(4).setPreferredWidth(100); // Kolom Status
        
        //Isi Data ke Dalam Table 
        int i = 0;
        for (Offers obj : o){
            model.addRow(new Object[]{++i, obj.getReqID(), obj.getOfferDate(), obj.getRemarks(), obj.getOfferStatus()});
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NamaDisplay = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableOffer = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        ReviewOffer = new javax.swing.JButton();
        Tutorial = new javax.swing.JButton();
        Resource = new javax.swing.JButton();
        LogOut = new javax.swing.JButton();
        SchoolNameAdmin = new javax.swing.JLabel();
        NameAdmin = new javax.swing.JLabel();
        PositionAdmin = new javax.swing.JLabel();
        IdSchool = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Submit = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jLabel5.setText("Review Offers");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 900, 80));

        TableOffer.setBackground(new java.awt.Color(153, 153, 153));
        TableOffer.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
        TableOffer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Request ID", "Offers Date", "Remarks", "Status"
            }
        ));
        jScrollPane1.setViewportView(TableOffer);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 810, 410));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));

        ReviewOffer.setFont(new java.awt.Font("Bitstream Charter", 0, 24)); // NOI18N
        ReviewOffer.setText("Review Offers");
        ReviewOffer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ReviewOffer.setContentAreaFilled(false);
        ReviewOffer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReviewOfferActionPerformed(evt);
            }
        });
        jPanel2.add(ReviewOffer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 300, 50));

        Tutorial.setFont(new java.awt.Font("Bitstream Charter", 0, 24)); // NOI18N
        Tutorial.setText("Tutorial ");
        Tutorial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Tutorial.setContentAreaFilled(false);
        Tutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TutorialActionPerformed(evt);
            }
        });
        jPanel2.add(Tutorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 300, 50));

        Resource.setFont(new java.awt.Font("Bitstream Charter", 0, 24)); // NOI18N
        Resource.setText("Resource");
        Resource.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Resource.setContentAreaFilled(false);
        Resource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResourceActionPerformed(evt);
            }
        });
        jPanel2.add(Resource, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 300, 50));

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

        SchoolNameAdmin.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        SchoolNameAdmin.setText("jLabel6");
        jPanel2.add(SchoolNameAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 300, 30));

        NameAdmin.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        NameAdmin.setText("jLabel6");
        jPanel2.add(NameAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 300, 30));

        PositionAdmin.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        PositionAdmin.setText("jLabel6");
        jPanel2.add(PositionAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 300, 30));

        IdSchool.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        IdSchool.setText("jLabel6");
        jPanel2.add(IdSchool, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 300, 30));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 300, 10));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 300, 600));

        Submit.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        Submit.setText("Submit");
        Submit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Submit.setContentAreaFilled(false);
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });
        jPanel1.add(Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 590, 100, 30));

        Cancel.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        Cancel.setText("Refresh");
        Cancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Cancel.setContentAreaFilled(false);
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        jPanel1.add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 590, 100, 30));

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

    //Fungsi untuk merefresh halaman 
    private void ReviewOfferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReviewOfferActionPerformed
        // TODO add your handling code here:
        SchoolAdmin_3 sa3 = new SchoolAdmin_3();
        sa3.setVisible(true);
        sa3.Display(NamaDisplay.getText());
        sa3.DisplayInfo(NameAdmin.getText(), PositionAdmin.getText(), IdSchool.getText(), SchoolNameAdmin.getText());
        this.dispose();
    }//GEN-LAST:event_ReviewOfferActionPerformed

    //fungsi utnuk ke halaman resource Request
    private void ResourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResourceActionPerformed
        // TODO add your handling code here:
        SchoolAdmin_2 sa2 = new SchoolAdmin_2();
        sa2.setVisible(true);
        sa2.Display(NamaDisplay.getText());
        sa2.DisplayInfo(NameAdmin.getText(), PositionAdmin.getText(), IdSchool.getText(), SchoolNameAdmin.getText());
        this.dispose();
    }//GEN-LAST:event_ResourceActionPerformed

    //fungsi untuk kembali kehalaman login / logut
    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        // TODO add your handling code here:
        loginForm l = new loginForm();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogOutActionPerformed

    //fungsi utnuk ke halaman Tutorial Request
    private void TutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TutorialActionPerformed
        // TODO add your handling code here:
        SchoolAdmin_1 sa1 = new SchoolAdmin_1();
        sa1.setVisible(true);
        sa1.Display(NamaDisplay.getText());
        sa1.DisplayInfo(NameAdmin.getText(), PositionAdmin.getText(), IdSchool.getText(), SchoolNameAdmin.getText());
        this.dispose();
    }//GEN-LAST:event_TutorialActionPerformed

    //fungsi ini bekerja apabila form terbuka atau ditampilkna
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        try{
            //maka fungsi ini akan mengeset row dari JTable menjadi 0 dan mengisi data yang ada di arraylist
            model = (DefaultTableModel) TableOffer.getModel();
            model.setRowCount(0);
            fillTable();
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_formWindowOpened

    //fungsi untuk submit offer 
    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        // TODO add your handling code here:
        //mendaptkan row yang di select
        int index = TableOffer.getSelectedRow();
        String reqId = model.getValueAt(index, 1).toString();
        
        //Mengubah Status dari oferrs dan request
        for (int i = 0; i < o.size(); i++) {
            if (reqId.equals(o.get(index).getReqID())) {
                o.get(index).setOfferStatus("ACCEPTED");
            }
        }
        
        if (reqId.substring(0, 2).equals("RR")){
            for(int i = 0; i < r.size(); i++){
                if (reqId.equals(r.get(i).getRequestID())){
                    r.get(i).setRequestStatus("CLOSED");
                }
            }
        }else{
            for(int i = 0; i < t.size(); i++){
                if (reqId.equals(t.get(i).getRequestID())){
                    t.get(i).setRequestStatus("CLOSED");
                }
            }
        }
        
        JOptionPane.showMessageDialog(null, "Offers Sudah Diterima");
    }//GEN-LAST:event_SubmitActionPerformed

    //fungsi untuk membatalkan submit penawaran
    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:
        SchoolAdmin_3 sa3 = new SchoolAdmin_3();
        sa3.setVisible(true);
        sa3.Display(NamaDisplay.getText());
        sa3.DisplayInfo(NameAdmin.getText(), PositionAdmin.getText(), IdSchool.getText(), SchoolNameAdmin.getText());
        this.dispose();
    }//GEN-LAST:event_CancelActionPerformed

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
            java.util.logging.Logger.getLogger(SchoolAdmin_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchoolAdmin_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchoolAdmin_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchoolAdmin_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchoolAdmin_3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JLabel IdSchool;
    private javax.swing.JButton LogOut;
    private javax.swing.JLabel NamaDisplay;
    private javax.swing.JLabel NameAdmin;
    private javax.swing.JLabel PositionAdmin;
    private javax.swing.JButton Resource;
    private javax.swing.JButton ReviewOffer;
    private javax.swing.JLabel SchoolNameAdmin;
    private javax.swing.JButton Submit;
    private javax.swing.JTable TableOffer;
    private javax.swing.JButton Tutorial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
