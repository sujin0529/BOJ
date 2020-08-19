package bind;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt(); // 수열의 길이
		int seq[] = new int[length];
		
		for(int i=0; i<length; i++) {
			seq[i] = sc.nextInt();
		}
		Arrays.sort(seq); // 오름차순으로 정렬
		
		int sum = 0;
		int zero_count = 0;
		int negative = -1; // 중간에 음수가 나올 경우, 그 최대 인덱스 표기
		for(int i=length-1; i>=0; i--) {
			if((seq[i] > 1) && (i-1 >= 0) && (seq[i-1] > 1)) {
				// 만약 자신도, 자신보다 인덱스가  1 작은 곳에 있는 값도 1보다 큰 정수라면
				// 두 수를 묶어서 더 크게 만듦
				// 1을 제외하는 이유는 1은 항등원이기 때문에, 그냥 더할 때 이득
				sum += (seq[i] * seq[i-1]);
				i--; // 자신보다 인덱스가 2 작은 곳으로 접근하게 될 것
			}
			else if(seq[i] == 0) {
				// 음수가 있을 경우, 최대 zero_count만큼 상쇄시켜줄 수 있기 때문
				zero_count++;
			}
			else if(seq[i] < 0) {
				// 만약 자신이 음수면 해당 인덱스를 표기하고 반복문 빠져나옴
				negative = i;
				break;
			}
			else {
				sum += seq[i];
			}
		}		
		
		for(int i=0; i<=negative; i++) {
			if((seq[i] < 0) && (i+1 <= negative) && (seq[i+1] < 0)) {
				// 만약 자신도, 자신보다 인덱스가  1 작은 곳에 있는 값도 음의 정수라면
				// 두 수를 묶어서 양수로 만들면서 더 크게 만듦
				sum += (seq[i] * seq[i+1]);
				i++; // 자신보다 인덱스가 2 큰 곳으로 접근하게 될 것
			}
			else if(zero_count > 0) {
				zero_count--;
			}
			else {
				// 증가시키거나 상쇄시킬 수 없기 때문에 음수 그대로 덧셈
				sum += seq[i];
			}
		}
		
		System.out.println(sum);
	}
}