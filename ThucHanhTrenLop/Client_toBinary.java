package ThucHanhTrenLop;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client_toBinary {

	public static void main(String[] args) {
		try {
			// Ket noi den Server //
			Socket s = new Socket("127.0.0.1",9999);
			// Lay In Out //
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			
			Scanner input = new Scanner(System.in);
			while(true) {		// goi nhieu lan //
				// Nhap du lieu //
				System.out.println("Nhap 1 chuoi so nguyen: ");
				String chuoinguyen = new String(input.nextLine());
				
				// Goi du lieu qua Server //
				byte[] goi = chuoinguyen.getBytes();
				out.write(goi);
				// thoat //
				if(chuoinguyen.equals("exit")) break;
				// Nhan du lieu goi ve Tu Server //
				byte[] ketqua = new byte[1000];
				int n = in.read(ketqua);
				// Hien thi du lieu //
				System.out.println(new String(ketqua,0,n));
				
			}// while
		// Dong ket noi //
			System.out.println("Client dong ket noi!");
			s.close();
		} catch (UnknownHostException e) {
			System.out.println("Khong tim thay dia chi!");
		} catch (IOException e) {
			System.out.println("Coi loi khi ket noi den Server!");
		}
		
		
	}

}
