package repairman;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int leakCount = sc.nextInt();
		int tapeLength = sc.nextInt();
		
		int[] location = new int[leakCount]; // 물이 새는 위치 저장
		
		for(int i=0; i<leakCount; i++) {
			location[i] = sc.nextInt();
		}
		Arrays.parallelSort(location);
		
		int count = 1; // 필요한 테이프의 개수 + 최소 1개 필요
		int index = 1;
		int startIndex = 0; // 최대 커버 가능 구역을 정할 때 시작 위치 인덱스
		
		while(index < leakCount) {
			int diff = location[index] - location[startIndex];
			if(diff >= tapeLength) {
				// 새로운 테이프 사용해야 함.
				count++;
				startIndex = index;
			}
			index++;
		}
		System.out.println(count);
	}
}