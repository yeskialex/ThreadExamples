package edu.handong.csee.java.examples.thread.lab17;

import java.util.ArrayList;

public class SumMultipleThreads implements Runnable{

	long from, to, totalSum;

	public SumMultipleThreads(long from, long to) {
		this.from = from;
		this.to= to;
	}

	public long getTotalSumFromTo() {
		long total = 0;
		for(long i=from;i<=to;i++)
			total+=i;
		
		return total;
	}

	public static void main(String[] args) {
		
		long to = 10000000;
		ArrayList<SumMultipleThreads> sumRunners = new ArrayList<SumMultipleThreads>();
		
		for(long i=0; i<to/1000000; i++) {
			sumRunners.add(new SumMultipleThreads((i*1000000)+1, (i+1)*1000000));
		}
		/*sumRunners.add(new SumMultipleThreads(1,1000));
		sumRunners.add(new SumMultipleThreads(1001,2000));
		sumRunners.add(new SumMultipleThreads(2001,3000));
		sumRunners.add(new SumMultipleThreads(3001,4000));
		sumRunners.add(new SumMultipleThreads(4001,5000));
		sumRunners.add(new SumMultipleThreads(5001,6000));
		sumRunners.add(new SumMultipleThreads(6001,7000));
		sumRunners.add(new SumMultipleThreads(7001,8000));
		sumRunners.add(new SumMultipleThreads(8001,9000));
		sumRunners.add(new SumMultipleThreads(9001,10000));*/
		
		ArrayList<Thread> threadsForSubSum = new ArrayList<Thread>();
		
		for(SumMultipleThreads runner:sumRunners) {
			Thread thread = new Thread(runner);
			thread.start();
			threadsForSubSum.add(thread);
		}
		
		long grandTotal = 0;
		for(SumMultipleThreads runner:sumRunners) {
			grandTotal += runner.totalSum;
		}
		
		System.out.println(grandTotal);
	}

	@Override
	public void run() {
		totalSum = getTotalSumFromTo();
		System.out.println("Computed from " + from + " to " + to);
	}
}
