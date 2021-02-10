import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 13975] 파일 합치기 3
// https://blog.naver.com/tnwls0529/222221891201

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int testCase = Integer.parseInt(br.readLine());
			for(int index=0; index<testCase; index++) {
				int fileNum = Integer.parseInt(br.readLine());
				String[] tmp = br.readLine().split(" ");
				long[] files = new long[fileNum+1]; // 0번째 인덱스 사용x
				
				for(int i=0; i<fileNum; i++) {
					add(files, Long.parseLong(tmp[i]), i+1);	
				}
				int size = files.length - 1;
				long result = 0;
				while(size > 1) {
					long first = delete(files, size);
					size--;
					long second = delete(files, size);
					size--;
					long sum = first+second;
					size++;
					add(files, sum, size);
					result += sum;
				}
				bw.write(result+"\n");
			}
			bw.close();
			br.close();
			
		}catch(Exception e) {
			
		}

	}
	
	static void add(long[] files, long value, int index) {
		while((index != 1) && value < files[index/2]) {
			files[index] = files[index/2];
			index = index/2;
		}
		files[index] = value;
	}
	
	static long delete(long[] files, int size) {
		long min = files[1];
		int parent = 1; 
		int child = 2;
		long temp = files[size];
		while(child < size) {
			if((child < size) && (files[child] > files[child+1])) {
				child++;
			}
			if(temp <= files[child]) {
				// 더 이상 내려갈 필요가 없음
				break;
			}
			files[parent] = files[child];
			parent = child;
			child = child * 2;
		}
		files[parent] = temp;
		
		return min;
	}
}
