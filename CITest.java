class Point{
  int x;
  int y;
  public Point() {
    this.x = 0;
    this.y = 0;
  }

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

}

public class CITest {
  public static void main(String args[]) {
    Point p = null;
    int i = 0;
    if (i == 0) {
      p.getX();
    }
  }
}
