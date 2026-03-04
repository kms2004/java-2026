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
    for (int i = 0; i < 3; i++) {
      points[i] = points[i].translated(-200.0, 50.0);
    }
    Polygon pol2 = new Polygon(points);
    for (int i = 0; i < 3; i++) {
      points[i].inverse();;
    }
    Polygon pol3 = new Polygon(points);
    scene.addPolygon(pol1);
    scene.addPolygon(pol2);
    scene.addPolygon(pol3);
    scene.save("../test.svg");
  }
}
