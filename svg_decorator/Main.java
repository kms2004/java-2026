import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TransformationDecorator triangle = new TransformationDecorator(new Polygon(new Vec2[]{
                new Vec2(0, 0),
                new Vec2(300, 0),
                new Vec2(150, 250)
        }), new Vec2(45, 105));

        SolidFillShapeDecorator rectangle =
                new SolidFillShapeDecorator(new Polygon(new Vec2[]{
                        new Vec2(350, 0),
                        new Vec2(750, 0),
                        new Vec2(750, 200),
                        new Vec2(350, 200)
                }), "blue");

        StrokeShapeDecorator pentagon = new StrokeShapeDecorator(
                new SolidFilledPolygon(new Vec2[]{
                        new Vec2(0, 260),
                        new Vec2(100, 460),
                        new Vec2(300, 560),
                        new Vec2(500, 460),
                        new Vec2(600, 260)
                }, "green"),
                "red", 12.0
        );

        StrokeShapeDecorator ellipse = new StrokeShapeDecorator(
                new SolidFillShapeDecorator(
                        new Ellipse(
                                new Vec2(500, 700),
                                400,
                                100),
                        "yellow"),
                "blue", 8
        );

        SvgScene scene = new SvgScene();
        scene.addShape(triangle);
        scene.addShape(rectangle);
        scene.addShape(pentagon);
        scene.addShape(ellipse);
        scene.save("../result.svg");
    }

}
