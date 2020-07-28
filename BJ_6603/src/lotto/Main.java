package lotto;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int num = 0;

		do {
			num = sc.nextInt();
			if (num == 0) {
				System.exit(0);
			}
			int lotto[] = new int[num];
			for (int i = 0; i < num; i++) {
				lotto[i] = sc.nextInt();
			}
			dfs(0, num, lotto);
			System.out.println();
		} while (num != 0);

	}

	static void dfs(int i, int num, int[] lotto) {
		// 시작 지점 정하는 애
		boolean visit[] = new boolean[num];
		dfs(i, num, visit, lotto, 0);

	}

	static void print(int[] lotto, boolean visit[], int num) {
		for (int i = 0; i < num; i++) {
			if (visit[i] == true) {
				System.out.print(lotto[i] + " ");
			}
		}
		System.out.println("");
	}

	static void dfs(int vertex, int num, boolean visit[], int[] lotto, int count) {

		if (count == 6) {
			print(lotto, visit, num);
		}

		for (int v = vertex; v < num; v++) {
			visit[v] = true;
			dfs(v + 1, num, visit, lotto, count + 1);
			visit[v] = false;
		}
	}

}
