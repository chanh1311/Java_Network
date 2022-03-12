package Thread;

public class Thread_Interface implements Runnable  {

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Thread_Interface: "+ i);
		}
		
	}
	
}
