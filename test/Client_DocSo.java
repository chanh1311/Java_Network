package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client_DocSo {

	public static void main(String[] args) {
		try {
			// Noi ket den Server cong 7777
			Socket s = new Socket("127.0.0.1",7778);
			System.out.println("Da noi ket thanh cong den Server");
			// Lay ra 2 stream in-out
			InputStream is = s.getInputStream();		// Nhan du lieu
			OutputStream os = s.getOutputStream();		// Gui du lieu
			while(true) {
				// Nhap 1 ky tu ch tu ban phim
				System.out.print("Nhap 1 ky tu (0-9): ");
				int ch = System.in.read();
				// Gui ky tu ch qua cho Server
				os.write(ch);
				System.in.skip(2);		// Loai bo trong buffer \r\n
				// Kiem tra dieu kien de thoat
				if(ch=='@') break;
				// Nhan ket qua tra ve tu Server (nhieu ky tu)
				byte b[] = new byte[1000];
				int n = is.read(b);
				// Hien thi ket qua ra man hinh
				String ketqua = new String(b,0,n);
				System.out.println("Nhan duoc: " + ketqua);
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
