package edu.handong.csee.java.examples.thread.synchronization;

public class Counter {
	private int c = 0;
    public void increase() {
        c++;
    }
    public void decrease() {
        c--;
    }
    public int getValue() {
        return c;
    }
}
