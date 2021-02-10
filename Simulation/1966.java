import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// [백준 1966] 프린터 큐
// https://blog.naver.com/tnwls0529/221826077179

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt(); // 테스트 케이스 개수
		
		for(int i=0; i<test_case; i++) {
			int N = sc.nextInt(); // 문서의 개수
			int M = sc.nextInt(); // 찾고자 하는 문서의 현재 큐 위치
			Queue<Integer> document = new LinkedList<Integer>();
			int importance[] = new int[N]; // 중요도 정렬할 거
			for(int j=0; j<N; j++) {
				int temp = sc.nextInt(); // 문서의 중요도 입력
				document.add(temp);
				importance[j] = temp;
			}
			// 입력
			
			Arrays.sort(importance);
			
			int index = N-1; // 중요도 배열에서 사용할 인덱스
			int count = 0; // 찾고자 하는 문서 인쇄 순서
			
			while(!document.isEmpty()) {
				int temp = document.remove();
				if(temp<importance[index]) {
					document.add(temp);
					if(M==0) {
						// 찾고자 하는게 첫번째에 있었던 거라면
						M = document.size()-1; // 맨 뒤의 인덱스로 재설정
					}
					else {
						M--;
					}
				}
				else {
					// 인쇄
					count++;
					if(M==0) {
						// 찾고자 하는게 첫번째에 있었던 거라면
						break;
					}
					else {
						M--; // 인쇄되는 문서가 하나 존재
						index--; // 가장 큰 것이 나갔으므로, 그 다음 중요도를 가리켜야 함.
					}
				}
			}
			System.out.println(count);
		}

	}

}
