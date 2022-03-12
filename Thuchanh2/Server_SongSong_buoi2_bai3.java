package Thuchanh2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server_SongSong_buoi2_bai3 {

	public static void main(String[] args) {
			try {
				// Tao Socket phia Server //
				ServerSocket ss = new ServerSocket(9999);
				System.out.println("Da khoi tao Server va cho Socket!");
				while(true) {
					// Lang nghe yeu cau va chap nhan noi ket  //
					try {
						Socket s = ss.accept();
						System.out.println("Co 1 client O dia chi " + s.getInetAddress() + " tai Cong " + s.getPort() + " da noi ket!");
						// Tao Thread xu ly //
						ThreadProcessing_bai3 th = new ThreadProcessing_bai3(s);
						th.start();
					}catch(IOException e) {
						System.out.println("Co loi xay ra trong qua trinh noi ket voi Client!");
					}
				}
				
			} catch (IOException e) {
				System.out.println("Co loi xay ra khi tao Socket!");
			}
	}

}
