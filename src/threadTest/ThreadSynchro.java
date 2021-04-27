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
public class ThreadSynchro {
    
    public static void main(String[] args) throws InterruptedException {
        Counter2 cnt = new Counter2();
        for (int i=0; i<200; i++) {
            Process p = new Process(cnt);
            new Thread(p).start();
        }
        Thread.sleep(1000);
        System.out.println(cnt.getCounter());
    }
}    
        class Counter2 {
            private long counter = 0;
            public synchronized void increase() {
        //1. Прочитать переменную из памяти
        //2. Увеличить значение на 1
        //3. Поместить новое значение в память
        // Реально выполняется 7 операции вместо одной i++
        // result = 198093, expected 200000, and this is a problem of synchronisation        
                counter++;
        // Будем выстраивать в очередь и синхронизировать процесс:
        // public void increase() -> public synchronized void increase()
        // New  result = 200000.       
            }
        
            public long getCounter() {
                return counter;
            }    
        }
    
    class Process implements Runnable{
        private Counter2 cnt;
        
        public Process(Counter2 counter) {
            this.cnt = counter;
        }
        @Override
        public void run() {
            for(int i=0; i<1000; i++) {
                cnt.increase();
            }
        }
    }    
        
// all classes also may be inside main! 
    

