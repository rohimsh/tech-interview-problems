package multithreading;

public class OddEvenUsingWaitNotify implements Runnable{
	public static final int MAX = 10;
	public static final Object MONITOR = new Object();
	
	private int val;
	
	public OddEvenUsingWaitNotify(int start){
		this.val = start;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				synchronized(MONITOR) {
					MONITOR.notify();
					System.out.println(Thread.currentThread().getName() +" notified others... ");
					System.out.println(Thread.currentThread().getName() +" produced "+ val);
					val += 2;
					if(val > MAX)
						break;
					System.out.println(Thread.currentThread().getName() +" is waiting... ");
					MONITOR.wait();
				}
			}
			
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread evenThread = new Thread(new OddEvenUsingWaitNotify(0), "EvenThread");
		Thread oddThread = new Thread(new OddEvenUsingWaitNotify(1), "OddThread");
		
		evenThread.start();
		Thread.sleep(1000);
		oddThread.start();
		evenThread.join();
		oddThread.join();
		
	}

}
