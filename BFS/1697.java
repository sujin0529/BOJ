import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// [백준 1697] 숨바꼭질
// https://blog.naver.com/tnwls0529/222246443455

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String[] token = br.readLine().split(" ");
			int subin = Integer.parseInt(token[0]); // 수빈이의 위치
			int young = Integer.parseInt(token[1]); // 동생의 위치

			int[] time = new int[100001];
			Queue<Integer> queue = new LinkedList<>();
			queue.add(subin);

			while (!queue.isEmpty()) {
				int current = queue.remove(); // 현재 수빈이의 위치
				int[] _dx = { -1, 1, current }; // 증감을 넣을 값
				
				if (young == current) {
					// 동생의 위치와 같아졌으면 빠져나오기 - 더 이후의 값이 최단 시간일 가능성이 없음
					break;
				}

				for (int i = 0; i < _dx.length; i++) {
					int dx = current + _dx[i];
					if (dx < 0 || dx > 100000) {
						// 이동할 수 없는 위치인 경우
						continue;
					}
					if(time[dx] != 0 && time[dx] < time[current]+1) {
						// 이동할 수 있는 위치이기는 하나, 현재 경로로 왔을 때 걸리는 시간보다 이미 짧게 도착할 수 있었던 경우
						continue;
					}
					
					// 갱신이 필요한 경우
					time[dx] = time[current] + 1;
					// 이동하게 된다면 현재 위치까지 걸린 시간보다 1초 더 오래 걸리는 것임
					queue.add(dx);
				}
			}
			bw.write(time[young] + "\n");
			bw.close();
			br.close();
		} catch (Exception e) {

		}
	}
}
