package File;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Read_File {
  public static void main(String[] args) {
    try {
    	File f = new File("test.txt");
    	Scanner sc = new Scanner(f);
    	while(sc.hasNextLine()) { 
    		String s = new String(sc.nextLine());
    		System.out.println(s);
    	}
    	sc.close();
    	
    }catch(FileNotFoundException e) {
    	System.out.println("Khong tim thay File");
    	e.printStackTrace();
    }
  }
}
//tao doi tuong File
//tao doi tuong scan
//while vo han -->hasNextLine() neu co dong tiep theo tra ve True
	// Lay gia tri bang pt NextLine gan cho chuoi String
// Dong ham scan
// Xu li ngoai le neu khong tim thay File