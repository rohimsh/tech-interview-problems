package tech.interview.problems.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerUsingBlockingQueue {

	static BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>();
	
	public static void main(String[] args) {
		
		Thread producerThread = new Thread(new Producer(blockingQueue), "Producer");
		Thread consumerThread = new Thread(new Consumer(blockingQueue), "Consumer");
		
		producerThread.start();
		consumerThread.start();
		
		
	}
	
	static class Producer implements Runnable{

		BlockingQueue<Integer> blockingQueue;
		int count;
		
		Producer(BlockingQueue<Integer> blockingQueue){
			this.blockingQueue = blockingQueue;
			this.count = 0;
		}
		
		@Override
		public void run() {
			try {
				while(count <= 10) {
					blockingQueue.put(count);
					System.out.println(Thread.currentThread().getName() + " produced: " + count);
					count++;
				}

			} catch(InterruptedException e) {
				System.out.println("InterruptedException" + e.getMessage());
			}
			
		}
		
	}
	
	static class Consumer implements Runnable{
		
		BlockingQueue<Integer> blockingQueue;
		
		Consumer(BlockingQueue<Integer> blockingQueue){
			this.blockingQueue = blockingQueue;
		}
		
		@Override
		public void run() {
			try {
				while(true) {
					int count = blockingQueue.take();
					System.out.println(Thread.currentThread().getName() + " consumed: " + count);
				}
				
			} catch(InterruptedException e) {
				System.out.println("InterruptedException" + e.getMessage());
			}			
		}
		
	}
}
