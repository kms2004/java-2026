public class Segment {
  public Point p1;
  public Point p2;
  public double lenght() {
    return Math.sqrt(Math.pow(this.p1.x-this.p2.x,2.0)+Math.pow(this.p1.y-this.p2.y,2.0));
  }
  public Segment longest(Segment[] segments) {
    double longest_length = 0.0;
    int longest_index = 0;
    for(int i=0; i< segments.length;i++){
      if(segments[i].lenght()>longest_length){
        longest_length=segments[i].lenght();
        longest_index=i;
      }
    }
    return segments[longest_index];
  }
}
