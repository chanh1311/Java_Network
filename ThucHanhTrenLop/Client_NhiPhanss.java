package ThucHanhTrenLop;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client_NhiPhanss {

	public static void main(String[] args) {
		// Noi Ket den Server //
		try {
			Socket s = new Socket("localhost",2021);
			
			// Lay 2 stream in-out //
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			// Nhap so nguyen tu ban phim //
			Scanner input = new Scanner(System.in);
			while(true) {
				System.out.println("Nhap 1 chuoi so: ");
				String str = input.nextLine();
				// thoat //
				if(str.equals("exit")) break;
				// Gui chuoi cho Server //
				byte[] b = new byte[1000];
				int n = in.read(b);
				// Nhan chuoi ket qua tra ve tu Server //
				String ketqua = new String(b,0,n);
				System.out.println("Ket qua la: " + ketqua);
			}
			// Dong ket noi! //
			s.close();
		}catch(UnknownHostException e) {
			System.out.println("Khong tim thay Server!");
		}catch(IOException e) {
			System.out.println("Co loi xay ra, khong tao duoc Socket cho Client!");
		}

	}
}
