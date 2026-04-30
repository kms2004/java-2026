import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PlantUMLRunner {
  private static String jarPath;

  public static String default_jar_path() {
    return "/usr/share/java/plantuml/plantuml.jar";
  }

  public static void setJarPath(String path) {
    jarPath = path;
  }

  

   public static void generate(String data, String outputPath, String fileName){
        File directory = new File(outputPath);
        directory.mkdirs();
        File file = new File(outputPath + "/" + fileName);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(data);
            writer.close();
            ProcessBuilder builder = new ProcessBuilder("java", "-jar", jarPath, file.getPath());
            builder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
  
}
