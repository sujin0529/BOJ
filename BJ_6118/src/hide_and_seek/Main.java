package hide_and_seek;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int iter = sc.nextInt(); // edge 개수
		
		List[] matrix = new LinkedList[size+1]; // 1부터라서 인덱스 0은 사용x
		int[] distance = new int[size+1];
			
		Queue q = new LinkedList<Integer>();
		
		
		for(int i=1; i<size+1; i++) {
			matrix[i] = new LinkedList<Integer>();
		}
		
		for(int i=0; i<iter; i++) {
			int _i = sc.nextInt();
			int _j = sc.nextInt();
			matrix[_i].add(_j);
			matrix[_j].add(_i);
		}
		
		Iterator<Integer> it = matrix[1].iterator();
		
		while(it.hasNext()) {
			int _next = it.next();
			distance[_next] = 1;
			q.add(_next);
		}
		
		while(!q.isEmpty()) {
			int _next = (int)q.remove();
			Iterator<Integer> u = matrix[_next].iterator();
			while(u.hasNext()) {
				int _u = (int)u.next();
				if((distance[_u]>distance[_next]+1 || distance[_u]==0)) {
					distance[_u] = distance[_next]+1;
					q.add(_u);
				}
			}
		}
		
		int max = 0;
		int index = 1;
		for(int i=2; i<size+1; i++) {
			if(distance[i]>max) {
				max = distance[i];
				index = i;
			}
		}
		
		int count = 0;
		for(int i=2; i<size+1; i++) {
			if(max == distance[i]) {
				count++;
			}
		}
		
		System.out.println(index+" "+distance[index]+" "+count);
		
	}
}