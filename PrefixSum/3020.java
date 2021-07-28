import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 3020] 개똥벌레

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] token = br.readLine().split(" ");
			int length = Integer.parseInt(token[0]); // 동굴 길이
			int height = Integer.parseInt(token[1]); // 동굴 높이
			
			int[] stalagmite = new int[height+1]; // 높이별 석순 부딪힐 개수
			int[] stalactite = new int[height+1]; // 높이별 종유석 부딪힐 개수
			
			for(int i=0; i<length; i++) {
				int tmp = Integer.parseInt(br.readLine());
				if(i%2 == 0) {
					// 짝수면 석순
					stalagmite[tmp]++;
				}
				else {
					stalactite[height-tmp+1]++;
				}
			}
			
			for(int i=height-1; i>0; i--) {
				// 석순 누적합
				int tmp = stalagmite[i];
				stalagmite[i] = stalagmite[i+1] + tmp;
			}
			
			for(int i=2; i<=height; i++) {
				// 종유석 누적합
				int tmp = stalactite[i];
				stalactite[i] = stalactite[i-1] + tmp;
			}
			
			int min = Integer.MAX_VALUE;
			int count = 0;
			for(int i=1; i<=height; i++) {
				if(min > stalagmite[i]+stalactite[i]) {
					min = stalagmite[i]+stalactite[i];
					count = 1;
				}
				else if(min == stalagmite[i]+stalactite[i]) {
					count++;
				}
			}
			
			bw.write(min+" "+count+"\n");
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
}
