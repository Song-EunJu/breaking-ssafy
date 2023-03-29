import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_서울_11_송은주 {
	/* 
	 * 문제 : 다른 봉우리에 의해 포함되지 않는 봉우리 개수 / 다른 봉우리를 포함하지 않는 봉우리 개수를 구하는 프로그램
	 */
	public static void main(String[] args) throws IOException {
		// 다른 봉우리에 의해 포함되지 않는 것 -> 자기 자신이 다른 봉우리를 포함하고 있는 애
		// 다른 봉우리에 포함되지도 않고, 다른 봉우리를 포함하지도 않는 것 -> 자기 혼자 우뚝 서있는 애
	
		
		/* 
		 * 봉우리가 시작되는 지점의 x좌표를 저장해두고, 
		 * 봉우리의 x좌표가 0이상으로 올라왔다가 다시 0 을 만나서 봉우리가 사라지기 전까지 봉우리의 최대 y 좌표 기억해둔다
		*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int bongStart = 0;
		int maxY = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			if(arr[i][1]>0) { // 봉우리가 시작되는 시점의 x좌표 저장
				bongStart = arr[i][0]; 
				maxY = Math.max(maxY, arr[i][1]);
			}
		}
	}
}
