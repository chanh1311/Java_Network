package BaiTapLTM;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class BaiTap4 {

	public static void main(String[] args) {
		Scanner input = null;
		String s = new String();
		try {
			input = new Scanner(new FileInputStream("C:\\ViduJava\\File1.txt"));
			while(true) {	//  co the su dung hasNextLine()//
				s = input.nextLine();
				System.out.println(s);
			}
		}catch(NoSuchElementException e){
			System.out.println("Da doc xong File!");
		}catch(FileNotFoundException e) {
			System.out.println("Khong tim thay duong dan File!");//sai duong dan
		}
	}
}
// scanner(obj File)
// obj File duoc tao tu FileInputStream
// (obj scanner).nextLine()--> Doc tung dong 1
// Xay ra ngoai le la da doc xong File!