package numbering;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Coordinate{
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
		int map = Integer.parseInt(sc.nextLine());
		
		int matrix[][] = new int[map][map];
		
		for(int i=0; i<map; i++) {
			String s = sc.nextLine();
			for(int j=0; j<map; j++) {
				matrix[i][j] = Integer.parseInt(s.charAt(j)+"");
			}
		}
		
		int index = 1;
		Queue<Coordinate> queue = new LinkedList<>();
		Map<Integer, Integer> count = new HashMap<>();
		
		for(int i=0; i<map; i++) {
			for(int j=0; j<map; j++) {
				if(matrix[i][j] == 1) {
					index++;
					Coordinate temp = new Coordinate(j, i);
					count.put(index, 1);
					matrix[i][j] = index;
					queue.add(temp);
					while(!queue.isEmpty()) {
						Coordinate tmp = queue.remove();
						int x = tmp.x;
						int y = tmp.y;
						
						if((x-1)>=0 && matrix[y][x-1]==1) {
							queue.add(new Coordinate(x-1, y));
							count.put(index, count.get(index)+1);
							matrix[y][x-1] = index;
						}
						if((x+1)<map && matrix[y][x+1]==1) {
							queue.add(new Coordinate(x+1, y));
							count.put(index, count.get(index)+1);
							matrix[y][x+1] = index;
						}
						if((y-1)>=0 && matrix[y-1][x]==1) {
							queue.add(new Coordinate(x, y-1));
							count.put(index, count.get(index)+1);
							matrix[y-1][x] = index;
						}
						if((y+1)<map && matrix[y+1][x]==1) {
							queue.add(new Coordinate(x, y+1));
							count.put(index, count.get(index)+1);
							matrix[y+1][x] = index;
						}
					}
					
				}
			}
		}
		
		Iterator<Integer> iter = count.keySet().iterator();
		int sort[] = new int[index-1];
		int i = 0;
		while(iter.hasNext()) {
			sort[i] = count.get(iter.next());
			i++;
		}
		
		Arrays.sort(sort);
		System.out.println(index-1); // 1에서 시작하는 index에 바로 1이 더해지기 때문
		
		for(i=0; i<index-1; i++) {
			System.out.println(sort[i]);
		}
	}

}
