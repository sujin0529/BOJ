package quadtree;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		int[][] image = new int[size][size];
		
		for(int i=0; i<size; i++) {
			String s = sc.nextLine();
			for(int j=0; j<size; j++) {
				image[i][j] = Integer.parseInt(s.charAt(j)+"");
			}
		}
		String result = quadtree(image, 0, 0, size);
		System.out.println(result);
	}
	
	static String quadtree(int[][] image, int x, int y, int size) {
		boolean check = true; // 모두 같은 값을 갖는지 체크
		String result = "";
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(image[y][x] != image[y+i][x+j]) {
					check = false;
				}
			}
		}
		if(check) {
			result += image[y][x];
		}
		else {
			int halfSize = size/2;
			result += "(";
			result += quadtree(image, x, y, halfSize);
			result += quadtree(image, x+halfSize, y, halfSize);
			result += quadtree(image, x, y+halfSize, halfSize);
			result += quadtree(image, x+halfSize, y+halfSize, halfSize);
			result += ")";
		}
		
		return result;
	}
}