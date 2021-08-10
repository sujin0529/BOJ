import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 9657] 돌 게임 3

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int stone = Integer.parseInt(br.readLine());
			String result = "";
			int remain = stone%7;
			
			if(remain == 2 || remain == 0) {
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
