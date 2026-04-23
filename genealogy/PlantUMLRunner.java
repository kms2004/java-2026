import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlantUMLRunner {
  private String jar_path;

  public static String default_jar_path() {
    return "/usr/share/java/plantuml/plantuml.jar";
  }

  public void setJarPath(String path) {
    jar_path = path;
  }

  public String generateTree(List<Person> people) {
    Set<Person> objects = new HashSet<>();
    for (Person person : people) {
      objects.add(person);
      objects.addAll(person.getChildren());
    }
    StringBuffer ret = new StringBuffer();
    return ret.toString();
  }

  public void generate(List<Person> people, String output_file) throws IOException {
    BufferedWriter file = new BufferedWriter(new FileWriter(output_file));
    file.write(generateTree(people));
    file.close();
  }
}
