package ThucHanh4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class web_Browser_Firefox {

	public static void main(String[] args) {
		try {
			// Nhap tu ban phim
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap dia chi Web Server: ");
			String diachiserver = kb.nextLine();
			System.out.print("Nhap ten tai nguyen can truy xuat: ");
			String tentainguyen = kb.nextLine();
			// Noi ket den Web Server
			Socket s = new Socket(diachiserver,80);
			// Lay ra 2 stream in-out
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			Scanner sc = new Scanner(is);
			// Gui cau lenh GET cho Web Server
			pw.println("GET /" + tentainguyen + " HTTP/1.1");
			pw.println("Host: " + diachiserver);
			pw.println("User-Agent: Mozilla/5.0 (Windows NT 10.0; rv:92.0) Gecko/20100101 Firefox/92.0");
			pw.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			pw.println("Accept-Language: en-US,en;q=0.5");
			pw.println("Accept-Encoding: gzip, deflate");
			pw.println("Connection: keep-alive");
			pw.println("Upgrade-Insecure-Requests: 1");
			pw.println();
			pw.flush();
			// Nhan ket qua tra ve tu Web Server va hien thi ra man hinh
			// Nhan Header tu Web Server
			/*
			System.out.println("HEADER:");
			while(true) {
				String kq = sc.nextLine();
				if(kq.equals("")) break;
				System.out.println(kq);
			}
			*/
			// Nhan noi dung tai nguyen
			FileOutputStream f = new FileOutputStream("C:/test/firefox.html");
			while(true) {
				// Nhan tung ky tu
				int ch = is.read();
				if(ch==-1) break;
				f.write(ch);
			}
			f.close();
			// Dong noi ket
			s.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}


	}

}
