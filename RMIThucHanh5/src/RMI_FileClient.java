import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RMI_FileClient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ten File: ");
		String filenamelay = sc.nextLine();
		System.out.println("Nhap file Luu: ");
		String filenameluu = sc.nextLine();
		
		try {
			RMI_FileItf ref = (RMI_FileItf)Naming.lookup("rmi://127.0.0.1/objfile");
			int len = ref.getLength(filenamelay);
			if(len == 0 || len == -1) System.out.println("File khong ton tai or file rong!");
			else {
				byte[] b = ref.getFile(filenamelay);
				FileOutputStream fileluu = new FileOutputStream(filenameluu);
				fileluu.write(b,0,b.length);
				fileluu.close();
				System.out.println("Da luu thanh cong file!");
			}
		} catch (NotBoundException e) {
			System.out.println("Khong tim thay doi tuong tu xa");
		} catch (MalformedURLException e) {
			System.out.println("Sai dinh dang URL!");
		} catch (RemoteException e) {
			System.out.println("Loi trong khi goi ham tu xa!");
		}catch (IOException e) {
			System.out.println("Loi doc File!");
		}

	}

}
