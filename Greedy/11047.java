import java.util.Scanner;

// [백준 11047] 동전 0
// https://blog.naver.com/tnwls0529/221796317469

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 동전의 가치
		int K = sc.nextInt(); // 금액
		int value[] = new int[N];
		for(int i=N; i>0; i--) {
			value[i-1] = sc.nextInt();
			// 동전의 가치를 내림차순으로 입력하도록 함.
		}
		int coin = 0; // 동전의 개수
		for(int i=0; i<N; i++) {
			if(K/value[i]>0) {
				coin += K/value[i];
				K %= value[i];
			}
			if(K==0) {
				break;
			}
		}
		System.out.println(coin);
	}
}
