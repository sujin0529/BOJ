package makingColoredPaper;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[][] paper = new int[size][size];
		int[] count = new int[2]; // 0은 하얀색, 1은 파란색
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		
		quadTree(paper, 0, 0, size, count);
		System.out.println(count[0]);
		System.out.println(count[1]);
	}
	
	static void quadTree(int[][] paper, int x, int y, int size, int[] count) {
		boolean check = true; // 모두 같은 색인지 체크
		for(int i=y; i<y+size; i++) {
			for(int j=x; j<x+size; j++) {
				if(paper[y][x] != paper[i][j]) {
					check = false;
				}
			}
		}
		
		if(check) {
			// 만약 모두 같으면
			count[paper[y][x]]++;
			return ;
		}
		
		// 같지 않은게 있으면 분할
		int halfSize = size/2;
		quadTree(paper, x, y, halfSize, count);
		quadTree(paper, x+halfSize, y, halfSize, count);
		quadTree(paper, x, y+halfSize, halfSize, count);
		quadTree(paper, x+halfSize, y+halfSize, halfSize, count);
	}
}