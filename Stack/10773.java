import java.util.Scanner;
import java.util.Stack;

// [백준 10773] 제로

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt(); // 수의 개수 입력
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<num; i++) {
			int temp = sc.nextInt();
			if(temp==0) {
				stack.pop(); // 0을 입력받으면 제거
			}
			else {
				stack.push(temp);
			}
		}
		
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);

	}

}
