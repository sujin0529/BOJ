package nm_2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		boolean[] visited = new boolean[N+1];
		
		dfs(1, N, visited, M, 0);
		
		

	}
	
	static void print(int n, boolean[] visited) {
		for(int i=1; i<=n; i++) {
			if(visited[i] == true) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
	}
	
	static void dfs(int start, int n, boolean[] visited, int count, int visit_count) {
		
		if(count == visit_count) {
			print(n, visited);
		}
		
		for(int i=start; i<=n; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				
				dfs(i+1, n, visited, count, visit_count+1);
				
				visited[i] = false;
			}
		}
	}

}
