package InOutStream;
import java.io.FileInputStream;
import java.io.IOException;
public class ReadFile_FileInput {

	public static void main(String[] args) {
	try {
		FileInputStream	f1 = new FileInputStream("test.txt");
		
		int dodai = f1.available();
		System.out.println("Do dai File la: " + dodai);
		for(int i = 0; i < dodai ; i++) {
			System.out.print((char)f1.read());//doc tuan tu
		}
		f1.close();// dong file//
	}catch(IOException e) {//loi IO la loi nhap xuat//
		System.out.println(e.getMessage());
	}
		

	}

}
