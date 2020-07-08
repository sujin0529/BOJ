package bi_coefficient;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int coefficient[][] = new int[N+1][N+1];
		coefficient[0][0] = 1;
		for(int i=1; i<N+1; i++) {
			coefficient[i][0] = 1;
			coefficient[i][i] = 1;
			for(int j=1; j<i; j++) {
				coefficient[i][j] = (coefficient[i-1][j-1] + coefficient[i-1][j])%10007;
			}
		}
		System.out.println(coefficient[N][M]);
	}

}
