package edu.handong.csee.java.examples.thread.synchronization;

public class Counter {
	private int c = 0;
    public void RunIncrease(String threadName) {
    	//synchronized(this) {
	    System.out.println("The " + threadName + "'s counter is " + getValue() + " and is increasing.");
	    increase();
	    System.out.println("The " + threadName + "'s counter value is now: " + getValue() );
    	//}
        System.out.println("The " + threadName + "'s counter value is again: " + getValue() );
        
    }
    
    public void increase() {
    	c++;
    }
    
    public void runDecrease(String threadName) {
    	//synchronized(this) {
	    System.out.println("The " + threadName + "'s counter is " + getValue() + " and is decreasing.");
	    decrease();
	    System.out.println("The " + threadName + "'s counter value is now: " + getValue() );
    	//}
        System.out.println("The " + threadName + "'s counter value is again: " + getValue() );
    }
    
    public void decrease() {
    	c--;
    }
    
    public int getValue() {
        return c;
    }
}
