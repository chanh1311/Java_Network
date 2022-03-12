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
		public int getLength(String filename) {
			File file = new File(filename);
			if(file.exists() && file.isFile())
				return (int)file.length();
			else {
				return -1;
			}
			
		}
		public byte[] getFile(String filename) throws IOException{
			int len = getLength(filename);
			byte b[] = new byte[len];
			FileInputStream f1 = new FileInputStream(filename);
			f1.read(b);
			System.out.println("Da doc xong noi dung file");
			f1.close();
			return b;
		}


}
