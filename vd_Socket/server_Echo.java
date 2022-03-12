package vd_Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server_Echo {

	public static void main(String[] args) {
		try {
			// Tao Server Socket lang nghe noi ket cong 7 //
			ServerSocket ss = new ServerSocket(7);
			System.out.println("Da khoi tao xong phia sv");
			// Cho phep nhieu noi ket tu phia clien //
			while(true){
			// Chep nhan cho client noi ket //
			// Nhieu Client co the noi ket toi duoc nhung sv thi chi phuc vu duoc cho 1 client //
			// Neu chi co 1 luong thi Server chi co the xu li cho 1 client tai 1 thoi diem //
				Socket s = ss.accept();
				System.out.println("Co 1 client " + s.getInetAddress() + " cong " + s.getPort() + " noi ket");
				// Lay ra 2 stream in-out //
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				while(true){
					//Nhan yeu cau tu server
					int ch = is.read();
					System.out.println("Ky tu nhap vao phia client " + ch);
					//xu ly yeu cau//
					int ch1 = ch;
					// Kiem tra ki tu de thoat //
					if(ch1 == -1) break;
					// goi ket qua cho client
					os.write(ch1);
					
					}
			// Dong noi ket voi clien //
				s.close();
				
			}
			// Khong the biet duoc khi nao se ngung phuc vu//
				//	Nen ko su dung dong nay ss.close();
				
		}catch(IOException e) {
			System.out.println(e.toString());
			System.out.println("Khong the tao socket hoac chap nhan ket noi!");
		}
	}

}
