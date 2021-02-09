import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 1647] 도시 분할 계획
// https://blog.naver.com/tnwls0529/222237870286

class edge implements Comparable<edge> {
	int head;
	int tail;
	int cost;

	public edge(int head, int tail, int cost) {
		this.head = head;
		this.tail = tail;
		this.cost = cost;
	}

	@Override
	public int compareTo(edge o) {
		// TODO Auto-generated method stub
		if (this.cost > o.cost) {
			return 1;
		} else if (this.cost < o.cost) {
			return -1;
		}
		return 0;
	}
}

class Heap {
	private edge[] arr;
	private int size;

	public Heap(int size) {
		arr = new edge[size + 1];
		this.size = 0;
	}

	public void add(edge value) {
		this.size++;
		int index = this.size;
		while (index != 1 && arr[index / 2].cost > value.cost) {
			arr[index] = arr[index / 2];
			index /= 2;
		}
		arr[index] = value;
	}

	public edge delete() {
		edge min = arr[1];
		edge tmp = arr[this.size];
		int parent = 1;
		int child = 2;

		while (child < this.size) {
			if (child + 1 < this.size && arr[child].cost > arr[child + 1].cost) {
				child++;
			}
			if (arr[child].cost > tmp.cost) {
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

class DisjointSet {
	int[] parent;

	public DisjointSet(int n) {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	public int find(int u) {
		if (parent[u] == u) {
			return u;
		}
		return parent[u] = find(parent[u]);
	}

	public void union(int u, int v) {
		u = find(u);
		v = find(v);

		if (u == v) {
			return;
		}
		parent[u] = v;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String[] token = br.readLine().split(" ");
			int city = Integer.parseInt(token[0]); // 집의 개수
			int road = Integer.parseInt(token[1]); // 길의 개수
			Heap heap = new Heap(road);

			for (int i = 0; i < road; i++) {
				token = br.readLine().split(" ");
				int head = Integer.parseInt(token[0]);
				int tail = Integer.parseInt(token[1]);
				int cost = Integer.parseInt(token[2]);
				heap.add(new edge(head, tail, cost));
			}

			int resultCost = 0;
			int edgeCount = 0;
			DisjointSet set = new DisjointSet(city + 1);

			while (edgeCount < city - 2) {
				// 두 마을로 나눌 것이기 때문에, 길 1개는 필요 없음
				edge tmp = heap.delete();
				if (set.find(tmp.head) != set.find(tmp.tail)) {
					resultCost += tmp.cost;
					set.union(tmp.head, tmp.tail);
					edgeCount++;

				}
			}

			bw.write(resultCost + "\n");
			br.close();
			bw.close();

		} catch (Exception e) {

		}
	}
}

