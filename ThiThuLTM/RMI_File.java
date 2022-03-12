package ThiThuLTM;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMI_File extends UnicastRemoteObject implements RMI_FileItf {

		// Ham xay dung //
		public RMI_File() throws RemoteException{
			super();
		}
		
		// Ham cuc bo //
		
		// Ham goi tu xa //
		public boolean fileTonTai(String filename) {
			File file = new File(filename);
			if(file.exists() && file.isFile())
				return true;
			else {
				return false;
			}
			
		}
		public void doiTenFile(String filename, String tenfilemoi) {
			File oldfile =new File(filename);
	        File newfile =new File(tenfilemoi);

	        if(oldfile.renameTo(newfile)){
	            System.out.println("Da doi thanh cong ten file");
	        }else{
	            System.out.println("Khong thanh cong!");
	        }
		}


}
