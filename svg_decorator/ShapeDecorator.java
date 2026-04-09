public class ShapeDecorator implements Shape {
  Shape decoratedShape;

  public ShapeDecorator(Shape decoratedShape) {
    this.decoratedShape = decoratedShape;
  }

  @Override
  public String toSvg() {
    return this.decoratedShape.toSvg();
  }

  @Override
  public BoundingBox boundingBox() {
    return this.decoratedShape.boundingBox();
  }

}
