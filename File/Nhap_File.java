package File;
import java.io.File;
public class Nhap_File {

	public static void main(String[] args) {
		File f = new File("test.txt");
		System.out.println(f.canRead());
		System.out.println(f.canWrite());
		System.out.println(f.getName());
		System.out.println(f.getAbsolutePath());
		System.out.println(f.length());
		
	}

}
//Tao doi tuong File
//Xem cac pt