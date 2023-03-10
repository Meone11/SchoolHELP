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
import javax.swing.table.TableModel;
/**
 *
 * @author meone
 */
public class Volunteer_1 extends javax.swing.JFrame {

    /**
     * Creates new form Volunteer_1
     */
    
    //Array list untuk menyimpan data dari object
    ArrayList<Tutorial> t;
    ArrayList<Resource> r;
    
    //fungsi untuk mendapatkan model dari table
    DefaultTableModel model;
    
    //fungsi untuk membuat value dari table menjadi center
    CenterText center = new CenterText();
    
    public Volunteer_1() {
        
        //dekalrasikan arraylist
        r = new ArrayList<Resource>();
        t = new ArrayList<Tutorial>();
        
        initComponents();
        
        //panggil fungsi regis array list
        regisArrayList();
        regisArrayListTutor();
    }
    
    //fungsi untuk menampilkan nama dari volunteer di sudut kiri atas dari form
    public void Display(String nama){
        NamaDisplay.setText(nama);
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
    
    //fungsi untuk mengisi value table dari data yang ada di array list
    public void fillTable(){
        
        //Set VAlue to Center
        for (int i = 0; i < TableReq.getColumnCount(); i++){
            TableReq.getColumnModel().getColumn(i).setCellRenderer(center);
        }
        
        //set Tbale Header to Center
        JTableHeader header = TableReq.getTableHeader();
        ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        
        //Set Column Width
        TableReq.getColumnModel().getColumn(0).setPreferredWidth(50); //Kolom No
        TableReq.getColumnModel().getColumn(1).setPreferredWidth(70); // Kolom Request ID
        TableReq.getColumnModel().getColumn(2).setPreferredWidth(150); // Kolon Request Date
        TableReq.getColumnModel().getColumn(3).setPreferredWidth(100); // Kolom Status
        TableReq.getColumnModel().getColumn(4).setPreferredWidth(200); // Kolom Desc
        
        //Isi Data ke Dalam Table 
        int i = 0;
        for (Resource obj : r){
            if (obj.getRequestStatus().equals("PENDING")){
                model.addRow(new Object[]{++i, obj.getRequestID(), obj.getRequestDate(), obj.getRequestStatus(), obj.getDescription()});
            }
        }
        for(Tutorial o : t){
            if (o.getRequestStatus().equals("PENDING")){
                model.addRow(new Object[]{++i, o.getRequestID(), o.getRequestDate(), o.getRequestStatus(), o.getDescription()});
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        SubmitOffer = new javax.swing.JButton();
        ViewRequest = new javax.swing.JButton();
        LogOut = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NamaDisplay = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableReq = new javax.swing.JTable();
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

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));

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
        jLabel5.setText("View Request");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 900, 60));

        TableReq.setBackground(new java.awt.Color(153, 153, 153));
        TableReq.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
        TableReq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Request ID", "Request Date", "Status", "Description"
            }
        ));
        jScrollPane1.setViewportView(TableReq);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 800, 440));

        Submit.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        Submit.setText("Submit");
        Submit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Submit.setContentAreaFilled(false);
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });
        jPanel1.add(Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 570, 100, 30));

        Cancel.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
        Cancel.setText("Cancel");
        Cancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Cancel.setContentAreaFilled(false);
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        jPanel1.add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 570, 100, 30));

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

    //fungsi untuk ke halaman submit offer
    private void SubmitOfferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitOfferActionPerformed
        // TODO add your handling code here:
        Volunteer_2 v2 = new Volunteer_2();
        v2.setVisible(true);
        v2.Display(NamaDisplay.getText());
        this.dispose();
    }//GEN-LAST:event_SubmitOfferActionPerformed

    //fungsi /event handle ini akan bekerja ketika form ini terbuka
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        try{
            //mendapatkan mdoel dari table 
            model = (DefaultTableModel) TableReq.getModel();
            //ngeset value dari table menjadi 0
            model.setRowCount(0);
            //dan mengisi value dari tabel
            fillTable();
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_formWindowOpened

    //fungsi untuk log out atau ke halaman login
    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        // TODO add your handling code here:
        loginForm l = new loginForm();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogOutActionPerformed

    //fungsi untuk merefresh halaman
    private void ViewRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewRequestActionPerformed
        // TODO add your handling code here:
        Volunteer_1 v1 = new Volunteer_1();
        v1.setVisible(true);
        v1.Display(NamaDisplay.getText());
        this.dispose();
    }//GEN-LAST:event_ViewRequestActionPerformed

    //fungsi untuk mengajukan penawaran
    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        // mendapatkan row yang dipilih
        int indeks = TableReq.getSelectedRow();
        //mengambil req id dari table
        String ReqID = model.getValueAt(indeks, 1).toString();
        //maka akan otomatis menampilkan halaman submit offers
        Volunteer_2 v2 = new Volunteer_2();
        v2.setVisible(true);
        v2.filltoForm(ReqID);
        v2.Display(NamaDisplay.getText());
        this.dispose();
    }//GEN-LAST:event_SubmitActionPerformed

    //fungsi untuk membatalkan penawaran
    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:
        Volunteer_1 v1 = new Volunteer_1();
        v1.setVisible(true);
        v1.Display(NamaDisplay.getText());
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
            java.util.logging.Logger.getLogger(Volunteer_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Volunteer_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Volunteer_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Volunteer_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Volunteer_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JButton LogOut;
    private javax.swing.JLabel NamaDisplay;
    private javax.swing.JButton Submit;
    private javax.swing.JButton SubmitOffer;
    private javax.swing.JTable TableReq;
    private javax.swing.JButton ViewRequest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
