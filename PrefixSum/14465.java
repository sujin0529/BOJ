import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 14465] 소가 길을 건너간 이유 5

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String[] token = br.readLine().split(" ");
			int size = Integer.parseInt(token[0]);
			int target = Integer.parseInt(token[1]);
			int wrongLight = Integer.parseInt(token[2]);

			int[] array = new int[size + 1];
			
			int start = 1;
			int end = target;
			int minLight = Integer.MAX_VALUE;

			for(int i = 0; i < wrongLight; i++) {
				int index = Integer.parseInt(br.readLine());
				array[index] = 1;
			}
			
			for(int i = 1; i<= size; i++) {
				array[i] = array[i-1] + array[i];
			}
			
			for(; end <= size; start++, end++) {
				int tmp = array[end]-array[start-1];
				minLight = minLight > tmp ? tmp : minLight;
			}
			bw.write(minLight+"\n");
			
			bw.close();
			br.close();

		} catch (Exception e) {

		}
	}
}
