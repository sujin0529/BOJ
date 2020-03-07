package sequence;

import java.util.Scanner;

public class Main {
	
	static void helix(long sequence[], int n) {
		if(n<4) {
			sequence[n] = 1;
		}
		else {
			if(sequence[n]==0) {
				// 값이 없다면
				helix(sequence, n-2);
				helix(sequence, n-3);
				sequence[n] = sequence[n-2] + sequence[n-3];
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int test_case = sc.nextInt();
		for(int i=0; i<test_case; i++) {
			int N = sc.nextInt(); // 값을 찾고자하는 번호
			long sequence[] = new long[N+1];
			helix(sequence, N);
			System.out.println(sequence[N]);
		}
		
	}
}