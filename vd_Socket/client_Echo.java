package vd_Socket;

import java.net.*;
import java.io.*;
public class client_Echo {

	public static void main(String[] args){
		// Noi Ket den Server cong 7 
		try{
			Socket s = new Socket("127.0.0.1",7);
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
				// Nhan ky tu tra ve tu Server
				int ch1 = is.read();
				// Hien thi ket qua ra man hinh
				System.out.println("Nhan duoc: " + (char)ch1);
				// Dong ket noi
			}
			s.close();
		}catch(UnknownHostException e ){
			System.out.println("Khong tim thay dia chi!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Loi IO!");
		}
	}

}
