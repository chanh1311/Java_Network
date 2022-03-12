package Thuchanh2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client_buoi2_bai1{
	public static void main(String args[]) {
		
		try {
			// Tao Socket va ket noi den Server //
			Socket s = new Socket("localhost",9999);
			// Tao kenh giao tiep //
			InputStream in = s.getInputStream();
			OutputStream os = s.getOutputStream();
			
			
			// Nhap nhieu lan //
			Scanner input = new Scanner(System.in);
			while(true){
				
				// Nhap chuoi String //
				System.out.println("Nhap vao ten day du:");
				String str = new String(input.nextLine());
				// kiem tra dieu kien nhap//
				if(str.equals("")) {
					System.out.println("Ho ten khong duoc de trong, Vui long nhap lai!");
					continue;
				}
				// Goi du lieu qua server //
				byte[] goiByte = str.getBytes();
				os.write(goiByte);
				// Kiem tra dieu kien thoat //
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
			
			
		} catch(IOException e) {
			System.out.println("Khong the tao Socket hoac Stream!");
			
		}
		
		
			
		
	}
}