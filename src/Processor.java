/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vitco
 */
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
 
public class Processor {
 
    public static final int STR_COUNT = 100;
    public static final int TASK_COUNT = 50000;
 
    public static void main(String[] args) throws InterruptedException {
        Long summa = 0L;
        System.out.println(System.currentTimeMillis());
        List<SingleProcess> list = new ArrayList<>();
        System.out.println("Doing the single Random process Test...");
        for(int i=0; i<5; i++){
            SingleProcess sp = new SingleProcess("ID " + i);
        // sp.start(); // this is for extends Thread
        Thread t = new Thread(sp);
        t.start();
        list.add(sp);
        
        }
        System.out.println(System.currentTimeMillis()); 
        Thread.sleep(5000);
        for(SingleProcess s : list) {
            System.out.println(s.name);
        }
        {
            BigTaskOneThread bt = new BigTaskOneThread();
            System.out.println("Doing the single Thread Test...");
            long d1 = System.currentTimeMillis();
            Long result = bt.startTask();
            long d2 = System.currentTimeMillis();
            
            
            System.out.println(result/1000 + ", Result of 1st test is Time 1: " + (d2 - d1)/1000 + " seconds");
        }
        {
            BigTaskManyThreads bt = new BigTaskManyThreads();
            System.out.println("Doing the multi Thread Test...");
            long d1 = System.currentTimeMillis();
            Long result = bt.startTask();
            long d2 = System.currentTimeMillis();
            System.out.println(result/1000 + ", Result of 2nd test is  Time 2: " + (d2 - d1)/1000 + " seconds");
        }
    }
 
    //class SingleProcess extends Thread
static class SingleProcess implements Runnable
    {
    private String name;
    
    public SingleProcess(String name) {
        this.name = name;
    }
    
        @Override
        public void run() {
        Processor p = new Processor();
         p.process();
        }
        
    }      
    
    public Long process() {
        Long summa = 0L;
 
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < Processor.TASK_COUNT; i++) {
            String g = new BigInteger(500, random).toString(32);
            for (char c : g.toCharArray()) {
                summa += c;
            }
        }
       // System.out.println(name); //? not seen "name"
        return summa;
    }
}
 
class BigTaskOneThread {
 
    public Long startTask() {
        Long summa = 0L;
        for (int i = 0; i < Processor.STR_COUNT; i++) {
            Processor p = new Processor();
            summa += p.process();
        }
        return summa;
    }
 
}
 
class BigTaskManyThreads {
 
    public Long startTask() {
        int ap = Runtime.getRuntime().availableProcessors();
        ExecutorService es = Executors.newFixedThreadPool(ap);
 
        Long summa = 0L;
        try {
            List<MyCallable> threads = new ArrayList<MyCallable>();
            for (int i = 0; i < Processor.STR_COUNT; i++) {
                threads.add(new MyCallable());
            }
            List<Future<Long>> result = es.invokeAll(threads);
 
            for (Future<Long> f : result) {
                summa += f.get();
            }
            es.shutdown();
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace(System.out);
        }
        
        return summa;
    }
}
 
class MyCallable implements Callable<Long> {
 
    @Override
    public Long call() throws Exception {
        Processor p = new Processor();
        return p.process();
    }
}