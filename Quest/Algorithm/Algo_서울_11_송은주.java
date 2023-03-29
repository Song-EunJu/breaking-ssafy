import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Algo_서울_11_송은주 {
	// 겹치는 게 아예 없는 경우 
	// -> 각 사각형의 둘레의 합 
	/*
	 * 몇개는 겹치고 몇개는 안겹치는 경우
	 * -> 안겹치는애 둘레 + 겹치는 애는 (큰사각형 상단 지점 - 작은 사각형 하단지점) * 2
	 * */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int arr[][] = new int[num][2];
		
		// 검은 스카프의 좌표 값을 arr 배열에 저장
		for(int i=0;i<num;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			arr[i][0] = x1;
			arr[i][1] = y1;
		}
		
		// 겹치거나 스치는 경우의 스카프들의 배열 인덱스를 set 에 저장
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<num-1;i++) { 
			for(int j=i+1;j<num;j++) {
				int absX = Math.abs(arr[i][0]-arr[j][0]);
				int absY = Math.abs(arr[i][1]-arr[j][1]);
				if(absX <=10 || absY <= 10) { // 절댓값이 10보다 작은 경우 겹치거나 스치게 됨 
					set.add(i);
					set.add(j);
				}
			}
		}
		
		// set 에 있는 인덱스들을 list 로 이동
		List<Integer> list = new ArrayList<>();
		for(int i: set) 
			list.add(i);
		
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;
		
		int sum = 0;
		
		// 겹치는 스카프들의 max, min 좌표를 구함
		for(int i=0;i<list.size();i++) {
			maxX = Math.max(maxX, arr[list.get(i)][0]);
			minX = Math.min(minX, arr[list.get(i)][0]);
			maxY = Math.max(maxY, arr[list.get(i)][1]);
			minY = Math.min(minY, arr[list.get(i)][1]);
		}

		// 모든 좌표들이 완전히 하나로 겹쳐지지 않은 경우 
		if(maxX != minX) {
			// 가운데에 작은 사각형이 생기게 겹쳐진 경우에만 작은 사각형 둘레를 더해줌
			if(maxX-(minX+10) > 0 && maxY-(minY+10) > 0)
				sum += (maxX-(minX+10))*2 + (maxY-(minY+10))*2;
		}
		
		// 스카프의 시작 max 값이 아니라 실제 스카프의 최대 x,y 좌표를 구해주기 위해 10씩 더함
		maxX += 10;
		maxY += 10;	
		
		// 가장 바깥쪽 스카프들의 둘레를 구함
		sum += (maxX-minX)*2 + (maxY-minY)*2;

		// 안겹치는 거는 리스트에 들어가있지 않으므로 자기자신의 둘레 더해주면 됨
		sum += 40*(num-list.size());
		 
		System.out.print(sum);
	}
}
