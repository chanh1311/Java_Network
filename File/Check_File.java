package File;
//Cac phuong thuc tuong tac voi File//
import java.io.File;  // Import the File class

public class Check_File { 
  public static void main(String[] args) {
    File myObj = new File("test.txt");
    if (myObj.exists()) { 
      System.out.println("File name: " + myObj.getName());
      System.out.println("Absolute path: " + myObj.getAbsolutePath());
      System.out.println("Writeable: " + myObj.canWrite());
      System.out.println("Readable " + myObj.canRead());
      System.out.println("File size in bytes " + myObj.length());
    } else {
      System.out.println("The file does not exist.");
    }
  }
}

//tao doi tuong File
//Neu File ton tai thi hien thi cac phuong thuc
//nguoc lai hien thi "File khong ton tai"