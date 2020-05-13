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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import mms.RegQueries;
public class RateMovieFrame extends JFrame {
    private JTextField rField = new JTextField(15);
    private JSlider rateSilder = new JSlider(JSlider.HORIZONTAL,0,10,5);
    private JButton Rate = new JButton ("Submit");
    private JButton Update = new JButton("Update"); // hidden from the user
    private JTextArea result = new JTextArea(2,20);
    private GridBagConstraints g = new GridBagConstraints();
    private String UserName;
    private String MovieName;
  public RateMovieFrame() {
        super("Rating");
        setLayout(new GridBagLayout());
        g.gridx=0;
        g.gridy=0;
        add(rateSilder,g);
        rateSilder.setBackground(Color.BLACK);
        rateSilder.setForeground(Color.WHITE);
        rateSilder.setPaintLabels(true);
        rateSilder.setPaintTicks(true);
        rateSilder.setMajorTickSpacing(1);
        
        g.gridx=1;
        g.gridy=0;
        add(Rate,g);
        
        g.gridy=1;
        g.gridx=0;
        add(result,g);
        
        g.gridy=2;
        g.gridx=0;
        add(Update,g);
        rField.setBackground(Color.GRAY);
        rField.setForeground(Color.WHITE);
        result.setBackground(Color.BLACK);
        result.setForeground(Color.RED);
        result.setEditable(false);
        Rate.setBackground(Color.WHITE);
        Update.setBackground(Color.WHITE);
        Update.setVisible(false);
       Rate.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
           int r = rateSilder.getValue();
            RegQueries q = new RegQueries ();
                 String s = q.AddRating(MovieName,(int) r, UserName);
                 if(s=="Error") { result.setText("Rating Exists\nPress Update to update it"); Rate.setVisible(false); Update.setVisible(true);  }
                 else {System.out.println(MovieName+" is ratted secussefully"); setVisible(false);  
                        result.setText("");
                          rateSilder.setValue(5);      }
        }
       });
        Update.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
           int r = rateSilder.getValue();
            RegQueries q = new RegQueries ();
                 q.UpdateRating(MovieName, r, UserName);  
                 setVisible(false);
                     result.setText("");
                          rateSilder.setValue(5);
                          Update.setVisible(false);
                          Rate.setVisible(true);
        }
       });
        
    }
public void CreateFrame(String UserName,String MovieName) {
      this.MovieName=MovieName;
      this.UserName=UserName;
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(350,150);
        setLocationRelativeTo(null);
  }
 public void ValidatePanel () {
                invalidate();
                validate();
                repaint(); }
        public void HideFrame() { setVisible(false); }
}
