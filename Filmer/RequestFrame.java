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
public class RequestFrame extends JFrame {
        //   private JButton SearchInv= new JButton("Search") ;
    private JTextField SIField = new JTextField(15);
    private JTable InvTable  = new JTable(); ;
    private DefaultTableModel InvModel = new DefaultTableModel() ;
    private JButton Refresh = new JButton("Refresh");
    private JPanel InvitePanel ;
    private JButton Accept = new JButton("Accept");
    private JButton Reject = new JButton("Reject");
    private String UserName;
    
    
   public RequestFrame () {
        super("Requests");
        InvitePanel= new JPanel();
       
                 
        
         Refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(InvTable.getSelectedRow()!=-1) {
                 Vector data= new Vector();
                 Vector column= new Vector();
                 RegQueries g = new RegQueries();
                 g.RequestsdataReturn(data, column, UserName);
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
         Accept.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 String Name = (String)InvTable.getValueAt(InvTable.getSelectedRow(), 0);
                 RegQueries g = new RegQueries();
                 g.AcceptFriend(Name, UserName); 
                 Vector data= new Vector();
                 Vector column= new Vector();
                 g.RequestsdataReturn(data, column, UserName);
                 System.out.print(column.toString());
                 System.out.print(data.toString());
                 InvModel = new DefaultTableModel(data,column);
                 InvTable.setModel(InvModel);
                 InvTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                 InvTable.setRowSelectionAllowed(true);
                 InvTable.setBackground(Color.WHITE);
                 InvTable.setOpaque(true);
            }
         });
         Reject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Name = (String)InvTable.getValueAt(InvTable.getSelectedRow(), 0);
                 RegQueries g = new RegQueries();
                 g.RejectFriend(Name, UserName); 
                 Vector data= new Vector();
                 Vector column= new Vector();
                 g.RequestsdataReturn(data, column, UserName);
                 System.out.print(column.toString());
                 System.out.print(data.toString());
                 InvModel = new DefaultTableModel(data,column);
                 InvTable.setModel(InvModel);
                 InvTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                 InvTable.setRowSelectionAllowed(true);
                 InvTable.setBackground(Color.WHITE);
                 InvTable.setOpaque(true);
            }
         
         
         });
         
        InvitePanel.setBackground(Color.BLACK);
        InvitePanel.setLayout(new BorderLayout());
        Box d =Box.createHorizontalBox();
        d.add(Box.createHorizontalGlue()); d.add(Refresh); d.add(Box.createHorizontalStrut(4)); d.add(Accept); d.add(Box.createHorizontalStrut(4)); d.add(Reject); d.add(Box.createHorizontalGlue());
        InvitePanel.add(d,BorderLayout.SOUTH);
        Refresh.setBackground(Color.WHITE);
        Reject.setBackground(Color.WHITE);
        Accept.setBackground(Color.WHITE);
        InvitePanel.add(new JScrollPane(InvTable),BorderLayout.CENTER);
        InvTable.setDefaultEditor(Object.class, null); 
        add(InvitePanel);  
       
}
   
   public void CreatFrame(String UserName) {
                this.UserName=UserName;
                Vector data= new Vector();
                 Vector column= new Vector();
                 RegQueries g = new RegQueries();
                 g.RequestsdataReturn(data, column, UserName);
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
    public void ValidatePanel () {
                InvitePanel.invalidate();
                InvitePanel.validate();
                InvitePanel.repaint(); 
                invalidate();
                validate();
                repaint(); 
    
    }
}
