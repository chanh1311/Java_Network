package vd_Socket.songsong;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RequestProcessing extends Thread {
	// Khai bao socket //
	private Socket s;
	// Ham tao //
	public RequestProcessing(Socket s) {
		this.s = s;
	}
	// Ham xu ly run //
	public void run() {
	
		try {
			// tao kenh giao tiep //
			InputStream in =  s.getInputStream();
			OutputStream out = s.getOutputStream();
			
			int kitu = 0;
			while(true) {
				// Doc du lieu //
				kitu = in.read();
				// Thoat //
				if(kitu == -1) break;
				// xu li //
				int result = kitu;
				// Goi ket qua ve Client //
				out.write(result);
			}
			System.out.println("Client da dong ket noi!");
			// Dong noi ket //
			s.close();
		}catch(IOException e) {
			e.toString();
			System.out.println("Co loi xay ra khong the giao tiep!");
		}
	}
	
		
		
}
