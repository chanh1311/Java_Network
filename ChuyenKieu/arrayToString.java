package ChuyenKieu;
// array byte[]-->String
public class arrayToString{
	public static void main(String args[]){
		byte[] array = {'A','B','C','D','E'};
//		String s = new String(array);
		String s = new String(array,0,array.length);
		System.out.print(s);
		//ABCDE
		//String() --> Nhan vao 1 mang cac byte
}

}

// khai bao mang cac byte
// tao doi tuong String tren mang do(mang,0,dodaimang)
// hien thi chuoi vua tao