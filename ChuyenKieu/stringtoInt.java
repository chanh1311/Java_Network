package ChuyenKieu;
public class stringtoInt{
	public static void main(String[] args){
		String s = "100";
		
		int i = Integer.valueOf(s);// chuyen doi tuong ve nguyen thuy int
		int j = Integer.parseInt(s);// chuyen kieu so ve int
		System.out.println(i + 1);
		System.out.println(j + 2);
		
		
	}
}
//  Integer.valueOf() , Integer.parseInt()
// intvalue()--> object ve nguyn thuy Int