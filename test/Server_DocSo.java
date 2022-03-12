package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_DocSo {

	public static void main(String[] args) {
		try {
			// Tao Server Socket lang nghe noi ket cong 7777
			ServerSocket ss = new ServerSocket(7778);
			System.out.println("Da khoi tao xong Server");
			while(true) {		// Phuc vu cho nhieu Client
				// Chap nhan cho Client noi ket
				Socket s = ss.accept();
				System.out.println("Co 1 Client " + s.getInetAddress()
									+ " cong " + s.getPort() + " noi ket");
				// Lay ra 2 stream in-out
				InputStream is = s.getInputStream();		// Nhan du lieu
				OutputStream os = s.getOutputStream();		// Gui du lieu
				while(true) {	// Phuc vu cho 1 Client nhieu lan
					// Nhan yeu cau (ky tu ch) tu Client
					int ch = is.read();
					System.out.println("Nhan duoc: " + ch);
					// Kiem tra dieu kien de thoat
					if(ch=='@') break;
					// Xu ly yeu cau - Doc so
					String ketqua = "Khong biet";
					switch(ch) {
						case '0': ketqua = "Khong"; break;
						case '1': ketqua = "Mot"; break;
						case '2': ketqua = "Hai"; break;
						case '3': ketqua = "Ba"; break;
						case '4': ketqua = "Bon"; break;
						case '5': ketqua = "Nam"; break;
						case '6': ketqua = "Sau"; break;
						case '7': ketqua = "Bay"; break;
						case '8': ketqua = "Tam"; break;
						case '9': ketqua = "Chin";
					}
					// Gui ket qua cho Client
					byte b[] = ketqua.getBytes();
					os.write(b);
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
