package ThucHanh4;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Web_Sever_Ao {

	public static void main(String[] args) {
		//  Tao ra Server Socket cong 80 //
		try {
			ServerSocket ss = new ServerSocket(80);
			System.out.println("Da khoi tao xong WebServer!");
			
			// Chap nhan cho noi ket //
			Socket s = ss.accept();
			
			// Lay ra 2 stream in-out //
			InputStream is = s.getInputStream();
			OutputStream out = s.getOutputStream();
			
			Scanner sc = new Scanner(is);// doi qua de nhan dong va chuoi cho de //
			// Nhan cau lenh GET va hien thi //
			while(true) {
				String str = sc.nextLine();
				if(str.equals("")) break;
				System.out.println(str);
			}
			// Dong noi ket //
			s.close();

		
		}catch(IOException e) {
			System.out.println(e);
		}
		
	}
}
