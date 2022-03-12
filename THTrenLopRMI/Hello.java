package THTrenLopRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Hello extends UnicastRemoteObject implements HelloItf {
	// ham xay dung //
	public Hello() throws RemoteException {	// thay loi ra ham nao goi bat no //
		super();// khong goi cung tu goi //
	}
	// Dinh nghia cac phuong thuc tu xa //
	public String sayHello() {
		return "Hello RMI";
	}
	
}
