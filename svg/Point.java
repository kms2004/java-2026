public class Point {
  public double x;
  public double y;
  public String toString() {
    return String.format("(%f,%f)",this.x,this.y);
  }
  public String toSvg() {
    return String.format("<svg height=\"%f\" width=\"%f\"><circle r=\"100\" cx=\"50\" cy=\"50\" /></svg>");
  }
  public void translate(double dx, double dy) {
    this.x+=dx;
    this.y+=dy;
  }
  public Point translated(double dx,double dy) {
    Point p = new Point();
    p.x=this.x+dx;
    p.y=this.y+dy;
    return p;
  }
}
