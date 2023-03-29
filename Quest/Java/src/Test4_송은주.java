
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test4_송은주 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 각 과제별로 응시생 평균 점수보다 낮은 점수를 받는 응시생 비율 알기
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			
			// 평균 점수 구하기
			int num = Integer.parseInt(st.nextToken()); // 응시인원
			int student[] = new int[num];
			int sum = 0;
			for(int j=0;j<num;j++) {
				student[j] = Integer.parseInt(st.nextToken());
				sum += student[j];
			}
			double avg = (double)sum/num;
			
			// 평균보다 낮은 점수 받는 응시생 비율 구하기
			int failPerson = 0;
			for(int j=0;j<num;j++) {
				if(student[j]-avg < 0) // 응시생 평균점수보다 낮은 점수받는 응시생 명수 체크
					failPerson++; 
			}
			System.out.print((i+1)+" ");
			System.out.printf("%.3f",((double)failPerson/num)*100);
			System.out.println("%");
		}
	}
}
