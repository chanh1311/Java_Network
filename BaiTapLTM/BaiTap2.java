package BaiTapLTM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BaiTap2 {
// doc file bang FileInputStream xai (obj file).read()
	public static void main(String[] args){
		FileInputStream FileInput = null;
		try {
			FileInput = new FileInputStream("C:\\ViduJava\\File1.txt");
			
			int x = 0;
			while(( x = FileInput.read()) != -1) {	// doc tung ki tu //
//				System.out.println(x);
				System.out.print((char)x);
			}
			FileInput.close();
		} catch (Exception e) {
			
			System.out.println("Khong the doc File!");
		}
		
		}
}


