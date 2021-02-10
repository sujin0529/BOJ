import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// [백준 10816] 숫자 카드 2
// https://blog.naver.com/tnwls0529/222213540300

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int count = Integer.parseInt(br.readLine());
			int[] num = new int[count];
			
			String[] tmp = br.readLine().split(" ");
			for(int i=0; i<count; i++) {
				num[i] = Integer.parseInt(tmp[i]);
			}
			
			Arrays.parallelSort(num);
			count = Integer.parseInt(br.readLine());
			tmp = br.readLine().split(" ");
			for(int i=0; i<count; i++) {
				int target = Integer.parseInt(tmp[i]);
				int[] boundary = binarySearch(num, 0, num.length-1, target);
				bw.write(boundary[1]-boundary[0]+" ");
			}
			bw.write("\n");
			br.close();
			bw.close();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	static int[] binarySearch(int[] num, int start, int end, int target) {
		int index = start + (end-start)/2;
		int[] boundary = {-1, -1};
		if(start > end) {
			return boundary;
		}
		else if(num[index] == target) {
			int leftBoundary = findLeftBoundary(num, 0, index-1, target);
			int rightBoundary = findRightBoundary(num, index+1, num.length-1, target);
			boundary[0] = leftBoundary;
			boundary[1] = rightBoundary;
		}
		else if(num[index] < target) {
			boundary = binarySearch(num, index+1, end, target);
		}
		else {
			boundary = binarySearch(num, start, index-1, target);
		}
		return boundary;
	}
	
	static int findLeftBoundary(int[] num, int start, int end, int target) {
		int index = start + (end-start)/2;
		if(start > end) {
			return end+1; // 원래 인덱스
		}
		else if(num[index] < target) {
			return findLeftBoundary(num, index+1, end, target);
		}
		else {
			return findLeftBoundary(num, start, index-1, target);
		}
	}
	
	static int findRightBoundary(int[] num, int start, int end, int target) {
		// 오른쪽 boundary는 target의 right boundary보다 1큰 값을 반환함.
		int index = start + (end-start)/2;
		if(start > end) {
			return start;
		}
		else if(num[index] > target) {
			return findRightBoundary(num, start, index-1, target);
		}
		else {
			return findRightBoundary(num, index+1, end, target);
		}
	}
}