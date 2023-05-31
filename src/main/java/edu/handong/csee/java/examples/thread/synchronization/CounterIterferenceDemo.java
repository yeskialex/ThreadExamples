package edu.handong.csee.java.examples.thread.synchronization;

public class CounterIterferenceDemo {

	public static void main(String[] args) {
		
		Counter counter = new Counter();
		
		System.out.println("The same counter resoruce is shared for both Thread A and B!");
		
		CounterThreadA runnableA = new CounterThreadA(counter, "A");
		CounterThreadB runnableB = new CounterThreadB(counter, "B");
		
		Thread threadA = new Thread(runnableA);
		Thread threadB = new Thread(runnableB);
		
		threadA.start();
		threadB.start();
				
	}

}
