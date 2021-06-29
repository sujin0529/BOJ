import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// [백준 11000] 강의실 배정

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

class Room{
	int start, end;
	public Room(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

class roomSort implements Comparator<Room>{

	public int compare(Room arg0, Room arg1) {
		// TODO Auto-generated method stub
		if(arg0.start > arg1.start) {
			return 1;
		}
		else if(arg0.start == arg1.start) {
			if(arg0.end > arg1.end) {
				return 1;
			}
			else if(arg0.end == arg1.end) {
				return 0;
			}
		}
		return -1;
	}
	
}


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int num = Integer.parseInt(br.readLine());
			ArrayList<Room> room = new ArrayList<>();
			for(int i=0; i<num; i++) {
				String[] token = br.readLine().split(" ");
				Room tmp = new Room(Integer.parseInt(token[0]+""), Integer.parseInt(token[1]+""));
				room.add(tmp);
			}
			Collections.sort(room, new roomSort());
			
			int count = 0; // 필요한 강의실 개수
			Heap endTime = new Heap(num);
			endTime.add(room.get(0).end);
			count++;
			for(int i=1; i<num; i++) {
				if(room.get(i).start >= endTime.top()) {
					endTime.add(room.get(i).end);
					endTime.delete();
				}
				else {
					endTime.add(room.get(i).end);
					count++;
				}
			}
			bw.write(count+"\n");
			bw.close();
			br.close();
		}catch(Exception e) {
			
		}

	}

}

