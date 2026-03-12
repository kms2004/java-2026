public abstract class Shape {
  protected Style style;

  public Shape(Style style) {
    this.style = style;
  }

  public abstract String toSvg();

  public abstract BoundingBox boundingBox();

  public abstract Shape moved(double dx, double dy);

  public abstract Shape moved(Point d);
}
