/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mms;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;
/**
 *
 * @author Dobler
 */
public class BlackFrame extends JFrame {
    
    BlackFrame() {
        super("Sucks");
        
    JLabel logo = new JLabel(new ImageIcon(getClass().getResource("logo.png")));
    logo.setBackground(Color.BLACK);
    add(logo);
    getContentPane().setBackground(Color.BLACK);
    setSize(700,700);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    
    }
}
