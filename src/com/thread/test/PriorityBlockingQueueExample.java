package com.concurrency.test;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueExample {
	public static void main(String[] args) {
		//final BlockingQueue<String> priorityBlockingQueue = new LinkedBlockingQueue<String>();
		final String[] names = { "carol", "alice", "malory", "bob", "alex", "jacobs" };
		final BlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<String>();
		PriorityBlockingQueueProducer queueProducer = new PriorityBlockingQueueProducer(priorityBlockingQueue, names);
		new Thread(queueProducer).start();

		PriorityBlockingQueueConsumer queueConsumer1 = new PriorityBlockingQueueConsumer(priorityBlockingQueue);
		new Thread(queueConsumer1).start();

		PriorityBlockingQueueConsumer queueConsumer2 = new PriorityBlockingQueueConsumer(priorityBlockingQueue);
		new Thread(queueConsumer2).start();

	}
}

class PriorityBlockingQueueProducer implements Runnable {

	protected BlockingQueue<String> blockingQueue;
	protected String[] names;
	final Random random = new Random();

	public PriorityBlockingQueueProducer(BlockingQueue<String> queue, String[] names) {
		this.names = names;
		this.blockingQueue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < names.length; i++) {
			try {
				String data = names[i]; // UUID.randomUUID().toString();
				System.out.println("Put: " + data);
				blockingQueue.put(data);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class PriorityBlockingQueueConsumer implements Runnable {

	protected BlockingQueue<String> blockingQueue;

	public PriorityBlockingQueueConsumer(BlockingQueue<String> queue) {
		this.blockingQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String data = blockingQueue.take();
				System.out.println(Thread.currentThread().getName() + " take(): " + data);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
