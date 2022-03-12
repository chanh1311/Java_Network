package InOutStream;
import java.io.IOException;
import java.io.InputStream;
public class InputStream_test {

	public static void main(String[] args) {
		InputStream banphim = System.in;
		while(true){
			try {
				System.out.print("Nhap vao 1 ki tu: ");
				int kitu = banphim.read();
				
				if(kitu == -1 || kitu == 'q') {
					break;
				}
				System.out.println(kitu);
				System.out.println((char)kitu);
			} catch (IOException e) {
				
				System.out.println("Loi doc ki tu!");
			}
			
		}

	}

}
