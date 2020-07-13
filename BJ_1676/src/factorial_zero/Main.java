package factorial_zero;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] count = new int[6];
		// 2와 5의 곱으로 10이 생기니까 소인수분해를 하는데, 5까지만 연산해보기
		
		for(int i=N; i>1; i--) {
			int index = 2;
			int number = i;
			while(index < 6) {
				if(number%index == 0) {
					count[index]++;
					number /= index;
				}
				else {
					index++;
				}
			}
		}
		
		int min = count[2] > count[5] ? count[5] : count[2];
		
		System.out.println(min);

	}

}
