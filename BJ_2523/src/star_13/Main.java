package star_13;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int line = sc.nextInt();
		
		for(int i=1; i<=line; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=line; i>1; i--) {
			for(int j=1; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
