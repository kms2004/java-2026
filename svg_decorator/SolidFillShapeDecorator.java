public class SolidFillShapeDecorator extends ShapeDecorator {
  String color;

  public SolidFillShapeDecorator(Shape shape, String color) {
    super.decoratedShape = shape;
    this.color = color;
  }

  @Override
  public String toSvg() {
    return this.decoratedShape.toSvg().replace("/>", String.format("fill=\"%s\" />", this.color));
  }
}
