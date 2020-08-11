package document;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String document = sc.nextLine();
		String find = sc.nextLine();

		int count = 0;
		int compare = 0; // 1이면 계속 이어서 비교
		int find_index = 0; // find 문자열의 인덱스
		int return_index = 0; // 만약 일치하지 않은 경우 돌아갈 인덱스

		int i = 0;
		while (i <= document.length()) {			
			if (compare == 0) {
				// 첫 번째 문자가 같은지 확인
				if(i == document.length()) {
					break;
				}
				if (find.charAt(find_index) == document.charAt(i)) {
					compare = 1;
					find_index++;
					i++;
					return_index = i; // 만약 중간에 틀리게 되면 돌아가야 하는 위치 저장
				} else {
					i++;
					return_index = i; // 현재 위치는 돌아갈 필요가 없기 때문에, 다음위치로 저장
					
				}
			} else {
				if (find_index == find.length()) {
					// find 문자열을 찾음 => 초기 상태로
					count++;
					find_index = 0;
					compare = 0;
					return_index = i; // 해당 위치는 넘어가야하기 때문
					
				} else if(i == document.length()) {
					break;
				} else if (find.charAt(find_index) == document.charAt(i)) {
					find_index++;
					i++;
				} else {
					// 같지 않다는 의미
					compare = 0;
					find_index = 0;
					i = return_index;
				}
			}
			

		}
		System.out.println(count);
	}
}
