import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//받은 일기를 보고 문자들을 알아내어 출력하거나, 모르는 문자가 있는 경우, 
// 이것이 처음 나오는 위치를 출력하는 프로그램
public class Test5_송은주 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		String[] aArray = {"000000", "100000", "010000", "001000", "000100", "000010", "000001"};
		String[] bArray = {"001111", "101111", "011111", "000111", "001011", "001101", "001110"};
		String[] cArray = {"010011", "110011", "000011", "011011", "010111", "010001", "010010"};
		String[] dArray = {"011100", "111100", "001100", "010100", "011000", "011110", "011101"};
		String[] eArray = {"100110", "000110", "110110", "101110", "100010", "100100", "100111"};
		String[] fArray = {"101001", "001001", "111001", "100001", "101101", "101011", "101000"};
		String[] gArray = {"110101", "010101", "100101", "111101", "110001", "110111", "110100"};
		String[] hArray = {"111010", "011010", "101010", "110010", "111110", "111000", "111011"};
		String[] tempArray = {"000101", "001010", "010110", "011001", "100011", "101100", "110000", "111111"}; 
		
		for(int i=0;i<n*6;i+=6) {
			// 6개 단위로 읽는다
			String alphabet = s.substring(i, i+6);
			// 숫자 1개만 다른 경우에는 원래 보내려던 문자를 알 수 있음  
			if(checkAlphabet(alphabet, tempArray)){
				System.out.println((i/6)+1);
				return;
			}
			else if(checkAlphabet(alphabet, aArray)) 
				sb.append("A");
			else if(checkAlphabet(alphabet, bArray))
				sb.append("B");
			else if(checkAlphabet(alphabet, cArray))
				sb.append("C");
			else if(checkAlphabet(alphabet, dArray))
				sb.append("D");
			else if(checkAlphabet(alphabet, eArray))
				sb.append("E");
			else if(checkAlphabet(alphabet, fArray))
				sb.append("F");
			else if(checkAlphabet(alphabet, gArray))
				sb.append("G");
			else if(checkAlphabet(alphabet, hArray))
				sb.append("H");
		}
		System.out.print(sb);
	}

	public static boolean checkAlphabet(String s, String[] array) {	
		for(int i=0;i<array.length;i++) {
			if(array[i].equals(s))
				return true;
		}
		return false; // 원본 문자열 + 틀릴 수 있는 문자열 모두에 속하지 않는 경우
	}
}