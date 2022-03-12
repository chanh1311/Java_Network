package ThucHanh3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPfile_client {

	public static void main(String[] args) {
		try{
			// Tao UDP Socket  //
			DatagramSocket ds = new DatagramSocket();
			// Nhap vao dia chi Server va ten file can lay ve //
			Scanner kb = new Scanner(System.in);
			
			System.out.println("Nhap dia chi sv");
			String dcServer = kb.nextLine();
			System.out.println("ten file: ");
			String tenFile = kb.nextLine();
			// Dong goi yeu cau  //
			String yeucau = "READUDP " + tenFile;
			byte b[] = yeucau.getBytes();
			int len = b.length;
			InetAddress dc = InetAddress.getByName(dcServer);
			int p = 2000;
			DatagramPacket goigui = new DatagramPacket(b, len,dc,p);
			// Goi goi //
			ds.send(goigui);
			// Nhan //
			byte[] b1 = new byte[60000];
			DatagramPacket goinhan = new DatagramPacket(b1, 60000);
			ds.receive(goinhan);
			// Kiem tra du lieu //
				// lay du lieu //
			byte b2[] = goinhan.getData();
			int len2 = goinhan.getLength();
				// kiem tra	//
			if(len2 == 0) {
				System.out.println("File khong ton tai or rong!");
			}else {
				System.out.println("Nhap ten file can luu: ");
				String tenfile = kb.nextLine();
				FileOutputStream file = new FileOutputStream(tenfile);
				// Luu file //
				file.write(b2,0,len2);
				file.close();
				System.out.println("Da doc xong file!");
			}
			
			
			// Dong //
			ds.close();
		}catch(SocketException e) {
			System.out.println("Khong the tao UDP Socket!");
		}catch (UnknownHostException e) {
			System.out.println("Khong tim thay address!");
		} catch (FileNotFoundException e) {
			System.out.println("Khong tim thay duong dan luu file!");	
		} catch (IOException e) {
			System.out.println("loi nhap xuat!");
		}
		
	}

}
