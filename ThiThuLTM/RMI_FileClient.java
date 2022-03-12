package ThiThuLTM;
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
		System.out.println("Nhap ten file cu: ");
		String filenamecu = sc.nextLine();
		System.out.println("Nhap ten file moi: ");
		String filenamemoi = sc.nextLine();
		
		try {
			RMI_FileItf ref = (RMI_FileItf)Naming.lookup("rmi://127.0.0.1/objfile");
			if(ref.fileTonTai(filenamecu)) {
				ref.doiTenFile(filenamecu,filenamemoi);
			}else {
				System.out.println("Ten file chua dung!");
			}
		} catch (NotBoundException e) {
			System.out.println("Khong tim thay doi tuong tu xa");
		} catch (MalformedURLException e) {
			System.out.println("Sai dinh dang URL!");
		} catch (RemoteException e) {
			System.out.println("Loi trong khi goi ham tu xa!");
		}

	}


}
