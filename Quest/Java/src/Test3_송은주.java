
public class Test3_송은주 {
	
	public void execute(String msg) {
		char ch[] = msg.toCharArray();
		int num[] = new int[10];
		for(int i=0;i<ch.length;i++) {
			num[ch[i]-'0']++;
		}
		for(int i=0;i<10;i++) {
			if(num[i] != 0) {
				System.out.println(i+" : "+num[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		// 각 숫자들의 출현 빈도수 체크 
		// 빈도수가 0인 숫자는 출력 X
		Test3_송은주 c=new Test3_송은주();
		c.execute("53290539955364534323455987827332679340558347453272569584"); 
		System.out.println("=======");
		c.execute("13334444555557777777"); 
	}
}
