package BaiMauUDP;

import java.net.*;
import java.io.*;

public class UDPFileServer {
	public static void main(String[] args) {
		try {
			// Tao UDP Socket cong 2000
			DatagramSocket ds = new DatagramSocket(2000);
			// Nhan goi yeu cau
			byte b[] = new byte[1000];
			DatagramPacket goinhan = new DatagramPacket(b,1000);
			while(true) {
				ds.receive(goinhan);			
				// Lay thong tin yeu cau
				byte b1[] = goinhan.getData();
				int len1 = goinhan.getLength();
				InetAddress dc1 = goinhan.getAddress();
				int p1 = goinhan.getPort();
				String yeucau = new String(b1,0,len1); 
				// Xu ly yeu cau
				String tenfile = yeucau.substring(8);
				System.out.println("Client yeu cau file: " + tenfile);
				File f = new File(tenfile);
				if(f.exists() && f.isFile()) {
					// File ton tai
					int len2 = (int)f.length();	// chieu dai file //
					byte b2[] = new byte[len2];
					// Doc file
					FileInputStream fis = new FileInputStream(tenfile);
					fis.read(b2);
					fis.close();
					// Dong goi
					DatagramPacket goigui = new DatagramPacket(b2,len2,dc1,p1);
					ds.send(goigui);
				}
				else {
					byte b2[] = new byte[10];
					int len2 = 0;	// chieu dai goi //
					DatagramPacket goigui = new DatagramPacket(b2,len2,dc1,p1);
					ds.send(goigui);
				}
			}
		}
		catch(SocketException e) {
			System.out.println("Khong khoi tao duoc UDP Socket");
		}
		catch(FileNotFoundException e) {
			System.out.println("Khong tim thay file");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}
}
