package rope;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt(); // 로프의 개수
		int[] rope = new int[number];
		for(int i=0; i<number; i++) {
			rope[i] = sc.nextInt(); // 로프의 최대 중량 입력
		}
		
		Arrays.sort(rope); // 오름차순으로 정렬
		int max_weight = 0; // 최대 중량
		int count = 1; // 로프 개수
		
		// 가장 적은 무게를 버틸 수 있는 로프에 대해서 개수만큼 곱한 것이 최대 중량임.
		
		for(int i=number-1; i>=0; i--) {
			// 오름차순이었으니까 뒤부터
			if((rope[i]*count)>max_weight) {
				max_weight = rope[i]*count;
			}
			count++;
		}
		System.out.println(max_weight);
	}
}
