package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Echo {

	public static void main(String[] args) {
		try {
			// Tao Server Socket lang nghe noi ket cong 7
			ServerSocket ss = new ServerSocket(7);
			System.out.println("Da khoi tao xong Server");
			while(true) {		// Phuc vu cho nhieu Client
				// Chap nhan cho Client noi ket
				Socket s = ss.accept();
				System.out.println("Co 1 Client " + s.getInetAddress()
									+ " cong " + s.getPort() + " noi ket");
				// Lay ra 2 stream in-out
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				while(true) {	// Phuc vu cho 1 Client nhieu lan
					// Nhan yeu cau (ky tu ch) tu Client
					int ch = is.read();
					System.out.println("Nhan duoc: " + ch);
					// Kiem tra dieu kien de thoat
					if(ch=='@') break;
					// Xu ly yeu cau
					int ch1 = ch;
					// Gui ket qua cho Client
					os.write(ch1);
				}
				// Dong noi ket
				s.close();
			}
			//ss.close();
		}
		catch(IOException e) {
			System.out.println("Khong khoi tao duoc Server");
		}
	}

}


