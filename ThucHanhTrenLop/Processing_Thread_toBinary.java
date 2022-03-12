package ThucHanhTrenLop;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Processing_Thread_toBinary extends Thread{
	private Socket s;
	
	public Processing_Thread_toBinary(Socket s) {
		this.s = s;
	}
	public void run() {
		// tao Input Output //
		try {
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			
			// Nhan du lieu goi qua tu Client //
			while(true) {	// Nhan nhieu lan //
				byte[] nhan = new byte[1000];
				int n = in.read(nhan);
				String chuoinhan = new String(nhan,0,n);
				
				if(chuoinhan.equals("exit")) break;
				// Hien thi du lieu nhan duoc //
				System.out.println("Nhan duoc tu Client: " + chuoinhan);
				// Xu li yeu cau //
				String ketqua = new String();
				try {
					// kieu int co the chuyen nguyen thanh binary //
					int chuoinguyen = Integer.parseInt(chuoinhan);
					ketqua  = Integer.toBinaryString(chuoinguyen);
				}catch(NumberFormatException e) {
					ketqua = "Khong phai chuoi so nguyen!";
				}
				// Goi tra ve cho client //
				byte[] goi = ketqua.getBytes();
				out.write(goi);
				
				
			}//while
			// Dong ket noi //
			System.out.println("Client da dong!");
			s.close();
		}catch(IOException e) {
			System.out.println("Co loi xay ra trong qua trinh xu ly!");
		}
		
	}
}
