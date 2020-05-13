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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import mms.Login;
import mms.RegQueries;

public class FilmerFrame extends JFrame {
    private String UserName ;
    
    //___Movie Panel variables
    private JButton SearchMovie= new JButton("Search") ;
    private JTextField SMField = new JTextField(15);
    private JTable MovieTable  = new JTable(); ;
    private DefaultTableModel MovieModel ;
    private JButton Rate = new JButton ("Rate");
    private JButton AddToList = new JButton ("Add To list");
    private JPanel MoviePanel ;
    private RateMovieFrame RateMovieFrame = new RateMovieFrame();
    private ListMovie ListMovie = new ListMovie();
    private JTabbedPane TabbedPane = new JTabbedPane();
    
    //___Movie Panel variables
    private JButton SearchTV= new JButton("Search") ;
    private JTextField STVField = new JTextField(15);
    private JTable TVTable  = new JTable(); ;
    private DefaultTableModel TVModel ;
    private JButton RateTV = new JButton ("Rate");
    private JButton AddToListTV = new JButton ("Add To list");
    private JPanel TVPanel ;
    private RateTVFrame RateTVFrame = new RateTVFrame();
   // private RateFrame RatingFrame = new RateFrame();
    private ListTV ListTV = new ListTV();
   
//___Lists Panel variables 
     private JButton SearchList= new JButton("Search") ;
    private JTextField SSField = new JTextField(15);
    private JTable ListTable  = new JTable(); ;
    private DefaultTableModel LModel ;
    private JButton Delete = new JButton ("Delete");
    private JButton ShowElements = new JButton ("Show elements");
    private JPanel ListPanel ;
    private ListElements ListFrame= new ListElements ();
 //___Invite Panel Variables 
    private JButton List= new JButton("Show List of friends") ;
    private JButton Invite = new JButton("Invite");
    private JButton Requests = new JButton ("Requests");
    private JPanel FriendsPanel ;
    private Invite InviteFrame = new Invite();
    private RequestFrame RequestFrame = new RequestFrame();
    private AllFriends FR = new AllFriends();
 //_____Ratings panel variables    
    private JRadioButton Movies = new JRadioButton ("Movies");
    private JRadioButton TV_series = new JRadioButton("TV-series");
    private ButtonGroup b = new ButtonGroup () ;
    private JTable RTable  = new JTable(); ;
    private DefaultTableModel RModel ;
    private JPanel RPanel;
    
   public FilmerFrame () {
        super("Filmer Frame");
        //______________________________________________Ratings Panel
        b.add(Movies); b.add(TV_series);
         RPanel=new JPanel();
        Box BB = Box.createHorizontalBox();
        BB.add(Movies); BB.add(TV_series);
        RPanel.setLayout(new BorderLayout());
        RPanel.add(BB,BorderLayout.NORTH);
        Movies.setForeground(Color.WHITE);
        Movies.setBackground(Color.BLACK);
        TV_series.setBackground(Color.BLACK);
        TV_series.setForeground(Color.WHITE);
        RPanel.setBackground(Color.BLACK);
        RPanel.add(new JScrollPane(RTable),BorderLayout.CENTER);
        RTable.setDefaultEditor(Object.class, null); 
        Movies.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if(!TV_series.isSelected() && (Movies.isSelected())) {
                 Vector data= new Vector();
                 Vector column= new Vector();
                 RegQueries g = new RegQueries();
                 g.moviesforfilmerReturn(data, column, UserName);
                 System.out.print(column.toString());
                 System.out.print(data.toString());
                 RModel = new DefaultTableModel(data,column);
                 RTable.setModel(RModel);
                 RTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                 RTable.setRowSelectionAllowed(true);
                 RTable.setBackground(Color.WHITE);
                 RTable.setOpaque(true); }
                
            }
        
        });
        TV_series.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if(TV_series.isSelected() && (!Movies.isSelected())) {
                 Vector data= new Vector();
                 Vector column= new Vector();
                 RegQueries g = new RegQueries();
                 g.tvforfilmerReturn(data, column, UserName);
                 System.out.print(column.toString());
                 System.out.print(data.toString());
                 RModel = new DefaultTableModel(data,column);
                 RTable.setModel(RModel);
                 RTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                 RTable.setRowSelectionAllowed(true);
                 RTable.setBackground(Color.WHITE);
                 RTable.setOpaque(true); }
            }
        
        });
        
        
        
        //________________________________________________friends panel
        FriendsPanel=new JPanel();
         FriendsPanel.setLayout(new GridBagLayout());
         FriendsPanel.setBackground(Color.BLACK);
         GridBagConstraints grid = new GridBagConstraints();
         grid.insets = new Insets(2,3,2,3);
         grid.gridy=1;
         grid.gridx=1;
         FriendsPanel.add(Invite,grid);
         Invite.setBackground(Color.WHITE);
         grid.gridy=2;
         grid.gridx=1;
         FriendsPanel.add(List,grid);
         List.setBackground(Color.WHITE);
         grid.gridy=3;
         grid.gridx=1;
         FriendsPanel.add(Requests,grid);
         Requests.setBackground(Color.WHITE);
         Invite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               InviteFrame.CreatFrame(UserName);
            }
         
         });
         Requests.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                RequestFrame.ValidatePanel();
              RequestFrame.CreatFrame(UserName);
              RequestFrame.ValidatePanel();
            }
         
         
         });
         List.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               
              FR.CreatFrame(UserName);
             
            }
         
         
         });
         
         
        
        //-----------------------------------------Lists Panel---------------------------------------------------------
        ListPanel= new JPanel();
        ListPanel.setBackground(Color.BLACK);
        SSField.setBackground(Color.GRAY);
        SSField.setForeground(Color.WHITE);
        Box bB = Box.createHorizontalBox();
        bB.add(SearchList); bB.add(SSField);
        ListPanel.setLayout(new BorderLayout());
        ListPanel.add(bB,BorderLayout.NORTH);
        Box dD =Box.createHorizontalBox();
        dD.add(Box.createHorizontalGlue()); dD.add(Delete); dD.add(Box.createHorizontalStrut(5)); dD.add(ShowElements); dD.add(Box.createHorizontalGlue());
        ListPanel.add(dD,BorderLayout.SOUTH);
        Delete.setBackground(Color.WHITE);
        ShowElements.setBackground(Color.WHITE);
        SearchList.setBackground(Color.WHITE);
        ListPanel.add(new JScrollPane(ListTable),BorderLayout.CENTER);
        ListTable.setDefaultEditor(Object.class, null); 
         SearchList.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e ) {
              String  TV_Name= SSField.getText();
                 if(!TV_Name.equals("")&&!TV_Name.equals(" ")&&!TV_Name.equals("  ")&&!TV_Name.equals("   ")) {
                     System.out.print(TV_Name);
                 Vector data= new Vector();
                 Vector column= new Vector();
                 RegQueries g = new RegQueries();
                 g.ListdataReturn(data, column, UserName);
                 System.out.print(column.toString());
                 System.out.print(data.toString());
                 LModel = new DefaultTableModel(data,column);
                 ListTable.setModel(LModel);
                 ListTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                 ListTable.setRowSelectionAllowed(true);
                 ListTable.setBackground(Color.WHITE);
                 ListTable.setOpaque(true);
                 }   
             }
         });
        ShowElements.addActionListener(new ActionListener() {
             public void actionPerformed (ActionEvent e ) {
                if(ListTable.getSelectedRow()!=-1) {
                    RegQueries r = new RegQueries();
                   String ListName=(String)ListTable.getValueAt(ListTable.getSelectedRow(), 0);
                    ListFrame.CreateFrame(UserName, ListName);
                }
                 
        
             }
         });
        Delete.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent ae) {
                 if(ListTable.getSelectedRow()!=-1) {
                    RegQueries r = new RegQueries();
                   String ListName=(String)ListTable.getValueAt(ListTable.getSelectedRow(), 0);
                    r.DeleteList(ListName, UserName);
                    Vector data= new Vector();
                 Vector column= new Vector();
                 RegQueries g = new RegQueries();
                 g.ListdataReturn(data, column, UserName);
                 System.out.print(column.toString());
                 System.out.print(data.toString());
                 LModel = new DefaultTableModel(data,column);
                 ListTable.setModel(LModel);
                 ListTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                 ListTable.setRowSelectionAllowed(true);
                 ListTable.setBackground(Color.WHITE);
                 ListTable.setOpaque(true);
                    
                }
            }
        });
       
        //------------------------------------------TV PANEL------------------------------------------------------------
        TVPanel= new JPanel();
        TVPanel.setBackground(Color.BLACK);
        STVField.setBackground(Color.GRAY);
        STVField.setForeground(Color.WHITE);
        Box bb = Box.createHorizontalBox();
        bb.add(SearchTV); bb.add(STVField);
        TVPanel.setLayout(new BorderLayout());
        TVPanel.add(bb,BorderLayout.NORTH);
        Box dd =Box.createHorizontalBox();
        dd.add(Box.createHorizontalGlue()); dd.add(RateTV); dd.add(Box.createHorizontalStrut(5)); dd.add(AddToListTV); dd.add(Box.createHorizontalGlue());
        TVPanel.add(dd,BorderLayout.SOUTH);
        RateTV.setBackground(Color.WHITE);
        AddToListTV.setBackground(Color.WHITE);
        SearchTV.setBackground(Color.WHITE);
        TVPanel.add(new JScrollPane(TVTable),BorderLayout.CENTER);
        TVTable.setDefaultEditor(Object.class, null); 
         SearchTV.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e ) {
              String  TV_Name= STVField.getText();
                 if(!TV_Name.equals("")&&!TV_Name.equals(" ")&&!TV_Name.equals("  ")&&!TV_Name.equals("   ")) {
                     System.out.print(TV_Name);
                 Vector data= new Vector();
                 Vector column= new Vector();
                 RegQueries g = new RegQueries();
                 g.tvdataReturnwithrating(data, column, TV_Name);
                 System.out.print(column.toString());
                 System.out.print(data.toString());
                 TVModel = new DefaultTableModel(data,column);
                 TVTable.setModel(TVModel);
                 TVTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                 TVTable.setRowSelectionAllowed(true);
                 TVTable.setBackground(Color.WHITE);
                 TVTable.setOpaque(true);
                 }   
             }
         });
         RateTV.addActionListener(new ActionListener() {
             public void actionPerformed (ActionEvent e ) {
                if(TVTable.getSelectedRow()!=-1) {
                    RegQueries r = new RegQueries();
                    double Age_r = Double.parseDouble((String)TVTable.getValueAt(TVTable.getSelectedRow(), 1));
                    double Filmer_Age = r.AgeReturn(UserName);
                    
                    if(Age_r>Filmer_Age) { JOptionPane.showMessageDialog(FilmerFrame.this, "TV-series is unappropiate because of your age ","Error",JOptionPane.ERROR_MESSAGE);   }
                    else { 
                    String MovieName = (String)TVTable.getValueAt(TVTable.getSelectedRow(), 0);
                    RateTVFrame.CreateFrame(UserName, MovieName); }
                }
                 
        
             }
         });
         AddToListTV.addActionListener(new ActionListener() {
             public void actionPerformed (ActionEvent e ) {
                if(TVTable.getSelectedRow()!=-1) {
                    RegQueries r = new RegQueries();
                    double Age_r = Double.parseDouble((String)TVTable.getValueAt(TVTable.getSelectedRow(), 1));
                    double Filmer_Age = r.AgeReturn(UserName);
                    
                    if(Age_r>Filmer_Age) { JOptionPane.showMessageDialog(FilmerFrame.this, "TV-series is unappropiate because of your age ","Error",JOptionPane.ERROR_MESSAGE);   }
                    else { 
                    String MovieName = (String)TVTable.getValueAt(TVTable.getSelectedRow(), 0);
                    ListTV.CreateFrame(UserName, MovieName); }
                }
                 
        
             }
         });
         
         TabbedPane.setBackground(Color.BLACK);
         
        
        //--------------------------------------------MOVIE PANEL-------------------------------------------------------
        MoviePanel= new JPanel();
        MoviePanel.setBackground(Color.BLACK);
        SMField.setBackground(Color.GRAY);
        SMField.setForeground(Color.WHITE);
        Box B = Box.createHorizontalBox();
        B.add(SearchMovie); B.add(SMField);
        MoviePanel.setLayout(new BorderLayout());
        MoviePanel.add(B,BorderLayout.NORTH);
        Box D =Box.createHorizontalBox();
        D.add(Box.createHorizontalGlue()); D.add(Rate); D.add(Box.createHorizontalStrut(5)); D.add(AddToList); D.add(Box.createHorizontalGlue());
        MoviePanel.add(D,BorderLayout.SOUTH);
        Rate.setBackground(Color.WHITE);
        AddToList.setBackground(Color.WHITE);
        SearchMovie.setBackground(Color.WHITE);
        MoviePanel.add(new JScrollPane(MovieTable),BorderLayout.CENTER);
        MovieTable.setDefaultEditor(Object.class, null); 
         SearchMovie.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e ) {
              String  MovieName= SMField.getText();
                 if(!MovieName.equals("")&&!MovieName.equals(" ")&&!MovieName.equals("  ")&&!MovieName.equals("   ")) {
                     System.out.print(MovieName);
                 Vector data= new Vector();
                 Vector column= new Vector();
                 RegQueries g = new RegQueries();
                 g.moviedataReturnwithrating(data, column, MovieName);
                 System.out.print(column.toString());
                 System.out.print(data.toString());
                 MovieModel = new DefaultTableModel(data,column);
                 MovieTable.setModel(MovieModel);
                 MovieTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                 MovieTable.setRowSelectionAllowed(true);
                 MovieTable.setBackground(Color.WHITE);
                 MovieTable.setOpaque(true);
                 }   
             }
         });
         Rate.addActionListener(new ActionListener() {
             public void actionPerformed (ActionEvent e ) {
                if(MovieTable.getSelectedRow()!=-1) {
                    RegQueries r = new RegQueries();
                    double Age_r = Double.parseDouble((String)MovieTable.getValueAt(MovieTable.getSelectedRow(), 1));
                    double Filmer_Age = r.AgeReturn(UserName);
                    
                    if(Age_r>Filmer_Age) { JOptionPane.showMessageDialog(FilmerFrame.this, "Movie is unappropiate because of your age ","Error",JOptionPane.ERROR_MESSAGE);   }
                    else { 
                    String MovieName = (String)MovieTable.getValueAt(MovieTable.getSelectedRow(), 0);
                    RateMovieFrame.CreateFrame(UserName, MovieName); }
                }
                 
        
             }
         });
         AddToList.addActionListener(new ActionListener() {
             public void actionPerformed (ActionEvent e ) {
                if(MovieTable.getSelectedRow()!=-1) {
                    RegQueries r = new RegQueries();
                    double Age_r = Double.parseDouble((String)MovieTable.getValueAt(MovieTable.getSelectedRow(), 1));
                    double Filmer_Age = r.AgeReturn(UserName);
                    
                    if(Age_r>Filmer_Age) { JOptionPane.showMessageDialog(FilmerFrame.this, "Movie is unappropiate because of your age ","Error",JOptionPane.ERROR_MESSAGE);   }
                    else { 
                    String MovieName = (String)MovieTable.getValueAt(MovieTable.getSelectedRow(), 0);
                    ListMovie.CreateFrame(UserName, MovieName); }
                }
                 
        
             }
         });
         
         TabbedPane.setBackground(Color.BLACK);
         TabbedPane.addTab("Movie", MoviePanel);
         TabbedPane.addTab("TV-series", TVPanel);
         TabbedPane.addTab("Rating", RPanel);
        TabbedPane.addTab("Lists", ListPanel);
        TabbedPane.addTab("Friends", FriendsPanel);
         add(TabbedPane);
     
   } 
   
   public void CreateFrame (String UserName)
   {
     this.UserName=UserName;
     setSize(780, 300);
     setDefaultCloseOperation(Login.EXIT_ON_CLOSE);
     getContentPane().setBackground(Color.BLACK);
     setLocationRelativeTo(null);
     setVisible(true); 
   }
    
    
}
