package ThucHanh4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class send_MailTestSMTP {

	public static void main(String[] args) {
		try {
			String host = "smtp.saix.net";	// server SMTP //
			String to = "contact@saix.net";		// goi den dia chi nao do //
			
			Socket socket = new Socket(host, 25);
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			Scanner sc = new Scanner(is);
			
			System.out.println(sc.nextLine());
			pw.print("HELO thuctap.vn\n"); pw.flush(); // helo .vn //
			System.out.println(sc.nextLine());
			pw.print("MAIL FROM:<nghiepb1809155@student.ctu.edu.vn>\n");// mail goi, mail that moi duoc //
			pw.flush();
			System.out.println(sc.nextLine());
			pw.print("RCPT TO:<" + to + ">\n"); pw.flush();
			System.out.println(sc.nextLine());
			pw.print("DATA\n"); pw.flush();
			System.out.println(sc.nextLine());
			pw.print("Sorry, this is an test email\n.\n"); pw.flush();
			System.out.println(sc.nextLine());
			pw.print("QUIT\n"); pw.flush();
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
