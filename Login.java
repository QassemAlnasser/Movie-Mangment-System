/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import mms.Filmer.FilmerFrame;
/**
 *
 * @author Dobler
 */
public class Login extends JFrame {
    
   

      JLabel logo = new JLabel(new ImageIcon(getClass().getResource("mms.png")));
    static JLabel nameLabel = new JLabel("     Username   ", SwingConstants.LEFT);
    static JLabel passLabel = new JLabel("      Password  ", SwingConstants.LEFT);
    static JLabel regLabel = new JLabel("Don't have an account?", SwingConstants.LEFT);

    static JTextField nameInput = new JTextField(5);
    static JPasswordField passInput = new JPasswordField(5);

    static JPanel namePanel = new JPanel(new BorderLayout(4, 4));
    static JPanel passPanel = new JPanel(new BorderLayout(4, 4));
    static JPanel infoPanel = new JPanel(new BorderLayout(4, 4));
    static JPanel dividingPanel = new JPanel(new BorderLayout(4, 4));
    static JPanel regPanel = new JPanel(new FlowLayout(1, 3, 3));

    static JButton register = new JButton("Register now");
    static JButton loginBtn = new JButton("Login");
    RegFrame RegFrame =new RegFrame();
    AdminFrame AdminFrame = new AdminFrame();
    FilmerFrame FilmerFrame = new FilmerFrame();
    
    
    Login() {
        super("Login");
        
        setSize(400, 240);
        setResizable(false);
        setDefaultCloseOperation(Login.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setLocationRelativeTo(null);
   
        loginBtn.setContentAreaFilled(false);
        loginBtn.setFont(new Font("Arial",Font.BOLD, 15));
        loginBtn.setBorderPainted(false);
        loginBtn.setBackground(Color.BLUE);
        loginBtn.setForeground(Color.WHITE);
        regLabel.setForeground(Color.WHITE);
        
        
        nameInput.setBackground(Color.GRAY);
        nameInput.setForeground(Color.WHITE);
        passInput.setBackground(Color.GRAY);
        passInput.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Arial",Font.BOLD,12));

        nameLabel.setBackground(Color.BLACK);
        nameLabel.setForeground(Color.WHITE);
        passLabel.setBackground(Color.BLACK);
        passLabel.setForeground(Color.WHITE);
        passPanel.setBackground(Color.BLACK);
        namePanel.setBackground(Color.BLACK);
        regPanel.setBackground(Color.BLACK);
        nameLabel.setOpaque(true);
        passLabel.setOpaque(true);
        passPanel.setOpaque(true);
        namePanel.setOpaque(true);
        regPanel.setOpaque(true);

        register.setBorderPainted(false);
        register.setForeground(Color.WHITE);
        register.setFocusPainted(false);
        register.setContentAreaFilled(false);

        nameInput.setMargin(new Insets(1, 2, 3, 3));
        passInput.setMargin(new Insets(1, 2, 3, 3));

        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
        passPanel.setLayout(new BoxLayout(passPanel, BoxLayout.X_AXIS));
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        dividingPanel.setLayout(new BorderLayout(30, 2));
        dividingPanel.setBackground(Color.BLACK);

        namePanel.add(nameLabel);
        namePanel.add(nameInput);

        passPanel.add(passLabel);
        passPanel.add(passInput);

        infoPanel.add(namePanel);

        infoPanel.add(passPanel);
        dividingPanel.setSize(new Dimension(200, 400));

        regPanel.add(regLabel);
        regPanel.add(register);

        dividingPanel.add(infoPanel, BorderLayout.NORTH);
        dividingPanel.add(regPanel, BorderLayout.CENTER);

        add(logo, BorderLayout.NORTH);
        add(dividingPanel, BorderLayout.CENTER);
        add(loginBtn,BorderLayout.SOUTH);
        
        setVisible(true);
        
        
        
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                RegFrame.Create();
                
                
            }
        });
        
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String st = nameInput.getText();
                String pass= passInput.getText();
                if(st.equals("")||pass.equals("")) { JOptionPane.showMessageDialog(Login.this, "password or username is not entered  ","Error",JOptionPane.ERROR_MESSAGE); }
                else {
                RegQueries q = new RegQueries();
                String FHolder = q.FilmerLogin(st, pass);
                String AHolder = q.AdminLogin(st, pass);
                
               
                if(FHolder.equals("")&&AHolder.equals(""))   JOptionPane.showMessageDialog(Login.this, "username or password is incorrect ","Error",JOptionPane.ERROR_MESSAGE);
                else if (!FHolder.equals("")) {
                        Login.this.dispose();
                        System.out.println("Filmer logged in");
                        FilmerFrame.CreateFrame(st);
                }
                else if (!AHolder.equals("")) {
                      Login.this.dispose();
                      System.out.println("admin logged in");
                      AdminFrame.CreateFrame();
                        
                }
                }
            
            }
        });
        
        
    }
 public static boolean isNumeric (String str ) {
    try {
    Double.parseDouble(str); 
    return true;
    } catch (NumberFormatException e ){
    return false ;
    }
}    
   

}
