package THTrenLopRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class helloClient {

	public static void main(String[] args) {
		// Tim doi tuong cho phep goi tu xa //
		
		try {
			HelloItf ref = (HelloItf)Naming.lookup("rmi://127.0.0.1/ABC");// dinh dang URL 1099 cong cua RMI//
			// Goi ham tu xa 
			String ketqua = ref.sayHello();
			// hien thi //
			System.out.println("Ket qua la: " + ketqua);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

}
