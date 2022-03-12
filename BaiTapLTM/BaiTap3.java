package BaiTapLTM;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

// doc file bang (obj FileInputStream).read(arr) --> lay tung ki tu cua File dua vao arr(int)
// tao chuoi string tren arr
public class BaiTap3 {

	public static void main(String[] args) {
		try {
			FileInputStream FileInput = new FileInputStream("C:\\ViduJava\\File1.txt");
			byte[] b = new byte[50];
			int x = 0;
			while((x = FileInput.read(b)) != -1) {		//doc tung ki tu va dua vo arr//
			}
			
			String s = new String(b,0,b.length);
			System.out.println(s);
		} catch (Exception e) {
			
			System.out.println("Doc File khong thanh cong!");
		}
				
	}

}
