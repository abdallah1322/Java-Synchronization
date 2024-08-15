public class Semaphore {
	private int permits = 0;

	public Semaphore() {
		permits = 0;
	}

	public Semaphore(int initialPermits) {
		permits = initialPermits;
	}

	public synchronized void acquire() {
		permits--;

		if (permits < 0) {
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				// Handle the exception if needed
			}
		}
	}

	public synchronized void release() {
		permits++;

		if (permits <= 0)
		{
			notify();
		}
	}
}