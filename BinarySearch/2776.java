import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// [백준 2776] 암기왕

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int testCase = Integer.parseInt(br.readLine());
			
			for(int iter=0; iter<testCase; iter++) {
				int firstNum = Integer.parseInt(br.readLine());
				int[] firstNote = new int[firstNum];
				
				String[] token = br.readLine().split(" ");
				for(int i=0; i<firstNum; i++) {
					firstNote[i] = Integer.parseInt(token[i]);
				}
				
				int secondNum = Integer.parseInt(br.readLine());
				int[] secondNote = new int[secondNum];
				
				token = br.readLine().split(" ");
				for(int i=0; i<secondNum; i++) {
					secondNote[i] = Integer.parseInt(token[i]);
				}
				
				Arrays.parallelSort(firstNote);
				
				for(int i=0; i<secondNum; i++) {
					int target = secondNote[i];
					int start = 0;
					int end = firstNum-1;
					int result = 0;
					
					while(start <= end) {
						int mid = (start+end)/2;
						if(firstNote[mid] == target) {
							result = 1;
							break;
						}
						else if(firstNote[mid] < target) {
							start = mid+1;
						}
						else {
							end = mid-1;
						}
					}
					bw.write(result+"\n");
				}
			}
			bw.close();
			br.close();
		} catch(Exception e) {
			
		}
	}
}
