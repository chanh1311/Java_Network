package ThucHanhTrenLop;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server_ListThuMuc {

	public static void main(String[] args) {
		// Tao Server Socket //
		try {
			ServerSocket ss = new ServerSocket(9990);
			
			//Chap nhan noi ket //
			Socket s = ss.accept();
			
			// Lay ra 2 Stream //
			InputStream in  = s.getInputStream();
			OutputStream out = s.getOutputStream();
			// Chuyen ve cai nay cho de xu ly //
			Scanner input = new Scanner(in);
			PrintWriter pw = new PrintWriter(out);
			// Nhan tu client //
			String caulenh = input.nextLine();
			// Lay ten Thu muc //
			String tenthumuc = caulenh.substring(5);
			// Xu ly yeu cau - tham khao class File //
			File f = new File(tenthumuc);
			if(f.exists() && f.isDirectory()) {
				String kq[] = f.list();
				int n = kq.length;
				//goi so luong thanh phan //
				pw.println(n); pw.flush();
				// Goi tiep cac TP tiep theo //
				for(int i = 0; i < n; i++) {
					File temp = new File(tenthumuc + "/" + kq[i]);
					if(temp.isFile()) {
						
					}
				}
				
			}
		} catch (IOException e) {
			System.out.println("");
		}
		
		
		
		
		
		
		
		
		
		//Goi ket qua //

	}

}
