import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// [백준 1931] 회의실 배정
// https://blog.naver.com/tnwls0529/221799975842

public class Main {
	
	static class Time{
		
		int start;
		int end;
		
		Time(int _start, int _end){
			start = _start;
			end = _end;
		}
	}
	
	static class EndComparator implements Comparator<Time>{

		@Override
		public int compare(Time o1, Time o2) {
			// TODO Auto-generated method stub

			if(o1.end>o2.end) {
				return 1;
			}
			else if(o1.end==o2.end) {
				return 0;
			}
			else {
				return -1;
			}
		}
		
	}
	
	static class StartComparator implements Comparator<Time>{

		@Override
		public int compare(Time o1, Time o2) {
			// TODO Auto-generated method stub

			if(o1.start>o2.start) {
				return 1;
			}
			else if(o1.start==o2.start) {
				return 0;
			}
			else {
				return -1;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		Time meeting[] = null;
		try {
			num = Integer.parseInt(br.readLine());
			meeting = new Time[num];
			for(int i=0; i<num; i++) {
				String temp = br.readLine();
				String token[] = temp.split(" ");
				meeting[i] = new Time(Integer.parseInt(token[0]), Integer.parseInt(token[1]));
			}
			Arrays.sort(meeting, new StartComparator()); // 시작 시간에 대해서 정렬
			Arrays.sort(meeting, new EndComparator()); // 끝 시간에 대해서 정렬
			br.close();
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int count = 0; // 가능한 회의 수
		int last = 0; // 마지막 회의 시간
		
		for(int i=0; i<num; i++) {
			if(meeting[i].start>=last) {
				// 회의 시작시간이 마지막 회의 시간보다 크거나 같다면
				last = meeting[i].end; // 마지막 회의 시간을 수정하고
				count++; // 회의 수 증가
			}
		}
		
		System.out.println(count);

	}

}
