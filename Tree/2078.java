import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 2078] 무한이진트리

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String[] token = br.readLine().split(" ");
			int left = Integer.parseInt(token[0]);
			int right = Integer.parseInt(token[1]);
			
			int leftCount = 0;
			int rightCount = 0;
			
			while(left > 1 || right > 1) {
				if(left < right) {
					right = right - left;
					rightCount++;
				}
				else if(left > right) {
					left = left - right;
					leftCount++;
				}
			}
			bw.write(leftCount+" "+rightCount+"\n");
			bw.close();
			br.close();	
		} catch(Exception e) {
			
		}
	}
}
