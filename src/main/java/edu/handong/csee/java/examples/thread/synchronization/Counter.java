package edu.handong.csee.java.examples.thread.synchronization;

public class Counter {
	private int c = 0;
    public void RunIncrease(String threadName) {
    	System.out.println("The " + threadName + "'s counter is " + getValue() + " and is increasing.");
        increase();
        System.out.println("The " + threadName + "'s counter value is now: " + getValue() );
    }
    
    public void increase() {
    	c++;
    }
    
    public void runDecrease(String threadName) {
    	System.out.println("The " + threadName + "'s counter is " + getValue() + " and is decreasing.");
        decrease();
        System.out.println("The " + threadName + "'s counter value is now: " + getValue() );
    }
    
    public void decrease() {
    	c--;
    }
    
    public int getValue() {
        return c;
    }
}
