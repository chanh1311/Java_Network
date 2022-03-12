package BaiTapLTM;
import java.math.*; 
import java.util.Scanner;
public class BaiTap1 {


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		float x = 0.0f;
		int n = 0;
		boolean check = false;
		while(!check) {
			try {
			System.out.println("Nhap x: ");
			 	x = input.nextFloat();
			
			System.out.println("Nhap n: ");
				n = input.nextInt();
			
			check = true;
			}catch(Exception e) {
				System.out.println("Nhap sai kieu - Nhap lai");
				 input.nextLine(); // doc ki tu /r va /n
			}
		}
		System.out.println(Math.pow(x,n));

	}

}
