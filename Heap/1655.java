import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 1655] 가운데를 말해요
// https://blog.naver.com/tnwls0529/222232861808

class MinHeap{
	private int size;
	private int[] arr;
	
	public MinHeap(int size) {
		arr = new int[size+1];
		this.size = 0;
	}
	
	public void add(int value) {
		this.size++;
		int index = this.size;
		
		while(index != 1 && this.arr[index/2] > value) {

			this.arr[index] = this.arr[index/2];
			index /= 2;
		}
		this.arr[index] = value;
	}
	
	public int delete() {
		int min = this.arr[1];
		int tmp = this.arr[this.size];
		int parent = 1;
		int child = 2;
		
		while(child < this.size) {
			if(child+1 < this.size && this.arr[child] > this.arr[child+1]) {
				child++;
			}
			if(this.arr[child] > tmp) {
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
	
	public int getSize() {
		return this.size;
	}
}

class MaxHeap{
	private int size;
	private int[] arr;
	
	public MaxHeap(int size) {
		arr = new int[size+1];
		this.size = 0;
	}
	
	public void add(int value) {
		this.size++;
		int index = this.size;
		
		while(index != 1 && this.arr[index/2] < value) {

			this.arr[index] = this.arr[index/2];
			index /= 2;
		}
		this.arr[index] = value;
	}
	
	public int delete() {
		int max = this.arr[1];
		int tmp = this.arr[this.size];
		int parent = 1;
		int child = 2;
		
		while(child < this.size) {
			if(child+1 < this.size && this.arr[child] < this.arr[child+1]) {
				child++;
			}
			if(this.arr[child] < tmp) {
				break;
			}
			this.arr[parent] = this.arr[child];
			parent = child;
			child *= 2;
		}
		this.arr[parent] = tmp;
		this.size--;
		
		return max;
	}
	
	public int peek() {
		return this.arr[1];
	}
	
	public int getSize() {
		return this.size;
	}
}


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			MinHeap minHeap = new MinHeap(n);
			MaxHeap maxHeap = new MaxHeap(n);
			
			for(int i=1; i<=n; i++) {
				int integer = Integer.parseInt(br.readLine());
				
				// 입력받은 integer를 크기에 맞는 힙 위치에 넣기
				// maxHeap <= minHeap이 되도록 구성
				if(minHeap.getSize() == 0 && maxHeap.getSize() == 0) {
					maxHeap.add(integer);
				}
				else if(maxHeap.peek() > integer) {
					maxHeap.add(integer);
				}
				else {
					minHeap.add(integer);
				}
				
				int index = (i+1)/2;
				// maxHeap에서 중간값을 반환하기 위한 maxHeap의 목표 size
				while(index != maxHeap.getSize()) {
					if(maxHeap.getSize() > index) {
						int tmp = maxHeap.delete();
						minHeap.add(tmp);
					}
					else {
						// maxHeap의 size가 부족
						int tmp = minHeap.delete();
						maxHeap.add(tmp);
					}
				}
				bw.write(maxHeap.peek()+"\n");
			}
			br.close();
			bw.close();
		}catch(Exception e) {
			
		}
	}
}
