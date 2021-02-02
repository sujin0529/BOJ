package sortCard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
		
		while(index != 1 && arr[index/2] > value) {
			arr[index] = arr[index/2];
			index /= 2;
		}
		arr[index] = value;
	}
	
	public int delete() {
		int min = arr[1];
		int tmp = arr[this.size];
		int parent = 1;
		int child = 2;
		
		while(child < this.size) {
			if(child + 1 < this.size && arr[child] > arr[child+1]) {
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
	
	public int size() {
		return this.size;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int count = Integer.parseInt(br.readLine());
			Heap card = new Heap(count);
			for(int i=0; i<count; i++) {
				card.add(Integer.parseInt(br.readLine()));
			}
			
			int comparison = 0;
			while(card.size() > 1) {
				int first = card.delete();
				int second = card.delete();
				int sum = first+second;
				comparison += sum;
				card.add(sum);
			}
			
			bw.write(comparison+"\n");
			br.close();
			bw.close();
		}catch(Exception e) {
			
		}
	}
}