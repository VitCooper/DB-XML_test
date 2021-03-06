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
public class CounterTester 
{
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        for(int i=0; i<200; i++) {
            CounterThread ct = new CounterThread(counter);
            ct.start();
        }
        Thread.sleep(1000);
        
        System.out.println("Counter:" + counter.getCounter());
    }
}
 
class Counter
{
    private long counter = 0L;
    
    public void increaseCounter() {
        synchronized(this) {
            counter++;
        }
    }
    
    public long getCounter() {
        return counter;
    }
}
 
class CounterThread extends Thread
{
    private Counter counter;
    
    public CounterThread(Counter counter) {
        this.counter = counter;
    }
    
    @Override
    public void run() {
        for(int i=0; i<1000; i++) {
            counter.increaseCounter();
        }
    }
}