import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1_송은주 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char c = br.readLine().charAt(0);
		if(c == '1') {
			int num = 1;
			for(int i=0;i<4;i++) {
				for(int j=0;j<=i;j++) {
					System.out.print((num++)+" ");
				}
				System.out.println();
			}
		}
		else if(c == 'a') {
			char ch = 'a';
			for(int i=5;i>0;i--) {
				for(int j=0;j<i-1;j++) {
					System.out.print("  ");
				}
				for(int j=5;j>=i;j--) {
					System.out.print((ch++)+" ");
				}
				System.out.println();
			}
		}
	}
}
