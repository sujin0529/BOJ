import java.util.Scanner;

// [백준 1748] 수 이어 쓰기 1
// https://blog.naver.com/tnwls0529/222065055807

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt(); // number까지 이어서 쓸 것
		int init = 9; // 초기 기준 값
	
		int new_number = 0;
		int expr = 0; // 지수승
		
		while(number >= init) {
			
			int change = 9*(int)Math.pow((double)10, (double)expr); // 자릿수가 달라졌을 때 그 개수 저장
			
			new_number += ((expr+1)*change);

			init = (init*10)+9;
			expr++;
		}
		
		init /= 10;
		// 나누기 전 init보다는 작지만, 나눈 후 init보다는 큰 경우 더할 자릿수가 더 있음.
		
		if((number-init) > 0) {
			new_number += ((expr+1)*(number-init));
		}
		
		System.out.println(new_number);
		

	}

}
