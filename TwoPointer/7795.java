import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// [백준 7795] 먹을 것인가 먹힐 것인가

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int testCase = Integer.parseInt(br.readLine());
			for(int index=0; index<testCase; index++) {
				String[] token = br.readLine().split(" ");
				int N = Integer.parseInt(token[0]); // A 배열의 크기
				int M = Integer.parseInt(token[1]); // B 배열의 크기
				
				int[] A = new int[N];
				int[] B = new int[M];
				
				token = br.readLine().split(" ");
				for(int i=0; i<N; i++) {
					A[i] = Integer.parseInt(token[i]);
				}
				
				token = br.readLine().split(" ");
				for(int i=0; i<M; i++) {
					B[i] = Integer.parseInt(token[i]);
				}
				
				Arrays.parallelSort(A);
				Arrays.parallelSort(B);
				
				int indexA = 0;
				int indexB = 0;		
				int pair = 0;
				
				while(indexA < N && indexB < M) {
					if(A[indexA] > B[indexB]) {
						indexB++;
					}
					else {
						// 해당 인덱스에서 A < B 인 형태
						// 이미 지나온 B에 대해서는 A가 크다고 볼 수 있기 때문
						pair += indexB;
						indexA++;
					}
				}
				if(indexB == M) {
					int tmp = N-indexA;
					pair += (tmp*M);
				}	
				bw.write(pair+"\n");
			}
			bw.close();
			br.close();
		} catch(Exception e) {
			
		}
	}
}
