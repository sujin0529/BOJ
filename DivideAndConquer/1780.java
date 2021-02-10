import java.util.Scanner;

// [백준 1780] 종이의 개수
// https://blog.naver.com/tnwls0529/222207071942

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[][] paper = new int[size][size];
		int[] count = new int[3];
		// count[2]에 -1에 대한 count 저장
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		paperCount(paper, 0, 0, size, count);
		
		System.out.println(count[2]);
		System.out.println(count[0]);
		System.out.println(count[1]);
	}
	
	static void paperCount(int[][] paper, int x, int y, int size, int[] count) {
		boolean check = true;
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(paper[y][x] != paper[y+i][x+j]) {
					check = false;
					break;
				}
			}
		}
		
		if(check) {
			if(paper[y][x] == -1) {
				count[2]++;
			}
			else {
				count[paper[y][x]]++;
			}
		}
		else {
			int trisection = size/3;
			
			paperCount(paper, x, y, trisection, count);
			paperCount(paper, x, y+trisection, trisection, count);
			paperCount(paper, x, y+trisection*2, trisection, count);
			paperCount(paper, x+trisection, y, trisection, count);
			paperCount(paper, x+trisection, y+trisection, trisection, count);
			paperCount(paper, x+trisection, y+trisection*2, trisection, count);
			paperCount(paper, x+trisection*2, y, trisection, count);
			paperCount(paper, x+trisection*2, y+trisection, trisection, count);
			paperCount(paper, x+trisection*2, y+trisection*2, trisection, count);
		}
	}
}