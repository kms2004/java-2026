import java.io.IOException;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Person> people;
    try {
      // List<Person> people = Person.fromBinaryFile("../people.bin");
      people = Person.fromCsv("../family.csv");
    } catch (IOException e) {
      System.err.println(e);
    // } catch (ClassNotFoundException e) {
      System.err.println(e);
    } catch (NegativeLifespanException | AmbiguousPersonException e) {
      System.err.println(e);
    }
  }
}
