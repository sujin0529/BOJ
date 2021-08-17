import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 10025] 게으른 백곰

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String[] token = br.readLine().split(" ");
			int pailCount = Integer.parseInt(token[0]);
			int range = Integer.parseInt(token[1]);
			
			int[] pail = new int[1000001];
			
			for(int i=0; i<pailCount; i++) {
				token = br.readLine().split(" ");
				int ice = Integer.parseInt(token[0]);
				int index = Integer.parseInt(token[1]);
				pail[index] = ice;
			}
			
			range = range > 500000 ? 500000 : range;
			
			long maxIce = 0;
			long value = 0;
			for(int i=0; i<=range*2; i++) {
				value += pail[i];
			}
			maxIce = value;
			
			int start = 1;
			int end = range*2 + 1;
			for(; end<=1000000; start++, end++) {
				value -= pail[start-1];
				value += pail[end];
				if(value > maxIce) {
					maxIce = value;
				}
			}
			
			bw.write(maxIce+"\n");
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
}
