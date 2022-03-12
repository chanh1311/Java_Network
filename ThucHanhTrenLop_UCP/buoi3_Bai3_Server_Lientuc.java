// Nguyen Van Chanh - B1809107 //

package ThucHanhTrenLop_UCP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class buoi3_Bai3_Server_Lientuc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			// Tao UDP Socket tren cong cu the //
			DatagramSocket ds = new DatagramSocket(9999);
			System.out.println("Da tao Socket!");
			// Tao ra goi de nhan //
			byte[] arr_goinhan = new byte[60000];
			DatagramPacket goinhan = new DatagramPacket(arr_goinhan, 60000);	
		while(true) {
			// Nhan goi //
			ds.receive(goinhan);
			
		// Xu li yeu cau //
			// lay du lieu ra //
			byte[] arr_nhan = goinhan.getData();
			int len_nhan = goinhan.getLength();
			
			// xu li //
			System.out.println("Da nhan: " + new String(arr_nhan,0,len_nhan));
			
			// Dong goi ket qua //
			InetAddress address = goinhan.getAddress();
			int port = goinhan.getPort();
			if(port == 1111) {
				port = 2222;
				System.out.println("Chuyen port goi cho 2");
			}
			else port = 1111;
			DatagramPacket goigoi = new DatagramPacket(arr_nhan, len_nhan,address,port);
			// Goi nguoc lai cho client //
			ds.send(goigoi);
		}
		} catch (SocketException e) {
			System.out.println("Loi Socket!");
		} catch (IOException e) {
			System.out.println("Loi IO!");
		}
	

	}

}
