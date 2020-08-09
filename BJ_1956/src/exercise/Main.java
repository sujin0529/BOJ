package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int vertex = sc.nextInt();
		int edge = sc.nextInt();
		
		int road[][] = new int[vertex+1][vertex+1];
		for(int i=1; i<=vertex; i++) {
			Arrays.fill(road[i], Integer.MAX_VALUE);
		}
		
		for(int i=1; i<=edge; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int cost = sc.nextInt();
			road[start][end] = cost;
		}
		
		
		
		
		for(int i=1; i<=vertex; i++) {
			for(int j=1; j<=vertex; j++) {
				for(int k=1; k<=vertex; k++) {
					if(road[i][k] != Integer.MAX_VALUE && road[k][j] != Integer.MAX_VALUE) {
						// 우선 경로가 있어야 함.
						if(road[i][j] > (road[i][k]+road[k][j])) {
							road[i][j] = road[i][k]+road[k][j];
						}
					}
					if(road[vertex-i+1][k] != Integer.MAX_VALUE && road[k][vertex-j+1] != Integer.MAX_VALUE) {
						// 우선 경로가 있어야 함.
						if(road[vertex-i+1][vertex-j+1] > (road[vertex-i+1][k]+road[k][vertex-j+1])) {
							road[vertex-i+1][vertex-j+1] = road[vertex-i+1][k]+road[k][vertex-j+1];
						}
					}
					
					
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=vertex; i++) {
			// 최소 사이클의 도로 길이의 합
			if(road[i][i] < min) {
				min = road[i][i];
			}
		}
		
		if(min == Integer.MAX_VALUE) {
			// 만약 값이 바뀌지 않았다면, 운동 경로 찾는 것이 불가능 하단 의미
			min = -1;
		}
		System.out.println(min);
		

	}

}
