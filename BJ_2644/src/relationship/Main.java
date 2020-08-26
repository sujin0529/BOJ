package relationship;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int people = sc.nextInt();
		int rel1 = sc.nextInt();
		int rel2 = sc.nextInt();
		// 관계를 구해야하는 두 사람
		
		int matrix[][] = new int[people+1][people+1];
		
		int relation = sc.nextInt();
		for(int i=0; i<relation; i++) {
			int head = sc.nextInt();
			int tail = sc.nextInt();
			matrix[head][tail] = 1;
			matrix[tail][head] = 1;
		}
		
		for(int i=1; i<=people; i++) {
			for(int j=1; j<=people; j++) {
				for(int k=1; k<=people; k++) {
					if(i==j) {
						continue;
					}
					if(matrix[i][k] != 0 && matrix[k][j] != 0) {
						if(matrix[i][j] == 0) {
							matrix[i][j] = matrix[i][k] + matrix[k][j];
							matrix[j][i] = matrix[i][k] + matrix[k][j];
						}
						else {
							matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
							matrix[j][i] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
						}
					}
					
					if(matrix[people-i+1][k] != 0 && matrix[k][people-j+1] != 0) {
						if(matrix[people-i+1][people-j+1] == 0) {
							matrix[people-i+1][people-j+1] = matrix[people-i+1][k] + matrix[k][people-j+1];
							matrix[people-j+1][people-i+1] = matrix[people-i+1][k] + matrix[k][people-j+1];
						}
						else {
							matrix[people-i+1][people-j+1] = Math.min(matrix[people-i+1][people-j+1], matrix[people-i+1][k] + matrix[k][people-j+1]);
							matrix[people-j+1][people-i+1] = Math.min(matrix[people-i+1][people-j+1], matrix[people-i+1][k] + matrix[k][people-j+1]);
						}
					}
				}
			}
		}
		
		int result = matrix[rel1][rel2];
		if(result == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
		

	}

}
