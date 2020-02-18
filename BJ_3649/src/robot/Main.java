package robot;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while(sc.hasNextInt()) {
			// 테스트 케이스 여러 개가 가능
			int w = 0;
			int number = 0;
			int check = 0; // 가능한지 확인하는 변수
			
			w = sc.nextInt(); // 너비. 나노미터로 맞추려면 0 7개
			number = sc.nextInt(); // 블록의 개수
			
			int block[] = new int[number]; // 블록 입력
			
			for(int i=0; i<number; i++) {
				block[i] = sc.nextInt();
			}
			
			if(number<2) {
				// 블록의 개수가 2보다 작다면 짝을 만들 수 없으니 실패
				System.out.println("danger");
				continue;
			}
			
			Arrays.sort(block); // 블록 길이대로 정렬
			
			int left = 0;
			int right = number-1;
			// left와 right는 인덱스임.
			
			w = w*10000000; // 너비도 나노 단위로 맞추기
			
			while(left<right) {
				if(block[left]+block[right] == w) {
					// 같다면 끝
					check = 1;
					break;
				}
				else if(block[left]+block[right] < w) {
					// 작아지면 left 값을 키워야함
					left++;
				}
				else if(block[left]+block[right] > w) {
					right--;
				}
			}
			
			
			// 출력
			if(check == 1) {
				System.out.println("yes "+block[left]+" "+block[right]);
			}
			else {
				System.out.println("danger");
			}
			
		}

	}

}
