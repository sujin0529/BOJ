import java.util.Scanner;

// [백준 1463] 1로 만들기
// https://blog.naver.com/tnwls0529/221833770207

public class Main {
	
	static void make_number(int[] cnt, int number) {
		
		if(number%3==0) {
			// 3으로 나누어 떨어짐
			cnt[number] = cnt[number/3]+1<cnt[number] ? cnt[number/3]+1 : cnt[number];
		}
		if(number%2==0) {
			// 2으로 나누어 떨어짐
			cnt[number] = cnt[number/2]+1<cnt[number] ? cnt[number/2]+1 : cnt[number];
		}
		
		// 1을 뺐을 때 더 줄어들 수도 있으므로 확인
		cnt[number] = cnt[number-1]+1<cnt[number] ? cnt[number-1]+1 : cnt[number];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		
		int[] cnt = new int[number+3];
		// 1이 입력으로 들어와도 범위를 벗어나지 않도록 하기 위한 크기 선언.
		
		for(int i=1; i<number+1; i++) {
			cnt[i] = Integer.MAX_VALUE;
			// 작은 것을 찾기 쉽게 하기 위한 배열 초기화
		}
		
		cnt[1] = 0;
		cnt[2] = 1;
		cnt[3] = 1;
		
		for(int i=4; i<number+1; i++) {
			make_number(cnt, i);
		}
		
		System.out.println(cnt[number]);
		
		

	}

}
