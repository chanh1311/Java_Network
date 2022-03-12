package ChuyenKieu;
public class stringToArray{
	public static void main(String args[]){
		String s = "chanh di hoc";
		 byte[] array = s.getBytes();
		System.out.println(array);
		for(int i = 0; i < array.length; i++){
			System.out.println((char)array[i]);
		}
	}
}

//Tu 1 Stirng tao ra 1 array kieu Bytes(ep kieu su dung phuong thuc getBytes())
//Hien thi cac phan tu array sau khi dc ep kieu Byte