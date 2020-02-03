package atm;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int people = sc.nextInt();
		int time[] = new int[people];
		for(int i=0; i<people; i++) {
			time[i] = sc.nextInt();
		}
		Arrays.sort(time);
		for(int i=1; i<people; i++) {
			time[i] += time[i-1];
		}
		int total = 0;
		for(int i=0; i<people; i++) {
			total += time[i];
		}
		System.out.println(total);
	}
}
