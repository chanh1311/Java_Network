package Thuchanh2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client_ListDict {

	public static void main(String[] args) {
		// Tao socket va noi ket den Server //
		try {
			Socket s = new Socket("127.0.0.1",9999);	
			
			// Tao IN OUT //
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			
			Scanner sc = new Scanner(in);
			PrintWriter pw = new PrintWriter(out);
			
			Scanner input = new Scanner(System.in);
			// Nhap du lieu //
			while(true) {
				System.out.println("Hay nhap vao thu muc muon lay thong tin: ");
				String cmd = "READ " + input.nextLine(); 
				
				// Goi du lieu //
				pw.println(cmd); pw.flush();
				
				// thoat //
				if(cmd.equals("READ exit")) break;
				
				// Nhan du lieu goi ve tu Server //
				int n = Integer.parseInt(sc.nextLine());
				
				// Xu li hien thi du lieu //
				// Hien thi so luong ben trong thu muc //
				String thongbao = new String();
				String dictfile = new String();
				if(n == -1) {
					thongbao = "Khong ton tai thu muc yeu cau!";
					System.out.println(thongbao);
				}else if(n == 0) {
					thongbao = "Thu muc rong!";
					System.out.println(thongbao);
				}else {
					thongbao = "Co tat ca " + n + " Thu muc va file ben trong: ";
					System.out.println(thongbao);
					// Hien thi tiep noi dung ben trong thu muc //
					for(int i = 0 ; i < n ; i++) {
						dictfile = sc.nextLine();
						System.out.println(dictfile);
					}
					
				}
			}
			
			s.close();
			
			
		} catch (UnknownHostException e) {
			System.out.println("Khong tim thay address!");
		} catch (IOException e) {
			System.out.println("Co loi trong qua trinh noi ket!");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
