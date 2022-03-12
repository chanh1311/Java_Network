// Nguyen Van Chanh - B1809107 //

package ThucHanhTrenLop_UCP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class buoi3_Bai3_Client_Lientuc1 {

	public static void main(String[] args) {
		
		try {
			// Tao UDP SocKet //
			DatagramSocket ds = new DatagramSocket(1111);
			
			// Nhap 1 chuoi tu ban phim /
			Scanner sc = new Scanner(System.in);
		while(true) {
			String str_goi = sc.nextLine();
			// Kiem tra dieu kien thoat //
			if(str_goi.equals("exit")) break;
			
			// Dong goi chuoi goi //
			byte[] arr_goi = str_goi.getBytes();
			int len_goi = arr_goi.length;
			InetAddress address = InetAddress.getByName("localhost");
			int port = 9999;
			DatagramPacket goigoi = new DatagramPacket(arr_goi, len_goi, address, port);
			
			// Gui goi UDP moi vua tao cho Socket //
			ds.send(goigoi);
			System.out.println("Da goi: " + str_goi);
			
			// Tao ra 1 goi de nhan du lieu tu Server goi ve //
			byte[] arr_goinhan = new byte[60000];
			int len_goinhan = arr_goinhan.length;
			DatagramPacket goinhan = new DatagramPacket(arr_goinhan, len_goinhan);
			// Nhan goi //
			ds.receive(goinhan);
			// Hien thi //
				// Lay du lieu ra //
			byte[] arr_nhan = goinhan.getData();
			int len_nhan = goinhan.getLength();
			
			System.out.println("Da nhan: " + new String(arr_nhan,0,len_nhan));
		}	
			
		}catch(SocketException e) {
			System.out.println("Loi Socket!");
		}catch(UnknownHostException e) {
			System.out.println("Khong tim thay dia chi!");
		}catch(IOException e) {
			System.out.println("Loi IO!");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
		

	}

}
