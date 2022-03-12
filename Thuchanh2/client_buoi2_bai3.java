package Thuchanh2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client_buoi2_bai3 {
	
	static final String path_file_write = "C:\\Users\\chanh\\OneDrive\\Desktop\\NHAP\\test\\ketqua.txt";  // can tao folder test o C //
	
	public static void main(String[] args) {
		// Tao noi ket den voi Server //
		try {
			Socket s = new Socket("localhost",9999);
			
			// Tao IN-Out //
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			// Tao 2 doi tuong Scanner va Printwriter //
			Scanner sc = new Scanner(in);
			PrintWriter pw = new PrintWriter(out);
			
			Scanner input = new Scanner(System.in);
			// Tren thuc te muon doc File tren Server khong can thiet ke doc lien tuc //
			// Nhap du lieu //
				System.out.println("Nhap vao ten file muon doc: ");
				String filename = input.nextLine();
				
				// Xu ly dau vao //
				String cmd = "READ " + filename;
				
				// Goi qua cho Server //
				pw.println(cmd); pw.flush();
				
				
				// Nhan du lieu goi ve //
					int n = Integer.parseInt(sc.nextLine());
					if( n == -1) {
						System.out.println("Khong tim thay File!");
					}else if(n == 0){
						System.out.println("File rong!");
					}
					else {
						String ketqua = new String();
						while(sc.hasNextLine()) {
							String nhan = new String();
							nhan = sc.nextLine() + "\n";
							ketqua += nhan;
						}
						// Tao ra 1 file luu ket qua //
						try {
							FileWriter file = new FileWriter(path_file_write);
							file.write(ketqua);
							file.close();
							System.out.println("Da ghi file thanh cong !");
						}catch(IOException e) {
							System.out.println("Loi ghi File!");
						}
						
					}
					s.close();
			
		} catch (UnknownHostException e) {
			System.out.println("khong tim thay address!");
		} catch (IOException e) {
			System.out.println("Co loi xay khi noi ket den Server!");
		}
		
		
		
		
		

	}

}
