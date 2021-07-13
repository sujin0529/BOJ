import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// [백준 3273] 두 수의 합

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int num = Integer.parseInt(br.readLine());
			int[] sequence = new int[num];
			String[] token = br.readLine().split(" ");
			for(int i=0; i<num; i++) {
				sequence[i] = Integer.parseInt(token[i]);
			}
			
			Arrays.parallelSort(sequence);
			int target = Integer.parseInt(br.readLine());
			
			int count = 0;
			int start = 0;
			int end = num-1;
			
			while(start < end) {
				if(sequence[start] + sequence[end] < target) {
					start++;
				}
				else if(sequence[start] + sequence[end] > target) {
					end--;
				}
				else {
					count++;
					start++;
					end--;
				}
			}
			
			bw.write(count+"\n");
			bw.close();
			br.close();
				
		}catch(Exception e) {
			
		}
	}
}
