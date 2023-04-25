/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_management_system;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;




/**
 *
 * @author RITIK CHAUHAN
 */
public class Signup extends javax.swing.JFrame {

    
     String fname,lname,uname,pass,conf_pass,cont_no;
    Date dob;
    int id=0;
    public Signup() {
        initComponents();
    }
    
    public int getId(){
        ResultSet rs=null;
        try{
            //com.mysql.cj.jdbc.Driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url="jdbc:mysql://localhost:3306/mysql";
                Connection con=DriverManager.getConnection(url,"root","root");
                String sql="select max(id) from signup";
                Statement st=con.createStatement();
                rs=st.executeQuery(sql);
                while(rs.next()){
                  
                    id=rs.getInt(1);
                     id++;
                     
                }
                con.close();
        }
        catch(Exception e){
            System.out.println("Connection failed..");
          
            e.printStackTrace();
            
        }
        return id;
       
        

}
      boolean validation(){
        fname=txtfname.getText();
        lname=txtlname.getText();
        uname=txtuname.getText();
        pass=txtpfield.getText();
        conf_pass=txtcpfield.getText();
        dob=txtdob.getDate();
        cont_no=txtcnumber.getText();
        if(fname.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter the firstname");
            return false;
        }
        if(fname.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter the firstname");
            return false;
        }
        if(lname.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter the lastname");
            return false;
        }
        if(uname.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter the username");
            return false;
        }
        if(pass.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter the password");
            return false;
        }
        if(conf_pass.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter  password again");
            return false;
        }
        if(dob.equals(null))
        {
            JOptionPane.showMessageDialog(this,"Please enter the DOB");
            return false;
        }
        if(cont_no.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter  mobile number");
            return false;
        }
        if(pass.length()<8)
            {
                lblpassworderror.setText("Password Should be of 8 digits.");
                return false;
            }
            
            if(!pass.equals(conf_pass))
            {
            JOptionPane.showMessageDialog(this, "Password Not Matched.");
            return false;
            
            }
            System.out.println(dob);
            return true;
            
        
        
        
        
    }
      public void passwordCheck()
     {
        pass=txtpfield.getText();
        if(pass.length()>=8){
            lblpassworderror.setText("");
        }
        else{
            lblpassworderror.setText("Enter 8 digits password");
        }
        
    }
      public void mobileCheck(){
        cont_no=txtcnumber.getText();
       if(cont_no.length()==10){
            lblcnumbererror.setText("");
       }
       else{
            lblcnumbererror.setText("Enter 10 digit number");
       }
    }
        void insertData(){
            System.out.println(dob);
            SimpleDateFormat s1=new SimpleDateFormat("yyyy-MM-dd");
            
            String dob1=s1.format(dob);
        
            
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
         
        
                String url="jdbc:mysql://localhost:3306/mysql";
                Connection con=DriverManager.getConnection(url,"root","root");
               
                String sql="insert into signup values(?,?,?,?,?,?,?)";
                PreparedStatement st =con.prepareStatement(sql);
                st.setInt(1,getId());
                st.setString(2,fname);
                st.setString(3,lname);
                st.setString(4,uname);
                st.setString(5,pass);
                st.setString(6,dob1);
                st.setString(7,cont_no);
                int i=st.executeUpdate();
                if(i>0)
                {
                    JOptionPane.showMessageDialog(this,"Record inserted succesfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Record not inserted succesfully");
                }
}
        
            catch(Exception e){
                e.printStackTrace();
    
                
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtlname = new javax.swing.JTextField();
        txtuname = new javax.swing.JTextField();
        txtcnumber = new javax.swing.JTextField();
        txtfname = new javax.swing.JTextField();
        txtcpfield = new javax.swing.JPasswordField();
        txtpfield = new javax.swing.JPasswordField();
        txtdob = new com.toedter.calendar.JDateChooser();
        btnlogin = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btnsignup = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblpassworderror = new javax.swing.JLabel();
        lblcnumbererror = new javax.swing.JLabel();
        lblcpassworderror1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 203, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("First Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Mobile");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("D.O.B");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Last Name");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("UserName");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Password");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Confirm Password");

        txtlname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtuname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtcnumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtcnumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcnumberKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcnumberKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcnumberKeyTyped(evt);
            }
        });

        txtfname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtcpfield.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtpfield.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtpfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpfieldActionPerformed(evt);
            }
        });
        txtpfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpfieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpfieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpfieldKeyTyped(evt);
            }
        });

        btnlogin.setBackground(new java.awt.Color(51, 51, 255));
        btnlogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnlogin.setForeground(new java.awt.Color(255, 255, 255));
        btnlogin.setText("Login");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        btnclear.setBackground(new java.awt.Color(51, 51, 255));
        btnclear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnclear.setForeground(new java.awt.Color(255, 255, 255));
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        btnsignup.setBackground(new java.awt.Color(51, 0, 255));
        btnsignup.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnsignup.setForeground(new java.awt.Color(255, 255, 255));
        btnsignup.setText("Signup");
        btnsignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsignupActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));

        lblpassworderror.setBackground(new java.awt.Color(255, 255, 204));
        lblpassworderror.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblpassworderror.setForeground(new java.awt.Color(255, 0, 51));

        lblcnumbererror.setBackground(new java.awt.Color(255, 255, 204));
        lblcnumbererror.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblcnumbererror.setForeground(new java.awt.Color(255, 0, 51));

        lblcpassworderror1.setBackground(new java.awt.Color(255, 255, 204));
        lblcpassworderror1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblcpassworderror1.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtdob, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtcnumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtuname, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcpfield, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtpfield, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblpassworderror, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblcnumbererror, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(btnsignup, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(612, Short.MAX_VALUE)
                    .addComponent(lblcpassworderror1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(208, 208, 208)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtuname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(21, 21, 21))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtpfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblpassworderror, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtcpfield, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtdob, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtcnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblcnumbererror, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsignup, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(216, 216, 216)
                    .addComponent(lblcpassworderror1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(233, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 820, 480));

        jPanel3.setBackground(new java.awt.Color(51, 0, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sign Up");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jLabel1)
                .addContainerGap(376, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsignupActionPerformed
      if(validation()){
          insertData();
          
      }  
        Login l1=new Login();
        l1.show();
        this.dispose();
      
     
    }//GEN-LAST:event_btnsignupActionPerformed

    private void txtpfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpfieldActionPerformed
        
    }//GEN-LAST:event_txtpfieldActionPerformed

    private void txtpfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpfieldKeyPressed
        passwordCheck();
    }//GEN-LAST:event_txtpfieldKeyPressed

    private void txtpfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpfieldKeyReleased
        passwordCheck();
    }//GEN-LAST:event_txtpfieldKeyReleased

    private void txtpfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpfieldKeyTyped
        passwordCheck();
    }//GEN-LAST:event_txtpfieldKeyTyped

    private void txtcnumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcnumberKeyPressed
        mobileCheck();
    }//GEN-LAST:event_txtcnumberKeyPressed

    private void txtcnumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcnumberKeyReleased
        mobileCheck();
    }//GEN-LAST:event_txtcnumberKeyReleased

    private void txtcnumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcnumberKeyTyped
        mobileCheck();
    }//GEN-LAST:event_txtcnumberKeyTyped

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        Login l1=new Login();
        l1.show();
        this.dispose();
    }//GEN-LAST:event_btnloginActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
       txtfname.setText("");
        txtlname.setText("");
        txtuname.setText("");
        txtpfield.setText("");
        txtcpfield.setText("");
           txtdob.getDate();
        txtcnumber.setText("");
        
    }//GEN-LAST:event_btnclearActionPerformed
   
        
      

  //private void passwordCheck() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

//    private void mobileCheck() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

//    private void validation() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
            
        
 
     
    
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
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton btnsignup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblcnumbererror;
    private javax.swing.JLabel lblcpassworderror1;
    private javax.swing.JLabel lblpassworderror;
    private javax.swing.JTextField txtcnumber;
    private javax.swing.JPasswordField txtcpfield;
    private com.toedter.calendar.JDateChooser txtdob;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtlname;
    private javax.swing.JPasswordField txtpfield;
    private javax.swing.JTextField txtuname;
    // End of variables declaration//GEN-END:variables

}