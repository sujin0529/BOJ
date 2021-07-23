import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 2559] 수열

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			String[] token = br.readLine().split(" ");
			int day = Integer.parseInt(token[0]);
			int serial = Integer.parseInt(token[1]);
			
			int[] temperature = new int[day+1];
			// 0번째는 연산의 편의를 위해 0을 저장할 것
			token = br.readLine().split(" ");
			for(int i=0; i<day; i++) {
				// 누적 합 계산하여 저장
				temperature[i+1] = temperature[i]+Integer.parseInt(token[i]);
			}
			
			int maxTemp = Integer.MIN_VALUE; // 연속된 최대의 온도 합
			int start = 1;
			int end = serial;
			for(;end<=day; start++, end++) {
				int sum = temperature[end]-temperature[start-1];
				maxTemp = maxTemp > sum ? maxTemp : sum;
			}
			
			bw.write(maxTemp+"\n");
			bw.close();
			br.close();		
			
		} catch(Exception e) {
			
		}
	}
}
