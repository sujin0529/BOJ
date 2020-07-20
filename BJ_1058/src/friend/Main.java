package friend;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		char friend[][] = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String tmp = sc.nextLine();
			for(int j=0; j<N; j++) {
				friend[i][j] = tmp.charAt(j);
			}
		}
		
		int friend_2[][] = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(friend[i][j]=='N') {
					// 바로 연결되어 있지는 않을 때
					if(i==j) {
						// 같은 경우에는 친구가 아님
					}
					else {
						for(int k=0; k<N; k++) {
							if(friend[i][k]=='Y' && friend[k][j]=='Y') {
								// 만약 중간다리 역할이 있다면
								friend_2[i][j] = 1;
								friend_2[j][i] = 1;
							}
						}
					}
				}
				else {
					// 바로 연결되어 있을 때
					friend_2[i][j] = 1;
					friend_2[j][i] = 1;
				}
			}
		}
		
		int max = 0;
		for(int i=0; i<N; i++) {
			int sum = 0;
			for(int j=0; j<N; j++) {
				sum += friend_2[i][j];
			}
			if(max < sum) {
				max = sum;
			}
		}
		
		System.out.println(max);
	}
}