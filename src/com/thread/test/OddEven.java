package com.thread.test;

public class OddEven extends Thread {
	private static int i;
	private OddEven oe;

	private void setNextObj(OddEven oe) {
		this.oe = oe;
	}

	public static void main(String[] args) throws InterruptedException {
		OddEven oe1 = new OddEven();
		OddEven oe2 = new OddEven();
		OddEven oe3 = new OddEven();

		oe1.setNextObj(oe2);
		oe2.setNextObj(oe3);
		oe3.setNextObj(oe1);

		oe1.start();
		oe2.start();
		oe3.start();

		Thread.sleep(500);

		synchronized (oe1) {
			oe1.notify();
		}
	}

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				try {
					Thread.sleep(1000);
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println(Thread.currentThread() + " HKHR : " + i++);

			synchronized (oe) {
				oe.notify();
			}
		}

	}

}
