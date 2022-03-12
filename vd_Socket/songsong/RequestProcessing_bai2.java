package vd_Socket.songsong;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RequestProcessing_bai2 extends Thread{
	// Khoi tao socket //
	private Socket s;
	
	public RequestProcessing_bai2(Socket s) {
		this.s = s;
	}
	// Xu li //
	public void run(){
		try {
			// tao kenh giao tiep //
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			while(true) {
				// Nhan du lieu tu client //
				byte[] cmd_revice = new byte[1000];
				int n = in.read(cmd_revice);
				// thoat //
				if( n == -1) {
					System.out.println("Client da dong!");
					break;
				}
				// Xu li cau lenh de lay duong dan //
				String cmd = new String(cmd_revice,0,n);
				String[] list_cmd = cmd.split(" ");
				String filename = list_cmd[1];
				System.out.print("Yeu cau: ");
				System.out.println(filename);
				String path = filename;
				
				// Tao doi tuong va lay con //
				try {
					File dir = new File(path);
					String[] children = dir.list();
					// Chuyen ve dinh dang co the goi //
					String str_child = new String();
					for(String x : children){
				          str_child += x;
				          str_child += "  ";
				       }
					str_child = str_child.trim();
					byte[] send = str_child.getBytes();
					out.write(send);
				}
				catch(NullPointerException e) {
					byte[] send = "Khong tim thay thu muc yeu cau!".getBytes();
					out.write(send);
				}
			}	// while //
			s.close();
		}catch(IOException e) {
			System.out.println("Khong tao duoc kenh giao tiep!");
		}
	}
	
}
