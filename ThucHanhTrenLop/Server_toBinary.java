package ThucHanhTrenLop;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_toBinary {

	public static void main(String[] args) {
		
		try {
			// Tao Socket //
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("Da tao Socket phia Server va cho ket noi!");
			// Lang nghe va xac nhan yeu cau ket noi //
			try {
				while(true) {			// Cho phep nhieu client noi ket //
					Socket s = ss.accept();
					System.out.println("Co 1 client " + s.getInetAddress() + " tai cong " + s.getPort() + " Da noi ket!");
					// tao luong xu ly //
					Processing_Thread_toBinary th = new Processing_Thread_toBinary(s);
					th.start();
				
			}//while noi ket
			
			}catch(IOException e) {
				System.out.println("Co loi xay ra trong qua trinh noi ket!");
			}
			
		} catch (IOException e) {
			System.out.println("Khong tao duoc Socket!");
		}
		
		
		
	}

}
