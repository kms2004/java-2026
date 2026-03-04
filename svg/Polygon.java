public class Polygon {
  private Point[] points;

  public Polygon(Point[] points) {
    // Point[] points2 = points.clone();
    this.points = new Point[points.length];
    for (int i = 0; i < points.length; i++) {
      this.points[i] = new Point(points[i]);
    }
  }

  /// Polygon only has points, thus only points need to be properly copied over.
  public Polygon(Polygon polygon) {
    this.points = new Point[polygon.points.length];
    for (int i = 0; i < polygon.points.length; i++) {
      this.points[i] = new Point(polygon.points[i]);
    }
  }

  public String toString() {
    String out = points[0].toString();
    for (int i = 1; i < this.points.length; i++) {
      out = out + "," + this.points[i].toString();
    }
    return out;
  }

  public String toSvg() {
    String out = String.format("<polygon points=\"%f,%f ", this.points[0].getX(), this.points[0].getY());
    for (int i = 1; i < this.points.length; i++) {
      out = out + " " + this.points[i].getX() + "," + this.points[i].getY();
    }
    return out + " style=\"fill:lime;stroke:purple;stroke-width:3\" />";
  }

  public BoundingBox boundingBox() {
    // find position of top left corner ()
    // x - -- +
    // y -
    // |
    // |
    // +
    // so lowest x, lowest y.
    // also highest x, highest x to calc width and height
    double cx = this.points[0].getX();
    double cy = this.points[0].getY();
    double dx = this.points[0].getX();
    double dy = this.points[0].getY();

    for (int i = 1; i < this.points.length; i++) {
      if (cx > this.points[i].getX()) {
        cx = this.points[i].getX();
      }
      if (cy > this.points[i].getY()) {
        cy = this.points[i].getY();
      }
      if (dx < this.points[i].getX()) {
        dx = this.points[i].getX();
      }
      if (dy < this.points[i].getY()) {
        dy = this.points[i].getY();
      }
    }
    return new BoundingBox(cx, cy, dx - cx, dy - cy);
  }

  // helper method
  public Polygon moved(double dx, double dy) {
    Polygon n = new Polygon(this);
    for (int i = 0; i < n.points.length; i++) {
      n.points[i] = this.points[i].translated(dx, dy);
    }
    return n;
  }
}
