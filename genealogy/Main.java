import java.io.IOException;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // Person person = Person.fromCsvLine("Anna Dąbrowska,07.02.1930,22.12.1991,Ewa
    // Kowalska,Marek Kowalski");
    // System.out.println(person.toString());
    try {
      List<Person> people = Person.fromCsv("../family.csv");
      for (Person person : people) {
        System.out.println(person);
      }
    } catch (IOException e) {
      System.err.println(e);
    } catch (NegativeLifespanException | AmbiguousPersonException e) {
      System.err.println(e);
    }
    // pre-CSV main
    // List<Person> people = new ArrayList<Person>();
    // people.add(new Person("Adam", "Kowalczyk", LocalDate.of(2000, 6, 9)));
    // people.add(new Person("Grzegorz", "Brzęczyszczykiewicz", LocalDate.of(1999,
    // 2, 1)));
    // people.add(new Person("Jan", "Kowalczyk", LocalDate.of(2005, 1, 1)));
    // people.add(new Person("Grzegorz", "Brzęczyszczykiewicz", LocalDate.of(2137,
    // 2, 1)));
    // {
    // Person parent = people.get(0);
    // Person child = people.get(1);
    // System.out.println(parent.adopt(child));
    // System.out.println(parent.adopt(child));
    // }
    // people.get(0).adopt(people.get(1));
    // people.get(0).adopt(people.get(2));
    // System.out.println(people.get(0).getYoungestChild());
    // System.out.println(people.get(0).getChildren());
    // Family family = new Family();
    // family.add(people.get(0), people.get(1), people.get(2),people.get(3));
    // System.out.println(family.get("Grzegorz-Brzęczyszczykiewicz"));
  }
}
