import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// [백준 2170] 선 긋기

class Line{
	int x, y;
	
	public Line(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class LineSort implements Comparator<Line>{
	@Override
	public int compare(Line arg0, Line arg1) {
		// TODO Auto-generated method stub
		if(arg0.x > arg1.x) {
			return 1;
		}
		else if(arg0.x < arg1.x) {
			return -1;
		}
		else {
			if(arg0.y > arg1.y) {
				return 1;
			}
			else if(arg0.y < arg1.y) {
				return -1;
			}
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
			int lineCount = Integer.parseInt(br.readLine());
			List<Line> line = new ArrayList<>();
			for(int i=0; i<lineCount; i++) {
				String[] coordinate = br.readLine().split(" ");
				line.add(new Line(Integer.parseInt(coordinate[0]), Integer.parseInt(coordinate[1])));
			}
			
			Collections.sort(line, new LineSort());
			
			int totalLength = 0;
			int start = Integer.MIN_VALUE;
			int end = Integer.MIN_VALUE;
			for(int i=0; i<lineCount; i++) {
				Line tmp = line.get(i);
				if(tmp.x > end) {
					totalLength += (end-start);
					start = tmp.x;
					end = tmp.y;
				}
				else {
					end = end > tmp.y ? end : tmp.y;
				}
			}
			totalLength += (end-start);
			
			bw.write(totalLength+"\n");
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
}
