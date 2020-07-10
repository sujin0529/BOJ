package sequence_sum;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int number[] = new int[N];
		
		String s = sc.nextLine();
		String tmp[] = s.split(" ");
		
		for(int i=0; i<N; i++) {
			number[i] = Integer.parseInt(tmp[i]);
		}
		
		int max = number[0];
		int sum = max;
		
		for(int i=1; i<N; i++) {
			if(number[i] < 0) {
				// 이번 것이 음수면

				if(max < sum) {
					// 이전 값이 더 컸다면, max 수정
					max = sum;	
				}
						
				if(sum < number[i]) {
					// 만약 단일 수 값이 더 크다면, 더하지 않고, 현재 값 그대로 사용
					sum = number[i];
				}
				else if(sum+number[i] > 0){
					sum = sum + number[i]; // 더한거	
				}
				else {
					// 만약 아니라면, 입력받을 수 없는 값 중 가장 작은 값으로 초기화
					sum = -1001;
				}
				
			}
			else {
				if(sum < 0) {
					sum = 0;
				}
				sum = sum+number[i];
			}
		}
		
		if(max < sum) {
			// max가 수정될 수 있다면 수정
			max =sum;
		}
		
		System.out.println(max);

	}

}
