package edu.handong.csee.java.examples.thread.synchronization;

public class CounterThread implements Runnable{
	
	private Counter myCounter;
	private int threadID;

	@Override
	public void run() {
		
		if(threadID==1)
			callIncrease();
		else
			callDecrease();
		
		printValue();
		
		
	}
	
	public void callIncrease() {
		myCounter.increase();
	}
	
	public void callDecrease() {
		myCounter.decrease();
	}
		
	public void printValue() {
		System.out.println("Thread " + threadID + "'s value is " + myCounter.getValue());
	}
	public CounterThread(Counter counter, int threadID) {
		myCounter = counter;
		this.threadID = threadID;
	}
}
