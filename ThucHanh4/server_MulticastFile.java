package ThucHanh4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class server_MulticastFile {

	public static void main(String[] args) {
		// Tao UDP socket //
		Scanner sc = new Scanner(System.in);
		try {
			DatagramSocket ds = new DatagramSocket();
			// Nhap ten file //
			while(true) {
				System.out.println("Nhap ten file can goi: ");
				String tenfile = sc.nextLine();
				// Lay noi dung file //
					File file = new File(tenfile);
					if(!file.exists() || !file.isFile()){
						System.out.println("File khong ton tai!");
						continue;
					}
					else{
			
						while(true) {
							FileInputStream readfile = new FileInputStream(tenfile);
							int len = (int)file.length();
							byte[] b = new byte[len];
							int n = readfile.read(b);
							
							// Tao goi goi //
							DatagramPacket packgoi = new DatagramPacket(b, n, InetAddress.getByName("230.0.0.1"), 9999);
							// goi cho group 230.0.0.1 nam o cong 9999 //
							
							// Goi goi //
							ds.send(packgoi);
							System.out.println("Da goi file thanh cong!");
							readfile.close();
							Thread.sleep(30000);
						}
						
					}
				
			}
			
					
		} catch (SocketException e) {
			System.out.println("Loi tao Socket!");
		} catch (UnknownHostException e) {
			System.out.println("Khong tim thay address goi!");
		} catch (IOException e) {
			System.out.println("Loi nhap xuat!");
		} catch (InterruptedException e) {
			System.out.println(e);
		} 
		
		

	}

}
