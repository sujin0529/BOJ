import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// [백준 5567] 결혼식
// https://blog.naver.com/tnwls0529/221782025006

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int same = sc.nextInt(); // 동기 수
		int list = sc.nextInt(); // 입력 반복 횟수
		int matrix[][] = new int[same+1][same+1];
		int wedding[] = new int[same+1];
		Queue q = new LinkedList<Integer>();
		int count = 0;
		for(int i=0; i<list; i++) {
			int _i = sc.nextInt();
			int _j = sc.nextInt();
			matrix[_i][_j] = 1;
			matrix[_j][_i] = 1;
			if(_i==1) {
				q.add(_j);
				wedding[_j] = 1; // 가게 된다면 1로 표시
			}
		}
		
		while(!q.isEmpty()) {
			int friend = (int)q.remove();
			for(int i=2; i<same+1; i++) {
				if(matrix[friend][i]==1) {
					wedding[i] = 1;
				}
			}
		}
		for(int i=2; i<same+1; i++) {
			if(wedding[i]==1) {
				count++;
			}
		}
		
		System.out.println(count);
		

	}

}
