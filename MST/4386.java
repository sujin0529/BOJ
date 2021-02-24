import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 4386] 별자리 만들기
// https://blog.naver.com/tnwls0529/222255593669

class Point{
	double x, y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

class Edge{
	int point1, point2;
	double cost;
	
	public Edge(int point1, int point2, double cost) {
		this.point1 = point1;
		this.point2 = point2;
		this.cost = cost;
	}
}

class Heap{
	Edge[] arr;
	int size;
	
	public Heap(int size) {
		arr = new Edge[size+1];
		this.size = 0;
	}
	
	public void add(Edge value) {
		this.size++;
		int index = this.size;
		while(index != 1 && arr[index/2].cost > value.cost) {
			arr[index] = arr[index/2];
			index /= 2;
		}
		arr[index] = value;
	}
	
	public Edge delete() {
		Edge min = arr[1];
		Edge tmp = arr[this.size];
		int parent = 1;
		int child = 2;
		
		while(child < this.size) {
			if(child+1 < this.size && arr[child].cost > arr[child+1].cost) {
				child++;
			}
			if(arr[child].cost > tmp.cost) {
				break;
			}
			arr[parent] = arr[child];
			parent = child;
			child *= 2;
		}
		arr[parent] = tmp;
		this.size--;
		
		return min;
	}
}

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
			int star = Integer.parseInt(br.readLine());
			Point[] coordinate = new Point[star];
			DisjointSet set = new DisjointSet(star);
			Heap heap = new Heap((star*(star+1))/2);
			
			for(int i=0; i<star; i++) {
				String[] token = br.readLine().split(" ");
				coordinate[i] = new Point(Double.parseDouble(token[0]), Double.parseDouble(token[1]));
			}
			
			for(int i=0; i<star; i++) {
				for(int j=i+1; j<star; j++) {
					double diffX = coordinate[i].x - coordinate[j].x;
					double diffY = coordinate[i].y - coordinate[j].y;
					double distX = diffX * diffX;
					double distY = diffY * diffY;
					heap.add(new Edge(i, j, Math.sqrt(distX+distY)));
				}
			}
			
			int edgeCount = 0;
			double result = 0.0;
			while(edgeCount < star-1) {
				Edge min = heap.delete();
				if(set.find(min.point1) != set.find(min.point2)) {
					set.union(min.point1, min.point2);
					edgeCount++;
					result += min.cost;
				}
			}
			
			bw.write(Math.round(result*100)/100.0+"\n"); // 소수점 둘째자리까지 출력
			bw.close();
			br.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
