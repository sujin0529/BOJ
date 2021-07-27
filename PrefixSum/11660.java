import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 11660] 구간 합 구하기 5

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] token = br.readLine().split(" ");
			int N = Integer.parseInt(token[0]); // 표의 크기
			int count = Integer.parseInt(token[1]); // 횟수
			
			int[][] matrix = new int[N+1][N+1];
			for(int i=1; i<=N; i++) {
				token = br.readLine().split(" ");
				for(int j=1; j<=N; j++) {
					matrix[i][j] = matrix[i][j-1] + Integer.parseInt(token[j-1]);
				}
			}
			
			for(int i=0; i<count; i++) {
				token = br.readLine().split(" ");
				int[] coordinate = new int[4]; // x1, y1, x2, y2
				for(int j=0; j<4; j++) {
					coordinate[j] = Integer.parseInt(token[j]);
				}
				// 좌표 얻기 완료
				
				int sum = 0;
				for(int start = coordinate[0]; start <= coordinate[2]; start++) {
					sum += matrix[start][coordinate[3]] - matrix[start][coordinate[1]-1];
				}
				bw.write(sum+"\n");
			}
			
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
}
