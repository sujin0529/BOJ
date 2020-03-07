package tiling;

import java.util.Scanner;

public class Main {
	
	static void tiling(int tile[], int n) {
		if(n==1) {
			tile[1] = 1;
		}
		else if(n==2) {
			tile[2] = 2;
		}
		else {
			if(tile[n]==0) {
				// 입력받은 게 아니라면
				tiling(tile, n-1);
				tiling(tile, n-2);
				tile[n] = (tile[n-1] + tile[n-2])%10007;
				
				/* 출력에서 10007로 나눈 나머지를 출력하라고 했기 때문에,
				 * n에 저장하기 전에, 나머지 연산을 진행한 후, 저장한다. */
				 
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 2*n에서 n 입력받음
		int tile[] = new int[n+1]; // n마다 타일링 방법을 저장할 배열
		tiling(tile, n);
		System.out.println(tile[n]);
		

	}

}
