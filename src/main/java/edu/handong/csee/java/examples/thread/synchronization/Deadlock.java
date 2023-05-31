package edu.handong.csee.java.examples.thread.synchronization;

public class Deadlock {
	static class Friend {
		private final String name;
		public Friend(String name) {
			this.name = name;
		}
		public String getName() {
			return this.name;
		}
		public synchronized void bowTo(Friend toFriend) {
			// in this synchronized area, a thread automatically acquires
			// a intrinsic lock for this method's objects.
			// So here, the object toFried is locked by this synchronized method.
			System.out.format("%s"
					+ " has bowed to %s!%n", 
					this.name, toFriend.getName());
			// toFried and this is locked by both threads who bowed at the same time.
			toFriend.bowBack(this);
		}
		public synchronized void bowBack(Friend toFriend) {
			System.out.format("%s"
					+ " has bowed back to me!%n",
					this.name, toFriend.getName());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// A strict rule of courtesy is that when you bow to a friend,
		// you must remain bowed until your friend has a chance to return the bow. 
		// The deadlock can happen when both bowed at the same time,
		// and both are waiting for the bow-back.
		final Friend alphonse =
				new Friend("Alphonse");
		final Friend gaston =
				new Friend("Gaston");
		new Thread(new Runnable() {
			public void run() { alphonse.bowTo(gaston); }
		}).start();
		//Thread.sleep(1000);
		new Thread(new Runnable() {
			public void run() { gaston.bowTo(alphonse); }
		}).start();
	}
}
