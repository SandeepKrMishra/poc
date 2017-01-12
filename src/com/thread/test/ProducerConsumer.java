package com.thread.test;

import java.util.Vector;

public class ProducerConsumer extends Thread {
	private static int i = 0;

	private static Vector<Integer> v = new Vector<Integer>(5);

	private ProducerConsumer tt;

	private void setNextObj(ProducerConsumer tt) {
		this.tt = tt;
	}

	public static void main(String[] args) throws InterruptedException {
		ProducerConsumer oe1 = new ProducerConsumer();
		ProducerConsumer oe2 = new ProducerConsumer();

		oe1.setNextObj(oe2);
		oe2.setNextObj(oe1);

		oe1.start();
		oe2.start();

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

			if (v.size() == 0) {

				synchronized (tt) {
					System.out.println(Thread.currentThread() + " HKHR producer : " + i);
					v.addElement(i);
					i++;

					tt.notify();
				}
			} else if (v.size() != 0) {

				synchronized (tt) {
					Integer value = v.remove(0);
					System.out.println(Thread.currentThread() + " HKHR consumer : " + value);
					tt.notify();
				}
			}
		}

	}

}

