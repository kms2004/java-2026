import java.io.FileWriter;
import java.io.IOException;

public class SvgScene {
  private Shape[] shapes;
  private int shape_count;

  public SvgScene() {
    this.shapes = new Shape[3];
    this.shape_count = 0;
  }

  public void addPolygon(Shape shape) {
    this.shapes[this.shape_count % 3] = shape;
    this.shape_count += 1;
  }

  public String toSvg() {
    String out = "";
    for (int i = 0; i < java.lang.Math.min(this.shape_count, 3); i++) {
      out += this.shapes[i].toSvg();
    }
    return out;
  }

  public void save(String filepath) {
    /// save polygons into a single svg,
    // width and height have to be derived from boundingboxes
    // HAS to start at (0,0)... what about polygons outside that? They still have to
    // fit, so gotta move them.
    // Gotta find the offset required to move all polygons into positive quadrant
    // and then move each by it.
    // Gotta find the lowest values... bounding box corner is the lowest for each
    // polygon.
    // Remember than polygon count is between 0 and 3
    double move_x, move_y, width, height;
    move_x = 0.0;
    move_y = 0.0;
    width = 0.0;
    height = 0.0;

    if (shape_count != 0) {
      for (int i = 0; i < java.lang.Math.min(this.shape_count, 3); i++) {
        BoundingBox temp = this.shapes[i].boundingBox();
        if (move_x > temp.x()) {
          move_x = temp.x();
        }
        System.out.println("y " + temp.y());
        if (move_y > temp.y()) {
          move_y = temp.y();
        }
        // cannot define width and height yet, gotta have the actual move vector
      }
      System.out.println("test " + move_y);
      for (int i = 0; i < java.lang.Math.min(this.shape_count, 3); i++) {
        // check for MOVED values
        BoundingBox temp = this.shapes[i].boundingBox();
        if (width < temp.w() + temp.x() - move_x) {
          width = temp.w() + temp.x() - move_x;
        }
        if (height < temp.h() + temp.y() - move_y) {
          height = temp.h() + temp.y() - move_y;
        }
      }
    }
    String out = String.format("<svg width=\"%d\" height=\"%d\" xmlns=\"http://www.w3.org/2000/svg\">", (int) width,
        (int) height);
    for (int i = 0; i < java.lang.Math.min(this.shape_count, 3); i++) {
      // defined a helper method
      out += this.shapes[i].moved(-move_x, -move_y).toSvg();
    }
    out = out + "</svg>";
    // out = String.format("<!DOCTYPE html><html><body>%s</body></html>",out);
    try {
      FileWriter writer = new FileWriter(filepath);
      writer.write(out);
      writer.close();

    } catch (IOException e) {
      System.out.println("Error during writing the file");
      e.printStackTrace();
    }

  }
}
