package Thuchanh2;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server_SsListDict {

	public static void main(String[] args) {
		
		try {
			// Tao Socket cho Server //
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("da tao Socket va cho noi ket!");
			// lang nghe yeu cau va noi ket //
			while(true) {
				try {
					Socket s = ss.accept();
					System.out.println("Co 1 client o dia chi " + s.getInetAddress() + " tai Port " + s.getPort() + " Da noi ket!" );
					
					// Tao luong xu li //
					ThreadProcessing_ListDict th1 = new ThreadProcessing_ListDict(s);
					th1.start();
				}catch(IOException e) {
					System.out.println("Co loi xay ra trong qua trinh ket noi voi client!");
				}	
			}
			//ss.close();
		} catch (IOException e) {
			System.out.println(e.toString());
			System.out.println("co loi xay ra khi co gang tao Socket!");
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
