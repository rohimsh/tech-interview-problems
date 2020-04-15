package tech.interview.problems.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerUsingWaitNotify {
	
	
	public static final int LIMIT = 10;
	private static boolean turn = true;
	
	
	public static void main(String[] args) throws InterruptedException {
		String monitor = "monitor";
		Queue<Integer> queue = new LinkedList<Integer>();
		Thread producerThread = new Thread(new Producer(monitor, queue), "Producer");
		Thread evenConsumerThread = new Thread(new Consumer(monitor, queue, true), "EvenConsumer");
		Thread oddConsumerThread = new Thread(new Consumer(monitor, queue, false), "OddConsumer");
		
		evenConsumerThread.start();
		oddConsumerThread.start();
		Thread.sleep(1000);
		producerThread.start();
		producerThread.join();
		evenConsumerThread.join();
		oddConsumerThread.join();
		
	}
	
	static class Producer implements Runnable{

		String monitor;
		Queue<Integer> queue;
		
		Producer(String monitor, Queue<Integer> queue){
			this.monitor = monitor;
			this.queue = queue;
		}
		
		@Override
		public void run() {
			try {
				int i = 0;
				while(i <= LIMIT) {
					synchronized(monitor) {
						if(queue.isEmpty()) {
							queue.add(i);							
							System.out.println(Thread.currentThread().getName() + " produced " + i);
							System.out.println(Thread.currentThread().getName() + " notified production of " + i);	
							i++;
							if(i > LIMIT)
								break;
						}
						monitor.notifyAll(); //notifyAll will also lead to same results in this case
						monitor.wait();
					}
				}
			} catch (Exception e) {
				System.out.println(Thread.currentThread().getName() + " threw InterruptedException" + e.getMessage());
			}
		}
		
	}
	
	static class Consumer implements Runnable{
		
		String monitor;
		Queue<Integer> queue;
		boolean localTurn;

		Consumer(String monitor, Queue<Integer> queue, boolean localTurn){
			this.monitor = monitor;
			this.queue = queue;
			this.localTurn = localTurn;
		}
		
		@Override
		public void run() {
			try {
				while(true) {
					synchronized(monitor){
						monitor.wait();
						if(!queue.isEmpty() && turn == localTurn) {
								int item = queue.poll();
								System.out.println(Thread.currentThread().getName() + " consumed " + item);
								System.out.println(Thread.currentThread().getName() + " notified consumption of " + item);		
								turn = !turn;
								if(item >= LIMIT)
									break;
						}
						monitor.notifyAll();
					}					
				}

			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " threw InterruptedException" + e.getMessage());
			}
			
		}
		
	}

}
