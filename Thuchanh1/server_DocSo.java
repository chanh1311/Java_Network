package Thuchanh1;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server_DocSo{

	public static void main(String[] args) {
		try {
			// Tao Server Socket lang nghe noi ket cong 777 //
			ServerSocket ss = new ServerSocket(7776);
			System.out.println("Da khoi tao xong phia server");
			// Cho phep nhieu noi ket tu phia clien //
			while(true){
			// Chap nhan cho client noi ket //
				Socket s = ss.accept();
				System.out.println("Co 1 client " + s.getInetAddress() + " cong " + s.getPort() + " noi ket");
				// Lay ra 2 stream in-out //
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				// Nhan nhieu yeu cau //
				while(true){
					//Nhan yeu cau tu client
					int ch = is.read();
					// Kiem tra ki tu de thoat //
					if(ch == -1) break;
					// Hien thi //
					System.out.println("Ky tu nhan tu phia client " + ch);
					
					//xu ly yeu cau(Phai sua doi)//
					String ketqua = new String();
					switch(ch){
						case '0': ketqua = "Khong";
							break;
						case '1': ketqua = "Mot";
							break;
						case '2': ketqua = "Hai";
							break;
						case '3': ketqua = "Ba";
							break;
						case '4': ketqua = "Bon";
							break;
						case '5': ketqua = "Nam";
							break;
						case '6': ketqua = "Sau";
							break;
						case '7': ketqua = "bay";
							break;
						case '8': ketqua = "Tam";
							break;
						case '9': ketqua = "Chin";
							break;
						default:
							ketqua = "Khong Phai So Nguyen";
					}
					
					
					
					
					// goi ket qua cho client
					byte[] b = ketqua.getBytes();
					os.write(b);
					
					
					}
			// Dong noi ket voi clien //
				System.out.println("Client da dong!");
				s.close();
				
			}
			// Khong the biet duoc khi nao se ngung phuc vu//
				//	Nen ko su dung dong nay ss.close();
				
		}catch(IOException e) {
			System.out.println(e.toString());
			System.out.println("Khong thang cong!");
		}
	}

}
