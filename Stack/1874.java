import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

// [백준 1874] 스택 수열
// https://blog.naver.com/tnwls0529/221853287187

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt(); // 1 ~ number까지
		
		int sequence[] = new int[number]; // 만들어야할 수열
		int made_sequence[] = new int[number]; // 만든 수열
		
		ArrayList<String> oper = new ArrayList<>(); // 연산자 저장할 리스트
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<number; i++) {
			sequence[i] = sc.nextInt();
		}
		// 만들어야하는 수열 입력
		
		int index = 0; // 현재 나와야하는 수열의 값과 비교하기 위한 인덱스
		for(int i=1; i<=number; i++) {
			
			stack.add(i); // 우선은 push
			oper.add("+");
			
			while(!stack.isEmpty() && sequence[index] == stack.peek()) {
				// 스택의 맨 위 값이랑 같은 동안에
				made_sequence[index] = stack.pop(); // 하나 뺌
				oper.add("-");
				index++;
			}
		}
		
		while(!stack.isEmpty()) {
			made_sequence[index] = stack.pop();
			oper.add("-");
			index++;
		}
		
		int check = 0; // 수열이 다르면 1
		
		for(int i=0; i<number; i++) {
			if(sequence[i] != made_sequence[i]) {
				check = 1;
				break;
			}
		}
		
		if(check==1) {
			System.out.println("NO");
		}
		else {
			for(int i=0; i<oper.size(); i++) {
				System.out.println(oper.get(i));
			}
		}
	}
}
