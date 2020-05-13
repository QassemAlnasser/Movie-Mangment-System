/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mms;

/**
 *
 * @author Dobler
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegFrame extends JFrame {
    private JTextField usrnField = new JTextField(15) ;
        private JLabel usrnLb = new JLabel("User name : ");
           private String UserName;
    private JTextField nameField = new JTextField(15) ;
        private JLabel nameLb = new JLabel("Your name : ");
            private String Name;
    private JTextField bdateField = new JTextField(15) ;
        private JLabel bdateLb = new JLabel("Date of birth : ");
            private String Date;
    private JTextField emailField = new JTextField(15) ;
        private JLabel emailLb = new JLabel("Your Email :  ");
            private String Email;
    private JPasswordField passField = new JPasswordField(15) ;
        private JLabel passLb = new JLabel("Password :  ");
            private String Pass;
    
    private JButton Submit = new JButton ("Submit");    
        
    private JPanel mainPanel ; 
    private GridBagConstraints gbc = new GridBagConstraints ();
    private JTextArea Result = new JTextArea(4,20) ;
        
    private      JLabel logo = new JLabel(new ImageIcon(getClass().getResource("logo.png")));
    RegFrame () {
        super("Registration");
        
        
        Result.setFont(new Font("Arial",Font.BOLD, 12));
        Result.setForeground(Color.red);
        Result.setBackground(Color.BLACK);
        
        usrnField.setBackground(Color.GRAY);
        usrnField.setForeground(Color.WHITE);
        usrnLb.setBackground(Color.BLACK);
        usrnLb.setForeground(Color.WHITE);
        
        nameField.setBackground(Color.GRAY);
        nameField.setForeground(Color.WHITE);
        nameLb.setBackground(Color.BLACK);
        nameLb.setForeground(Color.WHITE);        
        
        passField.setBackground(Color.GRAY);
        passField.setForeground(Color.WHITE);
        passLb.setBackground(Color.BLACK);
        passLb.setForeground(Color.WHITE);
        
        emailField.setBackground(Color.GRAY);
        emailField.setForeground(Color.WHITE);
        emailLb.setBackground(Color.BLACK);
        emailLb.setForeground(Color.WHITE);
        
        bdateField.setBackground(Color.GRAY);
        bdateField.setForeground(Color.WHITE);
        bdateLb.setBackground(Color.BLACK);
        bdateLb.setForeground(Color.WHITE);
        
        Submit.setBackground(Color.WHITE);
        Submit.setForeground(Color.BLACK);
        
        mainPanel= new JPanel ();
        mainPanel.setLayout(new GridBagLayout());
        gbc.insets = new Insets(2,3,2,3);
        gbc.gridx=0;
        gbc.gridy=0;
        mainPanel.add(usrnLb,gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridwidth=100;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(usrnField,gbc);
        
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.fill=GridBagConstraints.NONE;
        mainPanel.add(passLb,gbc);
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.gridwidth=100;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(passField,gbc);
        
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=1;
        gbc.fill=GridBagConstraints.NONE;
        mainPanel.add(nameLb,gbc);
        gbc.gridx=1;
        gbc.gridy=2;
        gbc.gridwidth=100;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(nameField,gbc);
        
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=1;
        gbc.fill=GridBagConstraints.NONE;
        mainPanel.add(bdateLb,gbc);
        gbc.gridx=1;
        gbc.gridy=3;
        gbc.gridwidth=100;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(bdateField,gbc);
        
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.gridwidth=1;
        gbc.fill=GridBagConstraints.NONE;
        mainPanel.add(emailLb,gbc);
        gbc.gridx=1;
        gbc.gridy=4;
        gbc.gridwidth=100;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        mainPanel.add(emailField,gbc);
        
        gbc.gridx=3;
        gbc.gridy=5;
        gbc.gridwidth=1;
        gbc.fill=GridBagConstraints.NONE;
        mainPanel.add(Submit,gbc);
        
        gbc.gridx=3;
        gbc.gridy=6;
        gbc.gridwidth=1;
        gbc.fill=GridBagConstraints.NONE;
        mainPanel.add(Result,gbc);
        
        
     mainPanel.setBackground(Color.BLACK);
        add(mainPanel,BorderLayout.CENTER);
        add(logo,BorderLayout.NORTH);
        Result.setEditable(false);
        
        Submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e ) {
                UserName = usrnField.getText();
                Name = nameField.getText();
                Pass=passField.getText();
                Date = bdateField.getText();
                Email = emailField.getText();
               
                if(UserName.equals("")||Name.equals("")||Pass.equals("")||Date.equals("")||Email.equals("")) Result.setText("*Please Enter all the data*");
                else if(Pass.length()<6) Result.setText("*Password Cannot be less than 6 digits*");
                else {
                    RegQueries q = new RegQueries();
                    if(q.IsThereUserName(UserName)) Result.setText("Please try another username ");
                    
                    else { 
                       String st= q.FilmerReg(UserName, Name, Date, Email, Pass);
                       if(st.equals("Error")) Result.setText("The date format should be Year-month-day \nEx: 1999-03-01");
                       else if(st.equals("NoError")) {
                            emailField.setText("");
                            passField.setText("");
                            usrnField.setText("");
                            bdateField.setText("");
                            nameField.setText("");
                            System.out.println("Registered Successfully");
                            setVisible(false);
                            
                       }
                    
                    }
                
                }
            }
        
        } );
        
        }
    public void Create() {
        setSize(350,350);
        setVisible(true);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);
    
    }
        
}
