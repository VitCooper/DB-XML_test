/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author vitco
 */
public class ExecutorExample2 {
    
    public static void main(String[] args) throws Exception {
        int ap = Runtime.getRuntime().availableProcessors();
        System.out.println("We have " + ap + " available CPUs");
        
        ExecutorService es = Executors.newFixedThreadPool(ap);
        
        List<Future<String>> list = new ArrayList<>();
        for(int i=0; i<10; i++) {
            SingleProc1 sp = new SingleProc1("ID: " +i);
            Future<String> ft = es.submit(sp);
            list.add(ft);
            
        }
        for(Future<String> f : list) {
            String answer = f.get();
        }
        
        es.shutdown();
    }
}

class SingleProc1 implements Callable<String>      
{
    private String name = null;
    public SingleProc1(String name) {
     this.name = name;   
    }
    @Override
   // public void run()
    public String call()
    {
        try {
            System.out.println("Start Thread: " + name);
            System.out.println("Start executing SingleProc!");
            Thread.sleep(3000 + ((int)(Math.random() * 1000)));
            System.out.println("Stop Thread: " + name);
          // System.out.println(name.length());
           System.out.println("Test OK");
        } catch (InterruptedException ex) {
            
        }
        return "RETURN FROM Call()";
    }
}