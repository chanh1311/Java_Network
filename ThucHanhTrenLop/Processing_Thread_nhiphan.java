package ThucHanhTrenLop;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Processing_Thread_nhiphan extends Thread {
	private Socket s;
	
	public Processing_Thread_nhiphan(Socket s) {
		this.s = s;
	}
	// xu li //
	public void run() {
		// lay ra 2 stream in-out
		try {
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			// Nhan chuoi so tu Client
			while(true){
				byte b[] = new byte[1000];
				int n = in.read(b);
				String str = new String(b,0,n);
				if(str.equals("EXIT")){
					System.out.println("Client dong ket noi!");
					break;
				}
				// Xu ly yeu cau(doi dsang nhi phan)
				String ketqua = new String();// dua dong nay ra ngoai la oke //
				try {
					int x = Integer.parseInt(str);
					ketqua = Integer.toBinaryString(x);
				}catch(NumberFormatException e) {
					ketqua = "khong phai la so nguyen!";
				}
				// Goi cho client //
				byte[] b1 = ketqua.getBytes();
				out.write(b);
			}
			s.close();
	}catch(IOException e) {
		System.out.println("Co loi trong qua trinh xu li cho Client!");
	}
		
	}
	
}
