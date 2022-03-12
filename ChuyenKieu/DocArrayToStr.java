package ChuyenKieu;
import java.io.*;
import java.io.IOException;
//Doc va xuat String tu mang cac byte//
public class DocArrayToStr {

	public static void main(String[] args) {
		while(true) {
			byte[] arr = new byte[100];
			try {
				int n = System.in.read(arr);//Doc chuoi cac ki tu dong thoi xuat do dai//
				System.out.println(n);
				String str = new String(arr,0,n-2);
				if(str.equals("Exit")) break;
				System.out.println(str);
			} catch (IOException e) {
				
				System.out.println("Loi" + e);
			}
		}

	}

}
