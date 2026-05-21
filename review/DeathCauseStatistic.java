import java.util.HashMap;
import java.util.Map;

public class DeathCauseStatistic {
  private final String code;
  private Map<Range, Integer> deaths = new HashMap<>();

  public static record Range(int begin, int end) {
  };

  public static record AgeBracketDeaths(int begin, int end, int deathCount) {
  };

  /// Uczynić prywatnym, jeżeli ma być wywołany jedynie przez metody wytwórcze
  private DeathCauseStatistic(String code) {
    this.code = code;
  }

  public AgeBracketDeaths getAge(int age) {
    Range temp = new Range(Math.floorDiv(age, 5) * 5, Math.floorDiv(age, 5) * 5 + 4);
    return new AgeBracketDeaths(temp.begin, temp.end, deaths.get(temp));
  }

  public AgeBracketDeaths getAgeRange(Range range) {
    return new AgeBracketDeaths(range.begin, range.end, deaths.get(range));
  }

  // Metoda wytwórcza
  public static DeathCauseStatistic fromCsvLine(String line) {
    String[] data = line.split(",");
    // Zakładamy poprawność, nie trzeba tego robić o ile nie jest jawnie w treści
    // Może być to konieczne ze względu na wywołanie wyjątku.
    DeathCauseStatistic dcs = new DeathCauseStatistic(data[0]);
    int begin = 0;
    int end = 4;
    int number;
    for (int i = 2; i < data.length; i++) {
      try {
        number = Integer.valueOf(data[i]);
      } catch (NumberFormatException e) {
        number = 0;
      }
      dcs.deaths.put(new Range(begin, end), number);
      begin += 5;
      end += 5;
    }
    return dcs;
  }

  public String getCode() {
    return this.code;
  }

  public static void printData (DeathCauseStatistic data) {
    System.out.println(data.code);
  } 

}
