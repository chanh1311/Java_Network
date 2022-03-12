package THMulticast;


import java.net.*;
import java.io.*;

public class MIlticastTimeClient {

	public static void main(String[] args) {
		// Tao 1 multicast //
		MulticastSocket socket;
		try {
			socket = new MulticastSocket(9013);
			
			// Ttham gia nhom 
			InetAddress dc = InetAddress.getByName("230.0.0.1");
			socket.joinGroup(dc);
			// Nhan goi
			byte[] b = new byte[1000];
			DatagramPacket goinhan = new DatagramPacket(b, 1000);
			socket.receive(goinhan);
			// Hien thi 
			byte b1[] = goinhan.getData();
			int len1 = goinhan.getLength();
			String ketqua = new String(b1,0,len1); 
			System.out.println("Ket qua la: " + ketqua);
			// Roi khoi nhom //
			socket.leaveGroup(dc);
			// Dong Socket //
			socket.close();
		} catch (IOException e) {
			System.out.println("Co loi khi tao va thuc thi phia client!");
		}
		
	}

}
