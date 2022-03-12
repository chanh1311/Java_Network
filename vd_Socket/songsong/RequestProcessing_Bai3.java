package vd_Socket.songsong;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class RequestProcessing_Bai3 extends Thread{
	// Lay socket //
	private Socket s;
	
	public RequestProcessing_Bai3(Socket s){
		this.s = s;
		
	}
	// ham xu ly //
	public void run() {
		// Tao luong xu li //
		try {
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			// Doc du lieu tu Client //
			
			while(true) {
				byte[] receive = new byte[1000];
				int n = in.read(receive);
				if(n == -1) {
					System.out.println("Client da dong!");
					break;
				}
				String cmd = new String(receive,0,n);
				System.out.print("Nhan duoc: ");
				System.out.println(cmd);
			// Xu ly //	
				// Lay ten file //
				 String[] list_cmd = cmd.split(" ");
				 String filename = "C:/" + list_cmd[1];
				 System.out.println(filename);
				// Doc file
				 try {
					 File file = new File(filename);
					 BufferedReader reader = new BufferedReader(new FileReader(file));
					 
					 String line = reader.readLine();
					 String contenfile = new String();
					 while(line != null) {
						 contenfile += line;
						 contenfile += "\n";
						 line = reader.readLine();
					 }
					 reader.close();
					 // goi qua cho client //
					 byte[] send = contenfile.getBytes();
					 out.write(send);
				 }catch(FileNotFoundException e) {
					 // Goi thong bao khi khong tim thay file! //
					 String thongbao = new String("Khong tim thay File!");
					 byte[] send = thongbao.getBytes();
					 out.write(send);
				 }catch(IOException e) {
					 System.out.println("Loi Doc File!");
				 }
			}
			s.close();
		}catch(IOException e) {
			System.out.println("Khong the tao kenh giao tiep(IN-OUT)!");
			//System.out.println(e.toString());
		}
	}
}
