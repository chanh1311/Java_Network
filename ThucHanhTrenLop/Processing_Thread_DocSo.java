package ThucHanhTrenLop;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Processing_Thread_DocSo extends Thread {
	private Socket s;
	
	public Processing_Thread_DocSo(Socket s) {
		this.s = s;
	}
	
	// xu li //
	public void run() {
		// Tao In-Out //
		try {
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			
			// Nhan du lieu tu Client //
			while(true) {	// Nhan nhieu lan //
				int nhan = in.read();
				
				// Hien thi du lieu da nhan //
				System.out.println("Nhan duoc tu Client la: " + nhan);
				// Thoat //
				if(nhan == '@') break;
				
				// Xu li du lieu //
				String ketqua = new String("Khong Biet!"); 
				switch(nhan) {
					case '1': ketqua = "Mot"; break;
					case '2': ketqua = "Hai"; break;
					case '3': ketqua = "Ba"; break;
					case '4': ketqua = "Bon"; break;
					case '5': ketqua = "Nam"; break;
					case '6': ketqua = "Sau"; break;
					case '7': ketqua = "Bay"; break;
					case '8': ketqua = "Tam"; break;
					case '9': ketqua = "Chin"; 
				}
			// Goi tra du lieu ve cho Client //
				byte[] goi = new byte[1000];
				goi = ketqua.getBytes();
				out.write(goi);
			}//while(Nhan du lieu nhieu lan!)
			
		// Dong Noi Ket //
			s.close();
		}catch(IOException e) {
			System.out.println("Co loi xay ra trong qua trinh xu li!");
		}
		
	}
	
}
