package multithreading;

public class DeadLockBetweenParentChildThreads extends Thread {

	private static Thread mainThread;
	
	public static void main(String[] args) {
		DeadLockBetweenParentChildThreads childThread = new DeadLockBetweenParentChildThreads();
		childThread.start();
		
		
		try {
			System.out.println("Parent thread sleeping for 4000ms");
			Thread.sleep(5000);
			mainThread = Thread.currentThread();
			
			System.out.println("Parent thread waiting for Child thread to exit...");
			childThread.join();
			
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		try {
			System.out.println("Child thread started...");
			while(mainThread == null) {
				System.out.println("Child thread sleeping for 2000ms");
				Thread.sleep(2000);
			}
			
			System.out.println("Child thread waiting for Parent thread to exit...");
			mainThread.join();
			
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
