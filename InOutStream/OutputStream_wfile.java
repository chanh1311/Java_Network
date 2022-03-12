package InOutStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
public class OutputStream_wfile {

	public static void main(String[] args){
			FileOutputStream f = null;
		try {
			f = new FileOutputStream("test.txt");
//			f.write(65);
			String str = new String("");//tu 1 chuoi//
			byte[] array = str.getBytes();//lay cac ki tu tu string//
			//dia chi mang
			f.write(array);//ghi cac ki tu vao file chi nhan doi so la kieu so(int)//
			System.out.println("Thanh Cong!");
		}catch(IOException e){
			System.out.println(e.getMessage());
		}finally {
			try {
				f.close();	
			}catch(IOException e){
				System.out.println("Loi!!!");
			}
			//co the tao ra mot loi IOexception//
		}

	}

}
// Tao doi tuong File
//Tao 1 doi tuong String va chuyen no thanh Array kieu Byte[]
// Dung phuong thuc write() de ghi array vao File
//Neu ngoai le xay ra hien thi loi 
//Dong File