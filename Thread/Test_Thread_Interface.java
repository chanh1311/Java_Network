package Thread;

//day la cach tao Thread bang interface
public class Test_Thread_Interface {

	public static void main(String[] args) {
		Thread_Interface inter = new Thread_Interface();
		new Thread(inter).start();

	}

}
