package ThiThuLTM;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI_FileItf extends Remote {
		public boolean fileTonTai(String tenfile) throws RemoteException;
		public void doiTenFile(String tenfile,String tenfilemoi) throws RemoteException;
}
