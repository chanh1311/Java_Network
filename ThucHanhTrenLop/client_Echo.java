package ThucHanhTrenLop;

import java.net.*;
import java.io.*;
public class client_Echo{

	public static void main(String[] args){
		// Noi Ket den Server cong 777 
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
				// Gui ky tu ch qua Server
				System.in.skip(2);
				os.write(ch);
				//thoat //
				if(ch=='@') break;
				// Nhan nhieu ki tra ve tu Server
				byte[] b = new byte[1000];
				int n = is.read(b);
				// Hien thi ket qua ra man hinh
				System.out.println((char) n);
				
			}
			// Dong ket noi
			System.out.println("Dong noi ket!");
			s.close();
		}catch(UnknownHostException e ){
			System.out.println("Khong tim thay dia chi!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Khong the tao Socket hoac Stream!");
		}
	}

}
