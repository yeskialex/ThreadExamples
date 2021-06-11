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
			System.out.format("%s"
					+ " has bowed to %s!%n", 
					this.name, toFriend.getName());
			toFriend.bowBack(this);
		}
		public synchronized void bowBack(Friend toFriend) {
			System.out.format("%s"
					+ " has bowed back to me!%n",
					this.name, toFriend.getName());
		}
	}

	public static void main(String[] args) {
		final Friend alphonse =
				new Friend("Alphonse");
		final Friend gaston =
				new Friend("Gaston");
		new Thread(new Runnable() {
			public void run() { alphonse.bowTo(gaston); }
		}).start();
		new Thread(new Runnable() {
			public void run() { gaston.bowTo(alphonse); }
		}).start();
	}
}
