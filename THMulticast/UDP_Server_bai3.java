package THMulticast;

/* Ho ten: Nguyen Van Chanh
	MSSV: B1809107
*/


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class UDP_Server_bai3 {
	public static void main(String[] args) {
		// Tao ra 1 UDP Socket tren 1 cong cu the //
		try {
			
			DatagramSocket ds = new DatagramSocket(22444);
			System.out.println("Server da thiet lap Socket!");
			// Tao ra goi den nhan //
			byte[] b_nhan = new byte[60000];
		while(true) {
				DatagramPacket goinhan = new DatagramPacket(b_nhan, 60000);
				
				// Nhan goi //
				ds.receive(goinhan);
				System.out.println("Da nhan duoc goi!");
				// Xu li yeu cau //
				byte[] arr_nhan = goinhan.getData();
				int len_nhan = goinhan.getLength();
				String str_ip = new String(arr_nhan,0,len_nhan);
				InetAddress address = InetAddress.getByName(str_ip);
				
				String firstTriplet = address.getHostAddress().
				        substring(0,address.getHostAddress().indexOf('.'));
				String ketqua = new String();
				if (Integer.parseInt(firstTriplet) < 128) {
				    ketqua = new String("Noi dung ban goi la 1 dia chi thuoc lop A");
				} else if (Integer.parseInt(firstTriplet) < 192) {
					ketqua = new String("Noi dung ban goi la 1 dia chi thuoc lop B");
				} else {
					ketqua = new String("Noi dung ban goi la 1 dia chi thuoc lop C");
				}
				// Dong goi ket qua //
				byte[] arr_goi = ketqua.getBytes();
				int len_goi = arr_goi.length;
				InetAddress address_goi = goinhan.getAddress();
				int port = goinhan.getPort();
				DatagramPacket goigoi = new DatagramPacket(arr_goi, len_goi,address_goi,port);
				// Goi cho client //
				ds.send(goigoi);
			}	
			
		}catch(SocketException e) {
			System.out.println("Co loi trong qua trinh thuyet lap Socket!");
		} catch (IOException e) {
			System.out.println("Co loi IO xay ra!");
		}
		
	
	}
}
