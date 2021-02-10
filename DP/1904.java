import java.util.Scanner;

// [백준 1904] 01타일

public class Main {
	
	static void make(int tile[], int n) {
		if(n<3) {
			tile[n] = n;
		}
		else {
			if(tile[n]==0) {
				// 만약 값이 저장되어있지 않다면
				make(tile, n-1);
				make(tile, n-2);
				tile[n] = (tile[n-1] + tile[n-2])%15746;
			}	
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 사용할 수 있는 타일의 개수
		int tile[] = new int[N+1]; // 가짓수 저장
		make(tile, N);
		System.out.println(tile[N]);
	}
}