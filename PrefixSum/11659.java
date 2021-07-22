import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 11659] 구간 합 구하기 4

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] token = br.readLine().split(" ");
			int length = Integer.parseInt(token[0]);
			int query = Integer.parseInt(token[1]);
			
			int[] sequence = new int[length+1];
			// 배열 범위를 넘어서는 것을 막기 위해 1부터 시작
			token = br.readLine().split(" ");
			for(int i=1; i<=length; i++) {
				sequence[i] = sequence[i-1]+Integer.parseInt(token[i-1]);
				// 입력시에 누적값 저장
			}
			
			for(int i=0; i<query; i++) {
				token = br.readLine().split(" ");
				int start = Integer.parseInt(token[0]);
				int end = Integer.parseInt(token[1]);
				bw.write(sequence[end]-sequence[start-1]+"\n");
				// start보다 1작은 곳의 합을 빼야 start부터의 합을 구할 수 있음.
			}
			
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
}
