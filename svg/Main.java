public class Main {
  public static void main(String[] args) {
    Point p1 = new Point();
    Point p2 = new Point(5.0, 5.0);
    Segment s1 = new Segment(p1, p2);
    System.out.println(s1.toString());
    p1.setX(100.0);
    p2.setX(-100.0);
    System.out.println(s1.toString());
    Point p3 = new Point(0.0, 200.0);
    Point[] points = { p1, p2, p3 };
    Polygon pol1 = new Polygon(points);
    System.out.println(pol1.toSvg());
    SvgScene scene = new SvgScene();
    // for (int i = 0; i < 3; i++) {
    //   points[i] = points[i].translated(-200.0, 50.0);
    // }
    // Polygon pol2 = new Polygon(points);
    // for (int i = 0; i < 3; i++) {
    //   points[i].inverse();;
    // }
    Segment s2 = new Segment(new Point(100.0,0.0),new Point(200.0,100.0));
    Polygon pol2 = Polygon.square(s2,new Style("red", "black", 1.0));
    System.out.print(pol2.toString());
    // Segment s3 = new Segment(new Point(-200.0,200.0),new Point(-200.0,100.0));
    // Polygon pol3 = Polygon.square(s3,new Style("lime", "black", 1.0));
    scene.addPolygon(pol1);
    scene.addPolygon(pol2);
    scene.addPolygon(new Ellipse(new Point(-100.0,-100.0), 150.0, 50.0, new Style()));
    scene.save("../test.svg");
  }
}
