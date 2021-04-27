/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitasku;

/**
 *
 * @author vitco
 */

import static java.awt.Color.red;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;  //importing swing package
//import java.awt.*;     //importing awt package
import java.awt.event.ComponentListener;

public class Third implements ActionListener {
    
   
  
    JFrame myBox;
    JFrame myFrame;
    JButton myButton;
    
public Third() {
            myFrame = new JFrame("Buttons");
            myBox = new JFrame("My New Swing BOX"); 
            myBox.setSize(600, 800);
            myBox.setVisible(true);
            myBox.setResizable(true);
            JButton but_eq = new JButton("=");
            JButton but_clear = new JButton("C");
            JButton but_back = new JButton("<");
            //myFrame.setVisible(true);
            //ComponentListener text1 = null;
           // myBox.add(popup.menu1);
           //myBox.addComponentListener(text1);
           
       //JButton myButton = new JButton("OK");
      // myButton.setName("EXIT");
     //  myButton.setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));
     //  myButton.setAction(Exit());
       
       // myButton = new JButton("<html><b><font color=" red ">OK</font></b></html>");
       //Установка Java Look and Feel (по умолчанию)       
        //   myBox.add(myButton);
         try {
      UIManager.setLookAndFeel(
         UIManager.getCrossPlatformLookAndFeelClassName());
   }
   catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) { }
          //остальная часть программы
    }  
   public static void main(String[] args) {
      // new First();
      //new Third();
         Third wnd = new Third();
        wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wnd.setVisible(true);
        }

    private Action Exit() {
        throw new UnsupportedOperationException("Not supported yet."); 
       //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    private void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

    private void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); 
        
//To change body of generated methods, choose Tools | Templates.
    }
        
    
    
}
