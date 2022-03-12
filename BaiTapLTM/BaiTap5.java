package BaiTapLTM;

import java.io.*;
import java.io.FileInputStream;

public class BaiTap5 {

	public static void main(String[] args){
		try {
			FileInputStream File1 = new FileInputStream("C:\\ViduJava\\File1.txt");
			DataInputStream in = new DataInputStream(File1);
			FileOutputStream File2 = new FileOutputStream("C:\\ViduJava\\File2.txt");
			DataOutputStream out = new DataOutputStream(File2);
		
		
			int n = in.available(); // lay chieu dai//
			byte[] arr = new byte[n];
			//doc File vao mang//
			in.readFully(arr);
			
			//ghi mang vao File//

			
			System.out.println("Ghi File Thanh Cong!");
			File1.close();
			File2.close();
			in.close();
			
			}catch(IOException e){
				System.out.println("Loi xay ra!");
			}
		
			//dong File//
			
		}

}
