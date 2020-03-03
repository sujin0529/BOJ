package stair;

import java.util.Scanner;

public class Main {
	static void max_score(int[][] arr, int[] stair, int index) {
		arr[index][1] = arr[index+1][0]+stair[index]; // 연속해서 자신 포함
		arr[index][0] = arr[index+1][2]+stair[index]; // 하나 건너뛰고 자신 포함
		arr[index][2] = Math.max(arr[index+1][0], arr[index+1][1]); // 자신 포함 x
		// 자신을 포함하지 않으려면, 자신 이전의 것은 반드시 밟았어야 함. 둘 중 더 큰 값을 선택한다.
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(); // 계단의 개수
		int stair[] = new int[num+1];
		for(int i=1; i<num+1; i++) {
			stair[i] = sc.nextInt();
		}
		
		
		int[][] max = new int[num+1][3];
		// 자신 포함 경우 2가지, 자신 포함x인 경우 1가지 계산 결과를 저장하기 위한 배열 생성
		
		max[num][0] = stair[num];
		max[num-1][1] = max[num][0]+stair[num-1]; // 연속해서 자신 포함
		max[num-1][0] = 0; // 자신만 있는 경우가 없음
		max[num-1][2] = max[num][0]; // 자신 포함 x		
		// 도착 지점과 도착지점 전의 계단에 대해서 초기화 진행
		
		for(int i=num-2; i>0; i--) {
			max_score(max, stair, i);
		}
		
		int score = max[1][0] > max[1][1] ? max[1][0] : max[1][1];
		score = score > max[1][2] ? score : max[1][2];
		// 3가지 경우 중 가장 큰 값을 최종 스코어로 저장
		
		System.out.println(score);
	}

}
