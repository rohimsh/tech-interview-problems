package multithreading;

import java.util.concurrent.CountDownLatch;

public class OddEvenUsingCountdownLatch implements Runnable{
	
	private static final int MAX = 10;
	private static CountDownLatch countDownLatch = new CountDownLatch(1); 
	private boolean isEven;
	
	OddEvenUsingCountdownLatch(boolean type){
		this.isEven = type;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread evenThread = new Thread(new OddEvenUsingCountdownLatch(true), "EvenThread");
		Thread oddThread = new Thread(new OddEvenUsingCountdownLatch(false), "OddThread");
		
		evenThread.start();
		Thread.sleep(1000);
		oddThread.start();
		evenThread.join();
		oddThread.join();
		
	}

	@Override
	public void run() {
		if(isEven) {
			try {
				int val = 0;
				while(val < MAX) {
					synchronized(countDownLatch) {
						System.out.println("Printing Even... " + val);
						val += 2;
						countDownLatch.countDown();
						countDownLatch.notify();
						if(val > MAX)
							break;
						countDownLatch.wait();
					}
				}
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			
			
		} else {
			try {
				countDownLatch.await();
				int val = 1;
				while(val < MAX) {
					synchronized(countDownLatch) {
						System.out.println("Printing Odd... " + val);
						val += 2;
						countDownLatch.notify();
						if(val > MAX)
							break;
						countDownLatch.wait();
					}
				}				
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}			
		}
		
	}
}
