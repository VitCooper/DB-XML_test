/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatever;

/**
 *
 * @author vitco
 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ideone {
    
//    public static String[] drinkNames = {"Капучино", "Эспрессо", "Water", "Milk"};
//    public static int[] drinkPrices = {150, 80, 20, 50};
    
    public static void main(String[] args) {
        
        try {
            File file = new File("new.txt");
            // FileInputStream stream = new FileInputStream(file);
            FileOutputStream stream = new FileOutputStream(file);
            stream.write("Ошибка или Исключение".getBytes());
            
            
        } catch (IOException ex) {
            Logger.getLogger(Ideone.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Кофе машина");
        // Manual Input data:
        //int moneyAmount =120;  
        int myMoney = 120;
        System.out.println("Вы внесли сумму = " + myMoney + " руб.");
        
        String[] drinkNames = {"Капучино", "Эспрессо", "Water", "Milk"};
        int[] drinkPrices = {150, 80, 20, 50};
        
        
        CoffeeMachine machine = new CoffeeMachine(drinkPrices, drinkNames);
        machine.checkPrices(myMoney);
        //checkPrices(myMoney);
    }
    // try it on ideone.com
    
    //int[] drinkPrices = {150,80,20,50};
    
    
    // Также надо сравнить размеры массивов имена и цены и в случае отличия выдавать ошибку
    
//    public Ideone(int moneyAmount)
//    {
//        totalMoneyAmount = moneyAmount;
//    }
//    
//    public static void main(String[] args) throws java.lang.Exception
//    {
        
//        
       
        
        
}
        
        
      //  System.out.println("Exit from the proggram when RC=0");
//    }
    

