package ThucHanhTrenLop;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Processing_Thread extends Thread{
	private Socket s;
	
	public Processing_Thread(Socket s) {
		this.s = s;
	}

	public void run() {
		
		try {
			// Tao 2 IN-OUT Stream //
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			while(true) {
				// Nhan du lieu tu Client goi qua //
				int ch = in.read();
				System.out.println("Nhan duoc " + ch);
				// thoat //
				if(ch == '@') break;
				// Xu li du lieu //
				int ch1 = ch;
				// Goi Du lieu ve cho Client //
				out.write(ch1);
				
			}
			// Dong noi ket //
			System.out.println("Dong noi ket!");
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
			
	}
			
}
