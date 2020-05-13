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
public class ListMovie extends JFrame {
    private String UserName ;
    private String MovieName ;
    JButton Add = new JButton("Add");
    JLabel youdont = new JLabel ("You don't have lists ?");
    JLabel insert = new JLabel ("Insert name of new list : ");
    JTextField inField = new JTextField(7);
    JButton Create = new JButton ("Create");
    JPanel gridpanel = new JPanel();
    
    
    JLabel chLbl = new JLabel ("Please Choose the list ");
    JTable ListTable = new JTable ();
    DefaultTableModel Model ;
    
   public ListMovie () {
    super("Choose List ")   ;
        chLbl.setForeground(Color.WHITE); add(chLbl,BorderLayout.NORTH);
        add(new JScrollPane(ListTable),BorderLayout.CENTER);
        ListTable.setDefaultEditor(Object.class, null); 
       add(gridpanel,BorderLayout.SOUTH);
       
       Add.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
           RegQueries r = new RegQueries();
           
           if(ListTable.getSelectedRow()!=-1) {
            String ListName = (String)ListTable.getValueAt(ListTable.getSelectedRow(), 0);
               boolean f = r.IsThereMovieInList(UserName, ListName, MovieName);
            if(f)  JOptionPane.showMessageDialog(ListMovie.this, "Movie is already exist in this list ","Error",JOptionPane.ERROR_MESSAGE);  ;
            if(!f) { r.AddMovieToList(MovieName, ListName, UserName);     setVisible(false); 
                    inField.setText("");
            
            
            }           
           } }
       });
        Create.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) { 
        String ListName = inField.getText();
         RegQueries r = new RegQueries();
        if("  ".equals(ListName)||"".equals(ListName)||" ".equals(ListName)) {} 
        else {
         String  status= r.AddList(UserName, ListName);
            if("Error".equals(status)) JOptionPane.showMessageDialog(ListMovie.this, "List is already exist ","Error",JOptionPane.ERROR_MESSAGE);
            else {
                 Vector data= new Vector();
                 Vector column= new Vector();
                 r.ListdataReturn(data, column, UserName);
                 System.out.print(column.toString());
                 System.out.print(data.toString());
                 Model = new DefaultTableModel(data,column);
                 ListTable.setModel(Model);
                 ListTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                 ListTable.setRowSelectionAllowed(true);
                 ListTable.setBackground(Color.WHITE);
                 ListTable.setOpaque(true);
            
            }
        }
        }
        });
       
        gridpanel.setLayout(new GridBagLayout());
        gridpanel.setBackground(Color.BLACK);
        GridBagConstraints g = new GridBagConstraints ();
        g.gridy = 0 ;
        g.gridx= 0;
        Add.setBackground(Color.WHITE);
        gridpanel.add(Add,g);
        g.gridy=1;
        g.gridx=0;
     //   g.weightx=3;
      //  g.fill=GridBagConstraints.HORIZONTAL;
        youdont.setBackground(Color.BLACK);
        youdont.setForeground(Color.WHITE);
        gridpanel.add(youdont,g);
        g.gridy=2;
        g.gridx=0;
        g.weightx=0;
    //    g.fill=GridBagConstraints.NONE;
        gridpanel.add(insert,g);
        insert.setForeground(Color.WHITE);
        g.gridy=2;
        g.gridx=1;
        g.weightx=0;
        g.fill=GridBagConstraints.NONE;
        gridpanel.add(inField,g);
        inField.setBackground(Color.GRAY);
        inField.setForeground(Color.WHITE);
        g.gridy=3;
        g.gridx=1;
        gridpanel.add(Create,g);
        Create.setBackground(Color.WHITE);
        
        //add(gridpanel);
     
    }
    public void CreateFrame(String UserName,String MovieName) {
      this.MovieName=MovieName;
      this.UserName=UserName;
        Vector data= new Vector();
                 Vector column= new Vector();
                 RegQueries r = new RegQueries();
                 r.ListdataReturn(data, column, UserName);
                 System.out.print(column.toString());
                 System.out.print(data.toString());
                 Model = new DefaultTableModel(data,column);
                 ListTable.setModel(Model);
                 ListTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                 ListTable.setRowSelectionAllowed(true);
                 ListTable.setBackground(Color.WHITE);
                 ListTable.setOpaque(true);
       setSize(300, 300);
       setDefaultCloseOperation(Login.HIDE_ON_CLOSE);
       getContentPane().setBackground(Color.BLACK);
       setLocationRelativeTo(null);
       setVisible(true);
        
  }
 public void ValidatePanel () {
                invalidate();
                validate();
                repaint(); }
        public void HideFrame() { setVisible(false); }
}
