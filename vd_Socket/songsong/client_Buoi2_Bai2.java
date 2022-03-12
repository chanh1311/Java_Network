package vd_Socket.songsong;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client_Buoi2_Bai2 {

	public static void main(String[] args) {
		//Tao Socket va ket noi den Server //
		try {
			Socket s = new Socket("localhost",9999);
			
			// Tao kenh giao tiep //
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			
			Scanner sc = new Scanner(System.in);
			// Nhap cau lenh //
			while(true) {
				System.out.println("Nhap vao cau lenh: ");
				String cmd = new String(sc.nextLine());
				
				// thoat //
				if(cmd.equals("exit")) break;
				
				// Khong nhap hoac sai dinh dang //
				String[] format = cmd.split(" ");
				if(cmd.equals("") || !format[0].equals("LIST") || format.length != 2) {
					System.out.println("Ban da nhap sai dinh dang, Vui long nhap lai: ");
					continue;
				}
					
				// Goi qua Server //
				byte[] cmd_send = cmd.getBytes();
				out.write(cmd_send);
				System.out.println("Da goi cho Server!");
				
				// Nhan ket qua tu Server //
				System.out.println("Nhan ve: ");
				byte[] cmd_recive = new byte[1000];
				int n = in.read(cmd_recive);
				String result = new String(cmd_recive,0,n);
				// Hien thi ket qua //
				System.out.println(result);
				
			}
			// Dong Socket //
			s.close();
			
		} catch (UnknownHostException e) {
			System.out.println("Khong tim thay dia chi!");
			
		} catch (IOException e) {
			System.out.println("Noi ket khong thanh cong!");
		}

	}

}
