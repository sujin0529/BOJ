import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// [백준 1504] 특정한 최단 경로
// https://blog.naver.com/tnwls0529/222252318020

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] token = br.readLine().split(" ");
			int vertex = Integer.parseInt(token[0]);
			int edge = Integer.parseInt(token[1]);
			int[][] matrix = new int[vertex+1][vertex+1];
			
			
			for(int i=1; i<=vertex; i++) {
				Arrays.fill(matrix[i], Integer.MAX_VALUE);
			}
			
			for(int i=0; i<edge; i++) {
				token = br.readLine().split(" ");
				int first = Integer.parseInt(token[0]);
				int second = Integer.parseInt(token[1]);
				int cost = Integer.parseInt(token[2]);
				matrix[first][second] = cost;
				matrix[second][first] = cost;
			}
			
			for(int k=1; k<=vertex; k++) {
				for(int i=1; i<=vertex; i++) {
					for(int j=1; j<=vertex; j++) {
						if(i==j) {
							matrix[i][j] = 0;
							continue;
						}
						if(matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE && matrix[i][k]+matrix[k][j] < matrix[i][j]) {
							matrix[i][j] = matrix[i][k] + matrix[k][j];
						}
					}
				}
			}
			
			token = br.readLine().split(" ");
			int visit1 = Integer.parseInt(token[0]);
			int visit2 = Integer.parseInt(token[1]);
			
			int finalCost = 0;
			int distance1 = Math.min(matrix[1][visit1], matrix[1][visit2]);
			int distance2 = Math.min(matrix[visit1][vertex], matrix[visit2][vertex]);
			
			if(distance1 == Integer.MAX_VALUE || distance2 == Integer.MAX_VALUE || matrix[visit1][visit2] == Integer.MAX_VALUE) {
				finalCost = -1;
			}
			else {
				finalCost = matrix[visit1][visit2];
				if(matrix[1][visit1] == Integer.MAX_VALUE) {
					finalCost += (matrix[1][visit2] + matrix[visit1][vertex]);
				}
				else if(matrix[1][visit2] == Integer.MAX_VALUE) {
					finalCost += (matrix[1][visit1] + matrix[visit2][vertex]);
				}
				else {
					int min = matrix[1][visit1] + matrix[visit2][vertex] > matrix[1][visit2] + matrix[visit1][vertex] 
							? matrix[1][visit2] + matrix[visit1][vertex] : matrix[1][visit1] + matrix[visit2][vertex];
					finalCost += min;	
				}
			}
			bw.write(finalCost+"\n");
			
			bw.close();
			br.close();
		} catch(Exception e) {
			
		}
	}
}
