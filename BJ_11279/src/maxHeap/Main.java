package maxHeap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Heap{
	int[] arr = null;
	int size;
	public Heap(int size) {
		arr = new int[size+1];
		this.size = 0;
	}
	
	public void add(int element) {
		size++;
		int parent = size/2;
		int child = size;
		while(child != 1 && (arr[parent] < element)) {
			arr[child] = arr[parent];
			child = parent;
			parent /= 2;
		}
		arr[child] = element;
		
	}
	
	public int delete() {
		if(this.size == 0) {
			// 배열이 빈 경우 출력 요청시 0을 출력하도록 함.
			return 0;
		}
		int max = arr[1];
		int tmp = arr[size];
		int parent = 1;
		int child = 2;
		while(child < size) {
			if(child < size+1 && (arr[child] < arr[child+1])) {
				child++;
			}
			if(tmp >= arr[child]) {
				// child가 바뀌었을 수 있으므로, 여기서 비교
				break;
			}
			arr[parent] = arr[child];
			parent = child;
			child *= 2;
		}
		arr[parent] = tmp;
		size--;
		
		return max;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int size = Integer.parseInt(br.readLine());
			Heap heap = new Heap(size);
			
			for(int i=0; i<size; i++) {
				int command = Integer.parseInt(br.readLine());
				if(command == 0) {
					bw.write(heap.delete()+"\n");
				}
				else {
					heap.add(command);
				}
			}
			bw.close();
			br.close();
		}catch(Exception e) {
			
		}

	}

}
