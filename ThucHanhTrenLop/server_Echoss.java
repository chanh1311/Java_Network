package ThucHanhTrenLop;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server_Echoss{

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(7776);
			System.out.println("Da khoi tao xong phia server");
			// Cho phep nhieu noi ket tu phia clien //
			while(true){
				try {
				
					Socket s = ss.accept();
					System.out.println("Co 1 client " + s.getInetAddress() + " cong " + s.getPort() + " noi ket");
					
					// Tao Thread //
					Processing_Thread th1 = new Processing_Thread(s);
					th1.start();
				
				}catch(IOException e) {
					System.out.println("Co loi khi ket noi voi Client!");
				}
			
			}// while
		}catch(IOException e) {
			System.out.println(e.toString());
			System.out.println("Loi tao socket phia Server!");
		}
	}

}
