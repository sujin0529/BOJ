package cardCombinationPlay;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Heap{
	long[] arr;
	int size;
	
	public Heap(int n) {
		arr = new long[n+1];
		size = 0;
	}
	
	public void add(long value) {
		this.size++;
		int index = this.size;
		while(index != 1 && arr[index/2] > value) {
			arr[index] = arr[index/2];
			index /= 2;
		}
		arr[index] = value;
	}
	
	public long delete() {
		long min = arr[1];
		int parent = 1;
		int child = 2;
		long tmp = arr[this.size];
		
		while(child < this.size) {
			if(child < this.size+1 && arr[child] > arr[child+1]) {
				child++;
			}
			if(arr[child] > tmp) {
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
	
	public boolean isEmpty() {
		if(this.size == 0) {
			return true;
		}
		return false;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] token = br.readLine().split(" ");
			int n = Integer.parseInt(token[0]); // 카드의 개수
			int combineCount = Integer.parseInt(token[1]); // 카드 합체 횟수
			
			Heap heap = new Heap(n);
			token = br.readLine().split(" ");
			for(int i=0; i<n; i++) {
				heap.add(Long.parseLong(token[i]));
			}
			
			long result = 0;
			for(int i=0; i<combineCount; i++) {
				long first = heap.delete();
				long second = heap.delete();
				long sum = first+second;
				heap.add(sum);
				heap.add(sum);
			}
			
			while(!heap.isEmpty()) {
				result += heap.delete();
			}
			
			bw.write(result+"\n");
			br.close();
			bw.close();	
		}catch(Exception e) {
			
		}
	}
}
