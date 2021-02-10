import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 10942] 팰린드롬?
// https://blog.naver.com/tnwls0529/222203706500

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int size = Integer.parseInt(br.readLine());
			int[] num = new int[size+1];
			String[] token = br.readLine().split(" ");
			for(int i=1; i<=size; i++) {
				num[i] = Integer.parseInt(token[i-1]);
			}
			int question = Integer.parseInt(br.readLine());
			for(int i=0; i<question; i++) {
				token = br.readLine().split(" ");
				int start = Integer.parseInt(token[0]);
				int end = Integer.parseInt(token[1]);
				bw.write(palindrome(num, start, end)+"\n");
			}
			br.close();
			bw.close();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static int palindrome(int[] num, int start, int end) {
		int halfSize = (end-start+1)/2;
		for(int i=0; i<halfSize; i++) {
			if(num[start+i] != num[end-i]) {
				return 0;
			}
		}
		return 1;
	}

}
