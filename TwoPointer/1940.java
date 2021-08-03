import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// [백준 1940] 주몽

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int num = Integer.parseInt(br.readLine());
			int target = Integer.parseInt(br.readLine());
			
			int[] material = new int[num];
			String[] token = br.readLine().split(" ");
			
			for(int i=0; i<num; i++) {
				material[i] = Integer.parseInt(token[i]);
			}
			
			Arrays.parallelSort(material);
			
			int count = 0; // 만들 수 있는 갑옷의 개수
			int start = 0;
			int end = num-1;
			
			while(start < end) {
				int sum = material[start] + material[end];
				if(sum == target) {
					count++;
					start++;
				}
				else if(sum < target) {
					start++;
				}
				else {
					end--;
				}
			}
			
			bw.write(count+"\n");
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
}
