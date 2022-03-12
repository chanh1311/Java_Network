package File;

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

public class Create_File{
  public static void main(String[] args) {
    try {
      File myObj = new File("filename.txt");// tao 1 doi tuong 
      if (myObj.createNewFile()) { //tao duoc file
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    	} catch (IOException e) {
    		System.out.println("An error occurred.");
    		e.printStackTrace();
    	}
  }
}
// tao mot doi tuong
// neu tao duoc file(True) : lay ten File
// Nguoc lai : File khong ton tai
// Neu co 1 loi nao do xay ra thi hien thi loai loi(sai duong dan tao file chang han)
// Loi IOException lien quan den thao tac IO