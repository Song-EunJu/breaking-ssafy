
public class Test2_송은주 {

	public static void main(String[] args) {

		int[]  su=  {45, 80, 68, 19, 34, 55, 27, 63, 38, 7};
		// 평균(실수값) 구하기
		// 평균과 값의 차이가 가장 큰 값을 찾아서 출력 -> 여러 개인 경우는 아무거나 출력
		
		int sum = 0;
		for(int i=0;i<su.length;i++) {
			sum += su[i];
		}
		double avg = (double)sum/su.length;
		
		double max = 0; // 평균과 값의 차이가 가장 큰 값 저장하는 변수
		int num = 0;
		for(int i=0;i<su.length;i++) {
			double abs = Math.abs(avg-su[i]);
			if(abs > max){
				max = abs;
				num = su[i];
			}
		}
		System.out.printf("%.1f",avg);
		System.out.print(" "+num);
	}
}
