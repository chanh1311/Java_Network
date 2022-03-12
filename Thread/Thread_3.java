package Thread;

public class Thread_3 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Thread_3 " + i);
		}
	}
	
}
