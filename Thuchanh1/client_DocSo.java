package Thuchanh1;

import java.net.*;
import java.io.*;
public class client_DocSo {

	public static void main(String[] args){
		// Noi Ket den Server cong 7776
		try{
			Socket s = new Socket("127.0.0.1",7776);
			System.out.println("Da noi ket thanh cong den Server");
			
			// Lay ra 2 Stream In-Out 
			
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			
			// Nhap 1 ki tu tu ban phim 
			while(true){
				System.out.println("Nhap 1 ky tu tu ban phim:");
				int ch = System.in.read();
				//Nhap 1 ki tu de thoat //
				if(ch=='@') break;
				// Gui ky tu ch qua Server
				System.in.skip(2);
				os.write(ch);
				// Nhan nhieu ki tra ve tu Server
				byte[] b = new byte[1000];
				int n = is.read(b);
				// Hien thi ket qua ra man hinh
				System.out.println(new String(b,0,n));
				
			}
			// Dong ket noi
			s.close();
		}catch(UnknownHostException e ){
			System.out.println("Khong tim thay dia chi!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Khong the tao Socket hoac Stream!");
		}
	}

}
