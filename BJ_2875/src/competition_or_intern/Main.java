package competition_or_intern;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int female = sc.nextInt(); // 여성 수
		int male = sc.nextInt(); // 남성 수
		int intern = sc.nextInt(); // 인턴십 참가자 수
		
		int team = 0;
		
		if(female/2 < male) {
			team = female/2;
		}
		else {
			team = male;
		}
		female = female - (team*2);
		male = male - team;
		
		if(intern <= female+male) {
			// team 그대로 출력
		}
		else {
			intern = intern - (female+male);
			int minus = 0;
			if(intern%3==0) {
				// 나머지가 0이면 1팀을 더 뺄 필요가 없기 때문에 3으로 나눈 몫만큼만 team에서 빼야 팀의 최댓값을 구할 수 있음
				minus = intern/3;
			}
			else {
				// 3명이 한 팀이기 때문에 3으로 나눈 몫에 1을 더한 만큼을 team에서 빼야 팀의 최댓값을 구할 수 있음
				minus = intern/3 + 1;
			}
			
			team = team - minus;
		}
		System.out.println(team);
	}

}
