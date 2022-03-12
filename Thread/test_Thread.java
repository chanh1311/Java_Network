package Thread;

public class test_Thread {

	public static void main(String[] args) {
		System.out.println("Start");
		System.out.println("End!");
		//Duoi day la cach khai bao va goi 1 luong!//
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println("Thread1: " + i);
				}
			}
		});
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println("Thread2: " + i);
				}
			}
		});
		t2.start();
		//cach viet ngan hon!
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				//viet code o day//
				
			}
		}).start();
		//van con cach viet ngan kieu lamda//
	}

}
