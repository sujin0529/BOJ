import java.util.Scanner;

// [백준 1003] 피보나치 함수
// https://blog.naver.com/tnwls0529/221839089827

public class Main {
	static void fibo(int count[][], int n) {
		if(n==0) {
			count[n][0] = 1;
			count[n][1] = 0;
		}
		else if(n==1) {
			count[n][0] = 0;
			count[n][1] = 1;

		}
		else if(count[n][0] != 0) {
			// 값이 비어있지 않다면 아무것도 하지 않아도 됨.
		}
		else {
			// 만약에 비어있다면 채워오도록 해야함.
			fibo(count, n-1);
			fibo(count, n-2);
			
			count[n][0] = count[n-1][0] + count[n-2][0];
			count[n][1] = count[n-1][1] + count[n-2][1];
		}			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for(int i=0; i<test_case; i++) {
			int N = sc.nextInt();
			int count[][] = new int[N+1][2];
			fibo(count, N);
			System.out.println(count[N][0]+" "+count[N][1]);
		}

	}

}
