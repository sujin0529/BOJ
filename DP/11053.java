import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [백준 11053] 가장 긴 증가하는 부분 수열
// https://blog.naver.com/tnwls0529/222023219915

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			int[][] sequence = new int[N][2];
			for(int i=0; i<str.length; i++) {
				sequence[i][0] = Integer.parseInt(str[i]);
			}
			
			sequence[0][1] = 1;
			for(int i=1; i<N; i++) {
				// 자기자신을 이어서 최대치 만들기
				int max = 0;
				for(int j=i; j>=0; j--) {
					// 앞으로 돌아가며 이을 수 있는 가장 긴 부분 수열 찾기
					if(sequence[j][0]<sequence[i][0]) {
						if(max<sequence[j][1]) {
							max = sequence[j][1];
						}
					}
				}
				sequence[i][1] = max+1;
			}
			
			int max = 0;
			for(int i=0; i<N; i++) {
				// 가장 긴 부분 수열 길이 찾기
				if(max < sequence[i][1]) {
					max = sequence[i][1];
				}
			}
			System.out.println(max);
			
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
