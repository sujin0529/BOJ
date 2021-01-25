package ccw;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int x3 = sc.nextInt();
		int y3 = sc.nextInt();
		
		int area = (x2-x1)*(y3-y1) - (y2-y1)*(x3-x1);
		int result = 0;
		if(area == 0) {
			result = 0;
		}
		else if(area > 0) {
			result = 1;
		}
		else {
			result = -1;
		}
		
		System.out.println(result);
	}
}