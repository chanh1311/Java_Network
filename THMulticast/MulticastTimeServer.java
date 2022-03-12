package THMulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;


public class MulticastTimeServer {

	public static void main(String[] args) {
		DatagramSocket ds;
		try {
			// Tao UDP socket //s
			ds = new DatagramSocket();
			// Lay thong tin ngay gio //
			while(true) {
				Date d = new Date();
				String ketqua = d.toString();
				// Dong goi UDP //
				byte[] b = ketqua.getBytes();
				int len = b.length;
				InetAddress dc = InetAddress.getByName("230.0.0.1");
				int p = 9013;
				DatagramPacket goigui = new DatagramPacket(b, len, dc, p);
				// goi //
				ds.send(goigui);
				// Them while true //
				Thread.sleep(1000);
			}
			
		} catch (SocketException e) {
			System.out.println(e.toString());
		} catch (UnknownHostException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		} catch (InterruptedException e) {
			System.out.println(e.toString());
		}
		
	}

}
