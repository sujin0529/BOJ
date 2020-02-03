package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] tree = new int[num];
		int[] not_leaf = new int[num];
		for(int i=0; i<num; i++) {
			tree[i] = sc.nextInt();
		}
		int del = sc.nextInt();
		Queue q = new LinkedList<Integer>();
		
		q.add(del);
		tree[del] = -2;// del 된 것은 -2로 표시
		while(!q.isEmpty()) {
			int parent = (int)q.remove();
			for(int i=0; i<num; i++) {
				if(tree[i]==parent) {
					q.add(i);
					tree[i] = -2; 
				}
			}
		}
		
		for(int i=0; i<num; i++) {
			if(tree[i]>=0) {
				not_leaf[tree[i]] = 1;
			}
			if(tree[i]==-2) {
				not_leaf[i] = 1;
			}
		}
		
		int count = 0;
		for(int i=0; i<num; i++) {
			if(not_leaf[i]==0) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
