package Thuchanh1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server_ChuoiSo1{
	public static void main(String args[]) {
		
		try {
			// Mo Socket server //
			ServerSocket sv = new ServerSocket(9999);
			System.out.println("Da mo Socket!");
			// Chap nhan ket noi //
		while(true){
			try {
				Socket s = sv.accept();
				System.out.println("Co 1 client " + s.getInetAddress() + " cong "+ s.getPort()+ " Da ket Noi!");
				// Tao kenh truyen //
				InputStream in = s.getInputStream();
				OutputStream os = s.getOutputStream();
				
				 while(true) {	
					 try {
						 // Nhan du lieu tu client //
						 	byte[] nhanByte = new byte[1000];
						 	int n = in.read(nhanByte);
						 	// Hien thi //
						 	System.out.println("Nhan duoc du lieu tu client la: " + new String(nhanByte,0,n));
						 	// Tao 1 chuoi //
						 	String string = new String(nhanByte,0,n);
						 	if(string.equals("exit")) break;
							// xu li du lieu chuoi so nguyen //
							 Integer intString = Integer.parseInt(string);
							 String result = new String(Integer.toBinaryString(intString));
							 // Goi du lieu ve client //
							 byte[] arr = result.getBytes();
							 os.write(arr);
							 
					 		// Khoi nay xu li du lieu khong phai so nguyen //
					 	}catch(NumberFormatException e){
					 		String result = new String("Khong phai so nguyen!");
					 		// Goi du lieu ve client //
							 byte[] arr = result.getBytes();
							 os.write(arr);
					 	}
			
				 }	// while nhap nhieu lan client
				 s.close();	// dong ket noi //
			}catch(IOException e){
				System.out.println("Khong the chap nhan ket noi hoac loi tao Stream!");
			}
		} // while chap nhan ket noi tu client //	
		
		}catch(IOException e){ 
			System.out.println("Khong mo duoc Socket");
		}
		
		
		
	}
}
