package THMulticast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class TCP_ReadFileServer {

	public static void main(String[] args) {
		// Tao Server Socket cong 23456 //
		try {
			ServerSocket ss = new ServerSocket(23456);
			while(true) {
				// Chap nhan noi ket //
				Socket s = ss.accept();
				
				// lay ra 2 stream in-out 
				// Lay ra 2 Stream IN-OUT //
					InputStream in = s.getInputStream();
					OutputStream out = s.getOutputStream();
					
					Scanner sc = new Scanner(in);
					PrintWriter pw = new PrintWriter(out);
				// Nhan cau lenh "READ tenfile" 
				String caulenh = sc.nextLine();
				
				// Lay ten file 
				String tenfile = caulenh.substring(5);
				// Kiem tra 
				File f = new File(tenfile);
				if(f.exists() && f.isFile()) {
					int size = (int)f.length();
					pw.println(size);
					pw.flush();	
					// Doc noi dung file 
					FileInputStream f1 = new FileInputStream(tenfile);
					DataInputStream dis = new DataInputStream(f1);
					// co phuong thuc doc het, an toan hon, goi data nhi phan //
					System.out.println(size);
					byte b[] = new byte[size];
					dis.readFully(b);
					f1.close();
					System.out.println("Da doc xong file!");
					// Goi noi dung file 
					// co the dung outputStream, de dam bao an toan su dung DataOutputStream //
					DataOutputStream dos = new DataOutputStream(out);
					dos.write(b);
					System.out.println("Da goi xong!");
				}else {
					pw.println("-1"); pw.flush();
				}
				
			}
				// Dong
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

