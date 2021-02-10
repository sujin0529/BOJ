import java.util.Scanner;

// [백준 1120] 문자열
// https://blog.naver.com/tnwls0529/222040867793

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		String[] tmp = s.split(" ");
		
		String compare = tmp[0]; // 기준과 비교가 되는 문자열
		String standard = tmp[1]; // 기준이 되는 문자열
		
		int diff = standard.length() - compare.length();
		int max = 0; // 같은 문자가 가장 많은 경우 저장
		
		for(int i=0; i<=diff; i++) {
			int same = 0; // 같은 문자의 개수 카운트
			for(int j=0; j<compare.length(); j++) {
				if(compare.charAt(j) == standard.charAt(i+j)) {
					// 만약 문자가 같다면
					same++;
				}
			}
			if(max < same) {
				max = same;
			}
		}
		
		/*
		 * 현재 max가 가장 많이 겹치는 경우
		 * compare에서 부족한 문자는 모두 standard와 같은 위치에 같은 문자를 가진다고 할 때
		 * 현재 compare의 길이에서 max를 뺀 값을 출력하면 됨.
		*/
		
		diff = compare.length() - max;
		System.out.println(diff);
	}

}
