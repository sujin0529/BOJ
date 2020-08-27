package cycle;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int test = 0; test<test_case; test++) {
			int num = sc.nextInt();
			int seq[] = new int[num+1];
			boolean visit[] = new boolean[num+1];
			
			for(int i=1; i<=num; i++) {
				seq[i] = sc.nextInt();
			}
			
			int count = 0;
			for(int i=1; i<=num; i++) {
				if(visit[i]) {
					continue;
				}
				else {
					count++;
					visit[i] = true;
					int index = seq[i];
					while(!visit[index]) {
						visit[index] = true;
						index = seq[index];
					}
				}
			}
			System.out.println(count);
		}
	}
}
