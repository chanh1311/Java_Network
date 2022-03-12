package File;
import java.io.*;

public class Write_File1 {
	

	public static void main(String[] args) {
		try {
			FileOutputStream f1 = new FileOutputStream("test.txt");
			int ch = '@'; f1.write(ch);// ghi vao tu 64-->@
			System.out.println(ch);//64
			byte[] arr = new byte[10];
			int m = 0;
			for(int i = '0'; i <= '9'; i++) {
//				System.out.println(i);//48-->57
				arr[m++] = (byte)i;
				
			}
			m = 0;
			f1.write(arr);
			f1.write('\r');
			f1.write('\n');
			byte[] arr2 = new byte[50];
			for(int i = 'a'; i < 'z'; i++) {
				arr2[m++] = (byte)i;
			}
			f1.write(arr2);
			f1.close();
			
//			for(byte i : arr) {
//				System.out.println(i);// kieu so nguyen nhung kieu unicode
//			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}



//tao doi tuong output//
// tao bien nhan gia tri char nhung tra ve gia tri int//
// ghi bien do vao file//
// tao mang luuu tru 10 gia tri//
// Gan tung gia tri cho mang theo bien i trong vong lap//
// ghi mang vao file //
// tao them vong lap nua va gan gia tri nhu tren//
// ghi vao file(0-->m)//
//	dong file//
//ngoai le//