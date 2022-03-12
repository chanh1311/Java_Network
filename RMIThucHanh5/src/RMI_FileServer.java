import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

public class RMI_FileServer {

	public static void main(String[] args) {
		try {
			// Khoi tao co che bao mat RMI //
			if(System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}
			// Tao doi tuong RMI file //
			RMI_File objfile = new RMI_File();
			System.out.println("Tao duoc doi tuong cho phep goi tu xa!");
			// Dang ki doi tuong //
			Naming.rebind("objfile", objfile);
			System.out.println("Da dang ki doi tuong thanh cong!");
			
		}catch(RemoteException e) {
			System.out.println("Loi khi khoi tao or dk dt");
		}catch(MalformedURLException e) {
			System.out.println("Viet sai dinh dang URL cuar doi tuong!");
		}
	}	

}


