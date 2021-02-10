import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

// [백준 11652] 카드
// https://blog.naver.com/tnwls0529/221821567469

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt(); // 카드의 개수
		HashMap<Long, Integer> card = new HashMap<Long, Integer>();
		
		for(int i=0; i<number; i++) {
			long input = sc.nextLong(); // 입력받은 정수
			if(card.containsKey(input)) {
				// 만약 이미 있는 값이라면
				card.put(input, card.get(input)+1); // 1만큼 값을 올려주기
			}
			else {
				card.put(input, 1); // 새로 생성
			}
		}
		// 입력
		
		long max_key = 0; // 가장 많이 있는 정수
		int max_value = 0; // 그 정수의 개수
		
		Iterator<Long> iter = card.keySet().iterator();
		while(iter.hasNext()) {
			long temp_key = iter.next(); // 키 값
			int temp_value = card.get(temp_key); // value
			if(temp_value > max_value) {
				max_key = temp_key;
				max_value = temp_value;
			}
			else if(temp_value == max_value) {
				// 만약에 값이 같은 경우라면
				if(max_key > temp_key) {
					// key값이 작은 것을 출력해야하므로, 그 경우에만 값을 바꿈
					max_key = temp_key;
				}
			}
		}
		
		System.out.println(max_key);

	}

}
