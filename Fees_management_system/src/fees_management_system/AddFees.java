/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_management_system;


import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

//import java.text.NumberFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;



/**
 *
 * @author RITIK CHAUHAN
 */
public class AddFees extends javax.swing.JFrame {

    /**
     * Creates new form AddFees
     */
    public void displayCashFirst(){
        lbl_dd_num.setVisible(false);
        lbl_cheque_num.setVisible(false);
        lbl_bank_name.setVisible(false);
        txt_dd_num.setVisible(false);
        txt_cheque_num.setVisible(false);
        txt_bank_name.setVisible(false);
        txt_rec_name.setVisible(true);
        lbl_r_name.setVisible(true);
        
        
    }
    public String insertData(){
        int receiptno=Integer.parseInt(txt_receipt_num.getText());
        String sname=txt_rec_name.getText();
        String rollno=lbl_rollno.getText();
        String paymentmode=combo_mode_payment.getSelectedItem().toString();
        String chequeno=txt_cheque_num.getText();
        String bankname=txt_bank_name.getText();
        String ddno=txt_dd_num.getText();
        String field=combo_course.getSelectedItem().toString();
        String gst=jLabel8.getText();
        float total=Float.parseFloat(txt_total.getText());
        System.out.println(total);
        SimpleDateFormat sd1=new SimpleDateFormat("yyyy-MM-dd");
        
        String date=sd1.format(date_c.getDate());
        
        
        
        
        
        System.out.println(date);
        
        float amount=Float.parseFloat(txt_amount.getText());
        float cgst=Float.parseFloat(txt_cgst.getText());
        float sgst=Float.parseFloat(txt_sgst.getText());
        String totalinwords=txt_totalinwords.getText();
        String remark=jTextField5.getText();
        int year1=Integer.parseInt(txt_fromyear.getText());
        int year2=Integer.parseInt(txt_toyear.getText());
         String status="";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
            Connection con= DriverManager.getConnection(url,"root","root");
            String sql= "insert into fees_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, receiptno);
            st.setString(2, sname);
            st.setString(3, rollno);
            st.setString(4, paymentmode);
            st.setString(5, chequeno);
            st.setString(6, bankname);
            st.setString(7, ddno);
            st.setString(8, field);
            st.setString(9, gst);
            st.setFloat(10, total);
            st.setString(11, date);
            st.setFloat(12, amount);
            st.setFloat(13, cgst);
            st.setFloat(14, sgst);
            st.setString(15, totalinwords);
            st.setString(16, remark);
            st.setInt(17, year1);
            st.setInt(18, year2);
          int count=  st.executeUpdate();
          
            if(count==1){
                status="Success";
            }
            else{
                status="Failed";
            }
            
            
        }
        catch(Exception e1){
            e1.printStackTrace();
        }
        return status;
        
    }
    public AddFees() {
        initComponents();
        
        displayCashFirst();
        //fillComboBox();
        
        int r=getRnu();
        r++;
        txt_receipt_num.setText(Integer.toString(r));
    }

   // private void fillComboBox() {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}
    public class NumberToWordsConverter {

	public static final String[] units = { "", "One", "Two", "Three", "Four",
			"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };

	public static final String[] tens = { 
			"", 		// 0
			"",		// 1
			"Twenty", 	// 2
			"Thirty", 	// 3
			"Forty", 	// 4
			"Fifty", 	// 5
			"Sixty", 	// 6
			"Seventy",	// 7
			"Eighty", 	// 8
			"Ninety" 	// 9
	};

	public static String convert(final int n) {
		if (n < 0) 
                {
			return "Minus " + convert(-n);
		}

		if (n < 20) 
                {
			return units[n];
		}

		if (n < 100) {
			return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
		}

		if (n < 1000) {
			return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
		}

		if (n < 100000) {
			return convert(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
		}

		if (n < 10000000) {
			return convert(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
		}

		return convert(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
	}

	public static void main(final String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the Amount : ");
		int n=sc.nextInt();

		
		System.out.println( convert(n)+ " Only");

	
	}
}
    boolean validation(){
    if(txt_rec_name.getText().equals("")){
        JOptionPane.showMessageDialog(this,"Please enter receiver name");
         return false;
    }
    if(date_c.getDate()==null){
        JOptionPane.showMessageDialog(this,"Please enter Date");
         return false;
    }
    if(txt_amount.getText().equals("") || txt_amount.getText().matches("[0-9]+")==false){
        JOptionPane.showMessageDialog(this,"Please enter amount(in numbers)");
         return false;
    }
    if(combo_mode_payment.getSelectedItem().toString().equalsIgnoreCase("cheque")){
        if(txt_cheque_num.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Plesae enter the cheque number");
            return false;
        }
        if(txt_bank_name.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Plesae enter bank name");
            return false;
        }
        
        
        if(combo_mode_payment.getSelectedItem().toString().equalsIgnoreCase("dd")){
        if(txt_dd_num.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Plesae enter the DD number");
            return false;
        }
        if(txt_bank_name.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Plesae enter bank name");
            return false;
        }
        if(combo_mode_payment.getSelectedItem().toString().equalsIgnoreCase("phonepay")){
        if(txt_dd_num.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Plesae enter the DD number");
            return false;
        }
        if(txt_bank_name.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Plesae enter bank name");
            return false;
        }
                
                
        }
        
   
        }
    }
     return true;
    }
   
//            
       
    

     public int getRnu(){
         int rno=0;
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             String url="jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
             Connection con=DriverManager.getConnection(url,"root","root");
             String sql ="select max(reciept_no) from fees_details";
             PreparedStatement st=con.prepareStatement(sql);
             ResultSet rs=st.executeQuery();
             if(rs.next()==true){
                 rno=rs.getInt(1);
             }
         }
         catch(Exception e){
             e.printStackTrace();
         }
         return rno;
         
     }
    
        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
  @SuppressWarnings("unchecked")
//  Generated code;
  
    
  
  
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btn_back = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbl_dd_num = new javax.swing.JLabel();
        lbl_receipt_num = new javax.swing.JLabel();
        lbl_mode_payment = new javax.swing.JLabel();
        lbl_cheque_num = new javax.swing.JLabel();
        txt_receipt_num = new javax.swing.JTextField();
        txt_dd_num = new javax.swing.JTextField();
        txt_bank_name = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        date_c = new com.toedter.calendar.JDateChooser();
        lbl_gst_in = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        lbl_bank_name = new javax.swing.JLabel();
        combo_mode_payment = new javax.swing.JComboBox<>();
        txt_cheque_num = new javax.swing.JTextField();
        lbl_mode_payment1 = new javax.swing.JLabel();
        combo_course = new javax.swing.JComboBox<>();
        jButton8 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_toyear = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_fromyear = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        txt_amount = new javax.swing.JTextField();
        txt_cgst = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_sgst = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_totalinwords = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        txt_rec_name = new javax.swing.JTextField();
        lbl_r_name = new javax.swing.JLabel();
        lbl_rollno = new javax.swing.JLabel();
        txt_roll_no = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_back.setBackground(new java.awt.Color(51, 51, 255));
        btn_back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("Back");
        btn_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_backMouseClicked(evt);
            }
        });
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jPanel2.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 180, 45));

        jButton2.setBackground(new java.awt.Color(51, 51, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Home");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 180, 45));

        jButton3.setBackground(new java.awt.Color(51, 51, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Course List");
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 180, 45));

        jButton5.setBackground(new java.awt.Color(51, 51, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Search Record");
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 180, 45));

        jButton6.setBackground(new java.awt.Color(51, 51, 255));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Add Course");
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 180, 45));

        jButton7.setBackground(new java.awt.Color(51, 51, 255));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Logout");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 180, 45));

        jPanel4.setBackground(new java.awt.Color(255, 51, 102));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/bits.jpeg"))); // NOI18N
        jLabel27.setText("jLabel2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, -1));

        jButton4.setBackground(new java.awt.Color(51, 51, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("View All Record");
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 180, 45));

        jButton10.setBackground(new java.awt.Color(51, 51, 255));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Edit Course");
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 180, 45));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 670));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_dd_num.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_dd_num.setText("DD No");
        jPanel1.add(lbl_dd_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 130, 30));

        lbl_receipt_num.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_receipt_num.setText("Receipt No");
        jPanel1.add(lbl_receipt_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 80, 30));

        lbl_mode_payment.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_mode_payment.setText("Mode of Payment");
        jPanel1.add(lbl_mode_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, 30));

        lbl_cheque_num.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_cheque_num.setText("Cheque No");
        jPanel1.add(lbl_cheque_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 130, 30));

        txt_receipt_num.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_receipt_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_receipt_numActionPerformed(evt);
            }
        });
        jPanel1.add(txt_receipt_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 120, 30));

        txt_dd_num.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_dd_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dd_numActionPerformed(evt);
            }
        });
        jPanel1.add(txt_dd_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 120, 30));

        txt_bank_name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_bank_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bank_nameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_bank_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 120, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("AVC56755HJ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 100, 30));
        jPanel1.add(date_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 130, 30));

        lbl_gst_in.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_gst_in.setText("GSTIN");
        jPanel1.add(lbl_gst_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 60, 30));

        lbl_date.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_date.setText("Date");
        jPanel1.add(lbl_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 60, 30));

        lbl_bank_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_bank_name.setText("Bank Name");
        jPanel1.add(lbl_bank_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 80, 30));

        combo_mode_payment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CASH", "DD", "PhonePay", "Cheque" }));
        combo_mode_payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_mode_paymentActionPerformed(evt);
            }
        });
        jPanel1.add(combo_mode_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 120, 30));

        txt_cheque_num.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_cheque_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cheque_numActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cheque_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 120, 30));

        lbl_mode_payment1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_mode_payment1.setText("      FIELD");
        jPanel1.add(lbl_mode_payment1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 130, 30));

        combo_course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CSE", "ME", "EE", "IT", "PHARMACY" }));
        combo_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_courseActionPerformed(evt);
            }
        });
        jPanel1.add(combo_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 120, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 650, 180));

        jButton8.setText("jButton8");
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("From year");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 80, 30));

        txt_toyear.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_toyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_toyearActionPerformed(evt);
            }
        });
        jPanel3.add(txt_toyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 130, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("To year");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 80, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Sr.No");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1237, 119, 80, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Rollno");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1117, 70, 60, 30));

        jSeparator1.setBackground(new java.awt.Color(255, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(153, 102, 255));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 858, -1));

        jSeparator2.setBackground(new java.awt.Color(255, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(153, 102, 255));
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 638, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("          Head");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(832, 119, 128, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("    Amount");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1073, 119, 80, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Sr No.");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(644, 119, 80, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("          Head");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 143, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Amount");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 174, 80, 30));

        txt_fromyear.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_fromyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fromyearActionPerformed(evt);
            }
        });
        jPanel3.add(txt_fromyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 130, 30));

        jTextField7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 229, 30));

        txt_amount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });
        txt_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_amountKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_amountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_amountKeyTyped(evt);
            }
        });
        jPanel3.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 170, 30));

        txt_cgst.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_cgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cgstActionPerformed(evt);
            }
        });
        jPanel3.add(txt_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 170, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Sr No.");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 174, 80, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("CGST 7%");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 80, 30));

        txt_sgst.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_sgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sgstActionPerformed(evt);
            }
        });
        jPanel3.add(txt_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 170, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("SGST7%");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 80, 30));

        jSeparator3.setBackground(new java.awt.Color(255, 51, 51));
        jSeparator3.setForeground(new java.awt.Color(153, 102, 255));
        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 858, -1));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 0));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Total");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 80, 30));

        txt_total.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });
        jPanel3.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 170, 30));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Total in Words");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 110, 30));

        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 250, 40));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("Remark");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 110, 30));

        jLabel19.setBackground(new java.awt.Color(255, 51, 51));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Reciever Signature");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 140, 40));

        txt_totalinwords.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_totalinwords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalinwordsActionPerformed(evt);
            }
        });
        jPanel3.add(txt_totalinwords, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 300, 30));

        jButton9.setBackground(new java.awt.Color(0, 0, 0));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Print");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, -1, -1));

        txt_rec_name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_rec_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rec_nameActionPerformed(evt);
            }
        });
        jPanel3.add(txt_rec_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 220, 30));

        lbl_r_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_r_name.setText("Reciever Name");
        jPanel3.add(lbl_r_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 30));

        lbl_rollno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_rollno.setText("Roll no");
        jPanel3.add(lbl_rollno, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 50, 30));

        txt_roll_no.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_roll_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_roll_noActionPerformed(evt);
            }
        });
        jPanel3.add(txt_roll_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 120, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 640, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    private void txt_toyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_toyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_toyearActionPerformed

    private void txt_receipt_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_receipt_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_receipt_numActionPerformed

    private void txt_dd_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dd_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dd_numActionPerformed

    private void txt_bank_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bank_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bank_nameActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void txt_fromyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fromyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fromyearActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
        String s1=txt_amount.getText();
        float amt=Float.parseFloat(s1);
        float cgst=(amt*0.07f)*10;
        float sgst=(amt*0.07f)*10;
        txt_cgst.setText(Float.toString(cgst));
        txt_sgst.setText(Float.toString(sgst));
        float t=amt+cgst+sgst;
        txt_total.setText(Float.toString(t));
       txt_totalinwords.setText(NumberToWordsConverter.convert((int)t));
        
    }//GEN-LAST:event_txt_amountActionPerformed

    private void txt_cgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cgstActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_cgstActionPerformed

    private void txt_sgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sgstActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_totalinwordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalinwordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalinwordsActionPerformed

    private void txt_cheque_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cheque_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cheque_numActionPerformed

    private void combo_mode_paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_mode_paymentActionPerformed
        if(combo_mode_payment.getSelectedIndex()==1){
            lbl_dd_num.setVisible(true);
            txt_dd_num.setVisible(true);
            lbl_bank_name.setVisible(true);
            txt_bank_name.setVisible(true);
            lbl_cheque_num.setVisible(false);
            txt_cheque_num.setVisible(false);
            txt_rec_name.setVisible(true);
            lbl_r_name.setVisible(true);
            
        }
         if(combo_mode_payment.getSelectedIndex()==0){
        lbl_dd_num.setVisible(false);
        lbl_cheque_num.setVisible(false);
        
        txt_dd_num.setVisible(false);
        txt_cheque_num.setVisible(false);
//        txt_bank_name.setVisible(false);
        txt_rec_name.setVisible(true);
        lbl_r_name.setVisible(true);
             
         }
         if(combo_mode_payment.getSelectedIndex()==3){
            
            lbl_bank_name.setVisible(true);
            txt_bank_name.setVisible(true);
            lbl_cheque_num.setVisible(true);
            lbl_dd_num.setVisible(false);
            txt_dd_num.setVisible(false);
            txt_cheque_num.setVisible(true);
            txt_rec_name.setVisible(true);
            lbl_r_name.setVisible(true);
            
        }
    }//GEN-LAST:event_combo_mode_paymentActionPerformed

    private void txt_rec_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rec_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rec_nameActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(validation()==true){
            String s=insertData();
            if(s.equals("Success")){
                JOptionPane.showMessageDialog(this,"Record Inserted Successfully..");
            }
            else{
                 JOptionPane.showMessageDialog(this,"Record Not Inserted..");
                
            }
            
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_backActionPerformed

    private void combo_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_courseActionPerformed
        // TODO add your handling code here:
        String s1=combo_course.getSelectedItem().toString();
        jTextField7.setText(s1);
    }//GEN-LAST:event_combo_courseActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        HomePage hp=new HomePage();
        hp.show();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
        HomePage hp1=new HomePage();
        hp1.show();
        this.dispose();
    }//GEN-LAST:event_btn_backMouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
       JOptionPane.showMessageDialog(this,"You logged out..");
        Login l=new Login();
        l.show();
        this.dispose();
        
    }//GEN-LAST:event_jButton7MouseClicked

    private void txt_roll_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_roll_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_roll_noActionPerformed

    private void txt_amountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_amountKeyPressed
        // TODO add your handling code here:
        String s1=txt_amount.getText();
        float amt=Float.parseFloat(s1);
        float cgst=amt*0.07f;
        float sgst=amt*0.07f;
        txt_cgst.setText(Float.toString(cgst));
        txt_sgst.setText(Float.toString(sgst));
        float t=amt+cgst+sgst;
        txt_total.setText(Float.toString(t));
       txt_totalinwords.setText(NumberToWordsConverter.convert((int)t));
        
    }//GEN-LAST:event_txt_amountKeyPressed

    private void txt_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_amountKeyReleased
        // TODO add your handling code here:
        //String s1=txt_amount.getText();
//        float amt=Float.parseFloat(s1);
//        float cgst=amt*0.07f;
//        float sgst=amt*0.07f;
//        txt_cgst.setText(Float.toString(cgst));
//        txt_sgst.setText(Float.toString(sgst));
//        float t=amt+cgst+sgst;
//        txt_total.setText(Float.toString(t));
//       txt_totalinwords.setText(NumberToWordsConverter.convert((int)t));
    }//GEN-LAST:event_txt_amountKeyReleased

    private void txt_amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_amountKeyTyped
        // TODO add your handling code here:
//        String s1=txt_amount.getText();
//        float amt=Float.parseFloat(s1);
//        float cgst=amt*0.07f;
//        float sgst=amt*0.07f;
//        txt_cgst.setText(Float.toString(cgst));
//        txt_sgst.setText(Float.toString(sgst));
//        float t=amt+cgst+sgst;
//        txt_total.setText(Float.toString(t));
//       txt_totalinwords.setText(NumberToWordsConverter.convert((int)t));
    }//GEN-LAST:event_txt_amountKeyTyped

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
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JComboBox<String> combo_course;
    private javax.swing.JComboBox<String> combo_mode_payment;
    private com.toedter.calendar.JDateChooser date_c;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lbl_bank_name;
    private javax.swing.JLabel lbl_cheque_num;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_dd_num;
    private javax.swing.JLabel lbl_gst_in;
    private javax.swing.JLabel lbl_mode_payment;
    private javax.swing.JLabel lbl_mode_payment1;
    private javax.swing.JLabel lbl_r_name;
    private javax.swing.JLabel lbl_receipt_num;
    private javax.swing.JLabel lbl_rollno;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_bank_name;
    private javax.swing.JTextField txt_cgst;
    private javax.swing.JTextField txt_cheque_num;
    private javax.swing.JTextField txt_dd_num;
    private javax.swing.JTextField txt_fromyear;
    private javax.swing.JTextField txt_rec_name;
    private javax.swing.JTextField txt_receipt_num;
    private javax.swing.JTextField txt_roll_no;
    private javax.swing.JTextField txt_sgst;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_totalinwords;
    private javax.swing.JTextField txt_toyear;
    // End of variables declaration//GEN-END:variables

    //private void initComponents() {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}

    

}