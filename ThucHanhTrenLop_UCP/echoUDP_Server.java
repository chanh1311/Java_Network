1package ThucHanhTrenLop_UCP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class echoUDP_Server {

	public static void main(String[] args) {
		// Tao ra UDP Socket cong 7 //
		try {
			DatagramSocket ds = new DatagramSocket(7);
			// Tao ra goi de nhan //
			byte[] b = new byte[60000];
			// Nhan goi yeu cau tu client //
			while(true) {
				DatagramPacket goinhan = new DatagramPacket(b, 60000);
				ds.receive(goinhan);
				// xu li yeu cau //
				byte b1[] = goinhan.getData();
				int len1 = goinhan.getLength();// chieu dai cua goi //
				String yeucau = new String(b1,0,len1);
				System.out.println(yeucau);
				String ketqua = yeucau.toUpperCase();
				//Dong goi ket qua //
				byte[] b2 = ketqua.getBytes();
				int len2 = b2.length;
				InetAddress dc2 = goinhan.getAddress();
				int p2 = goinhan.getPort();
				DatagramPacket out = new DatagramPacket(b2, len2, dc2,p2);
				
				// Gui goi ket qua cho Client //
				ds.send(out);
			}
			
		} catch (SocketException e) {
			System.out.println("Khong the tao UDPSocket!");
		}catch(IOException e) {
			System.out.println("Loi nhap xuat!");
		}
		
		
	}

}
