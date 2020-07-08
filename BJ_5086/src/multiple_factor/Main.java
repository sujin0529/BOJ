package multiple_factor;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		do {
				
			int isFactor = M%N;
			int isMultiple = N%M;
			
			if(isFactor == 0) {
				System.out.println("factor");
			}
			else if(isMultiple == 0) {
				System.out.println("multiple");
			}
			else {
				System.out.println("neither");
			}
			N = sc.nextInt();
			M = sc.nextInt();
			
		}while(N!=0 && M!=0);
		

	}

}
