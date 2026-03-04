public class Point {
  private double x;
  private double y;

  public String toString() {
    return String.format("(%f,%f)", this.x, this.y);
  }

  public String toSvg() {
    return String.format("<svg height=\"%f\" width=\"%f\"><circle r=\"100\" cx=\"50\" cy=\"50\" /></svg>", this.x,
        this.y);
  }

  public void translate(double dx, double dy) {
    this.x += dx;
    this.y += dy;
  }

  public Point translated(double dx, double dy) {
    Point p = new Point();
    p.x = this.x + dx;
    p.y = this.y + dy;
    return p;
  }

  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public Point() {
    this.x = 0.0;
    this.y = 0.0;
  }

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public Point(Point r) {
    this.x = r.x;
    this.y = r.y;
  }

  public void inverse() {
    this.x = -this.x;
    this.y = -this.y;
  }
}
