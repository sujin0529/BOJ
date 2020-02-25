package staff;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt(); // 만들어야하는 길이
		
		int total = 64; // 길이 누적 
		int short_staff = 64; // 가장 짧은 막대기 길이
		int count = 0; // 막대기의 개수
		// 초기 상태
		
		while(total > X) {
			// total이 X보다 작은 동안에 반복
			total -= short_staff; // 가장 짧은 막대기를 하나 빼기
			short_staff /= 2; // 반으로 쪼개서
			total += short_staff; // 하나만 더함
			if(total < X) {
				// 찾고자 한 길이보다 작은 경우
				count++; 
				total += short_staff;
				// 이 경우에는 하나를 반드시 더해야하니까
			}
			else if(total == X) {
				// 찾고자 한 길이와 일치하는 경우
				count++; // 반으로 쪼갠 막대기 하나의 개수는 더해야하기 때문
				break; // 더 이상 찾을 필요가 없기 때문에 나감
			}
		}
		
		if(X==64) {
			// X의 값이 64와 같을 때, count를 1로 함.
			count = 1;
		}
		System.out.println(count);

	}

}
