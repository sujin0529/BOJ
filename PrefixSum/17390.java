import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// [백준 17390] 이건 꼭 풀어야 해!

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String[] token = br.readLine().split(" ");
			int N = Integer.parseInt(token[0]);
			int query = Integer.parseInt(token[1]);
			
			int[] arr = new int[N+1];
			token = br.readLine().split(" ");
			for(int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(token[i-1]);
			}
			Arrays.parallelSort(arr);
			for(int i=1; i<=N; i++) {
				arr[i] = arr[i] + arr[i-1];
			}
			
			for(int i=0; i<query; i++) {
				token = br.readLine().split(" ");
				int start = Integer.parseInt(token[0]);
				int end = Integer.parseInt(token[1]);
				
				int result = arr[end]-arr[start-1];
				bw.write(result+"\n");
			}
			
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
}
