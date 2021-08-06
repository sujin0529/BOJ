import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// [백준 15565] 귀여운 라이언

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String[] token = br.readLine().split(" ");
			int count = Integer.parseInt(token[0]);
			int target = Integer.parseInt(token[1]);
			
			int[] dolls = new int[count];
			
			token = br.readLine().split(" ");
			int length = 0; // 라이언 인형의 개수
			for(int i=0; i<count; i++) {
				int tmp = Integer.parseInt(token[i]);
				if(tmp == 1) {
					dolls[length] = i;
					length++;
				}
			}
			
			int start = 0;
			int end = target-1;
			int minSize = Integer.MAX_VALUE;
			
			for(; end < length; start++, end++) {
				int tmp = dolls[end]-dolls[start]+1;
				if(tmp < minSize) {
					minSize = tmp;
				}
			}
			
			if(minSize == Integer.MAX_VALUE) {
				minSize = -1;
			}
			
			bw.write(minSize+"\n");
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
}
