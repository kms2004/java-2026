public class Segment {
  private Point p1;
  private Point p2;

  public double lenght() {
    return Math.sqrt(Math.pow(this.p1.getX() - this.p2.getX(), 2.0) + Math.pow(this.p1.getY() - this.p2.getY(), 2.0));
  }

  public Segment longest(Segment[] segments) {
    double longest_length = 0.0;
    int longest_index = 0;
    for (int i = 0; i < segments.length; i++) {
      if (segments[i].lenght() > longest_length) {
        longest_length = segments[i].lenght();
        longest_index = i;
      }
    }
    return segments[longest_index];
  }
  public String toString() {
    return String.format("(%s,%s)", this.p1.toString(),this.p2.toString());
  }
  
  Segment(Point p1,Point p2) {
    this.p1=new Point(p1);
    this.p2=new Point(p2);
  }
}
