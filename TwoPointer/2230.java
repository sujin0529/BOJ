import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// [백준 2230] 수 고르기

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] token = br.readLine().split(" ");
			int length = Integer.parseInt(token[0]);
			int target = Integer.parseInt(token[1]);
			
			int[] array = new int[length];
			for(int i=0; i<length; i++) {
				array[i] = Integer.parseInt(br.readLine());
			}
			Arrays.parallelSort(array);
			
			int min = Integer.MAX_VALUE;
			int start = 0;
			int end = 1;
			int diff = 0;
			while(true) {
				if(diff > target) {
					min = diff > min ? min : diff;
					start++;
					diff = array[end] - array[start];
				}
				else if(diff == target) {
					// diff가 target과 일치하면 target 이상이면서 가장 작은 값
					min = diff;
					break;
				}
				else if(end == length || start == length) {
					break;
				}
				else {
					end++;
					if(end == length) {
						break;
					}
					diff = array[end] - array[start];
					
				}
			}
			
			bw.write(min+"\n");
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
}
