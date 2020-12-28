package treeParent;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		LinkedList<Integer> node[] = new LinkedList[num+1]; // 간선 여부
		int parent[] = new int[num+1]; // 각 노드의 부모
		for(int i=1; i<=num; i++) {
			node[i] = new LinkedList<>();
		}
		for(int i=0; i<num-1; i++) {
			String[] s = sc.nextLine().split(" ");
			int node1 = Integer.parseInt(s[0]);
			int node2 = Integer.parseInt(s[1]);
			
			node[node1].add(node2);
			node[node2].add(node1);
		}
		
		sc.close();
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		while(!queue.isEmpty()) {
			int parentNode = queue.remove();
			Iterator<Integer> iter = node[parentNode].iterator();
			while(iter.hasNext()) {
				int tmp = iter.next();
				if(parent[tmp] == 0) {
					parent[tmp] = parentNode;
					queue.add(tmp);
				}
			}
		}
		
		for(int i=2; i<=num; i++) {
			System.out.println(parent[i]);
		}
	}
}