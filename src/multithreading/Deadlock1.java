package multithreading;

public class Deadlock1 {

	public static void main(String[] args) {
		final String FIRST = "FIRST";
		final String SECOND = "SECOND";
		
		Runnable firstRunnable = new Runnable() {

			@Override
			public void run() {
				synchronized(FIRST) {
					try {
						System.out.println("Acquired " + FIRST + " by Thread " + FIRST);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(SECOND) {
						System.out.println("Acquired " + SECOND + " by Thread " + FIRST);
					}
				}
			}
		};

		Runnable secondRunnable = new Runnable() {

			@Override
			public void run() {
				//Replace SECOND with FIRST below to resolve Deadlock
					synchronized(SECOND) {
						System.out.println("Acquired " + SECOND + " by Thread " + SECOND);
						synchronized(FIRST) {
							System.out.println("Acquired " + FIRST + " by Thread " + SECOND);
						}	
					}
			}			
		};
		
		Thread first = new Thread(firstRunnable, FIRST);
		Thread second = new Thread(secondRunnable, SECOND);
		
		first.start();
		second.start();

	}
}
