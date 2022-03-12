package File;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class Write_File{
  public static void main(String[] args) {
    try {
      FileWriter myObj = new FileWriter("mainhe.txt");//tao file o trong thu muc project//
      myObj.write("HELLO BAN MINH TEN LA CHANH");//neu chua co file thi tao file roi ghi,neu file da ton tai ghi de//
      myObj.close();
      System.out.println("Ghi Thanh Cong!");
    } catch (IOException e) {
    	System.out.println("An error occurred.");
        e.printStackTrace();
    }
  }
}
//Tao doi tuong File
//Ghi File thong qua chuoi String
//Dong File
// Neu ngoai le xay ra (IOEXcep) thi xu li