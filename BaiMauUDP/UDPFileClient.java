package BaiMauUDP;
import java.net.*;
import java.io.*;
import java.util.Scanner;
public class UDPFileClient {
	public static void main(String[] args) {
		try {
			// Tao UDP Socket
			DatagramSocket ds = new DatagramSocket();
			// Nhap tu ban phim: dia chi Server, ten file can lay ve
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap dia chi Server: ");
			String dcServer = kb.nextLine();
			System.out.print("Nhap ten file tren Server can lay ve: ");
			String tenfile = kb.nextLine();
			// Tao ra yeu cau
			String yeucau = "READUDP " + tenfile;
			// Dong goi yeu cau
			byte b[] = yeucau.getBytes();
			int len = b.length;
			InetAddress dc = InetAddress.getByName(dcServer);
			int p = 2000;
			DatagramPacket goigui = new DatagramPacket(b,len,dc,p);
			// Gui goi yeu cau qua Server
			ds.send(goigui);
			// Tao ra goi tin de nhan
			byte b1[] = new byte[60000];
			DatagramPacket goinhan = new DatagramPacket(b1,60000);
			// Nhan goi ket qua
			ds.receive(goinhan);
			// Lay thong tin trong goi ket qua
			byte b2[] = goinhan.getData();
			int len2 = goinhan.getLength();
			if(len2==0)
				System.out.println("File khong ton tai hoac file rong");
			else {
				// Luu thanh file
				System.out.print("Nhap ten file can luu: ");
				String tenfileluu = kb.nextLine();
				FileOutputStream f = new FileOutputStream(tenfileluu);
				f.write(b2,0,len2);
				f.close();
				System.out.println("Da ghi file thanh cong");
			}
			ds.close();
		}
		catch(SocketException e) {
			System.out.println("Khoi tao UDP Socket that bai");
		}
		catch(UnknownHostException e) {
			System.out.println("Sai dia chi");
		}
		catch(FileNotFoundException e) {
			System.out.println("Ghi file that bai");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}
}
