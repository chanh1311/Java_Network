package ThucHanh4;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class send_EmailSMTP {

	public static void main(String[] args) {
		try {
			String host = "smtp.saix.net";
			String to = "contact@saix.net";
			
			Socket socket = new Socket(host, 25);
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			Scanner sc = new Scanner(is);
			
			System.out.println(sc.nextLine());
			pw.print("HELO chanh.vn\n"); pw.flush();
			System.out.println("HELO chanh.vn\n");
			System.out.println(sc.nextLine());
			pw.print("MAIL FROM:<chanhb1809107@student.ctu.edu.vn>\n");
			pw.flush();
			System.out.println("MAIL FROM:<chanhb1809107@student.ctu.edu.vn>\n");
			System.out.println(sc.nextLine());
			pw.print("RCPT TO:<" + to + ">\n"); pw.flush();
			System.out.println("RCPT TO:<" + to + ">\n");
			System.out.println(sc.nextLine());
			pw.print("DATA\n"); pw.flush();
			System.out.println("DATA\n");
			System.out.println(sc.nextLine());
			System.out.println(sc.nextLine());
			pw.print("Day la noi dung email \n.\n"); pw.flush();
			System.out.println("Day la noi dung email \n.\n");
			System.out.println(sc.nextLine());
			pw.print("QUIT\n"); pw.flush();
			System.out.println("QUIT\n");
			System.out.println(sc.nextLine());
			System.out.println("Gui email thanh cong!");
		}
		catch (UnknownHostException  e) {
			System.out.println(e.getMessage());
		}
		catch(SocketException e) {
			System.out.println(e.getMessage());
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
