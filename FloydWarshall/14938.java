import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 14938] 서강그라운드

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] token = br.readLine().split(" ");
			int size = Integer.parseInt(token[0]);
			int range = Integer.parseInt(token[1]);
			int road = Integer.parseInt(token[2]);
			
			int[] item = new int[size+1];
			int[][] ground = new int[size+1][size+1];
			
			token = br.readLine().split(" ");
			for(int i=1; i<=size; i++) {
				item[i] = Integer.parseInt(token[i-1]);
			}
			
			for(int i=0; i<road; i++) {
				token = br.readLine().split(" ");
				int city1 = Integer.parseInt(token[0]);
				int city2 = Integer.parseInt(token[1]);
				int length = Integer.parseInt(token[2]);
				
				ground[city1][city2] = length;
				ground[city2][city1] = length;
			}
			
			// 최단경로 찾기
			for(int k=1; k<=size; k++) {
				for(int i=1; i<=size; i++) {
					for(int j=1; j<=size; j++) {
						if(ground[i][k] != 0 && ground[k][j] != 0) {
							if(ground[i][j] == 0) {
								ground[i][j] = ground[i][k] + ground[k][j];
								ground[j][i] = ground[i][k] + ground[k][j];
							}
							else if(ground[i][j] > (ground[i][k] + ground[k][j])) {
								ground[i][j] = ground[i][k] + ground[k][j];
								ground[j][i] = ground[i][k] + ground[k][j];
							}
						}
					}
				}
			}
			
			int totalItem = 0;
			for(int i=1; i<=size; i++) {
				int _item = 0;
				for(int j=1; j<=size; j++) {
					if(i==j) {
						_item += item[j];
					}
					else if(ground[i][j] != 0 && ground[i][j] <= range) {
						_item += item[j];
					}
				}
				totalItem = totalItem > _item ? totalItem : _item;
			}
			
			bw.write(totalItem+"\n");
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
}
