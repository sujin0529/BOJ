import java.util.Scanner;

// [백준 1932] 정수 삼각형
// https://blog.naver.com/tnwls0529/221843748015

public class Main {
	
	static void triangle_sum(int[][] sum, int[][] triangle, int line) {
		sum[line][0] = sum[line-1][0]+triangle[line][0];
		// 맨 왼쪽 값 저장
		for(int i=1; i<line; i++) {
			sum[line][i] = Math.max(sum[line-1][i-1], sum[line-1][i])+triangle[line][i];
			// 윗 줄의 인접 값 두 개 중 더 큰 것과 자기 자신을 더한 값을 sum에 저장
		}
		sum[line][line] = sum[line-1][line-1]+triangle[line][line];
		// 맨 오른쪽 값 저장
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt(); // 삼각형의 높이
		int[][] triangle = new int[size][size];
		for(int i=0; i<size; i++) {
			for(int j=0; j<=i; j++) {
				triangle[i][j] = sc.nextInt();
			}
		}
		// 정수 삼각형 입력

		int[][] sum = new int[size][size]; // 누적 합을 저장할 배열
		sum[0][0] = triangle[0][0];
		for(int i=1; i<size; i++) {
			triangle_sum(sum, triangle, i);
		}

		int max = sum[size-1][0];
		for(int i=1; i<size; i++) {
			if(max<sum[size-1][i]) {
				max = sum[size-1][i];
			}
		}
		System.out.println(max);
	}
}
