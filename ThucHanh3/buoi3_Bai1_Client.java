// Nguyen Van Chanh - B1809107 //

package ThucHanh3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class buoi3_Bai1_Client {

	public static void main(String[] args) {
		
		try {
			// Tao UDP Socket(DatagramSocket) //
			DatagramSocket ds = new DatagramSocket();
			
			// Nhap 1 chuoi tu ban phim //
			Scanner sc = new Scanner(System.in);
			
			// Dong goi chuoi goi //
			byte b_goi[] = new byte[0];
			int len = b_goi.length;
			InetAddress address_sv = InetAddress.getByName("localhost");
			int port = 13;
			DatagramPacket goigui = new DatagramPacket(b_goi, len, address_sv, port);
			// Goi //
			ds.send(goigui);
			System.out.println("Da goi di: " + new String(b_goi,0,len));
			// Tao 1 goi de nhan du lieu tu Server goi ve //
			byte[] b_nhan = new byte[60000];
			DatagramPacket goinhan = new DatagramPacket(b_nhan,60000);
			// Nhan goi //
			ds.receive(goinhan);
			// Hien thi //
			byte[] arr_nhan = goinhan.getData();
			int len_nhan = arr_nhan.length;
			String str_nhan = new String(arr_nhan,0,len_nhan);
			
			System.out.println("Nhan ve: " + str_nhan);
			
			// Dong //
			sc.close();
			ds.close();
		} catch (SocketException e) {
			System.out.println("Co loi xay ra khi tao Socket!");
		} catch (UnknownHostException e) {
			System.out.println("Khong tim thay dia chi!");
		} catch (IOException e) {
			System.out.println("Co loi nhap xuat xay ra!");
		}
		
		
	}

}
