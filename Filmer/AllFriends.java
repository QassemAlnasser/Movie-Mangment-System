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

public class AllFriends extends JFrame {
     private JTable InvTable  = new JTable(); ;
    private DefaultTableModel InvModel = new DefaultTableModel() ;
    private JButton Refresh = new JButton("Refresh");
    private String UserName;
    private JPanel InvitePanel ;
    public AllFriends () {
    super("List");
        InvitePanel= new JPanel();
       
                 
        
         Refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(InvTable.getSelectedRow()!=-1) {
                 Vector data= new Vector();
                 Vector column= new Vector();
                 RegQueries g = new RegQueries();
                 g.FriendsdataReturn(data, column, UserName);
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
    
        InvitePanel.setBackground(Color.BLACK);
        InvitePanel.setLayout(new BorderLayout());
        Box d =Box.createHorizontalBox();
        d.add(Box.createHorizontalGlue()); d.add(Refresh); d.add(Box.createHorizontalGlue());
        InvitePanel.add(d,BorderLayout.SOUTH);
        Refresh.setBackground(Color.WHITE);
     
        InvitePanel.add(new JScrollPane(InvTable),BorderLayout.CENTER);
        InvTable.setDefaultEditor(Object.class, null); 
        add(InvitePanel);  
    
    }
    public void CreatFrame(String UserName) {
                this.UserName=UserName;
                Vector data= new Vector();
                 Vector column= new Vector();
                 RegQueries g = new RegQueries();
                 g.FriendsdataReturn(data, column, UserName);
                 System.out.print(column.toString());
                 System.out.print(data.toString());
                 InvModel = new DefaultTableModel(data,column);
                 InvTable.setModel(InvModel);
                 InvTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                 InvTable.setRowSelectionAllowed(true);
                 InvTable.setBackground(Color.WHITE);
                 InvTable.setOpaque(true); 
   
       setSize(300, 300);
       setDefaultCloseOperation(Login.HIDE_ON_CLOSE);
       getContentPane().setBackground(Color.BLACK);
       setLocationRelativeTo(null);
       setVisible(true);
       
   }
}
