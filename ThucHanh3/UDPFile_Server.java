package ThucHanh3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import java.net.SocketException;

public class UDPFile_Server {

	public static void main(String[] args) {
		// Tao UDP Socket cong 2000 //
		try {
			DatagramSocket ds = new DatagramSocket(2000);
			// Nhan goi yeu cau tu client //
			byte b[] = new byte[3000];
			DatagramPacket goinhan = new DatagramPacket(b, 3000);
			
			while(true) {
				ds.receive(goinhan);
				// Xu li yeu cau
					// Lay thong tin tu goi //
				byte[] arr_nhan = goinhan.getData();
				//System.out.println(arr_nhan.length); // 3000
				//System.out.println(goinhan.getLength()); // 68
				int len_nhan = goinhan.getLength();// chu y cho nay //
				String strnhan = new String(arr_nhan,0,len_nhan);
				System.out.println("Nhan duoc:" + strnhan);
				
					// xu ly //
				
				   	// tao doi tuong de doc file //
					String tenfile = strnhan.substring(8);
					System.out.println("Yeu cau: " + tenfile);
					File file = new File(tenfile);// trim()-->new String(arr,0,len)? //
					// Truong hop file ton tai //
						if(file.exists() && file.isFile()) {
							
							FileInputStream in = new FileInputStream(file);
							int len_file = (int)file.length();
							byte[] arr_file = new byte[len_file];
							
							// doc file //
							in.read(arr_file);
							in.close();
							
							// Dong goi va goi //
							DatagramPacket pack_goi = new DatagramPacket(arr_file, len_file,goinhan.getAddress(),goinhan.getPort());
							ds.send(pack_goi);
					
						}else {
							// truong hop file khong ton tai hoac rong //
							byte[] arr_goi = new byte[5];
							int len_goi = 0;
							DatagramPacket pack_goi = new DatagramPacket(arr_goi, len_goi, goinhan.getAddress(), goinhan.getPort());
							ds.send(pack_goi);
						}
							
			}
		}catch(SocketException e) {
			System.out.println("Khong the tao UDP Socket!");
		} catch (IOException e) {
			System.out.println("loi nhap xuat!");
			System.out.println(e.toString());
		}
		
		


	}

}
