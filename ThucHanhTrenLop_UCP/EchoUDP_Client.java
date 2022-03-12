package ThucHanhTrenLop_UCP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoUDP_Client {

	public static void main(String[] args) {
		// tao UDP Socket //
		try {
			DatagramSocket ds = new DatagramSocket();
			// Nhap 1 chuoi tu ban phim //
			Scanner kb = new Scanner(System.in);
			
			while(true) {
				System.out.println("Nhap vao 1 chuoi: ");
				String str = kb.nextLine();
				if(str.equals("EXIT")) break;
				// Dong goi chuoi //
				byte b[] = str.getBytes();
				int len = b.length;
				InetAddress dc = InetAddress.getByName("localhost");
				int p = 7;
				DatagramPacket goigui = new DatagramPacket(b,len, dc,p);
				// Gui goi UDP qua Server //
				ds.send(goigui); // dua dia chi IP, cong ben goi vao //
				
				// Tao ra goi de nhan //
				byte b1[] = new byte[60000];
				DatagramPacket goinhan = new DatagramPacket(b1, 60000);
				
				// Nhan goi tra ve tu Server //
				ds.receive(goinhan);
				
				// Hien thi //
				byte b2[] = goinhan.getData();
				int len2 = goinhan.getLength();
				String ketqua = new String(b2,0,len2);
				System.out.println(ketqua);
				
			}
			
			
			// Dong UDP Socket //
				ds.close();
				kb.close();
			
		}catch(SocketException e) {
			System.out.println("Khong khoi tao UDP");
			
		}catch(UnknownHostException  e) {
			System.out.println("Khong tim thay address!");
		}catch(IOException e) {
			System.out.println("Loi nhap xuat!");
		}
		
		

	}

}
