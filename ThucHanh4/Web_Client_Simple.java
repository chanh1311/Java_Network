package ThucHanh4;
// chorme //
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Web_Client_Simple {

	public static void main(String[] args) {
		try {
			// Nhap tu ban phim //
			Scanner sc = new Scanner(System.in);
			String diachi = sc.nextLine();
			System.out.println("Nhap ten tai nguyen can truy xuat: ");
			String tainguyen = sc.nextLine();
			// Noi ket den web server // 
			Socket s = new Socket(diachi,80);
			// lay ra 2 stream //
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			
			PrintWriter pw = new PrintWriter(out);
			Scanner input = new Scanner(in);
			// Goi cau lenh get //
			pw.println("GET " +tainguyen+" HTTP/1.1");
//			System.out.println("GET " +tainguyen+" HTTP/1.1");
			pw.println("Host: " + diachi);
//			System.out.println("Host: " + diachi);
			pw.println("Connection: keep-alive");
//			System.out.println("Connection: keep-alive");
			pw.println("Cache-Control: max-age=0");
//			System.out.println("Cache-Control: max-age=0");
			pw.println("sec-ch-ua: \"Google Chrome\";v=\"95\", \"Chromium\";v=\"95\", \";Not A Brand\";v=\"99\"");
//			System.out.println("sec-ch-ua: \"Google Chrome\";v=\"95\", \"Chromium\";v=\"95\", \";Not A Brand\";v=\"99\"");
			pw.println("sec-ch-ua-mobile: ?0");
//			System.out.println("sec-ch-ua-mobile: ?0");
			pw.println("sec-ch-ua-platform: \"Windows\"");
//			System.out.println("sec-ch-ua-platform: \"Windows\"");
			pw.println("Upgrade-Insecure-Requests: 1");
//			System.out.println("Upgrade-Insecure-Requests: 1");
			pw.println("User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.54 Safari/537.36");
//			System.out.println("User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.54 Safari/537.36");
			pw.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
//			System.out.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
			pw.println("Sec-Fetch-Site: none");
//			System.out.println("Sec-Fetch-Site: none");
			pw.println("Sec-Fetch-Mode: navigate");
//			System.out.println("Sec-Fetch-Mode: navigate");
			pw.println("Sec-Fetch-User: ?1");
//			System.out.println("Sec-Fetch-User: ?1");
			pw.println("Sec-Fetch-Dest: document");
//			System.out.println("Sec-Fetch-Dest: document");
			pw.println("Accept-Encoding: gzip, deflate, br");
//			System.out.println("Accept-Encoding: gzip, deflate, br");
			pw.println("Accept-Language: en-US,en;q=0.9,vi;q=0.8");
//			System.out.println("Accept-Language: en-US,en;q=0.9,vi;q=0.8");
			
			pw.println();
			pw.flush();
			
			
			// Nhan ket qua tra ve tu Web Server //
			FileOutputStream f = new FileOutputStream("C:/test/ketqua.html");
			PrintWriter fpw = new PrintWriter(f);
			while(input.hasNextLine()) {
				String str = input.nextLine();
//				System.out.println(str);// ket qua tra ve voi ding dang xuong hang, khong phu hop voi file nhi phan //
				//c2: int ch = is.read();
				
				fpw.println(str); fpw.flush();
				// khong the dong //
				
			}
			
			// Dong noi ket //
			fpw.close();
			input.close();
			sc.close();
			s.close();

		
		}catch(IOException e) {
			System.out.println(e);
		}
		
	}
}
