public class Style {
  public final String fillColor;
  public final String strokeColor;
  public final Double strokeWidth;

  Style() {
    this.fillColor = "none";
    this.strokeColor = "black";
    this.strokeWidth = 1.0;
  }

  Style(String fillColor, String strokeColor, Double strokeWidth) {
    this.fillColor = fillColor;
    this.strokeColor = strokeColor;
    this.strokeWidth = strokeWidth;
  }

  public String toSvg() {
    return java.lang.String.format("style=\"fill:%s;stroke:%s;stroke-width:%f;\"", this.fillColor, this.strokeColor,
        this.strokeWidth);
  }
}
