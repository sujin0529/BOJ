package bridge;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int loop = sc.nextInt();
		
		for(int i=0; i<loop; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int bridge[][] = new int[M+1][M+1]; // N <= M
			
			bridge[0][0] = 0;

			for(int row = 1; row<=M; row++) {
				bridge[row][0] = 1;
				bridge[row][row] = 1;
				for(int col = 1; col<row; col++) {
					bridge[row][col] = bridge[row-1][col-1] + bridge[row-1][col];
				}
			}
			System.out.println(bridge[M][N]);
		}
		

	}

}
