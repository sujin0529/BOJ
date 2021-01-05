package minimunSpanningTree;

import java.util.Arrays;
import java.util.Scanner;

class edge implements Comparable<edge> {
	int head;
	int tail;
	int cost;

	public edge(int head, int tail, int cost) {
		this.head = head;
		this.tail = tail;
		this.cost = cost;
	}

	@Override
	public int compareTo(edge o) {
		// TODO Auto-generated method stub
		if (this.cost > o.cost) {
			return 1;
		} else if (this.cost < o.cost) {
			return -1;
		}
		return 0;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int vertex = sc.nextInt();
		int edge = sc.nextInt();

		edge[] graph = new edge[edge];

		int root[] = new int[vertex + 1]; // 처음 트리의 루트는 자신

		for (int i = 1; i <= vertex; i++) {
			root[i] = i;
		}
		for (int i = 0; i < edge; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			int cost = sc.nextInt();

			graph[i] = new edge(first, second, cost);
		}
		Arrays.sort(graph);

		int result = 0;
		int edgeCount = 0;
		int index = 0;
		while (edgeCount < vertex - 1) {
			int headParent = root[graph[index].head];
			int tailParent = root[graph[index].tail];
			if (headParent != tailParent) {
				result += graph[index].cost;

				for (int j = 1; j <= vertex; j++) {
					if (root[j] == tailParent) {
						// 현재 합쳐지는 트리라면 루트 변경하여 트리 조정
						root[j] = headParent;
					}
				}
				edgeCount++;
			}
			index++;
		}
		System.out.println(result);
	}
}