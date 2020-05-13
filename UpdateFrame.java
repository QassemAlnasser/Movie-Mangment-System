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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class UpdateFrame extends JFrame {
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
        private JPanel AddMoviePanel;
        UpdateFrame() {
            super("Update");
   setSize(400, 300);
     setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    // getContentPane().setBackground(Color.BLACK);
     setLocationRelativeTo(null);
     RegQueries q = new RegQueries();
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
                if(MovieName.equals("")||MovieL.equals("")||MovieDate.equals("")||Age.equals("")||MovieGenre.equals("")) AddResult.setText("*Please Enter all the data*");
                else if(!isNumeric(Age)||!isNumeric(MovieL)) AddResult.setText("*Age or Movie length is not numeric*");
                else if(Integer.parseInt(Age)<1||Integer.parseInt(Age)>21) AddResult.setText("*Invalid age range [1,21] *");
                else if(Double.parseDouble(MovieL)<=0) AddResult.setText("*Invalid length range (should be positive number) *");
                else {
                    
//                    if(q.IsThereMovie(MovieName)) AddResult.setText("The movie name already exisit ");
                    
                     
                        
                       String st= q.UpdateMovie(MovieName, MovieL, Age,MovieGenre, MovieDate);
                       if(st.equals("Error")) AddResult.setText("The date format should be Year-month-day \nEx: 1999-03-01");
                       else if(st.equals("NoError")) {
                            mvnField.setText("");
                            mvlField.setText("");
                            mvarField.setText("");
                            rdateField.setText("");
                            AddResult.setText("");
                            mvgBox.setSelectedIndex(0);
                            System.out.println("updated seccussfully");
                          setVisible(false);  
                       
                    
                    }
                
                }
            
            
            }
        
        }); 
                AddMoviePanel.invalidate();
                AddMoviePanel.validate();
                AddMoviePanel.repaint();
        add(AddMoviePanel,BorderLayout.CENTER);
    
        }
        public void CreateFrame(String MovieAge,String MovieLength,int Genre,String MovieName,String MovieDate) {
        mvarField.setText(MovieAge);
        mvnField.setText(MovieName);
        mvlField.setText(MovieLength);
        rdateField.setText(MovieDate);
        mvgBox.setSelectedIndex(Genre);
        mvnField.setEditable(false);
        setVisible(true);
        }
        public void ValidatePanel () {
                AddMoviePanel.invalidate();
                AddMoviePanel.validate();
                AddMoviePanel.repaint(); }
        public void HideFrame() { setVisible(false); }
        
            public static boolean isNumeric (String str ) {
    try {
    Double.parseDouble(str); 
    return true;
    } catch (NumberFormatException e ){
    return false ;
    }
} 
}
