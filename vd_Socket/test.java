package vd_Socket;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String string = input.nextLine();
		System.out.println(string);
		byte[] arr = string.getBytes();
		System.out.println(arr.length);
		
		
	}

}
