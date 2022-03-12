package vd_Socket.songsong;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_SongSong_Bai2 {
	public final static int defaultPort = 9999;
	public static void main(String[] args) {
		
		try {
			// Tao Socket cho Server//
			ServerSocket ss = new ServerSocket(defaultPort);
			System.out.println("Da tao xong Socket va cho noi ket!");
			
			while(true) {
				try {
					// Lang nghe yeu cau noi ket va hien thi//
						Socket s = ss.accept();
						System.out.println("Co 1 Client dia chi " + s.getInetAddress() + "Cong " + s.getPort() + " Da ket noi!");
					
					// Tao luong xu li rieng //
						RequestProcessing_bai2 rp = new RequestProcessing_bai2(s);
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
