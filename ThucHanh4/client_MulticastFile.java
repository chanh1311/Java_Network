package ThucHanh4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class client_MulticastFile {

	public static void main(String[] args) {
		// Tao multicast Socket //
		Scanner sc = new Scanner(System.in);
		
			MulticastSocket ms;
			try {
				ms = new MulticastSocket(9999);
				
				// Tham gia group //
				InetAddress dc = InetAddress.getByName("230.0.0.1");
				ms.joinGroup(dc);
				byte[] b = new byte[60000];
				DatagramPacket goinhan = new DatagramPacket(b, 60000);
				ms.receive(goinhan);
				// Nhan goi  //
				byte[] nhan = goinhan.getData();
				int len1 = goinhan.getLength();
				// Luu noi dung File //
				System.out.println("Nhap ten file can luu: ");
				String file = sc.nextLine();
				FileOutputStream f = new FileOutputStream(file);
				f.write(nhan,0,len1);
				System.out.println("Ghi file thanh cong!");
				// Roi khoi nhom //
				ms.leaveGroup(dc);
				// Dong //
				f.close();
				ms.close();
				sc.close();
				
			} catch (IOException e) {
				System.out.println("Khong the thiet lap Multicast!");
			}
			
		
		
		
		
		
		
		
		
		
		
		

	}

}
