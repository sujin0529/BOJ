package card2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 번호 입력
		
		Queue<Integer> card = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			// 큐에 1부터 순차적으로 저장
			card.add(i); 
		}
		
		while(card.size()>1) {
			// size가 2이상일 것이기 때문에 1개를 제거해도 문제가 안생김 
			card.remove(); // 맨 위에 있는 것은 버리고
			int back = card.remove(); 
			card.add(back);
			// 그 다음에 있는 것은 큐에 다시 저장
		}
		
		System.out.println(card.remove());
		// 한 개가 남았기 때문에, 이를 출력함.

	}

}
