package ThiThuLTM;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Client_Multisocket_Cau1 {
	public static void main(String[] args) {
		// Tao 1 multicast //
		MulticastSocket socket;
		try {
			socket = new MulticastSocket(33433);
			
			// Ttham gia nhom 
			InetAddress dc = InetAddress.getByName("230.3.3.3");
			socket.joinGroup(dc);
			// Nhan goi
			while(true) {
				byte[] b = new byte[60000];
				DatagramPacket goinhan = new DatagramPacket(b, 60000);
				socket.receive(goinhan);
				// Hien thi 
				byte b1[] = goinhan.getData();
				int len1 = goinhan.getLength();
				String X = new String(b1,0,len1); 
				
				System.out.println("chuoi X la: " + X);
				// Roi khoi nhom //
				socket.leaveGroup(dc);
				// Dong Socket //
			}
			
		} catch (IOException e) {
			System.out.println("Co loi khi tao va thuc thi phia client!");
		}
		
	}
}
