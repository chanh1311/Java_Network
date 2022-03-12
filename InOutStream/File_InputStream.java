package InOutStream;

//import java.io.FileInputStream;
//import java.io.IOException;
// 
//public class InputStream{
//    public static void main(String args[]) throws IOException{//khai bao ham nay co the xay ra ngoai le!
//        FileInputStream fin = null;
//        try {
//            fin = new FileInputStream("test.txt");//neu rong thi gia tri -1//
//            int i = fin.read();//doc ki tu dau tien o dang so
//            System.out.print((char) i);//chuyen ve ki tu
//            
//        } catch (Exception e) {
// //        	e.printStackTrace();
//            System.out.println(e);
//        } finally {
//            fin.close();
//        }
//    }
//}

//import java.io.FileInputStream;
//import java.io.IOException;
// 
//public class InputStream{
//    public static void main(String args[]) throws IOException {//dung cho dong close//
//        FileInputStream fin = null;
//        try {
//            fin = new FileInputStream("test.txt");
//            int i = 0;
//            while ((i = fin.read()) != -1) {
//                System.out.print((char) i);
//            }
//            fin.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            fin.close();//co the xay ra ngoai le ngay day
//        }
//    }
//}

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;//dong nay de khai bao ngoai le!

public class File_InputStream{
	public static void main(String args[] ){
		 
		try {
			
			FileInputStream f = new FileInputStream("test.txt");
			int x = 0;
			while((x = f.read()) != -1) {
//				System.out.print(x);
				System.out.print((char)x);
			}
			f.close();
		} catch (IOException e) {
			System.out.println("Khong tim thay File!");
		
		
		}
	}
}
// Khai bao doi tuong File(f->null + f = new())
// Neu x != -1 tuc la x khac rong, vi neu dong tiep theo rong se doc dc -1
	// xu li ben trong : doc tung dong, hien thi kieu char vi kieu doc ra la Byte//
//Ngoai le xay ra khi khong tim thay file
//Dong File