package tournament;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int participants = sc.nextInt(); // 대회 참가자의 명 수
		int Kim = sc.nextInt(); // 김지민의 번호
		int Lim = sc.nextInt(); // 임한수의 번호
		
		int round = 1;

		while(participants>1) {
			Kim--;
			Lim--;
			if(Kim/2 == Lim/2) {
				// 둘의 몫이 같다면
				System.out.println(round);
				System.exit(0);
			}
			Kim = (Kim/2)+1;
			Lim = (Lim/2)+1;
			// 번호 새로 할당
			round++;
		}
		System.out.println(-1); // 만나지 못하는 것이므로
		

	}

}
