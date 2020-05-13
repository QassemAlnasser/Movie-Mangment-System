/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mms.Filmer;

/**
 *
 * @author Dobler
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import mms.Login;
import mms.RegQueries;
public class Invite extends JFrame{
     private JButton SearchInv= new JButton("Search") ;
    private JTextField SIField = new JTextField(15);
    private JTable InvTable  = new JTable(); ;
    private DefaultTableModel InvModel ;
    private JButton Invite = new JButton("Invite");
    private JPanel InvitePanel ;
    private String UserName;
    
    
   public Invite () {
        super("Invite a friend");
        InvitePanel= new JPanel();
         SearchInv.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e ) {
              String  TV_Name= SIField.getText();
                 if(!TV_Name.equals("")&&!TV_Name.equals(" ")&&!TV_Name.equals("  ")&&!TV_Name.equals("   ")) {
                     System.out.print(TV_Name);
                 Vector data= new Vector();
                 Vector column= new Vector();
                 RegQueries g = new RegQueries();
                 g.FilmerdataReturn(data, column, TV_Name);
                 System.out.print(column.toString());
                 System.out.print(data.toString());
                 InvModel = new DefaultTableModel(data,column);
                 InvTable.setModel(InvModel);
                 InvTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                 InvTable.setRowSelectionAllowed(true);
                 InvTable.setBackground(Color.WHITE);
                 InvTable.setOpaque(true);
                 }   
             }
         });
         Invite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(InvTable.getSelectedRow()!=-1) {
                    RegQueries r = new RegQueries();
                   String Friend=(String)InvTable.getValueAt(InvTable.getSelectedRow(), 0);
                   if(r.IsInvited(UserName, Friend)) JOptionPane.showMessageDialog(Invite.this, "You already invited this one ","Error",JOptionPane.ERROR_MESSAGE); 
                   else {
                       r.InviteFriend(UserName, Friend);
                       SIField.setText("");
                       setVisible(false);
                       
                   }
                }
            }
         
         });
      add(InvitePanel);   
}
   
   public void CreatFrame(String UserName) {
   this.UserName=UserName;
    
        InvitePanel.setBackground(Color.BLACK);
        SIField.setBackground(Color.GRAY);
        SIField.setForeground(Color.WHITE);
        Box b = Box.createHorizontalBox();
        b.add(SearchInv); b.add(SIField);
        InvitePanel.setLayout(new BorderLayout());
        InvitePanel.add(b,BorderLayout.NORTH);
        Box d =Box.createHorizontalBox();
        d.add(Box.createHorizontalGlue()); d.add(Invite); d.add(Box.createHorizontalGlue());
        InvitePanel.add(d,BorderLayout.SOUTH);
        Invite.setBackground(Color.WHITE);
        SearchInv.setBackground(Color.WHITE);
        InvitePanel.add(new JScrollPane(InvTable),BorderLayout.CENTER);
        InvTable.setDefaultEditor(Object.class, null); 
        
       setSize(300, 300);
       setDefaultCloseOperation(Login.HIDE_ON_CLOSE);
       getContentPane().setBackground(Color.BLACK);
       setLocationRelativeTo(null);
       setVisible(true);
   }
}