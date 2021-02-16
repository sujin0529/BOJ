import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 16953] A -> B
// https://blog.naver.com/tnwls0529/222245496681

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String[] token = br.readLine().split(" ");
			int result = 1;
			int base = Integer.parseInt(token[0]);
			int target = Integer.parseInt(token[1]);
			
			while(base < target) {
				if(target%10 == 1) {
					// 1의 자리수가 1일 때
					target /= 10;
					result++;
				}
				else if(target%2 == 0){
					// 짝수일 때는 2로 나눠주기
					target /= 2;
					result++;
				}
				else {
					// 만약 1의 자리수가 1 또는 짝수가 아니라면 위의 연산으로 만들어 낼 수 없음
					result = -1;
					break;
				}
			}
			
			if(base > target) {
				result = -1;
			}
			
			bw.write(result+"\n");
			bw.close();
			br.close();
		} catch (Exception e) {

		}
	}
}
