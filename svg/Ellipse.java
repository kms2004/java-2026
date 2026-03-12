public class Ellipse extends Shape {
  private Point center;
  private double rx;
  private double ry;

  Ellipse(Point center, double rx, double ry, Style style) {
    super(style);
    this.center = center;
    this.rx = rx;
    this.ry = ry;
  }

  @Override
  public String toSvg() {
    return String.format("<ellipse rx=\"%f\" ry=\"%f\" cx=\"%f\" cy=\"%f\" %s />", this.rx, this.ry, this.center.getX(),
        this.center.getY(), this.style.toSvg());
  }

  @Override
  public BoundingBox boundingBox() {
    return new BoundingBox(this.center.getX() - rx, this.center.getY() - ry, 2.0 * rx, 2.0 * ry);
  }

  @Override
  public Shape moved(Point d) {
    return new Ellipse(this.center.translated(d), this.rx, this.ry, this.style);
  }

  @Override
  public Shape moved(double dx, double dy) {
    return new Ellipse(this.center.translated(dx, dy), this.rx, this.ry, this.style);
  }

}
