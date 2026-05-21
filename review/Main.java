import java.io.IOError;
import java.io.IOException;
import java.nio.file.Path;

public class Main {
  public static void main() {
    try {
      DeathCauseStatisticList dcsl;
      dcsl = DeathCauseStatisticList.fromCsv(Path.of("zgony.csv"));
      dcsl.mostDeadlyDiseases(20, 10).stream().forEach(DeathCauseStatistic::printData);
      ICDCodeTabular tabular = new ICDCodeTabularOptimizedForMemory(Path.of("icd10.txt"));
      System.out.println(tabular.getDescription("R99"));
    } catch (IOError | IOException e) {

    }
  }
}
