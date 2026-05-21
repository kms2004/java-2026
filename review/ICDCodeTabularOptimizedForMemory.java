import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ICDCodeTabularOptimizedForMemory implements ICDCodeTabular {
  private Path path;

  public ICDCodeTabularOptimizedForMemory(Path path) {
    this.path = path;
  }

  @Override
  public String getDescription(String code) {
    try (
        Stream<String> lines = Files.lines(path)) {
      // pomijam od linii 0, kolejne 88 linji (do 87)
      return lines.skip(88).filter(s -> s.matches("[A-Z][0-9]{2}.*")).map(s -> s.split(" ", 2))
          .filter(strings -> strings[0].equals(code)).map(strings -> strings[1]).findFirst().orElse("?");
    }catch (IOException e){
      
    }
    return "?";
  }

}
