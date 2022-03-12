//package test;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class ThreadProcessing_bai3 extends Thread{
//	private Socket s;
//	public ThreadProcessing_bai3(Socket s) {
//		this.s = s;
//	}
//	public void run() {
//		try {
//			InputStream in = s.getInputStream();
//			OutputStream out = s.getOutputStream();
//			// Tao cac doi tuong nhan goi du lieu //
//			Scanner sc = new Scanner(in);
//			PrintWriter pw = new PrintWriter(out);
//			
//			Scanner input = new Scanner(System.in);
//			
//			// Nhan du lieu tu phia client //
//			String nhan = new String();
//			nhan = sc.nextLine();
//			
//			// Hien thi du lieu xem //
//			System.out.println("Nhan duoc: " + nhan);
//		
//			
//		// Xu ly yeu cau //
//				// lay ten file //
//			try {
//				String tenfile = nhan.substring(5);
//				// Doc file va goi //
//				File file = new File(tenfile);
//				BufferedReader buffer = new BufferedReader(new FileReader(file));
//				String line = buffer.readLine();
//				// Truong hop File rong! //
//				if(line == null) {
//					pw.println("0"); pw.flush();
//				}
//				// File chua noi dung //
//				pw.println("1"); pw.flush();
//				while(line != null) {
//					pw.println(line); pw.flush();
//					line = buffer.readLine();
//				}
//				// Dong //
//				buffer.close();
//				s.close();
//			}catch(FileNotFoundException e){
//				pw.println("-1"); pw.flush();
//			}
//		}catch(IOException e) {
//			System.out.println("Co loi xay ra trong qua trinh xu ly!");
//		}
//		
//		
//		
//	}
//}
