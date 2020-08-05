package good_word;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		Stack<String> stack;
		
		int count = 0;
		
		for(int i=0; i<num; i++) {
			stack = new Stack<>();
			String tmp = sc.nextLine();
			for(int j=0; j<tmp.length(); j++) {
				if(stack.isEmpty()) {
					// 스택이 비어있으면 넣기
					stack.push(tmp.charAt(j)+"");
				}
				else if((stack.peek()).equals(tmp.charAt(j)+"") ) {
					// 스택의 top과 같은 문자면 pop
					stack.pop();
				}
				else {
					// 같지 않은 것이므로 넣기
					stack.push(tmp.charAt(j)+"");
				}
			}
			if(stack.isEmpty()) {
				// 스택이 비었으면 좋은 단어
				count++;
			}
		}
		System.out.println(count);
	}
}