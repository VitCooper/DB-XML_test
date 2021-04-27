/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlexample;

/**
 *
 * @author vitco
 */
public class Test1 {
  

  static void method() throws IllegalAccessException {
throw new IllegalAccessException("demo");
}
public static void main(String args[]) {
try {
method();
} catch (IllegalAccessException e) {
    //System.out.println(“ex " + e);
    System.out.println("Exception of this method is :" + e);
            
}
}
    


}
/*


static void method() throws IllegalAccessException {
throw new IllegalAccessException("demo");
}
public static void main(String args[]) {
try {
method();
} catch (IllegalAccessException e) {
System.out.println(“ex " + e);
}
}
int getAreaValue(int x, int y) throw IllegalArgumentException {
if(x < 0 || y < 0)
throw new IllegalArgumentException(“Wrong arg”);
*/