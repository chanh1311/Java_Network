package vd_Socket.songsong;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_SongSong_Bai3 {
	static final int defaultPort = 9999;
	public static void main(String[] args) {
		try {
			// Tao socket //
			ServerSocket ss = new ServerSocket(defaultPort);
			System.out.println("Server da mo Socket va dang lang nghe!");
			while(true) {
				// lang nghe //
				try {
					Socket s = ss.accept();
					System.out.println("Co 1 Client dai chi " + s.getInetAddress() + "cong " + s.getPort() + " da noi ket!");
					// Tao luong xu li //
					RequestProcessing_Bai3 rp = new RequestProcessing_Bai3(s);
					rp.start();
				}catch(IOException e) {
					System.out.println("Khong the noi ket!");
				}
			}
			
		} catch (IOException e) {
			System.out.println("Khong the tao Socket!");
		}

	}

}
