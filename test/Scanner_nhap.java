package test;

import java.io.IOException;
import java.util.Scanner;

public class Scanner_nhap {

	public static void main(String[] args) {
		//kieu 1
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(s);
		
		System.out.println("Nhap A: ");
		try {
			int A = System.in.read();//nhap vao 1 ki tu
			System.out.println((char)A);//co the xay ra 1 ngoai le gi day
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

	

	


}
