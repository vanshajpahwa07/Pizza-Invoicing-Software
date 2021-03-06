/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirst;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;
/**
 *
 * @author vansh
 */

class mymodel1 extends javax.swing.table.AbstractTableModel 
{
    ResultSet rs;
    ResultSetMetaData rsmd;
    mymodel1(ResultSet rs1)
    {
    try
    {
        rs=rs1;
        rsmd=rs.getMetaData();
    }
    catch(Exception e)
    {
        System.out.print(e);
    }
    }
    @Override
    public int getRowCount() {
       try
        {
            rs.last();
            return rs.getRow();
        }
        catch(Exception e)
        {
            System.out.print(e);
            return -1;
        }
    }

    @Override
    public int getColumnCount() {
         try
        {
           
            return rsmd.getColumnCount();
        }
        catch(Exception e)
        {
            System.out.print(e);
            return -1;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    try{
        rs.absolute(rowIndex+1);
        return rs.getObject(columnIndex+1);
    } 
    catch(Exception e)
    {
        return null;
    }
    }
    
     public String getColumnName(int n)
    {
        try  
        {
            return rsmd.getColumnName(n+1);
        }
        catch(Exception e)
        {
         System.out.print(e);   
        return null;
        }
    }

}
public class Pizza extends javax.swing.JFrame {

    /**
     * Creates new form Pizza
     */
    public Pizza() {
        super("Pano's Pizza");
       initComponents();
      T1.setEditable(false);
      T4.setText("1");
       this.setBounds(610,180,750,820);
        try
        {
       Class.forName("com.mysql.jdbc.Driver");
       Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza","root","");
             Statement st=c.createStatement();
             ResultSet rs=st.executeQuery("select max(ID) from pizza");
           if(rs.next()){
           int i = Integer.parseInt(rs.getString(1));
           i = i+1;
           T1.setText("" + i);
           }
        }
        catch(Exception e)
        {
           // System.out.print(e);
            T1.setText("101");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jt1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        T1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        C1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        C3 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        T3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        C2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        C4 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        T4 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(255, 204, 204));
        getContentPane().setLayout(null);

        jt1.setBackground(new java.awt.Color(255, 255, 204));
        jt1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jt1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "TYPE", "CUSTOMISATION", "SIZE", "QUANTITY", "PRICE"
            }
        ));
        jt1.setGridColor(new java.awt.Color(255, 255, 255));
        jt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jt1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jt1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 550, 760, 96);

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 13)); // NOI18N
        jLabel7.setText("PIZZA ID:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 180, 70, 40);
        getContentPane().add(T1);
        T1.setBounds(80, 190, 79, 22);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfirst/panos_pizza_100x100.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(330, 10, 100, 100);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfirst/cart.png"))); // NOI18N
        jButton1.setText("ADD TO CART");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("NAME:");

        C1.setBackground(new java.awt.Color(255, 255, 204));
        C1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Margherita", "Farmhouse", "Cheese n Corn", "Peppy Paneer", "Paneer n Onion", "Golden Corn", "Capsicum", " " }));
        C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SIZE:");

        C3.setBackground(new java.awt.Color(255, 255, 204));
        C3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Small", "Medium", "Large" }));
        C3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C3ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("COST:");

        T3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T3MouseClicked(evt);
            }
        });
        T3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TYPE:");

        C2.setBackground(new java.awt.Color(255, 255, 204));
        C2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Veg", "Non-Veg" }));
        C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C2ActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 204));
        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("QUANTITY:");

        C4.setBackground(new java.awt.Color(255, 255, 204));
        C4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C4ActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 204));
        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CUSTOMISATION:");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("+");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("-");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(C1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(356, 356, 356))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(C4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(358, 358, 358)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(C2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(202, 202, 202)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(261, 261, 261)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton5)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(C3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(T4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                                .addComponent(T3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(109, 109, 109))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5)
                            .addComponent(T4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6))
                        .addGap(61, 61, 61)
                        .addComponent(jButton1)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(C4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(T3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 250, 760, 300);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfirst/save.png"))); // NOI18N
        jButton2.setText("  SAVE DETAILS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(280, 720, 190, 40);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(560, 670, 120, 40);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setText("UPDATE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(50, 670, 120, 40);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfirst/back.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9);
        jLabel9.setBounds(40, 40, 50, 60);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfirst/pizza3.jpg"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, 0, 760, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jt1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jt1MouseEntered

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Congratulations! You're just a step away!!");
        Billing B1 = new Billing();
        B1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C2ActionPerformed
        // TODO add your handling code here:
       
        String S1 = C2.getSelectedItem().toString();
        try
        {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/stock","root","");
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("Select CUSTOMISATION from Pizza where TYPE='"+S1+"'");
            while(rs.next()){
                C4.addItem(rs.getString("CUSTOMISATION"));
            }
           C4.addItem("None");
            c.close();
            st.close();
            rs.close();
        }
        catch(Exception e)
        {
            System.out.print(e);
            // T1.setText("101");
        }
    }      
 /*private void C4ActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // TODO add your handling code here:
        String S2 = C4.getSelectedItem().toString();
        if(S2.equals("NEW"))
        {
            T4.setVisible(true);
        } 
    }//GEN-LAST:event_C2ActionPerformed
*/
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String n = C1.getSelectedItem().toString();
        String t = C2.getSelectedItem().toString();
        String c1 = C4.getSelectedItem().toString();
        
        String s = C3.getSelectedItem().toString();
        String q = T4.getText();
        String p = T3.getText();
     /*   DefaultTableModel dt1= (DefaultTableModel)jt1.getModel();
        Object obj[]={i,n,t,s,c1,q,p};
        dt1.addRow(obj); */
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza","root","");
            Statement st=c.createStatement();

            int i = st.executeUpdate("insert into Pizza values ('"+T1.getText()+"', '"+n+"', '"+t+"', '"+c1+"', '"+s+"','"+q+"' ,'"+p+"')");
            if(i==1)
            {
                JOptionPane.showMessageDialog(this, "PIZZA ADDED!!");
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
            // T1.setText("101");
        }

         try
        {
       Class.forName("com.mysql.jdbc.Driver");
       Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza","root","");
             Statement st=c.createStatement();
             ResultSet rs=st.executeQuery("select max(ID) from pizza");
           if(rs.next()){
           int i = Integer.parseInt(rs.getString(1));
           i = i+1;
           T1.setText("" + i);
           }
        }
        catch(Exception e)
        {
            T1.setText("101");
        }

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza","root","");
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("select * from Pizza");
            mymodel1 m1=new mymodel1(rs);
            jt1.setModel(m1);
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt1MouseClicked
        // TODO add your handling code here:
        TableModel m1 = jt1.getModel();
        String ID = m1.getValueAt(jt1.getSelectedRow(), 0).toString();
        T1.setText(ID);
        String NAME = m1.getValueAt(jt1.getSelectedRow(), 1).toString();
        for(int i = 0; i < C1.getItemCount(); i++){
            if(C1.getItemAt(i).toString().equalsIgnoreCase(NAME)){
            C1.setSelectedIndex(i);
            }
        }
        String SIZE = m1.getValueAt(jt1.getSelectedRow(), 4).toString();
         for(int i = 0; i < C3.getItemCount(); i++){
            if(C3.getItemAt(i).toString().equalsIgnoreCase(SIZE)){
            C3.setSelectedIndex(i);
            }
        }
          String TYPE = m1.getValueAt(jt1.getSelectedRow(), 2).toString();
         for(int i = 0; i < C2.getItemCount(); i++){
            if(C2.getItemAt(i).toString().equalsIgnoreCase(TYPE)){
            C2.setSelectedIndex(i);
            }
        }
          String CUSTOMISATION = m1.getValueAt(jt1.getSelectedRow(), 3).toString();
         for(int i = 0; i < C4.getItemCount(); i++){
            if(C4.getItemAt(i).toString().equalsIgnoreCase(CUSTOMISATION)){
            C4.setSelectedIndex(i);
            }
        }
          String COST = m1.getValueAt(jt1.getSelectedRow(), 6).toString();
          T3.setText(COST);
          String QUANTITY = m1.getValueAt(jt1.getSelectedRow(), 5).toString();
          T4.setText(QUANTITY);
      
    }//GEN-LAST:event_jt1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String S1 = C1.getSelectedItem().toString();
        String S2 = C2.getSelectedItem().toString();
        String S3 = C4.getSelectedItem().toString();
        String S4 = C3.getSelectedItem().toString();
        String S5 = T4.getText();
        String S6 = T3.getText();
       
       try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza","root","");
            Statement st=c.createStatement();

            int i = st.executeUpdate("update pizza set NAME = '"+S1+"', TYPE = '"+S2+"', CUSTOMISATION = '"+S3+"', SIZE = '"+S4+"', QUANTITY = '"+S5+"', COST='"+S6+"' where ID = '"+T1.getText()+"'");
            if(i==1)
            {
                JOptionPane.showMessageDialog(this, "PIZZA UPDATED!!");
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
            // T1.setText("101");
        }
        
         try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza","root","");
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("select * from Pizza");
            mymodel1 m1=new mymodel1(rs);
            jt1.setModel(m1);
        }
        catch(Exception e)
        {
            System.out.print(e);
        } 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza","root","");
            Statement st=c.createStatement();

            int i = st.executeUpdate("delete from pizza where ID = '"+T1.getText()+"'");
            if(i==1)
            {
                JOptionPane.showMessageDialog(this, "PIZZA DELETED!!");
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
            // T1.setText("101");
        }
          try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza","root","");
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("select * from Pizza");
            mymodel1 m1=new mymodel1(rs);
            jt1.setModel(m1);
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void C4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C4ActionPerformed
        // TODO add your handling code here:
        String S2 = C4.getSelectedItem().toString();
       
    }//GEN-LAST:event_C4ActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        this.dispose();
       // Welcome W = new Welcome();
       // W.setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void T3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T3ActionPerformed
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_T3ActionPerformed

    private void C1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C1ActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_C1ActionPerformed

    private void C3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C3ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_C3ActionPerformed

    private void T3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T3MouseClicked

    String name = C1.getSelectedItem().toString();
       String size = C3.getSelectedItem().toString();
       String S2 = C4.getSelectedItem().toString();
       String Quantity = T4.getText(); 
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/price","root","");
            PreparedStatement st=c.prepareStatement("select Cost from price where Name='"+name+"' and Size='"+size+"'");
            ResultSet rs=st.executeQuery();
           if(rs.next()){
           int i = Integer.parseInt(rs.getString("Cost"));
           int j = Integer.parseInt(Quantity);
           int t = i*j;
           
           if(S2.equals("None")){
           T3.setText("" + t);
           }
           else{
           int k = (i+30)*j;
           T3.setText("" + k);
           }
           }
            c.close();
            st.close();
            rs.close();
        }
        catch(Exception e)
        {
            System.out.print(e);
        } 
    }//GEN-LAST:event_T3MouseClicked

private int i = 1;
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        i = Integer.parseInt(T4.getText());
        i = i+1;
        T4.setText(Integer.toString(i));
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        i = Integer.parseInt(T4.getText());
        i = i-1;
        T4.setText(Integer.toString(i));
    }//GEN-LAST:event_jButton6ActionPerformed
 
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
            java.util.logging.Logger.getLogger(Pizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
         
        java.awt.EventQueue.invokeLater(new Runnable() {
       
            public void run() {
                new Pizza().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> C1;
    private javax.swing.JComboBox<String> C2;
    private javax.swing.JComboBox<String> C3;
    private javax.swing.JComboBox<String> C4;
    private javax.swing.JTextField T1;
    private javax.swing.JTextField T3;
    private javax.swing.JTextField T4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt1;
    // End of variables declaration//GEN-END:variables
}
