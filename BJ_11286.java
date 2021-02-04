import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 11286] 절댓값 힙
// https://blog.naver.com/tnwls0529/222231575684

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
		int absFirst = Math.abs(first);
		int absSecond = Math.abs(second);
		if(absFirst < absSecond) {
			return 1;
		}
		else if(absFirst > absSecond) {
			return -1;
		}
		else if(first < second) {
			// 절댓값이 같은 경우 음수가 더 작음
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
			int count = Integer.parseInt(br.readLine());
			Heap heap = new Heap(count);
			for(int i=0; i<count; i++) {
				int command = Integer.parseInt(br.readLine());
				if(command == 0) {
					bw.write(heap.delete()+"\n");
				}
				else {
					heap.add(command);
				}
			}
			
			br.close();
			bw.close();
		}catch(Exception e) {
			
		}
	}
}
