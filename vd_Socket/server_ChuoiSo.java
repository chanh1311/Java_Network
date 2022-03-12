package vd_Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class server_ChuoiSo{

	public static void main(String[] args) {
		try {
			// Tao Server Socket lang nghe noit ket cong 7 //
			ServerSocket ss = new ServerSocket(7778);
			System.out.println("Da khoi tao xong phia server");
			// Cho phep noi ket tu phia clien //
			while(true){
				try {
					// Chep nhan cho client noi ket //
					Socket s = ss.accept();
					System.out.println("Co 1 client " + s.getInetAddress() + " cong " + s.getPort() + " noi ket");
					// Lay ra 2 stream in-out //
					InputStream is = s.getInputStream();
					OutputStream os = s.getOutputStream();
					while(true){
						//Nhan yeu cau tu client
						byte[] b = new byte[1000];
						try {
							int n = is.read(b);
							// Hien thi //
							System.out.println("Nhan duoc: "+ new String(b,0,n));
							// Tao ra 1 chuoi //
							String strInteger = new String(b,0,n);
							// kiem tra chuoi so bang bieu thuc chinh quy //
							if(strInteger.matches("-?\\d+(\\.\\d+)?")) {
								// xu li yeu cau //	
								Integer intString = Integer.parseInt(strInteger);
								String result = new String(Integer.toBinaryString(intString));
								byte[] arr = result.getBytes();
								// goi ve client  //
								os.write(arr);
							//  Neu chuoi khong phai chuoi so nguyen tu 1 -> 9 //
							}else {
								// xu li  //
								String result = new String("Khong phai so nguyen!");
								byte[] arr = result.getBytes();
								// goi ve client  //
								os.write(arr);
							}
							
						}catch(StringIndexOutOfBoundsException e){
							System.out.println("Client da dong ket noi!");
							break;
						}
						
					
					} // while nhan nhieu yeu cau //
					s.close();
				
				}catch(IOException e) {
					System.out.println("Khong the tao ket noi!");
				}
			}	// while cho phep nhieu ket noi //
		}catch(IOException e) {
			System.out.println(e.toString());
			System.out.println("Tao Socket khong thang cong!");
		}


	}
}
