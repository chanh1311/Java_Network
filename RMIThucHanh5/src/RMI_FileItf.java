import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI_FileItf extends Remote {
		public int getLength(String filename) throws RemoteException;
		public byte[] getFile(String filename) throws RemoteException,IOException;
}
