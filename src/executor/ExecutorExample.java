/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author vitco
 */
public class ExecutorExample {
    
    public static void main(String[] args) {
       ExecutorService es = Executors.newSingleThreadExecutor();
    //   Future<?> s = es.submit(new SingleProc()); // это квитанция
       Future<String> s = es.submit(new SingleProc());
        boolean done = s.isDone();
        System.out.println("SingleProc is" + done);
        
        try {
          //   s.get();// пока не обработайте - не уйду
          String answer = s.get();
            System.out.println("After get() message: " + answer);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
           // ex.printStackTrace(System.out);
        }
       es.shutdown();
    }
    
}

//class SingleProc implements Runnable
  class SingleProc implements Callable<String>      
{
    private String name = null;
    
    @Override
   // public void run()
    public String call()
    {
        try {
            Thread.sleep(1000);
          // System.out.println(name.length());
           System.out.println("Test OK");
        } catch (InterruptedException ex) {
            
        }
        return "RETURN FROM Call()";
    }
}