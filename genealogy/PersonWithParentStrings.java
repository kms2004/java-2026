import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PersonWithParentStrings {
  private Person person;
  private final String[] parents;

  public PersonWithParentStrings(Person person, String[] parents) {
    this.person = person;
    this.parents = parents;
  }

  public static PersonWithParentStrings fromCsvLine(String line) throws NegativeLifespanException {
    Person person = Person.fromCsvLine(line);
    String[] columns = line.split(",", -1);
    // index'ujemy za ostatni element (3 i 5 element to (3,6))
    return new PersonWithParentStrings(person, Arrays.copyOfRange(columns, 3, 6));
  }

  public String getFullname() {
    return this.person.getFullname();
  }

  public static void connectRelatives(Map<String, PersonWithParentStrings> people_map) {
    // List<Person> people = new HashSet();
    for (PersonWithParentStrings person : people_map.values()) {
      for (String parent : person.parents) {
        // zakładamy że rodzic istnieje
        if (people_map.containsKey(parent)) {
          people_map.get(parent).person.adopt(person.person);
        }
      }
    }
  }

  public static List<Person> unpackMap(Map<String, PersonWithParentStrings> people_map) {
    List<Person> people_list = new ArrayList<Person>();
    for (PersonWithParentStrings person : people_map.values()) {
      people_list.add(person.person);
    }
    return people_list;
  }

  String ambiguousPersonExceptionMessage(PersonWithParentStrings person) {
    return String.format("Least two people with names '%s' exist", this.getFullname());
  }

}
