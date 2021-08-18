import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// [백준 6159] 코스튬 파티

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String[] token = br.readLine().split(" ");
			int cowNum = Integer.parseInt(token[0]);
			int size = Integer.parseInt(token[1]);
			int[] cow = new int[cowNum];
			
			for(int i=0; i<cowNum; i++) {
				cow[i] = Integer.parseInt(br.readLine());
			}
			Arrays.parallelSort(cow);
			
			int start = 0;
			int end = cowNum-1;
			int pair = 0;
			while(start < end) {
				if(cow[start] + cow[end] > size) {
					end--;
				}
				else {
					pair += (end-start);
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
