import java.util.Scanner;
import java.util.Stack;

// [백준 4949] 균형잡힌 세상
// https://blog.naver.com/tnwls0529/221851825703

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		while(!s.equals(".")) {
			int check = 0; // 1이면 no
			Stack<Integer> stack = new Stack<>();
			
			for(int i=0; i<s.length(); i++) {
				char ch = s.charAt(i);
				if(ch == '(') {
					stack.push(0); // 소괄호는 0
				}
				else if(ch == ')') {
					
					if(stack.isEmpty() || stack.peek()!=0) {
						// 스택이 비어있거나, 가장 가까운 괄호가 (가 아니라면
						check = 1;
					}
					else {
						// 그게 아니라면 하나 없애기
						stack.pop();
					}	
				}
				else if(ch == '[') {
					stack.push(1); // 대괄호는 1
				}
				else if(ch == ']') {
					if(stack.isEmpty() || stack.peek()!=1) {
						// 스택이 비어있거나, 가장 가까운 괄호가 [가 아니라면
						check = 1;
					}
					else {
						// 그게 아니라면 하나 없애기
						stack.pop();
					}
				}
			}
			
			if(check == 1 || !stack.isEmpty()) {
				System.out.println("no");
			}
			else {
				System.out.println("yes");
			}
			s = sc.nextLine();
			
		}

	}

}
