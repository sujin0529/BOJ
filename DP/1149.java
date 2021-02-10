import java.util.Scanner;

// [백준 1149] RGB거리
// https://blog.naver.com/tnwls0529/221840591418

public class Main {
	
	static void coloring(int [][] color, int[] input, int number) {
		// number : color 배열의 row
		// 비용의 최솟값이기 때문에, 누적된 가격이 저렴해야함. -> min 사용
		
		color[number][0] = Math.min(color[number-1][1], color[number-1][2])+input[0];
		// 현재가 red가 되려면 이전 것이 green 또는 blue.
		color[number][1] = Math.min(color[number-1][0], color[number-1][2])+input[1];
		// 현재가 green이 되려면 이전 것이 red 또는 blue.
		color[number][2] = Math.min(color[number-1][0], color[number-1][1])+input[2];
		// 현재가 blue가 되려면 이전 것이 red 또는 green.	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int house = sc.nextInt(); // 집의 개수
		int[][] color = new int[house][3]; // RGB에 대한 가격 누적
		
		// red : 0, green : 1, blue : 2
		
		color[0][0] = sc.nextInt();
		color[0][1] = sc.nextInt();
		color[0][2] = sc.nextInt();
		// 첫 번째 집에 대한 가격. 초기값
		
		for(int i=1; i<house; i++) {
			int input[] = new int[3]; // rgb 입력 받아 저장할 배열
			for(int j=0; j<3; j++) {
				input[j] = sc.nextInt();
			}
			coloring(color, input, i);
		}
		
		int min = color[house-1][0]>color[house-1][1] ? color[house-1][1] : color[house-1][0];
		min = min>color[house-1][2] ? color[house-1][2] : min;
		// 맨 마지막 집까지 누적된 비용 중 작은 값 찾기
		
		System.out.println(min);

	}

}
