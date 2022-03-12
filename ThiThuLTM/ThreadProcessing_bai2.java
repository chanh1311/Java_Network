package ThiThuLTM;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadProcessing_bai2 extends Thread {
	// Khai bao socket //
		private Socket s;
		// Ham tao //
		public ThreadProcessing_bai2(Socket s) {
			this.s = s;
		}
		// Ham xu ly run //
		public void run() {
		
			try {
				// tao kenh giao tiep //
				InputStream in =  s.getInputStream();
				OutputStream out = s.getOutputStream();
				
				// Tao 2 doi tuong Scanner va Prinwriter //
				Scanner sc = new Scanner(in);
				PrintWriter pw = new PrintWriter(out);

				while(true) {
					// Nhan ve kich thuoc cuia file 
					String chuoinhan = sc.nextLine();
					try {
						int n = Integer.parseInt(chuoinhan);
						int x = 1;
						for(int i = 1 ; i <= n; i++) {
							x *= i;
						}
						pw.println(x); pw.flush();
						
					}catch(NumberFormatException e) {
						String thongbao = new String("Khong tinh duoc");
						pw.println(thongbao); pw.flush();
					}
					
				}
				// Dong noi ket //
				
			}catch(IOException e) {
				System.out.println(e.toString());
				System.out.println("Co loi xay ra trong viec xu ly!");
			}
		}
}
