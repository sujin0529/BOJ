package connect;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int vertex = sc.nextInt();
		int edge = sc.nextInt();
		
		int matrix[][] = new int[vertex+1][vertex+1];
		boolean visited[] = new boolean[vertex+1];
		
		for(int i=0; i<edge; i++) {
			int head = sc.nextInt();
			int tail = sc.nextInt();
			matrix[head][tail] = 1;
			matrix[tail][head] = 1;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		int count = 0; // 연결 요소 개수 카운트
		for(int index = 1; index<=vertex; index++) {
			if(visited[index] != true) {
				count++;
				queue.add(index);
				visited[index] = true;
			}
			
			while(!queue.isEmpty()) {
				int tmp = queue.remove();
				for(int i=1; i<=vertex; i++) {
					if(matrix[tmp][i] == 1 && visited[i] != true) {
						queue.add(i);
						visited[i] = true;
					}
				}
			}
		}
		
		System.out.println(count);
	}
}