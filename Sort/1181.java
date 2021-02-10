import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

// [백준 1181] 단어 정렬
// https://blog.naver.com/tnwls0529/221820152648

public class Main {
	
	static class WordCompare implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			if(o1.length()<o2.length()) {
				// 작은 게 앞으로 와야 함
				return -1;
			}
			else if(o1.length()>o2.length()) {
				return 1;
			}
			else {
				// 같은 경우
				for(int i=0; i<o1.length(); i++) {
					int _o1 = (int)o1.charAt(i);
					int _o2 = (int)o2.charAt(i);
					// 아스키 코드가 사전 순
					if(_o1 < _o2) {
						return -1;
					}
					else if(_o1 > _o2) {
						return 1;
					}
				}
			}
			return 0;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int number = Integer.parseInt(sc.nextLine()); // 단어의 개수
		
		HashSet<String> word = new HashSet<String>();
		// 같은 단어가 여러 개면 한 번만 출력해야함
		
		for(int i=0; i<number; i++) {
			word.add(sc.nextLine());
		}
		
		ArrayList<String> sort_word = new ArrayList<String>(word);
		// 집합에 들어있는 걸로 list 다시 만듦
		Collections.sort(sort_word, new WordCompare()); // 정렬
		
		for(int i=0; i<sort_word.size(); i++) {
			System.out.println(sort_word.get(i));
		}
		
	}

}
