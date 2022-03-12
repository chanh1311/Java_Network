package THMulticast;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCP_ReadFileClient {

	public static void main(String[] args) {
		//  Nhap dia chi SV va Ten File //
		Scanner kb = new Scanner(System.in);
		System.out.println("Nhap vao adress SSV:");
		String dcServer = kb.nextLine();
		System.out.println("Nhap ten file tren Server:");
		String tenfile = kb.nextLine();
		System.out.println("Nhap ten file can luu:");
		String tenfilesava = kb.nextLine();
		// Noi ket den Server //
		try {
			Socket s = new Socket(dcServer,23456);
			// Lay ra 2 Stream IN-OUT //
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			Scanner sc = new Scanner(in);
			PrintWriter pw = new PrintWriter(out);
			// Goi cau lenh "READ tenfile"
			String caulenh = "READ " + tenfile;
			pw.println(caulenh); pw.flush();
			// Nhan ve kich thuoc cuia file 
			String ketqua = sc.nextLine();
			int size = Integer.parseInt(ketqua);
			
			if(size == -1) {
				System.out.println("FIle khong ton tai!");
			}else if(size == 0) {
				System.out.println("file rong!");
			}else {
				// Nhan ve noi dung cua file 
				FileOutputStream f = new FileOutputStream(tenfilesava);
				DataInputStream dis = new DataInputStream(in); // thay vi nhan tren is thi nhan tren Data
				// Nhan tung doan dua vao buffer //
				byte b[] = new byte[10000];
				int tong = 0;
				while(true) {
					int n = dis.read(b,0,10000);
					f.write(b,0,n);
					tong += n;
					if(tong==size) break;
				}
				f.close();
				System.out.println("Da ghi file thanh cong!");
			}
			// Dong noi ket //
			s.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// FileNotFound //
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		

	}

}
