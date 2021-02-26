import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 20040] 사이클 게임
// https://blog.naver.com/tnwls0529/222257338236

class DisjointSet{
	int[] parent;
	
	public DisjointSet(int size) {
		parent = new int[size];
		for(int i=0; i<size; i++) {
			parent[i] = i;
		}
	}
	
	public void union(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(u == v) {
			return ;
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
			String[] token = br.readLine().split(" ");
			int point = Integer.parseInt(token[0]);
			int limit = Integer.parseInt(token[1]);
			
			DisjointSet set = new DisjointSet(point);
			
			int result = 0;
			
			for(int i=1; i<=limit; i++) {
				token = br.readLine().split(" ");
				int point1 = Integer.parseInt(token[0]);
				int point2 = Integer.parseInt(token[1]);
				if(set.find(point1) == set.find(point2)) {
					result = i;
					break;
				}
				else {
					set.union(point1, point2);
				}
			}
			
			bw.write(result+"\n");
			
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
}
