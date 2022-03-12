package THTrenLopRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloItf extends Remote{
	public String sayHello() throws RemoteException;
}
