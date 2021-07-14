import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 2003] 수들의 합 2

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] token = br.readLine().split(" ");
			int N = Integer.parseInt(token[0]);
			int target = Integer.parseInt(token[1]);
			
			int[] num = new int[N];
			token = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				num[i] = Integer.parseInt(token[i]);
			}
			
			int start = 0;
			int end = 0;
			int total = num[start];
			int count = 0; // target과 일치한 경우의 수
			while(end < N) {
				if(total < target) {
					end++;
					if(end >= N) {
						break;
					}
					total += num[end];
				}
				else if(total > target) {
					total -= num[start];
					start++;
				}
				else {
					count++;
					total -= num[start];
					start++;
					end++;
					if(end >= N) {
						break;
					}
					total += num[end];
				}
			}
			bw.write(count+"\n");
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
}
