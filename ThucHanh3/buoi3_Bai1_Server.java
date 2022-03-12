// Nguyen Van Chanh - B1809107 //

package ThucHanh3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class buoi3_Bai1_Server {

	public static void main(String[] args) {
		// Tao ra 1 UDP Socket tren 1 cong cu the //
		try {
			
			DatagramSocket ds = new DatagramSocket(13);
			System.out.println("Server da thiet lap Socket!");
			// Tao ra goi den nhan //
			byte[] b_nhan = new byte[60000];
		while(true) {
			DatagramPacket goinhan = new DatagramPacket(b_nhan, 60000);
			
			// Nhan goi //
			ds.receive(goinhan);
			System.out.println("Da nhan duoc yeu cau!");
			// Xu li yeu cau //
			int len_nhan = goinhan.getLength();
			if(len_nhan == 0) {
				//Create formatter
				DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a");
				 
				//Local date time instance
				LocalDateTime localDateTime = LocalDateTime.now();
				 
				//Get formatted String
				String date = FOMATTER.format(localDateTime);
				
			// Dong goi ket qua //
				byte[] arr_goi = date.getBytes();
				int len_goi = arr_goi.length;
				InetAddress address = goinhan.getAddress();
				int port = goinhan.getPort();
				DatagramPacket goigoi = new DatagramPacket(arr_goi,len_goi,address,port);
			// Goi cho client //
				ds.send(goigoi);
			}	
			
				
		}
		
		
		}catch(SocketException e) {
			System.out.println("Co loi trong qua trinh thuyet lap Socket!");
		} catch (IOException e) {
			System.out.println("Co loi IO xay ra!");
		}
		
		
		
	}

}
