package ThucHanhTrenLop;

import java.util.Scanner;

public class Java_Loops_II {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		// Nhap vao du lieu //
		int q = sc.nextInt();
		for(int i = 0; i < q ; i++) {
			// xu li //
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int result = a;
			for(int j = 0; j < c ; j++) {
				result += Math.pow(2,j)*b;
				System.out.printf("%s ",result);
			}
			System.out.println();
		}
		sc.close();
		
	}

}
