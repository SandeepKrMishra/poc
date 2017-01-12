package com.thread.test;

public class TableTest extends Thread {
	private static int i = 0;

	private static int j = 1;

	private TableTest tt;
	private int x ;
	 
	TableTest (int x) {
		this.x = x;
	}

	private void setNextObj(TableTest tt) {
		this.tt = tt;
	}

	public static void main(String[] args) throws InterruptedException {
		TableTest oe1 = new TableTest(1);
		TableTest oe2 = new TableTest(2);
		TableTest oe3 = new TableTest(3);

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
			
			System.out.println(Thread.currentThread() + " HKHR : " + j * x);

			synchronized (tt) {
				tt.notify();
			}
			i++;
			if (i % 3 == 0) {
				j++;
			}
		}

	}

}
