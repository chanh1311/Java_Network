package test;
import java.io.*;
import java.net.*;
public class ServerNhiPhan{
	public static void main(String[] args){
		try{
			ServerSocket ss=new ServerSocket(444);
			System.out.println("Da tao Server thanh cong!");
			while(true){
				try{
					Socket s=ss.accept(); 
					InputStream is=s.getInputStream();
					OutputStream os=s.getOutputStream();
					while(true){
						byte [] inputByte= new byte[500];
						int n=is.read(inputByte);
						String inputStr=new String(inputByte,0,n);
						if(inputStr.equals("exit")) break;
						int inputInt=Integer.parseInt(inputStr);
						String Nhiphan=Integer.toBinaryString(inputInt);
						os.write(Nhiphan.getBytes());
					}
					s.close();
					System.out.println("Dong ket noi voi Client");
				}catch(IOException e) {
					System.out.println("Co loi IOException");
				}
			}
		}catch(IOException e) {
			System.out.println("Tao Server khong thanh cong!");
		}
	}			
}