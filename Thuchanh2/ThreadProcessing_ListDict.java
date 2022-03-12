package Thuchanh2;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadProcessing_ListDict extends Thread {
	private Socket s;
	public ThreadProcessing_ListDict(Socket s) {
		this.s = s;
	}
	public void run() {
		// Tao IN-OUT //
			try {
				InputStream in = s.getInputStream();
				OutputStream out = s.getOutputStream();
				
				// Tao 2 doi tuong Scanner va Prinwriter //
				Scanner sc = new Scanner(in);
				PrintWriter pw = new PrintWriter(out);
				while(true) {	// nhan nhieu lan
					// Nhan du lieu goi qua tu Client //
					String nhan = sc.nextLine();
						//System.out.println("Nhan Duoc: " + nhan);
					if(nhan.equals("READ exit")) break;
					// Xu li du lieu //
					
					// Lay ten thu muc //
					String cmd = nhan.substring(0,4);
					String thumuc = nhan.substring(5);
					
					// xu li //
					
					int soluong;
					String[] list_thumuc = new String[1000];
					try {
						File file = new File(thumuc);
						list_thumuc = file.list();
						
						soluong = list_thumuc.length;
					}catch(NullPointerException e) {
						soluong = -1;
					}
					
					// Goi tra nguoc ve Client //
					if(soluong == -1 && soluong == 0) {
						pw.println(soluong); pw.flush();
					}else {
						// Goi soluong //
						pw.println(soluong); pw.flush();
						
						// Goi file va thumuc //
						for(int i = 0; i < soluong ; i++) {
							File temp = new File(thumuc + "/" + list_thumuc[i]);
							if(temp.isFile()) {
								pw.println(list_thumuc[i]); pw.flush();
							}else {
								pw.println("["+list_thumuc[i]+"]"); pw.flush();
							}
						}
					}
				}
				System.out.println("Co 1 client da dong!");
				s.close();
				
			}catch(IOException e) {
				System.out.println("Co loi trong qua trinh xu ly!");
			}
					
					
	}
}
