import java.util.Scanner;

// [백준 2156] 포도주 시식
// https://blog.naver.com/tnwls0529/221850040056

public class Main {
	
	static void wine_sum(int sum[][], int wine[], int num) {
		sum[num][0] = Math.max(sum[num-1][1], sum[num-1][2]);
		sum[num][0] = Math.max(sum[num][0], sum[num-1][0]);
		// 0번째는 여러 개를 먹지 않아도 괜찮기 때문에 0인 것도 고려해야 함.
		sum[num][1] = sum[num-1][0] + wine[num];
		sum[num][2] = sum[num-1][1] + wine[num];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt(); // 포도주 잔 개수
		
		int wine[] = new int[number];
		
		for(int i=0; i<number; i++) {
			wine[i] = sc.nextInt(); // 포도주 양
		}
		
		int sum[][] = new int[number][3];
		// 0 : 끊김, 1 : 한 잔, 2 : 두 잔
		
		sum[0][0] = 0;
		sum[0][1] = wine[0];
		sum[0][2] = 0;
		
		for(int i=1; i<number; i++) {
			wine_sum(sum, wine, i);
		}
		
		int max = Math.max(sum[number-1][0], sum[number-1][1]);
		max = Math.max(max, sum[number-1][2]);
		
		System.out.println(max);
	}

}
