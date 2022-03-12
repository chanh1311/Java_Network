package Thuchanh1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client_ChuoiSo1{
	public static void main(String args[]) {
		
		try {
			// Tao Socket va ket noi den Server //
			Socket s = new Socket("localhost",9999);
			// Tao kenh giao tiep //
			InputStream in = s.getInputStream();
			OutputStream os = s.getOutputStream();
			
			
			// Nhap nhieu lan //
			while(true){
				
				// Nhap chuoi so nguyen va doc thanh chuoi String //
				System.out.println("Nhap vao chuoi so nguyen:");
				Scanner input = new Scanner(System.in);
				String str = new String(input.nextLine());
				// Chuyen chuoi string sang chuoi Byte de co the goi //
				byte[] goiByte = str.getBytes();
				// Goi du lieu qua server //
				os.write(goiByte);
				// kiem tra dieu kien thoat//
				if(str.equals("exit")) break;
				// Nhan ket qua tu server //
				byte[] nhanByte = new byte[1000];
				int n = in.read(nhanByte);
				//Hien thi ket qua//
				System.out.println("Nhan ve: " + new String(nhanByte,0,n));
			}
			// dong ket noi //
			s.close();
			
		} catch(UnknownHostException e) {
			System.out.println("khong tim thay dia chi!");
			e.printStackTrace();
			
		} catch(IOException e) {
			System.out.println("Khong the tao Socket hoac Stream!");
			e.printStackTrace();
			
		}
		
		
		
	}
}