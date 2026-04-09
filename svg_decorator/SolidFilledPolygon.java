public class SolidFilledPolygon extends Polygon {
  private String color;

  public SolidFilledPolygon(Vec2[] points, String color) {
    super(points);
    this.color = color;
  }

  @Override
  public String toSvg() {
    return super.toSvg().replace("/>", String.format(" fill=\"%s\" />", this.color));
  }
}
