import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 10828] 스택

class Stack {
	int[] arr;
	int top;

	public Stack(int size) {
		arr = new int[size+1];
		top = 0;
	}

	public int size() {
		return top;
	}

	public int empty() {
		if (top == 0) {
			return 1;
		}
		return 0;
	}

	public int top() {
		if (top == 0) {
			return -1;
		} else {
			return arr[top - 1];
		}
	}

	public void push(int x) {
		arr[top] = x;
		top++;
	}

	public int pop() {
		if (top == 0) {
			return -1;
		} else {
			top--;
			return arr[top];
		}
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int command = Integer.parseInt(br.readLine());
			Stack stack = new Stack(command);

			for (int i = 0; i < command; i++) {
				String[] token = br.readLine().split(" ");
				if (token[0].equals("push")) {
					stack.push(Integer.parseInt(token[1]));
				} else if (token[0].equals("pop")) {
					bw.write(stack.pop()+"\n");
				} else if (token[0].equals("size")) {
					bw.write(stack.size()+"\n");
				} else if (token[0].equals("empty")) {
					bw.write(stack.empty()+"\n");
				} else if (token[0].equals("top")) {
					bw.write(stack.top()+"\n");
				}
			}
			
			bw.close();
			br.close();

		} catch (Exception e) {

		}
	}
}
