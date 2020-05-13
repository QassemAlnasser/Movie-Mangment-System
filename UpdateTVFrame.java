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
import static mms.AdminFrame.isNumeric;

public class UpdateTVFrame extends JFrame {
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
        String gn[] = {"Comedy","Horror","Romance","SCI-FI","Action","Thriller","Drama","Mystery","Crime","Animation","Adventure","Fantasy","Superhero"}; 
            private JComboBox tvgBox = new JComboBox (gn);  
            private JLabel tvgLb = new JLabel("Movie genre :"); 
       //     private String mvg;
            
        private JButton tvaButton = new JButton("Submit");
        
      
        
        private GridBagConstraints tvc = new GridBagConstraints();
        
        private JTextArea AddtvResult=new JTextArea(4,20) ;
        UpdateTVFrame() {
            super("Update");
     setSize(400, 300);
     setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    // getContentPane().setBackground(Color.BLACK);
     setLocationRelativeTo(null);
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
                else if(Double.parseDouble(MovieL)<=0) AddtvResult.setText("*Invalid number of episodes range (should be positive number) *");
                else {
                    RegQueries q = new RegQueries();
                                       
                     
                       String st= q.UpdateTVS(MovieName, MovieL, Age, MovieGenre, MovieDate);
                       if(st.equals("Error")) AddtvResult.setText("The date format should be Year-month-day \nEx: 1999-03-01");
                       else if(st.equals("NoError")) {
                            tvnField.setText("");
                            tvlField.setText("");
                            tvarField.setText("");
                            tdateField.setText("");
                            AddtvResult.setText("");
                            tvgBox.setSelectedIndex(0);
                            System.out.println("Added seccussfully");
                         setVisible(false);   
                    
                    
                    }
                
                }
            
            
            }
        
        });
        add(AddTvPanel,BorderLayout.CENTER);
    
        }
        public void CreateFrame(String MovieAge,String MovieLength,int Genre,String MovieName,String MovieDate) {
        tvarField.setText(MovieAge);
        tvnField.setText(MovieName);
        tvlField.setText(MovieLength);
        tdateField.setText(MovieDate);
        tvgBox.setSelectedIndex(Genre);
        tvnField.setEditable(false);
        setVisible(true);
        }
        public void ValidatePanel () {
                AddTvPanel.invalidate();
                AddTvPanel.validate();
                AddTvPanel.repaint(); }
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
