package vd_Socket.songsong;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_SongSong {
	public final static int defaultPort = 7779;
	public static void main(String[] args) {
		
		try {
			// Tao Socket cho Server//
			ServerSocket ss = new ServerSocket(defaultPort);
			System.out.println("Da tao xong Socket va cho noi ket!");
			while(true) {
				try {
					// Lang nghe yeu cau noi ket //
						Socket s = ss.accept();
					// Hien thi thong tin noi ket //
						System.out.println("Co 1 Client dia chi " + s.getInetAddress() + "Cong " + s.getPort() + "Da ket noi!");
					
					// Tao 1 doi tuong chua phan xu ly //
					// tao ra 1 luong chay rieng khong phai chay tren luong chinh //
					// Luong chinh da xong nhiem vu quay lai cho client moi noi ket //
						RequestProcessing rp = new RequestProcessing(s);
					// Goi xu ly cho Client hien tai //
						// luong moi thi cu tiep tuc chay //
						rp.start();
				
				}catch(IOException e) {
					System.out.println("Co loi khi ket Noi!");
				}
			}
			
			
			
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("Khong the tao Socket!");
		}
		
		
		
		
		
		
	}

}
