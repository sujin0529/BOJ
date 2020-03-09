package coordinates_sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	static class Coordinates_sort implements Comparator<int[]>{

		@Override
		public int compare(int[] o1,int[] o2) {
			// TODO Auto-generated method stub
			if(o1[1] < o2[1]) {
				return -1;
			}
			else if(o1[1] > o2[1]) {
				return 1;
			}
			else {
				// 같은 경우
				if(o1[0] < o2[0]) {
					return -1;
				}
				else{
					return 1;
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		int[][] coordinates = new int[number][2]; // x, y 좌표 저장
		
		for(int i=0; i<number; i++) {
			for(int j=0; j<2; j++) {
				coordinates[i][j] = sc.nextInt();
			}
		}
		
		Arrays.sort(coordinates, new Coordinates_sort());
		
		for(int i=0; i<number; i++) {
			for(int j=0; j<2; j++) {
				System.out.print(coordinates[i][j]+" ");
			}
			System.out.println();
		}

	}

}
