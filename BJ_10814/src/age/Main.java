package age;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int number = Integer.parseInt(s); // 회원 수
		int age[] = new int[number+1]; // 나이 저장 배열
		String name[] = new String[number+1]; // 이름 저장 배열
		// sentinel 값을 위한 크기 1 증가
		
		for(int i=1; i<number+1; i++) {
			// 입력
			s = sc.nextLine();
			String token[] = s.split(" ");
			age[i] = Integer.parseInt(token[0]);
			name[i] = token[1];
		}
		
		int min = age[1]; // 나이 최솟값 저장할 변수
		int index = 1;
		
		for(int i=2; i<number+1; i++) {
			// sentinel 값 찾기
			if(age[i]<min) {
				// 작은 경우에만 min 값을 바꿈. => 같은 경우 가장 앞에 있는 거
				min = age[i];
				index = i;
			}
		}
		age[0] = age[index];
		name[0] = name[index];
		// sentinel 값 배치
		
		for(int i=1; i<number+1; i++) {
			int j = i-1;
			int _age = age[i];
			String _name = name[i];
			// 위치 조정할 인덱스의 나이와 이름 저장
			while(_age<age[j]) {	
				age[j+1] = age[j];
				name[j+1] = name[j];
				j--;
			}
			age[j+1] = _age;
			name[j+1] = _name;
		}
		// 삽입 정렬 실행
		
		// 출력
		for(int i=1; i<number+1; i++) {
			System.out.println(age[i]+" "+name[i]);
		}
	}
}
