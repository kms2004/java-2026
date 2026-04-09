import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Family {
  Map<String, List<Person>> members = HashMap.newHashMap(2);

  void add(Person... people) {
    for (Person person : people) {
      String key = Family.key(person);
      if (this.members.containsKey(key)) {
        List<Person> old_list = this.members.get(key);
        old_list.add(person);
        old_list.sort(Person::compareTo);
      } else {
        List<Person> new_list = new ArrayList<Person>();
        new_list.add(person);
        this.members.put(key, new_list);
      }
    }
  }

  List<Person> get(String key) {
    return this.members.get(key);
  }

  static String key(Person person) {
    return String.format("%s-%s", person.getName(), person.getSurname());
  }
}
