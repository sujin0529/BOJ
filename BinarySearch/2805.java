import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// [백준 2805] 나무 자르기
// https://blog.naver.com/tnwls0529/222216123207

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] s = br.readLine().split(" ");
			int count = Integer.parseInt(s[0]); // 나무 개수
			int target = Integer.parseInt(s[1]); // 목표 나무 길이
			int[] tree = new int[count];
			s = br.readLine().split(" ");
			for(int i=0; i<count; i++) {
				tree[i] = Integer.parseInt(s[i]);
			}
			Arrays.parallelSort(tree);
			long result = treeLength(tree, 0, tree[count-1], target);
			bw.write(result+"\n");
			br.close();
			bw.close();
		}catch(Exception e) {
			
		}
	}
	
	static long treeLength(int[] tree, long start, long end, int target) {
		long treeLength = 0;
		long maxLength = 0;
		while(start <= end) {
			treeLength = (start+end)/(long)2;
			long cutLength = 0;
			for(int i=0; i<tree.length; i++) {
				long tmp = tree[i] - treeLength;
				if(tmp > 0) {
					cutLength += tmp; 
				}
			}
			if(cutLength >= target) {
				start = treeLength + 1;
				maxLength = maxLength > treeLength ? maxLength : treeLength;
			}
			else {
				end = treeLength - 1;
			}
		}
		return maxLength;
	}
}