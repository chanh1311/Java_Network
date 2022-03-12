package vd_Socket.songsong;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client_Buoi2_bai3 {
	static final String path_file_write= "C:/test/ketqua.txt";// can tao 1 thu muc test o dia C//
	public static void main(String[] args) {
		// Tao Socket va noi ket den Server //
		try {
			Socket s = new Socket("localhost",9999);
			
			// Tao kenh giao tiep //
			InputStream in = s.getInputStream();//ex-io//
			OutputStream out = s.getOutputStream();
			
			Scanner input = new Scanner(System.in);
			// Nhap cau lenh //
			while(true) {
				System.out.println("Nhap vao cau lenh: ");
				String cmd = new String(input.nextLine());
				// thoat //
				if(cmd.equals("exit")) break;
				// Kiem tra dinh dang cau lenh //
				String[] list_cmd = cmd.split(" "); 
				if(cmd.equals("") || !list_cmd[0].equals("READ") || list_cmd.length != 2) {
					System.out.println("Ban da nhap sai dinh dang, Nhap Lai: ");
					continue;
				}
				// Goi du lieu cho server //
				byte[] send = cmd.getBytes();
				out.write(send);
				System.out.println("Da goi yeu cau len Server");
				// Nhan ket qua tu Server //
				byte[] receive = new byte[10000];
				int n = in.read(receive);
				// Ghi vao 1 file moi //
				try {
					String result = new String(receive,0,n);
					FileWriter obj = new FileWriter(path_file_write);
					obj.write(result);
					obj.close();
					System.out.println("Ghi Thanh Cong!");
				}catch(IOException e){
					System.out.println("Loi ghi File!");
					//System.out.println(e.toString());
				}
				
			}
			s.close();
		} catch (UnknownHostException e) {
			System.out.println("khong tim thay address!");
		} catch (IOException e) {
			System.out.println("Khong the noi ket!");
		}

	}

}
