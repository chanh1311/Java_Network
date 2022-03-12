package ThucHanhTrenLop;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_NhiPhanss {

	public static void main(String[] args) {
		// tao server socket //
		try {
			ServerSocket ss = new ServerSocket();
			
			// chap nhan //
			while(true){
				
					Socket s = ss.accept();
					
					
			}
				
		} catch (IOException e) {
			System.out.println("Loi tao socket!");
			e.printStackTrace();
		}
		
		

	}

}
