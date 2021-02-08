import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 15723] n단 논법
// https://blog.naver.com/tnwls0529/222236746059

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			boolean[][] matrix = new boolean[26][26];
			int n = Integer.parseInt(br.readLine());
			for(int i=0; i<n; i++) {
				String s = br.readLine();
				int head = s.charAt(0)-'a';
				int tail = s.charAt(5)-'a';
				matrix[head][tail] = true;
			}
			
			for(int k=0; k<26; k++) {
				for(int i=0; i<26; i++) {
					for(int j=0; j<26; j++) {
						if(matrix[i][k] && matrix[k][j]) {
							matrix[i][j] = true;
						}
					}
				}
			}
			int m = Integer.parseInt(br.readLine());
			for(int i=0; i<m; i++) {
				String s = br.readLine();
				int head = s.charAt(0)-'a';
				int tail = s.charAt(5)-'a';
				if(matrix[head][tail]) {
					bw.write("T\n");
				}
				else {
					bw.write("F\n");
				}
			}
			bw.close();
			br.close();
			
		}catch(Exception e) {
			
		}
	}
}
