/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlexample;

import static xmlexample.Test1.method;

/**
 *
 * @author vitco
 */
public class Test2 {
   public int getAreaValue(int x, int y)
   {
    if(x < 0 || y < 0)
    throw new IllegalArgumentException("Wrong arg - test");
    return x = 0;
   }
   public static void main(String args[]) {
try {
method();

} catch (IllegalAccessException e) {
    
    System.out.println("Exception of this method is :" + e);
           
}
} 
   

    
    }
