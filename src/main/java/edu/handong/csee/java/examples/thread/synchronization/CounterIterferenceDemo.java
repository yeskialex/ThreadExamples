package edu.handong.csee.java.examples.thread.synchronization;

public class CounterIterferenceDemo {

	public static void main(String[] args) {
		
		Counter counter = new Counter();
		
		CounterThread one = new CounterThread(counter, 1);
		CounterThread two = new CounterThread(counter, 2);
		
		Thread threadOne = new Thread(one);
		Thread threadTwo = new Thread(two);
		
		threadOne.start();
		threadTwo.start();
				
	}

}
