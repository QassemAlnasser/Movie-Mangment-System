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
public class ListElements extends JFrame {
    private String UserName;
    private String ListName;
    private JTable eTable = new JTable();
    private DefaultTableModel eModel=new DefaultTableModel();
    private JButton Delet = new JButton ("Delete From List");
    public ListElements (){
        super("Elements");
        getContentPane().setBackground(Color.BLACK);
        add(new JScrollPane(eTable),BorderLayout.CENTER);
        eTable.setDefaultEditor(Object.class, null); 
        Box v = Box.createHorizontalBox();
        v.add(Box.createGlue()); v.add(Delet); v.add(Box.createGlue());
        add(v,BorderLayout.SOUTH);
        Delet.setBackground(Color.WHITE);
         Delet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              if(eTable.getSelectedRow()!=-1) { 
                  String TV_MovieName=(String) eTable.getValueAt(eTable.getSelectedRow() , 0 ); 
                   RegQueries g = new RegQueries();
                   g.DeleteMovieFromList(TV_MovieName, ListName, UserName);
                   g.DeleteTVFromList(TV_MovieName, ListName, UserName);
                   Vector data= new Vector();
                 Vector column= new Vector();
                   g.SingleListdataReturn(data, column, UserName, ListName);
                 System.out.print(column.toString());
                 System.out.print(data.toString());
                 eModel = new DefaultTableModel(data,column);
                 eTable.setModel(eModel);
                 eTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                 eTable.setRowSelectionAllowed(true);
                 eTable.setBackground(Color.WHITE);
                 eTable.setOpaque(true);
              
              }
            }
         });
         
    
    }
    public void CreateFrame(String UserName,String ListName) {
        this.UserName=UserName;
        this.ListName=ListName;
        
                 Vector data= new Vector();
                 Vector column= new Vector();
                 RegQueries g = new RegQueries();
                 g.SingleListdataReturn(data, column, UserName, ListName);
                 System.out.print(column.toString());
                 System.out.print(data.toString());
                 eModel = new DefaultTableModel(data,column);
                 eTable.setModel(eModel);
                 eTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                 eTable.setRowSelectionAllowed(true);
                 eTable.setBackground(Color.WHITE);
                 eTable.setOpaque(true);
       setSize(300, 300);
       setDefaultCloseOperation(Login.HIDE_ON_CLOSE);
       getContentPane().setBackground(Color.BLACK);
       setLocationRelativeTo(null);
       setVisible(true);
    
    }
}
