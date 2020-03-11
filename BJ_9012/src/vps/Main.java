package vps;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int test_case = Integer.parseInt(sc.nextLine());
		
		for(int i=0; i<test_case; i++) {
			String s = sc.nextLine(); // 괄호 문자열 입력
			Stack<Integer> stack = new Stack<>();
			// 그냥 값이 들어갔다 정도만 확인하면 되기 때문에 integer로 함.
			
			int check = 0; // 1이라면 잘못된 것
			for(int j=0; j<s.length(); j++) {
				if(s.charAt(j)=='(') {
					// 여는 괄호면
					stack.push(1);
				}
				else {
					// 닫는 괄호면
					if(stack.isEmpty()) {
						// 닫는 괄호인데 비어있다면 잘못된 것.
						check = 1;
						break;
					}
					stack.pop();
				}
			}
			
			if(check == 1) {
				System.out.println("NO");
			}
			else if(stack.isEmpty()) {
				// check이 1이 아니면서 비어있으면 vps
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}

	}

}
