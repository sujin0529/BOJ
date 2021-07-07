import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// [백준 2841] 외계인의 기타 연주

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] token = br.readLine().split(" ");
			int melody = Integer.parseInt(token[0]);
			int maxFret = Integer.parseInt(token[1]);
			
			Stack<Integer>[] play = new Stack[7]; // 기타 줄이 6개 (1번부터 6번까지)
			for(int i=1; i<=6; i++) {
				play[i] = new Stack<>();
			}
			
			int count = 0;
			for(int i=0; i<melody; i++) {
				token = br.readLine().split(" ");
				int line = Integer.parseInt(token[0]);
				int fret = Integer.parseInt(token[1]);
				
				while(!play[line].isEmpty()  && play[line].peek() > fret) {
					play[line].pop();
					count++;
				}
				if(play[line].isEmpty()  || play[line].peek() < fret) {
					play[line].add(fret);
					count++;
				}
			}
			
			bw.write(count+"\n");
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
}
