package beer;

import java.util.Scanner;

class Coordinate {

	int x, y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int t_case = sc.nextInt();

		for (int loop = 0; loop < t_case; loop++) {
			int convenience = sc.nextInt();

			int mat[][] = new int[convenience + 2][convenience + 2];

			Coordinate coor[] = new Coordinate[convenience + 2];

			for (int i = 0; i < convenience + 2; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				coor[i] = new Coordinate(x, y);
			}

			for (int i = 0; i < convenience + 2; i++) {
				for (int j = 0; j < convenience + 2; j++) {
					for (int k = 0; k < convenience + 2; k++) {

						if (i == j) {
							continue;
						}
						// 시작지점
						int x1 = coor[i].x;
						int y1 = coor[i].y;

						// 도착지점
						int x2 = coor[j].x;
						int y2 = coor[j].y;

						int stop_x = coor[k].x; // 경유지 x좌표
						int stop_y = coor[k].y; // 경유지 y좌표

						int diff_sx = x1 > stop_x ? x1 - stop_x : stop_x - x1;
						int diff_sy = y1 > stop_y ? y1 - stop_y : stop_y - y1;

						int diff_dx = x2 > stop_x ? x2 - stop_x : stop_x - x2;
						int diff_dy = y2 > stop_y ? y2 - stop_y : stop_y - y2;

						if (diff_sx + diff_dx + diff_sy + diff_dy <= 1000) {
							mat[i][j] = 1;
							mat[j][i] = 1;
						}

						if (mat[i][k] == 1 && mat[k][j] == 1) {
							mat[i][j] = 1;
							mat[j][i] = 1;
						}
						if (mat[convenience + 1 - i][k] == 1 && mat[k][convenience + 1 - j] == 1) {
							mat[convenience + 1 - i][convenience + 1 - j] = 1;
							mat[convenience + 1 - j][convenience + 1 - i] = 1;
						}
					}
				}
			}

			if (mat[0][convenience + 1] == 1) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
		}
	}

}
