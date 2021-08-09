import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 9659] 돌 게임 5

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			long stone = Long.parseLong(br.readLine());
			String result = "";
			
			if(stone%2 == 0) {
				result = "CY";
			}
			else {
				result = "SK";
			}
			
			bw.write(result+"\n");
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
}
