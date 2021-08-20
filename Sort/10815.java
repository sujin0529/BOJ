import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// [백준 10815] 숫자 카드

public class Main {
	static int[] numberCard;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int N = Integer.parseInt(br.readLine());
			numberCard  = new int[N];
			String[] token = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				numberCard[i] = Integer.parseInt(token[i]);
			}
			Arrays.parallelSort(numberCard);
			
			int compare = Integer.parseInt(br.readLine());
			token = br.readLine().split(" ");
			StringBuilder result = new StringBuilder();
			for(int i=0; i<compare; i++) {
				int _result = haveNum(Integer.parseInt(token[i]));
				result.append(_result+" ");
			}
			
			bw.write(result+"\n");
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
	
	static int haveNum(int target) {
		int start = 0;
		int end = numberCard.length-1;
		while(start <= end) {
			int index = (start+end)/2;
			if(numberCard[index] > target) {
				end = index-1;
			}
			else if(numberCard[index] < target) {
				start = index+1;
			}
			else {
				return 1;
			}
		}
		return 0;
	}
}
