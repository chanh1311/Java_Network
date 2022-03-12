package ThucHanhTrenLop;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client_ListThuMuc {

	public static void main(String[] args) {
		// Noi ket //
		Socket s;
		try {
			s = new Socket("localhost",9990);
			// Lay ra 2 stream //
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			// su dung 2 chuyen doi de nhieu tinh nang hon //
			Scanner input = new Scanner(in);
			PrintWriter pw = new PrintWriter(out);
			// Nhap ten thu muc(tren Server) can list 
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap ten thu muc can list: ");
			String tenthumuc = sc.nextLine();
			// Goi cau lenh yeu cau //
			String caulenh = "LIST" + tenthumuc;
			pw.println(caulenh); pw.flush();
			// Nhan ket qua tra ve //
			String chuoisoluong = input.nextLine();
			int n = Integer.parseInt(chuoisoluong);
			// Cac truong hop //
			if(n==-1) System.out.println("Thu muc " + tenthumuc + " Khong ton tai!");
			else if(n==0) System.out.println("Thu muc " + tenthumuc + " Rong!");
			else {
				System.out.println("Thu muc gom: ");
				for(int i = 0; i < n; i++) {
					//
				}
			}
		} catch (UnknownHostException e) {
			System.out.println("Khong tim thay address!");
		} catch (IOException e) {
			System.out.println("Co loi xay ra trong qua trinh ket noi toi Server!");
		}
		
		
		
		
		
		
		
		
		// Dong noi ket //

	}

}
