import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N, M;
		int Maze[][];
		int visited[][];
		
		
		Queue queue_i = new LinkedList<Integer>();
		Queue queue_j = new LinkedList<Integer>();
		
		int dx[] = {1, -1, 0, 0};
		int dy[] = {0, 0, 1, -1};

		try {
			String temp1 = br.readLine();
			String temp2[] = temp1.split(" ");
			N = Integer.parseInt(temp2[0]);

			M = Integer.parseInt(temp2[1]);
			
			Maze = new int[N][M];
			visited = new int[N][M];
			
			for(int[] row: visited) {
	            Arrays.fill(row, 0);
	        }
			
			for(int i=0;i<N;i++) {
				String temp = br.readLine();
				for(int j=0;j<M;j++) {
					Maze[i][j] = Integer.parseInt(temp.charAt(j)+"");
				}
			}
			
			queue_i.add(0);
			queue_j.add(0);
			// 큐에 들어가는 값 초기화
			
			int space = 0;
			while(!queue_i.isEmpty()) {
				int _i = (int)queue_i.remove();
				int _j = (int)queue_j.remove();
				space = Integer.MAX_VALUE;
				int _dx = 0;
				int _dy = 0;
				if(Maze[_i][_j] != 0 && visited[_i][_j] != 1) {
					visited[_i][_j] = 1;
					for(int i=0;i<4;i++) {
						_dx = _i+dx[i];
						_dy = _j+dy[i];
						if((_dx>=0) && (_dx<N) && (_dy>=0) && (_dy<M)) {
							if(Maze[_dx][_dy] != 0) {
								if(visited[_dx][_dy] != 1) {
									queue_i.add(_dx);
									queue_j.add(_dy);
								}
								if(space > Maze[_dx][_dy] && Maze[_dx][_dy] != 1)
									space = Maze[_dx][_dy];
								}
						}
					}
					if(space == Integer.MAX_VALUE) {
						Maze[_i][_j] = 2;
					}
					else{
						Maze[_i][_j] = space+1;
					}
					
					
					if(_i==(N-1) && _j==(M-1)) {
						break;
					}
				}	
			}
			System.out.println(Maze[N-1][M-1]-1);
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
	}

}
