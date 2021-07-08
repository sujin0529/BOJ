import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// [백준 4889] 안정적인 문자열

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			boolean finish = false;
			int count = 1;
			while(true) {
				String input = br.readLine();
				Stack<Integer> stack = new Stack<>();
				// { : add
				// } : pop
				
				int closeCount = 0;
				int totalCount = 0;
				for(int i=0; i<input.length(); i++) {
					if(input.charAt(i)=='}') {
						if(stack.isEmpty()) {
							// 만약 비어있다면, 무조건으로 바꾼다고 생각하고 add
							stack.add(0);
							closeCount++;
						}
						else {
							stack.pop();
						}
					}
					else if(input.charAt(i)=='{') {
						stack.add(0);
					}
					else {
						// -인 경우이므로, 끝내기
						finish = true;
						break;
					}
				}
				
				if(finish) {
					break;
				}
				totalCount = (stack.size()+1)/2 + closeCount;
				bw.write(count+". "+totalCount+"\n");
				count++;
			}
			
			bw.close();
			br.close();
			
		}catch(Exception e) {
			
		}
	}
}
