public class StrokeShapeDecorator extends ShapeDecorator {
  private final String color;
  private final double width;

  public StrokeShapeDecorator(Shape shape, String color, double width) {
    super.decoratedShape = shape;
    this.color = color;
    this.width = width;
  }

  @Override
  public String toSvg() {
    return this.decoratedShape.toSvg().replace("/>",
        String.format(" stroke=\"%s\" stroke-width=\"%f\" />", this.color, this.width));
  }
}
