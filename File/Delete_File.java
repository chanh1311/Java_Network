package File;

import java.io.File;

public class Delete_File {

	public static void main(String[] args) {
		try {
			File f = new File("\\chanh.txt");//co the xoa thu muc \\//
			if(f.delete()) {
				System.out.println("Xoa thanh cong!");
			}else {
				System.out.println("Khong the Xoa!");
			}
		}catch(Exception e){
				System.out.println("Nhan ve 1 loi!");
				System.out.println(e.toString());
		}
	}

}

//tao doi tuong
//neu xoa file duoc(True) : Xoa thanh cong
//Neu khong xoa duoc(False): Khong the xoa
//Khac voi tao File la tao File co the tra ve exception con xoa khong duoc thì khong tra ve exception-->Tra ve Fasle