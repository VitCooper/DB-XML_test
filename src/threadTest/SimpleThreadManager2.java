/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadTest;

/**
 *
 * @author vitco
 */
public class SimpleThreadManager2
{
    public static void main(String[] arg) {
        for(int i=0; i<10; i++) {
            Runnable first = new SimpleRunnable();
            Thread t = new Thread(first);
            t.start();
        }
    }
}
 
class SimpleRunnable implements Runnable
{
    @Override
    public void run() {
        try {
            long pause = Math.round(Math.random()*2000);
            Thread.sleep(pause);
            System.out.println("Simple Thread - pause="+pause);
        } catch(InterruptedException i_ex) {
            
        }
    }
}