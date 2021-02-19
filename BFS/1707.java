import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// [백준 1707] 이분 그래프
// https://blog.naver.com/tnwls0529/222246871161

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int testCase = Integer.parseInt(br.readLine());
			for (int iter = 0; iter < testCase; iter++) {
				String[] token = br.readLine().split(" ");
				int vertex = Integer.parseInt(token[0]);
				int edge = Integer.parseInt(token[1]);
				int[] visited = new int[vertex+1]; // 1 또는 2 를 넣어 둘로 구분
				LinkedList<Integer>[] graph = new LinkedList[vertex+1];
				
				for(int i=1; i<=vertex; i++) {
					graph[i] = new LinkedList<>();
				}

				for (int i = 0; i < edge; i++) {
					token = br.readLine().split(" ");
					int u = Integer.parseInt(token[0]);
					int v = Integer.parseInt(token[1]);
					graph[u].add(v);
					graph[v].add(u);	
				}
				
				boolean check = true;
				for(int i=1; i<=vertex; i++) {
					if(visited[i] == 0) {
						if(!bfs(graph, visited, i)) {
							// 이분 그래프를 만족하지 못하는 경우를 찾은 경우
							check = false;
							break;
						}
					}
				}
				
				if(check) {
					bw.write("YES\n");
				}
				else {
					bw.write("NO\n");
				}
			}
			bw.close();
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static boolean bfs(LinkedList<Integer>[] graph, int[] visited, int index) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(index);
		visited[index] = 1;
		while(!queue.isEmpty()) {
			int start = queue.remove();
			int value = visited[start] == 1 ? 2 : 1;
			// start랑 안겹치게 넣어야 할 값
			
			for(int i : graph[start]) {
				if(visited[i] == 0) {
					visited[i] = value;
					queue.add(i);
				}
				else if(visited[i] != value) {
					return false;
				}
			}
		}
		return true;
	}
}
