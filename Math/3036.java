import java.util.Scanner;

// [백준 3036] 링

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int ring_num = sc.nextInt();
		
		int first_ring = sc.nextInt();
		for(int i=1; i<ring_num; i++) {
			int ring = sc.nextInt();
			int div = gcd(first_ring, ring);
			int div_first = first_ring/div;
			int div_ring = ring/div;
			System.out.println(div_first+"/"+div_ring);
		}

	}
	
	static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		else {
			return gcd(b, a%b);
		}
	}

}
