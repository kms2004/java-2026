import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ICDCodeTabularOptimizedForTime implements ICDCodeTabular {
  private Map<String, String> codeDescriptionMap = new HashMap<>();

  public ICDCodeTabularOptimizedForTime(Path path) throws IOException {
    Stream<String> lines = Files.lines(path);
    lines.skip(88).filter(s -> s.matches("[A-Z][0-9]{2}.*")).map(s -> s.split(" ", 2))
        .forEach(s -> this.codeDescriptionMap.put(s[0], s[1]));
    lines.close();
  }

  @Override
  public String getDescription(String code) {
          this.codeDescriptionMap.filter(strings -> strings[0].equals(code)).map(strings -> strings[1]).findFirst().orElse("?");

}

}
