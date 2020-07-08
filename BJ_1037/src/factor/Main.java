package factor;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 약수의 개수
		int factor[] = new int[N]; // 약수 입력 받기
		for(int i=0; i<N; i++) {
			factor[i] = sc.nextInt();
		}
		Arrays.sort(factor); // 정렬
		System.out.println(factor[0]*factor[N-1]);
		// N은 약수의 곱으로 표현할 수 있는데, 가장 작은 약수와 가장 큰 약수의 곱으로 표현할 수 있음.

	}

}
