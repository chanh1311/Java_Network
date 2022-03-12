package vd_Socket;

import java.net.*;
import java.util.Scanner;
import java.io.*;
public class client_ChuoiSo {

	public static void main(String[] args){
		// Noi Ket den Server cong 7 
		try{
			Socket s = new Socket("127.0.0.1",7778);
			System.out.println("Da noi ket thanh cong den Server");
			
			// Lay ra 2 Stream In-Out 
			
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			
			// Nhap 1 ki tu tu ban phim 
			Scanner input = new Scanner(System.in);
			while(true){
				System.out.println("Nhap chuoi so:");
				// Doc string tu ban phim //
				String str = new String(input.nextLine());
				// Nhap vao chuoi de thoat //
				if(str.equals("exit")) break;
				// Chuyen String sang mang byte va goi di //
				byte[] b = str.getBytes();
				os.write(b);
				
				// Nhan mot mang so nhi phan tu server //
				byte[] strBinary = new byte[1000];
				int n = is.read(strBinary);
				// Hien thi ket qua ra man hinh
				System.out.println(new String(strBinary,0,n));
				
			}
			// Dong ket noi
			s.close();
		}catch(UnknownHostException e ){
			System.out.println("Khong tim thay dia chi!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Loi IO!");
		}
	}

}
