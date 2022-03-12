package Thuchanh2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_SongSong_buoi2_bai1 {
	public final static int defaultPort = 9999;
	public static void main(String[] args) {
		
		try {
			// Tao Socket cho Server//
			ServerSocket ss = new ServerSocket(defaultPort);
			System.out.println("Da tao xong Socket va cho noi ket!");
			while(true) {
				try {
					// Lang nghe yeu cau noi ket //
						Socket s = ss.accept();
						System.out.println("Co 1 Client dia chi " + s.getInetAddress() + "Cong " + s.getPort() + " Da ket noi!");
					
					// Tao 1 luong xu li cho Client //
						RequestProcessing_bai1 rp = new RequestProcessing_bai1(s);
						rp.start();
				
				}catch(IOException e) {
					System.out.println("Co loi khi ket Noi!");
				}
			}
			
			
			
		}catch (IOException e) {
			
			System.out.println("Khong the tao Socket!");
		}
		
		
		
	}

}
