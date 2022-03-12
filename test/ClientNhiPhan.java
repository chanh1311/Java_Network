package test;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class ClientNhiPhan{
	public static void main(String[] args){
		try{
			Socket s=new Socket("127.0.0.1",444);
			try{
				InputStream is=s.getInputStream();
				OutputStream os=s.getOutputStream();
				Scanner sc=new Scanner(System.in);
				while(true){
					System.out.println("Nhap chuoi so:");
					String inputStr=sc.nextLine();
					//Day du lieu len Server
					byte [] inputByte=inputStr.getBytes();
					os.write(inputByte);
					if(inputStr.equals("exit")) break;
					//
					byte [] resultByte= new byte[500];
					int n=is.read(resultByte);
					String resultStr=new String(resultByte,0,n);
					System.out.println("Ket qua: "+resultStr);
				}
				s.close();
			}catch (UnknownHostException e) {
				System.out.println("Co loi UnknownHostException!");
			}
		}catch (IOException e) {
			System.out.println("Co loi IOException!");
		}
	}
}