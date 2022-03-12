package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class client_Echo {
	public static void main(String[] args) {
		try {
			// Noi ket den Server cong 7
			Socket s = new Socket("127.0.0.1",7);
			System.out.println("Da noi ket thanh cong den Server");
			// Lay ra 2 stream in-out
			InputStream is = s.getInputStream();		// Nhan du lieu
			OutputStream os = s.getOutputStream();		// Gui du lieu
			while(true) {
				// Nhap 1 ky tu ch tu ban phim
				System.out.print("Nhap 1 ky tu: ");
				int ch = System.in.read();
				// Gui ky tu ch qua cho Server
				os.write(ch);
				System.in.skip(2);		// Loai bo trong buffer \r\n
				// Kiem tra dieu kien de thoat
				if(ch=='@') break;
				// Nhan ky tu tra ve tu Server
				int ch1 = is.read();
				// Hien thi ket qua ra man hinh
				System.out.println("Nhan duoc: " + (char)ch1);
			}
			// Dong noi ket
			s.close();
		}
		catch(UnknownHostException e) {
			System.out.println("Sai dia chi Server");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}
}
