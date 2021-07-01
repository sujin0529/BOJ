import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// [백준 2812] 크게 만들기

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] token = br.readLine().split(" ");
			int length = Integer.parseInt(token[0]+"");
			int remove = Integer.parseInt(token[1]+"");
			
			Stack<Integer> stack = new Stack<>();
			int[] num = new int[length];
			String tmp = br.readLine();
			
			for(int i=0; i<length; i++) {
				num[i] = Integer.parseInt(tmp.charAt(i)+"");
			}
			
			stack.add(num[0]);
			for(int i=1; i<length; i++) {
				while(!stack.isEmpty() && stack.peek() < num[i]) {
					if(remove == 0) {
						break;
					}
					remove--;
					stack.pop();
				}
				stack.add(num[i]);
			}
			
			while(remove > 0) {
				// 아직 덜 지워진 개수만큼 낮은 자릿수에서 빼주기
				stack.pop();
				remove--;
			}
			
			StringBuilder sb = new StringBuilder();
			while(!stack.isEmpty()) {
				sb.insert(0, stack.pop());
			}
			
			bw.write(sb+"\n");
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
}
