import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DeathCauseStatisticList {
  private List<DeathCauseStatistic> causes = new ArrayList<DeathCauseStatistic>();

  private DeathCauseStatisticList(List<DeathCauseStatistic> list) {
    this.causes = list;
  }

  public static DeathCauseStatisticList fromCsv(Path path) throws IOException, IOError {
    BufferedReader file = new BufferedReader(new FileReader(path.toString()));
    // file.lines().skip(1).forEach((String line) ->
    // this.causes.add(DeathCauseStatistic.fromCsvLine(line)));
    // Pomijamy nagłówki oraz wartość OGÓŁEM
    List<DeathCauseStatistic> list = file.lines().skip(2).map((String line) -> DeathCauseStatistic.fromCsvLine(line)).toList();
    file.close();
    return new DeathCauseStatisticList(list);
  };

  public int length() {
    return this.causes.size();
  }

  public List<DeathCauseStatistic> mostDeadlyDiseases(int age, int n) {
    DeathCauseStatistic.Range rg = new DeathCauseStatistic.Range(Math.floorDiv(age, 5) * 5,
        Math.floorDiv(age, 5) * 5 + 4);
    return this.causes.stream()
        .sorted((DeathCauseStatistic s1, DeathCauseStatistic s2) -> {
          return s2.getAgeRange(rg).deathCount() - s1.getAgeRange(rg).deathCount();
        }).limit(n).toList();
    
  }
}
