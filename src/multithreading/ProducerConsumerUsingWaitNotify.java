package multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerUsingWaitNotify {
	
	
	public static final int LIMIT = 10;
	
	public static void main(String[] args) throws InterruptedException {
		String monitor = "monitor";
		Queue<Integer> queue = new LinkedList<Integer>();
		Thread producerThread = new Thread(new Producer(monitor, queue), "Producer");
		Thread evenConsumerThread = new Thread(new Consumer(monitor, queue), "EvenConsumer");
		Thread oddConsumerThread = new Thread(new Consumer(monitor, queue), "OddConsumer");
		
		producerThread.start();
		evenConsumerThread.start();
		oddConsumerThread.start();
		
		
		
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
				for(int i = 1; i <= LIMIT; i++) {
					synchronized(monitor) {
						Thread.sleep(1000);
						queue.add(i);
						System.out.println(Thread.currentThread().getName() + " produced " + i);
						monitor.notify(); //notifyAll will also lead to same results in this case
						System.out.println(Thread.currentThread().getName() + " notified production of " + i);		
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
		
		Consumer(String monitor, Queue<Integer> queue){
			this.monitor = monitor;
			this.queue = queue;
		}
		
		@Override
		public void run() {
			try {
				while(true) {
					synchronized(monitor){
						monitor.wait();
						int item = 0;
						if(!queue.isEmpty()) {
							item = queue.peek();
							if(item % 2 == 0 && Thread.currentThread().getName().equals("EvenConsumer")) {
								queue.poll();
								System.out.println(Thread.currentThread().getName() + " consumed " + item);
								System.out.println(Thread.currentThread().getName() + " notified consumption of " + item);	
							}
							else if(item % 2 != 0 && Thread.currentThread().getName().equals("OddConsumer")) {
								queue.poll();
								System.out.println(Thread.currentThread().getName() + " consumed " + item);
								System.out.println(Thread.currentThread().getName() + " notified consumption of " + item);	
							}
							monitor.notifyAll();
						}
						Thread.sleep(1000);
						if(item == LIMIT)
							break;
					}					
				}

			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " threw InterruptedException" + e.getMessage());
			}
			
		}
		
	}

}
