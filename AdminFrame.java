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

public class AdminFrame extends JFrame {
   
    
    
    private JPanel AddMoviePanel ;
        
        private JLabel mvnLb = new JLabel("Movie name :");
        private JTextField mvnField = new JTextField(15);
         //   private String mvn;
        
        private JLabel mvlLb = new JLabel("Movie length (minutes):");
        private JTextField mvlField = new JTextField(15);
         //   private String mvl ;
        
        private JLabel rdateLb = new JLabel("Dete of release :");
            private JTextField rdateField = new JTextField(15);
       //     private String rdate ;
            
        private JLabel mvarLb = new JLabel("Age restriction :");
        private JTextField mvarField = new JTextField(15);
        //    private String mvar ; 
        
       String gn[] = {"Comedy","Horror","Romance","SCI-FI","Action","Thriller","Drama","Mystery","Crime","Animation","Adventure","Fantasy","Superhero"}; 
       private JComboBox mvgBox = new JComboBox (gn);  
            private JLabel mvgLb = new JLabel("Movie genre :"); 
       //     private String mvg;
            
        private JButton mvaButton = new JButton("Submit");
        
      
        
        private GridBagConstraints gbc = new GridBagConstraints();
        
        private JTextArea AddResult=new JTextArea(4,20) ;
            
     

 
    
    
    
    //_________MODIFYING VARIABLES
    private JPanel DeletPanel;
    private JButton Search=new JButton("Search");
    private JButton Delete = new JButton("Delete");
    private JTextField SearchField=new JTextField(15);
    private JTable DeletTable = new JTable();
    private DefaultTableModel DeletModel;
    private JButton Update = new JButton("Update");
    private UpdateFrame UpdateFrame = new UpdateFrame();
    private JTabbedPane TabbedPane = new JTabbedPane() ; 
    
//________________TV SERIES__________________________________
    //______ADD VARIABLES
    private JPanel AddTvPanel; 
    
    private JLabel tvnLb = new JLabel("TV-series name :");
        private JTextField tvnField = new JTextField(15);
         //   private String mvn;
        
        private JLabel tvlLb = new JLabel("Number of episodes:");
        private JTextField tvlField = new JTextField(15);
         //   private String mvl ;
        
        private JLabel tdateLb = new JLabel("Dete of release :");
            private JTextField tdateField = new JTextField(15);
       //     private String rdate ;
            
        private JLabel tvarLb = new JLabel("Age restriction :");
        private JTextField tvarField = new JTextField(15);
        //    private String mvar ; 
        
            private JComboBox tvgBox = new JComboBox (gn);  
            private JLabel tvgLb = new JLabel("Movie genre :"); 
       //     private String mvg;
            
        private JButton tvaButton = new JButton("Submit");
        
      
        
        private GridBagConstraints tvc = new GridBagConstraints();
        
        private JTextArea AddtvResult=new JTextArea(4,20) ;
            
       // private UpdateFrame UpdateFrame = new UpdateFrame();
    //_________DELETE AND UPDATE VARIABLES
    private JPanel TVSPanel;
    private JButton SearchTV=new JButton("Search");
    private JButton DeleteTV = new JButton("Delete");
    private JTextField SearchTVField=new JTextField(15);
    private JTable TVTable = new JTable();
    private DefaultTableModel TVModel;
    private JButton UpdateTV = new JButton("Update");
    private UpdateTVFrame UpdateTVFrame = new UpdateTVFrame();
    //private UpdateFrame UpdateFrame = new UpdateFrame();

    AdminFrame () {
         super("Admin Frame");
         //________________________________DELETE AND UPDATE PANEL__________________________________
         TVSPanel= new JPanel();
        TVSPanel.setBackground(Color.BLACK);
        SearchTVField.setBackground(Color.GRAY);
        SearchTVField.setForeground(Color.WHITE);
        Box b = Box.createHorizontalBox();
        b.add(SearchTV); b.add(SearchTVField);
        TVSPanel.setLayout(new BorderLayout());
        TVSPanel.add(b,BorderLayout.NORTH);
        Box d =Box.createHorizontalBox();
        d.add(Box.createHorizontalGlue()); d.add(DeleteTV); d.add(Box.createHorizontalStrut(25)); d.add(UpdateTV); d.add(Box.createHorizontalGlue());
        UpdateTV.setBackground(Color.WHITE);
        TVSPanel.add(d,BorderLayout.SOUTH);
        DeleteTV.setBackground(Color.WHITE);
        SearchTV.setBackground(Color.WHITE);
        TVSPanel.add(new JScrollPane(TVTable),BorderLayout.CENTER);
        TVTable.setDefaultEditor(Object.class, null); 
         SearchTV.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e ) {
              String MovieName= SearchTVField.getText();
                   if(!MovieName.equals("")&&!MovieName.equals(" ")&&!MovieName.equals("  ")&&!MovieName.equals("   ")) {
                     System.out.print(MovieName);
                 Vector data= new Vector();
                 Vector column= new Vector();
                 RegQueries g = new RegQueries();
                 g.tvdataReturn(data, column, MovieName);
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
         DeleteTV.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e ) {
                RegQueries r = new RegQueries ();
               if(TVTable.getSelectedRow()!=-1) {
                String n = (String)TVTable.getValueAt(TVTable.getSelectedRow(), 3);
               
               if(r.IsThereTV(n))
                r.DeleteTV(n);
                 Vector data= new Vector();
                 Vector column= new Vector();
                r.tvdataReturn(data, column, SearchTVField.getText());
                 System.out.print(column.toString());
                 System.out.print(data.toString());
                 TVModel = new DefaultTableModel(data,column);
                 TVTable.setModel(TVModel);
               
               
               }
             }
         });
         UpdateTV.addActionListener(new ActionListener () { 
            @Override
            public void actionPerformed(ActionEvent e ) {
            if(TVTable.getSelectedRow()!=-1) { 
                String Age = (String)TVTable.getValueAt(TVTable.getSelectedRow(), 0);
                String Length = (String)TVTable.getValueAt(TVTable.getSelectedRow(), 1);
                String Genre = (String)TVTable.getValueAt(TVTable.getSelectedRow(), 2);
                String MovieName = (String)TVTable.getValueAt(TVTable.getSelectedRow(), 3);
                String MovieDate = (String)TVTable.getValueAt(TVTable.getSelectedRow(), 4);
                int genre = 0 ;
                for(int i=0;i<gn.length;i++) { if(gn[i].equals(Genre)) genre=i; }
                System.out.print(MovieName);
                UpdateTVFrame.CreateFrame(Age, Length, genre, MovieName, MovieDate);
                UpdateTVFrame.invalidate();
                UpdateTVFrame.validate();
                UpdateTVFrame.repaint();
                UpdateTVFrame.ValidatePanel();
            }
            
            
            }
        
        
        });
         
         //__________________________________________ADD TVS Panel__________________________________________________________________
         AddTvPanel = new JPanel();
        AddTvPanel.setLayout(new GridBagLayout ());
        tvc.insets = new Insets(2,3,2,3);
        tvc.gridy=0;
        tvc.gridx=0;
        AddTvPanel.add(tvnLb,tvc);
        tvc.gridy=0;
        tvc.gridx=1;
        tvc.weightx=100;
        tvc.fill=GridBagConstraints.HORIZONTAL;
        AddTvPanel.add(tvnField,tvc);
       
        
        tvc.gridy=1;
        tvc.gridx=0;
        tvc.weightx=0;
        tvc.fill=GridBagConstraints.NONE;
        AddTvPanel.add(tvlLb,tvc);
        tvc.gridy=1;
        tvc.gridx=1;
        tvc.weightx=100;
        tvc.fill=GridBagConstraints.HORIZONTAL;
        AddTvPanel.add(tvlField,tvc);
        
        tvc.gridy=2;
        tvc.gridx=0;
        tvc.weightx=0;
        tvc.fill=GridBagConstraints.NONE;
        AddTvPanel.add(tdateLb,tvc);
        tvc.gridy=2;
        tvc.gridx=1;
        tvc.weightx=100;
        tvc.fill=GridBagConstraints.HORIZONTAL;
        AddTvPanel.add(tdateField,tvc);
        
        tvc.gridy=3;
        tvc.gridx=0;
        tvc.weightx=0;
        tvc.fill=GridBagConstraints.NONE;
        AddTvPanel.add(tvarLb,tvc);
        tvc.gridy=3;
        tvc.gridx=1;
        tvc.weightx=100;
        tvc.fill=GridBagConstraints.HORIZONTAL;
        AddTvPanel.add(tvarField,tvc);
        
        tvc.gridy=4;
        tvc.gridx=0;
        tvc.weightx=0;
        tvc.fill=GridBagConstraints.HORIZONTAL;
        AddTvPanel.add(tvgLb,tvc);
        tvc.gridy=4;
        tvc.gridx=1;
        tvc.weightx=0;
        tvc.fill=GridBagConstraints.HORIZONTAL;
        AddTvPanel.add(tvgBox,tvc);
        
        tvc.gridy=5;
        tvc.gridx=1;
        tvc.weightx=0;
        tvc.fill=GridBagConstraints.HORIZONTAL;
        AddTvPanel.add(tvaButton,tvc);
        
        tvc.gridy=6;
        tvc.gridx=1;
        AddTvPanel.add(AddtvResult,tvc);
        AddTvPanel.setBackground(Color.BLACK);
        tvlField.setBackground(Color.GRAY);
        tvlField.setForeground(Color.WHITE);
        tvlLb.setForeground(Color.WHITE);
        
        tvnField.setBackground(Color.GRAY);
        tvnField.setForeground(Color.WHITE);
        tvnLb.setForeground(Color.WHITE);
        tvarField.setBackground(Color.GRAY);
        tvarField.setForeground(Color.WHITE);
        tvarLb.setForeground(Color.WHITE);
        tvgBox.setForeground(Color.WHITE);
        tvgBox.setBackground(Color.BLACK);
        tvgLb.setForeground(Color.WHITE);
       
        
        tdateField.setBackground(Color.GRAY);
        tdateField.setForeground(Color.WHITE);
        tdateLb.setForeground(Color.WHITE);
        
        TabbedPane.addTab("Add movie", AddTvPanel);
        TabbedPane.setBackground(Color.BLACK);
        AddtvResult.setFont(new Font("Arial",Font.BOLD, 12));
        AddtvResult.setForeground(Color.red);
        AddtvResult.setBackground(Color.BLACK);
        AddtvResult.setEditable(false);
        
        tvaButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                String MovieName = tvnField.getText();
                String MovieL = tvlField.getText();
                String MovieDate= tdateField.getText();
                String Age = tvarField.getText();
                String MovieGenre =(String) tvgBox.getSelectedItem();
               System.out.println(MovieGenre);
               System.out.println(tvgBox.getSelectedIndex());
                if(MovieName.equals("")||MovieL.equals("")||MovieDate.equals("")||Age.equals("")||MovieGenre.equals("")) AddtvResult.setText("*Please Enter all the data*");
                else if(!isNumeric(Age)||!isNumeric(MovieL)) AddtvResult.setText("*Age or number of episodes is not numeric*");
                else if(Integer.parseInt(Age)<1||Integer.parseInt(Age)>21) AddtvResult.setText("*Invalid age range [1,21] *");
                else if(Double.parseDouble(MovieL)<=0) AddtvResult.setText("*Invalid length range (should be positive number) *");
                else {
                    RegQueries q = new RegQueries();
                    if(q.IsThereTV(MovieName)) AddtvResult.setText("The tv-series already exisit ");
                    
                    else { 
                       String st= q.AddTVS(MovieName,Double.parseDouble(MovieL), MovieGenre, Integer.parseInt(Age), MovieDate);
                       if(st.equals("Error")) AddtvResult.setText("The date format should be Year-month-day \nEx: 1999-03-01");
                       else if(st.equals("NoError")) {
                            tvnField.setText("");
                            tvlField.setText("");
                            tvarField.setText("");
                            tdateField.setText("");
                            AddtvResult.setText("");
                            tvgBox.setSelectedIndex(0);
                            System.out.println("Added seccussfully");
                            
                       }
                    
                    }
                
                }
            
            
            }
        
        });
        
        
       
        
        
        
        //_________________________________________________________________MODIFYING MOVIE Panel______________________________________
        DeletPanel= new JPanel();
        DeletPanel.setBackground(Color.BLACK);
        SearchField.setBackground(Color.GRAY);
        SearchField.setForeground(Color.WHITE);
        Box B = Box.createHorizontalBox();
        B.add(Search); B.add(SearchField);
        DeletPanel.setLayout(new BorderLayout());
        DeletPanel.add(B,BorderLayout.NORTH);
        Box D =Box.createHorizontalBox();
       D.add(Box.createHorizontalGlue()); D.add(Delete); D.add(Box.createHorizontalStrut(25)); D.add(Update); D.add(Box.createHorizontalGlue());
        Update.setBackground(Color.WHITE);
        DeletPanel.add(D,BorderLayout.SOUTH);
        Delete.setBackground(Color.WHITE);
        Search.setBackground(Color.WHITE);
        DeletPanel.add(new JScrollPane(DeletTable),BorderLayout.CENTER);
        DeletTable.setDefaultEditor(Object.class, null); 
         Search.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e ) {
              String   MovieName= SearchField.getText();
                   if(!MovieName.equals("")&&!MovieName.equals(" ")&&!MovieName.equals("  ")&&!MovieName.equals("   ")) {
                     System.out.print(MovieName);
                 Vector data= new Vector();
                 Vector column= new Vector();
                 RegQueries g = new RegQueries();
                 g.moviedataReturn(data, column, MovieName);
                 System.out.print(column.toString());
                 System.out.print(data.toString());
                 DeletModel = new DefaultTableModel(data,column);
                 DeletTable.setModel(DeletModel);
                 DeletTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                 DeletTable.setRowSelectionAllowed(true);
                 DeletTable.setBackground(Color.WHITE);
                 DeletTable.setOpaque(true);
                
                 }   
             }
         });
         Delete.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e ) {
                RegQueries r = new RegQueries ();
               if(DeletTable.getSelectedRow()!=-1) {
                String n = (String)DeletTable.getValueAt(DeletTable.getSelectedRow(), 3);
               
               if(r.IsThereMovie(n))
                r.DeleteMovie(n);
                 Vector data= new Vector();
                 Vector column= new Vector();
                r.moviedataReturn(data, column, SearchField.getText());
                 System.out.print(column.toString());
                 System.out.print(data.toString());
                 DeletModel = new DefaultTableModel(data,column);
                 DeletTable.setModel(DeletModel);
               
               
               }
             }
         });
         Update.addActionListener(new ActionListener () { 
            @Override
            public void actionPerformed(ActionEvent e ) {
            if(DeletTable.getSelectedRow()!=-1) { 
                String Age = (String)DeletTable.getValueAt(DeletTable.getSelectedRow(), 0);
                String Length = (String)DeletTable.getValueAt(DeletTable.getSelectedRow(), 1);
                String Genre = (String)DeletTable.getValueAt(DeletTable.getSelectedRow(), 2);
                String MovieName = (String)DeletTable.getValueAt(DeletTable.getSelectedRow(), 3);
                String MovieDate = (String)DeletTable.getValueAt(DeletTable.getSelectedRow(), 4);
                int genre = 0 ;
                for(int i=0;i<gn.length;i++) { if(gn[i].equals(Genre)) genre=i; }
                System.out.print(MovieName);
                UpdateFrame.CreateFrame(Age, Length, genre, MovieName, MovieDate);
                UpdateFrame.invalidate();
                UpdateFrame.validate();
                UpdateFrame.repaint();
                UpdateFrame.ValidatePanel();
            }
            
            
            }
        
        
        });
         
        
        
//___________________________________________________________________ADD Panel_________________________________________________________________________________________
        AddMoviePanel = new JPanel();
        AddMoviePanel.setLayout(new GridBagLayout ());
        gbc.insets = new Insets(2,3,2,3);
        gbc.gridy=0;
        gbc.gridx=0;
        AddMoviePanel.add(mvnLb,gbc);
        gbc.gridy=0;
        gbc.gridx=1;
        gbc.weightx=100;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        AddMoviePanel.add(mvnField,gbc);
       
        
        gbc.gridy=1;
        gbc.gridx=0;
        gbc.weightx=0;
        gbc.fill=GridBagConstraints.NONE;
        AddMoviePanel.add(mvlLb,gbc);
        gbc.gridy=1;
        gbc.gridx=1;
        gbc.weightx=100;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        AddMoviePanel.add(mvlField,gbc);
        
        gbc.gridy=2;
        gbc.gridx=0;
        gbc.weightx=0;
        gbc.fill=GridBagConstraints.NONE;
        AddMoviePanel.add(rdateLb,gbc);
        gbc.gridy=2;
        gbc.gridx=1;
        gbc.weightx=100;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        AddMoviePanel.add(rdateField,gbc);
        
        gbc.gridy=3;
        gbc.gridx=0;
        gbc.weightx=0;
        gbc.fill=GridBagConstraints.NONE;
        AddMoviePanel.add(mvarLb,gbc);
        gbc.gridy=3;
        gbc.gridx=1;
        gbc.weightx=100;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        AddMoviePanel.add(mvarField,gbc);
        
        gbc.gridy=4;
        gbc.gridx=0;
        gbc.weightx=0;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        AddMoviePanel.add(mvgLb,gbc);
        gbc.gridy=4;
        gbc.gridx=1;
        gbc.weightx=0;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        AddMoviePanel.add(mvgBox,gbc);
        
        gbc.gridy=5;
        gbc.gridx=1;
        gbc.weightx=0;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        AddMoviePanel.add(mvaButton,gbc);
        
        gbc.gridy=6;
        gbc.gridx=1;
        AddMoviePanel.add(AddResult,gbc);
        AddMoviePanel.setBackground(Color.BLACK);
        mvlField.setBackground(Color.GRAY);
        mvlField.setForeground(Color.WHITE);
        mvlLb.setForeground(Color.WHITE);
        
        mvnField.setBackground(Color.GRAY);
        mvnField.setForeground(Color.WHITE);
        mvnLb.setForeground(Color.WHITE);
        mvarField.setBackground(Color.GRAY);
        mvarField.setForeground(Color.WHITE);
        mvarLb.setForeground(Color.WHITE);
        mvgBox.setForeground(Color.WHITE);
        mvgBox.setBackground(Color.BLACK);
        mvgLb.setForeground(Color.WHITE);
       
        
        rdateField.setBackground(Color.GRAY);
        rdateField.setForeground(Color.WHITE);
        rdateLb.setForeground(Color.WHITE);
        
       
        AddResult.setFont(new Font("Arial",Font.BOLD, 12));
        AddResult.setForeground(Color.red);
        AddResult.setBackground(Color.BLACK);
        AddResult.setEditable(false);
        
        mvaButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                String MovieName = mvnField.getText();
                String MovieL = mvlField.getText();
                String MovieDate= rdateField.getText();
                String Age = mvarField.getText();
                String MovieGenre =(String) mvgBox.getSelectedItem();
               System.out.println(MovieGenre);
               System.out.println(mvgBox.getSelectedIndex());
                if(MovieName.equals("")||MovieL.equals("")||MovieDate.equals("")||Age.equals("")||MovieGenre.equals("")) AddResult.setText("*Please Enter all the data*");
                else if(!isNumeric(Age)||!isNumeric(MovieL)) AddResult.setText("*Age or Movie length is not numeric*");
                else if(Integer.parseInt(Age)<1||Integer.parseInt(Age)>21) AddResult.setText("*Invalid age range [1,21] *");
                else if(Double.parseDouble(MovieL)<=0) AddResult.setText("*Invalid length range (should be positive number) *");
                else {
                    RegQueries q = new RegQueries();
                    if(q.IsThereMovie(MovieName)) AddResult.setText("The movie already exisit ");
                    
                    else { 
                       String st= q.AddMovie(MovieName,Double.parseDouble(MovieL), MovieGenre, Integer.parseInt(Age), MovieDate);
                       if(st.equals("Error")) AddResult.setText("The date format should be Year-month-day \nEx: 1999-03-01");
                       else if(st.equals("NoError")) {
                            mvnField.setText("");
                            mvlField.setText("");
                            mvarField.setText("");
                            rdateField.setText("");
                            AddResult.setText("");
                            mvgBox.setSelectedIndex(0);
                            System.out.println("Added seccussfully");
                            
                       }
                    
                    }
                
                }
            
            
            }
        
        }); 
        
         TabbedPane.addTab("Add movie", AddMoviePanel);
        TabbedPane.add(DeletPanel,"Modify a movie");
         TabbedPane.add(AddTvPanel,"Add TV-series");
        TabbedPane.addTab("Modify TV-series", TVSPanel); 
        TabbedPane.setBackground(Color.BLACK);
        
        add(TabbedPane,BorderLayout.CENTER); 
       
        
        
    }       
    public void CreateFrame () {
        
        
     setSize(780, 300);
    
     setDefaultCloseOperation(Login.EXIT_ON_CLOSE);
     getContentPane().setBackground(Color.BLACK);
     setLocationRelativeTo(null);
     setVisible(true);
    
    
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
