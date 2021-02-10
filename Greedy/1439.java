import java.util.Scanner;

// [백준 1439] 뒤집기
// https://blog.naver.com/tnwls0529/222198265381

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		int count[] = new int[2];
		
		int start = Integer.parseInt(s.charAt(0)+"");
		count[start]++;
		
		for(int i=1; i<s.length(); i++) {
			int prev = Integer.parseInt(s.charAt(i-1)+"");
			int curr = Integer.parseInt(s.charAt(i)+"");
			if(prev != curr) {
				count[curr]++;
			}
		}
		
		int min = count[0] > count[1] ? count[1] : count[0];
		System.out.println(min);
	}
}
