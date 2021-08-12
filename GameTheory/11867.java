import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 11867] 박스 나누기 게임

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String[] token = br.readLine().split(" ");
			int N = Integer.parseInt(token[0]);
			int M = Integer.parseInt(token[1]);
			String result = "";
			
			if(N%2 == 0 || M%2 == 0) {
				result = "A";
			}
			else {
				result = "B";
			}
			
			bw.write(result+"\n");
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
}
