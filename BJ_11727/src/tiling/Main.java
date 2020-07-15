package tiling;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int tile[] = new int[N+1];
		tile[1] = 1;
		
		for(int i=2; i<=N; i++) {
			if(i%2==0) {
				// Â¦¼ö¸é
				tile[i] = (tile[i-1]*2+1)%10007;
			}
			else {
				// È¦¼ö¸é
				tile[i] = (tile[i-1]*2-1)%10007;
			}
		}
		
		System.out.println(tile[N]);

	}

}
