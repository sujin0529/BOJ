import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 1806] 부분합

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] token = br.readLine().split(" ");
			int length = Integer.parseInt(token[0]);
			int target = Integer.parseInt(token[1]);
			// target 이상이 되는 부분합
			
			int[] num = new int[length];
			token = br.readLine().split(" ");
			for(int i=0; i<length; i++) {
				num[i] = Integer.parseInt(token[i]);
			}
			
			int minLength = Integer.MAX_VALUE; // 부분합의 최소 길이
			int start = 0;
			int end = 1;
			int sum = num[start];
			
			while(true) {
				if(sum >= target) {
					minLength = minLength < (end-start) ? minLength : (end-start);
					sum -= num[start];
					start++;
				}
				else if(end == length) {
					break;
				}
				else {
					sum += num[end];
					end++;
				}
			}
			minLength = minLength==Integer.MAX_VALUE ? 0 : minLength;
			
			bw.write(minLength+"\n");
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
}
