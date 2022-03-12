package THTrenLopRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

public class helloServer {

	public static void main(String[] args) {
		try {
			// Khoi tao co che bao mat cho RMI //
			if(System.getSecurityManager()==null) // neu co che bao mat he thong chua ton tai thi gan cho RMI //
				System.setSecurityManager(new RMISecurityManager());
			
			// Tao doi tuong cho phep goi tu xa //
			Hello obj = new Hello();
			System.out.println("Da tao xong doi tuong cho phep goi tu xa!");
			
			// Dang ki doi tuong cho phep goi tu xa //
			Naming.rebind("ABC", obj); //rebind thi ghi de name //
			System.out.println("Dang ki name cho obj thanh cong!");
			
		}catch(RemoteException e) {
			System.out.println(e);
		}catch(MalformedURLException e) {
			System.out.println("Ten dang ki sai dinh dang URL!");
		}
		
	}

}
