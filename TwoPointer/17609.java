import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 17609] 회문

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int num = Integer.parseInt(br.readLine());
			for(int i=0; i<num; i++) {
				int check = palindrome(br.readLine(), false);
				bw.write(check+"\n");
			}
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
	
	static int palindrome(String s, boolean _pseudo) {
		int start = 0;
		int end = s.length()-1;
		boolean pseudo = false;
		
		while(start < end) {
			if(s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			}
			else if(!pseudo) {
				if(_pseudo) {
					// 만약 한 번 달라서 재귀호출이 되었을 때 또 다른 경우가 있다면, 유사회귀도 아님.
					return 2;
				}
				pseudo = true;
				int left = palindrome(s.substring(start+1, end+1), true);
				int right = palindrome(s.substring(start, end), true);
				if(left == 0) {
					start++;
				}
				else if(right == 0) {
					end--;
				}
				else {
					// 현재 다른 문자를 제외한 내부의 문자열에서는 회문이어야 함.
					return 2;
				}
			}
			else {
				// 유사회문도 아닌 경우 2를 반환하고 끝내기
				return 2;
			}
		}
		
		if(pseudo) {
			// 유사회문
			return 1;
		}
		
		return 0;
	}
}
