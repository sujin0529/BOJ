import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// [백준 11657] 타임머신
// https://blog.naver.com/tnwls0529/222253538598

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] token = br.readLine().split(" ");
			int city = Integer.parseInt(token[0]);
			int bus = Integer.parseInt(token[1]);
			
			long[][] time = new long[city+1][city+1];
			long[] result = new long[city+1];
			// 가장 빠른 시간 저장 
			
			for(int i=1; i<=city; i++) {
				Arrays.fill(time[i], Integer.MAX_VALUE);
			}
			Arrays.fill(result, Integer.MAX_VALUE);
			result[1] = 0;
			
			for(int i=0; i<bus; i++) {
				token = br.readLine().split(" ");
				int head = Integer.parseInt(token[0]);
				int tail = Integer.parseInt(token[1]);
				int cost = Integer.parseInt(token[2]);
				if(time[head][tail] > cost) {
					// 같은 노선 버스가 여러 개 입력이 될 수 있음
					time[head][tail] = cost;
				}	
			}
			
			boolean negativeCycle = false;
			
			for(int iter=0; iter<city-1; iter++) {
				for(int i=1; i<=city; i++) {
					for(int j=1; j<=city; j++) {
						if(result[i] == Integer.MAX_VALUE || time[i][j] == Integer.MAX_VALUE) {
							// 경로가 없는 경우
							continue;
						}
						if(result[i] + time[i][j] < result[j]) {
							result[j] = result[i] + time[i][j];
						}
					}
				}
			}
			
			for(int i=1; i<=city; i++) {
				// v-1번 반복이 끝난 후에도 갱신되는 경우가 있다면, 음수 사이클이 존재하는 경우임.
				for(int j=1; j<=city; j++) {
					if(result[i] == Integer.MAX_VALUE || time[i][j] == Integer.MAX_VALUE) {
						continue;
					}
					if(result[i] + time[i][j] < result[j]) {
						negativeCycle = true;
						break;
					}
				}
			}
			
			if(negativeCycle) {
				bw.write("-1\n");
			}
			else {
				for(int i=2; i<=city; i++) {
					if(result[i] == Integer.MAX_VALUE) {
						result[i] = -1;
					}
					bw.write(result[i]+"\n");
				}
			}
			
			bw.close();
			br.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
