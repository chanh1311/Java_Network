package Thuchanh2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RequestProcessing_bai1 extends Thread {
	// Khai bao socket //
	private Socket s;
	// Ham tao //
	public RequestProcessing_bai1(Socket s) {
		this.s = s;
	}
	// Ham xu ly run //
	public void run() {
	
		try {
			// tao kenh giao tiep //
			InputStream in =  s.getInputStream();
			OutputStream out = s.getOutputStream();

			while(true) {
				// Doc du lieu //
				byte[] arr_nhan = new byte[1000];
				int n = 0;
				n = in.read(arr_nhan);	
				// Xu li va hien thi tren server //
				String hoten = new String(arr_nhan,0,n);
				System.out.println("Nhan duoc: " + hoten);
				if(hoten.equals("exit")) {
					System.out.println("Client da thoat!");
					break;
				}
				// Thong bao neu client goi ve so //
				if (hoten.matches("-?\\d+(\\.\\d+)?")) {
					String thongbao = new String("Ten khong the la mot chuoi So!");
					byte[] arr_thongbao = thongbao.getBytes();
					out.write(arr_thongbao);
					continue;
				}
			// Xu li du lieu //
				// Loai bo chu so du thua //
				String hoten_xuli = hoten.replaceAll("[0-9]","");
				String[] arr_hoten = hoten_xuli.split(" ");
				// truong hop nhap vao toan khoang trang //
				if(arr_hoten.length == 0) {			
					String thongbao = new String("Ten khong the chua toan khoang trang!");
					byte[] arr_thongbao = thongbao.getBytes();
					out.write(arr_thongbao);
					continue;	
				}
				String ten = arr_hoten[arr_hoten.length-1];
				// Goi du lieu di //
				byte[] arr_ten = ten.getBytes();
				out.write(arr_ten);
			
			}
			s.close();
			// Dong noi ket //
			
		}catch(IOException e) {
			System.out.println(e.toString());
			System.out.println("Co loi xay ra trong viec xu ly!");
		}
	}
	
		
		
}
