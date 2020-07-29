package nm_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] visited = new int[N+1];
		
		dfs(1, N, visited, M, 0);
		

	}
	
	static void print(int n, int[] visited, int m) {
		int index = 1;
		for(int i=0; i<m; i++) {
			for(int j=1; j<=n; j++) {
				if(visited[j] == index) {
					System.out.print(j+" ");
					index++;
				}
			}
		}
		System.out.println();
	}
	
	static void dfs(int start, int n, int[] visited, int count, int visit_count) {
		
		if(count == visit_count) {
			print(n, visited, count);
		}
		
		for(int i=1; i<=n; i++) {
			if(visited[i] == 0) {
				visited[i] = visit_count+1;
				
				dfs(i+1, n, visited, count, visit_count+1);
				
				visited[i] = 0;
			}
		}
	}
	
}