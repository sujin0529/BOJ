import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 9372] 상근이의 여행
// https://blog.naver.com/tnwls0529/222254798133

class DisjointSet{
	int[] parent;
	
	public DisjointSet(int size) {
		parent = new int[size+1];
		for(int i=1; i<=size; i++) {
			parent[i] = i;
		}
	}
	
	public void union(int u, int v) {
		u = find(u);
		v = find(v);
		if(u == v) {
			return;
		}
		parent[v] = u;
	}
	
	public int find(int u) {
		if(u == parent[u]) {
			return u;
		}
		return find(parent[u]);
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int testCase = Integer.parseInt(br.readLine());
			for(int i=0; i<testCase; i++) {
				String[] token = br.readLine().split(" ");
				int country = Integer.parseInt(token[0]);
				int airplane = Integer.parseInt(token[1]);
				DisjointSet set = new DisjointSet(country);
				
				int airplaneCount = 0;
				
				for(int count=0; count<airplane; count++) {
					token = br.readLine().split(" ");
					int head = Integer.parseInt(token[0]);
					int tail = Integer.parseInt(token[1]);
					
					if(set.find(head) != set.find(tail)) {
						airplaneCount++;
						set.union(head, tail);
					}
				}
				bw.write(airplaneCount+"\n");
			}
			br.close();
			bw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
