package ThucHanhTrenLop;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client_DocSo {

	public static void main(String[] args) {
		
		try {
			// Tao noi ket den Server //
			Socket s = new Socket("127.0.0.1",9999);
		
			// Tao 2 tream IN-OUT //
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			
			while(true) {		// Nhap nhieu lan //
				// Nhap du lieu //
				System.out.println("Nhap vao ki tu(0->9):");
				int songuyen = System.in.read();
				// Goi Yeu cau //
				out.write(songuyen);
				System.in.skip(100); //loai bo 2 ki tu thua //
				// thoat //
				if(songuyen == '@') break;
				// Nhan ve du lieu tu Server //
				byte[] ketqua = new byte[1000];
				int n = in.read(ketqua);
				// Hien Thi Du Lieu ra man hinh //
				System.out.println("Ket qua: " + new String(ketqua,0,n));
				
				
			}
			// Dong noi ket //
			s.close();
		} catch (UnknownHostException e) {
			System.out.println("Khong tim thay dia chi!");
		} catch (IOException e) {
			System.out.println("Co loi trong qua trinh noi ket!");
		}
		
		
		
		
		
		
		
				
		
	}

}
