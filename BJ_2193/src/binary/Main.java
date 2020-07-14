package binary;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long[] num = new long[N+2]; // 최소한 0과 1의 공간 확보
		
		num[0] = 0;
		num[1] = 1;
		
		for(int i=2; i<N+1; i++) {
			num[i] = num[i-1]+num[i-2];
		}
		
		System.out.println(num[N]);
	}
}
