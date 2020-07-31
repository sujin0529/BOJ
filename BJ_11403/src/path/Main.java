package path;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] matrix = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(matrix[i][k] == 1 && matrix[k][j] == 1) {
						matrix[i][j] = 1;
					}
					if(matrix[N-i-1][k] == 1 && matrix[k][N-j-1] == 1) {
						matrix[N-i-1][N-j-1] = 1;
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}