package InOutStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Doc_File_Scanner {
    public static void main(String args[]) throws FileNotFoundException {

        String url = "test.txt";
        //doc File
        FileInputStream fileInputStream = new FileInputStream(url);
        Scanner scanner = new Scanner(fileInputStream);

        try {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } finally {
            try {
                scanner.close();
                fileInputStream.close();
            } catch (IOException ex) {
                System.out.println("Ngoai le xay ra khi co gang dong File!");
            }
        }
    }
}