import java.util.Arrays;
import java.util.Scanner;

// [백준 1920] 수 찾기
// https://blog.naver.com/tnwls0529/222212406883

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] num = new int[count];
		
		for(int i=0; i<count; i++) {
			num[i] = sc.nextInt();
		}
		Arrays.parallelSort(num);
		
		int targetCount = sc.nextInt();
		int[] target = new int[targetCount];
		for(int i=0; i<targetCount; i++) {
			target[i] = sc.nextInt();
		}
		
		for(int i=0; i<targetCount; i++) {
			System.out.println(binarySearch(num, 0, count-1, target[i]));
		}
	}
	
	static int binarySearch(int[] num, int start, int end, int target) {
		int index = start+(end-start)/2;
		if(start > end) {
			return 0;
		}
		else if(num[index] == target) {
			return 1;
		}
		else if(num[index] < target){
			return binarySearch(num, index+1, end, target);
		}
		else {
			return binarySearch(num, start, index-1, target);
		}
	}
}
