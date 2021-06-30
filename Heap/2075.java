import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 2075] N번째 큰 수

class Heap{
	private int size;
	private int[] arr;
	
	public Heap(int size) {
		arr = new int[size+1];
		this.size = 0;
	}
	
	public void add(int value) {
		this.size++;
		int index = this.size;
		
		while(index != 1 && compareTo(this.arr[index/2], value) < 0) {
			this.arr[index] = this.arr[index/2];
			index /= 2;
		}
		this.arr[index] = value;
	}
	
	public int top() {
		return this.arr[1];
	}
	
	public int delete() {
		if(this.size == 0) {
			return 0;
		}
		
		int min = this.arr[1];
		int tmp = this.arr[this.size];
		int parent = 1;
		int child = 2;
		
		while(child < this.size) {
			if(child+1 < this.size && compareTo(this.arr[child], this.arr[child+1])<0) {
				child++;
			}
			if(compareTo(this.arr[child], tmp) < 0) {
				break;
			}
			this.arr[parent] = this.arr[child];
			parent = child;
			child *= 2;
		}
		this.arr[parent] = tmp;
		this.size--;
		
		return min;
	}
	
	public int compareTo(int first, int second) {
		// first가 클 때 1반환
		if(first > second) {
			return 1;
		}
		else if(first < second) {
			return -1;
		}
		return 0;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int num = Integer.parseInt(br.readLine());
			Heap[] matrix = new Heap[num];
			
			for(int i=0; i<num; i++) {
				matrix[i] = new Heap(num);
			}
			
			for(int i=0; i<num; i++) {
				String[] token = br.readLine().split(" ");
				for(int j=0; j<num; j++) {
					matrix[j].add(Integer.parseInt(token[j]+""));
				}
			}
			
			int result = 0;
			for(int i=0; i<num; i++) {
				int max = matrix[0].top();
				int maxIndex = 0;
				for(int j=1; j<num; j++) {
					if(max < matrix[j].top()) {
						max = matrix[j].top();
						maxIndex = j;
					}
				}
				result = matrix[maxIndex].delete();
			}
			// 반복문을 나올 때 result에 있는 것이 N번째 큰 수
			
			bw.write(result+"\n");
			bw.close();
			br.close();
		}catch(Exception e) {
			
		}
	}
}
