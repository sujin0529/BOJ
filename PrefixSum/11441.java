import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 11441] 합 구하기

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			String[] token = br.readLine().split(" ");
			int N = Integer.parseInt(token[0]);
			int[] number = new int[N+1];
			// 0번째는 연산의 편의를 위해 0을 저장할 것
			
			token = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				// 누적 합 계산하여 저장
				number[i+1] = number[i]+Integer.parseInt(token[i]);
			}
			
			int query = Integer.parseInt(br.readLine());
			for(int i=0; i<query; i++) {
				token = br.readLine().split(" ");
				int start = Integer.parseInt(token[0]);
				int end = Integer.parseInt(token[1]);
				
				int result = number[end]-number[start-1];
				bw.write(result+"\n");
			}
			
			bw.close();
			br.close();		
			
		} catch(Exception e) {
			
		}
	}
}
