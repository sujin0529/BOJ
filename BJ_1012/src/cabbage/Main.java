package cabbage;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Coordinate {
	int x;
	int y;
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for(int loop = 0; loop<test_case; loop++) {
			int col = sc.nextInt();
			int row = sc.nextInt();
			int cabbage_num = sc.nextInt();
			
			int cabbage[][] = new int[row][col];
			
			
			for(int i=0; i<cabbage_num; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				cabbage[y][x] = 1;

			}
			
			Queue<Coordinate> queue = new LinkedList<>();
			
			int index = 1;
			
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					if(cabbage[i][j] == 1) {
						index++;
						queue.add(new Coordinate(j, i));
						cabbage[i][j] = index;
						while(!queue.isEmpty()) {
							Coordinate tmp = queue.remove();
							int x = tmp.x;
							int y = tmp.y;
							
							if((y-1)>=0 && cabbage[y-1][x]==1) {
								cabbage[y-1][x] = index;
								queue.add(new Coordinate(x, y-1));
							}
							if((y+1)<row && cabbage[y+1][x]==1) {
								cabbage[y+1][x] = index;
								queue.add(new Coordinate(x, y+1));
							}
							if((x-1)>=0 && cabbage[y][x-1]==1) {
								cabbage[y][x-1] = index;
								queue.add(new Coordinate(x-1, y));
							}
							if((x+1)<col && cabbage[y][x+1]==1) {
								cabbage[y][x+1] = index;
								queue.add(new Coordinate(x+1, y));
							}
						}
					}
				}
			}
			System.out.println(index-1);
		}
	}
}
