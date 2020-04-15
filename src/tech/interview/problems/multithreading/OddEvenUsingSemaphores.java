package tech.interview.problems.multithreading;

import java.util.concurrent.Semaphore;

public class OddEvenUsingSemaphores implements Runnable{
	
	private static final int MAX = 10;
	
	private boolean isEven;
	private Semaphore semaphore = new Semaphore(1);

	
	public OddEvenUsingSemaphores(boolean type){
		this.isEven = type;
	}
	
	
	@Override
	public void run() {
		try {
				if(isEven) {
					printEven();
				} else {
					printOdd();
				}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	private void printOdd() throws InterruptedException {
		int val = 1;
		while(val < MAX) {
			semaphore.acquire();
			System.out.println("Printing Odd..." + val);
			val += 2;
			semaphore.release();
			Thread.sleep(1000);
		}
	}


	public void printEven() throws InterruptedException {
		int val = 0;
		while(val < MAX) {
			semaphore.acquire();
			System.out.println("Printing Even..." + val);
			val += 2;
			semaphore.release();
			Thread.sleep(1000);
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Thread evenThread = new Thread(new OddEvenUsingSemaphores(true), "EvenThread");
		Thread oddThread = new Thread(new OddEvenUsingSemaphores(false), "OddThread");
		
		evenThread.start();
		Thread.sleep(1000);
		oddThread.start();
		evenThread.join();
		oddThread.join();
		
	}
}
