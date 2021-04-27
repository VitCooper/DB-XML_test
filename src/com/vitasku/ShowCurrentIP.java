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

//import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ShowCurrentIP extends JFrame {
   private JLabel clockLabel = new JLabel();
   private JLabel lanLabel = new JLabel();
   //private JFrame myFrame;
   //private JInternalFrame iFrame;
   
    public ShowCurrentIP() {
       // this.myFrame = new JFrame("Current IP");
        setTitle(" ClockThread with the Current IP ");
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
       // lanLabel.setHorizontalAlignment(SwingConstants.TOP);
                    
        
        Font f = new Font("Default", Font.BOLD + Font.ITALIC, 24);
        clockLabel.setFont(f);
     
     getContentPane().add(clockLabel);
     setBounds(800, 600, 600, 200);
             
     getContentPane().add(lanLabel);
     
//     myFrame.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });
     
      //Создается панель, 
      //которая будет содржать информацию о IP адресе
      //JPanel panel1 = new JPanel();
      //JPanel panel2 = new JPanel();
      //panel2.add(this.clockLabel);
     // iFrame.getContentPane().add(panel2);
      //panel2.setBorder(BorderFactory.createTitledBorder("Current Data and Time is: "));
      //добавление границы к панели
      //panel1.setBorder(BorderFactory.createTitledBorder("Current IP Address: "));
      //panel1.add(new JLabel("          " + IP + "          "));
      //Добавление панели к фрейму
      //myFrame.getContentPane().add(panel1);
      //метод рack(); сообщает Swing о том,
      //что нужно придать компонентам необходимые размеры для
      //правильного помещения их в форму.
      //Другой способ - вызвать setSize(int width, int height).
      //myFrame.setSize(300,300);
      //myFrame.pack();
      //Для того, чтобы увидеть окно на экране 
      //вы должны вызвать метод setVisible(true)
      //myFrame.setVisible(true);
      //clockLabel.setText("          " + IP + "          ");
      
      
      Thread thr = new ClockThread(this);
        thr.start();
}
    
     public void setTime() {
        // Более корректный вызов в отдельном потоке, который отвечает за графику
        SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
                 String IP = "127.0.0.1";
                            try {
                        IP = InetAddress.getLocalHost().getHostAddress();
                        }  catch (UnknownHostException e) 
                        {  IP = "Error finding IP"; }
                SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                clockLabel.setText(df.format(Calendar.getInstance().getTime()));
                lanLabel.setText("          " + IP + "          ");
            }
        });
    }
    
   public static void main(String [] args) {
      ShowCurrentIP wnd = new ShowCurrentIP();
        wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wnd.setVisible(true);
        
   }
}   
   
   class ClockThread extends Thread {
 
    private final ShowCurrentIP clock;
 
    public ClockThread(ShowCurrentIP clock) {
        this.clock = clock;
    }
 
    @Override
    public void run() {
        while (true) {
            clock.setTime();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
   
   
   }
