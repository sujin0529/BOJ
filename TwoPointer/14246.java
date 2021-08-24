import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 14246] K보다 큰 구간

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int numCount = Integer.parseInt(br.readLine());
			String[] token = br.readLine().split(" ");
			int[] num = new int[numCount];
			
			for(int i=0; i<numCount; i++) {
				num[i] = Integer.parseInt(token[i]);
			}
			
			int target = Integer.parseInt(br.readLine());
			
			int start = 0;
			int end = 0;
			int prefixSum = 0;
			long pair = 0;
			
			while(start <= end) {
				if(prefixSum <= target) {
					if(end == numCount) {
						break;
					}
					prefixSum += num[end];
					end++;
				}
				else {
					pair += (numCount-end+1);
					prefixSum -= num[start];
					start++;
				}
			}
			
			bw.write(pair+"\n");
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
}
