import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// [백준 7562] 나이트의 이동
// https://blog.naver.com/tnwls0529/222246757075

class Point{
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int testCase = Integer.parseInt(br.readLine());
			
			for(int iter=0; iter<testCase; iter++) {
				int size = Integer.parseInt(br.readLine());
				int[][] map = new int[size][size];
				String[] token = br.readLine().split(" ");
				Point start = new Point(Integer.parseInt(token[0]), Integer.parseInt(token[1]));
				token = br.readLine().split(" ");
				Point goal = new Point(Integer.parseInt(token[0]), Integer.parseInt(token[1]));
				
				Queue<Point> queue = new LinkedList<>();
				queue.add(start);
				
				while(!queue.isEmpty()) {
					int[] _dx = {-2, -1, 1, 2, -2, -1, 1, 2};
					int[] _dy = {1, 2, 2, 1, -1, -2, -2, -1};
					
					Point current = queue.remove();
					if(current.x == goal.x && current.y == goal.y) {
						// 목적지 도착		
						break;
					}
					
					for(int i=0; i<_dx.length; i++) {
						int dx = current.x + _dx[i];
						int dy = current.y + _dy[i];
						
						if(dx < 0 || dx >= size || dy < 0 || dy >= size || map[dy][dx] != 0) {
							// 체스판의 범위를 벗어나거나, 이미 이동 가능 경로로 판단했던 경우
							// 이미 이동 가능 경로로 판단했었다면, 그것보다 짧은 경로로 이동할 수 있는 가능성이 없음.
							continue;
						}
						if(start.x == dx && start.y == dy) {
							continue;
						}
						map[dy][dx] = map[current.y][current.x] + 1;
						queue.add(new Point(dx, dy));
					}
				}	
				bw.write(map[goal.y][goal.x]+"\n");
			}
			bw.close();
			br.close();	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
