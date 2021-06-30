import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 14241] 슬라임 합치기

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
	
	public int size() {
		return this.size;
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
		// first가 작을 때 1반환
		if(first < second) {
			return 1;
		}
		else if(first > second) {
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
			String[] token = br.readLine().split(" ");
			Heap heap = new Heap(num);
			for(int i=0; i<num; i++) {
				heap.add(Integer.parseInt(token[i]+""));
			}
			
			int score = 0;
			while(heap.size() > 1) {
				int first = heap.delete();
				int second = heap.delete();
				score += (first*second);
				
				heap.add(first+second);
			}
			
			bw.write(score+"\n");
			bw.close();
			br.close();
		
		} catch(Exception e) {
			
		}
	}
}
