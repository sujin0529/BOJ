import java.util.Scanner;

// [백준 9095] 1, 2, 3 더하기
// https://blog.naver.com/tnwls0529/221835698479

public class Main {
	
	static int adder(int[] num, int index) {
		if(num[index]!=0) {
			// 비어있지 않으면 계산된 값 그대로 반환
			return num[index];
		}
		else if(index == 1) {
			return 1;
		}
		else if(index == 2) {
			return 2;
		}
		else if(index == 3) {
			return 4;
		}
		else {
			return (num[index] = adder(num, index-1)+adder(num, index-2)+adder(num, index-3));
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int test_case = sc.nextInt();
		
		int [] integer = new int[11]; // 11미만
		
		for(int i=0; i<test_case; i++) {
			int number = sc.nextInt();
			System.out.println(adder(integer, number));
		}

	}

}
