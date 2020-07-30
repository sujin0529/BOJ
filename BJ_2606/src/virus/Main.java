package virus;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int network = sc.nextInt();
		
		int computer[][] = new int[num+1][num+1];
		
		for(int i=0; i<network; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			computer[u][v] = 1;
			computer[v][u] = 1;
		}
		
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=num; j++) {
				for(int k=1; k<=num; k++) {
					if(computer[i][k] == 1 && computer[k][j] == 1) {
						computer[i][j] = 1;
						computer[j][i] = 1;
					}
					if(computer[1][k] == 1 && computer[k][j] == 1) {
						// 추가한 코드
						computer[1][j] = 1;
						computer[j][1] = 1;
					}
				}
			}
		}
		
		int count = 0;
		for(int i=2; i<=num; i++) {
			if(computer[1][i] == 1) {
				count++;
			}
		}
		
		System.out.println(count);
	}

}
