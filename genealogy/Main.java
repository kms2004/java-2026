import java.io.IOException;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Person> people;
    try {
      // List<Person> people = Person.fromBinaryFile("../people.bin");
      people = Person.fromCsv("../family.csv");
      // for (Person person : Person.filterToDead(people)) {
      //   System.out.println(person);
      // }
      PlantUMLRunner.setJarPath(PlantUMLRunner.default_jar_path());
      PlantUMLRunner.generate(Person.generateTree(people), "../output", "test");
    } catch (IOException e) {
      System.err.println(e);
      // } catch (ClassNotFoundException e) {
      System.err.println(e);
    } catch (NegativeLifespanException | AmbiguousPersonException e) {
      System.err.println(e);

    }
  }
}
