package ThucHanhTrenLop;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_DocSo {

	public static void main(String[] args) {
		try {
			// Tao Socket //
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("Da tao Socket va cho noi ket!");
			while(true) {		// Phuc vu nhieu Client //
				// Lang nghe yeu cau va xac nhan //
				try {
					Socket s = ss.accept();
					System.out.println("Co mot Client " + s.getInetAddress() + " Cong " + s.getPort() + " da noi ket!");
					
					// Tao luong xu li moi va chay no //
					Processing_Thread_DocSo th = new Processing_Thread_DocSo(s);
					th.start();
					
				}catch(IOException e) {
					System.out.println("Co loi khi thiet lap ket noi voi Client!");
				}
				
				
			}//while(phuc vu nhieu client)
				
			
		} catch (IOException e) {
			System.out.println("Co loi xay ra khi tao Socket!");
		}
		
		
		
		
		
		
		
		
		
		
		

	}

}
