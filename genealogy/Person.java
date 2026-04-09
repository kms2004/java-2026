import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Person implements Comparable<Person> {
  private final String name;
  private final String surname;
  private final LocalDate birthdate;
  private final LocalDate death;
  // referencja jest finalna, nie Set
  private final Set<Person> children = new HashSet<>();

  public Person(String name, String surname, LocalDate birthdate, LocalDate death) throws NegativeLifespanException {
    this.name = name;
    this.surname = surname;
    this.birthdate = birthdate;
    this.death = death;
    // if statement has a direction, if first condition fails on AND, second one
    // isn't checked.
    if (this.death != null && this.birthdate.isAfter(this.death)) {
      throw new NegativeLifespanException(this);
    }
    // }
  }

  public Person(String name, String surname, LocalDate birthdate) throws NegativeLifespanException {
    this(name, surname, birthdate, null);
  }

  public static Person fromCsvLine(String line) throws NegativeLifespanException {
    DateTimeFormatter date_parser = DateTimeFormatter.ofPattern("d.M.y");
    // apparently without limit -1, trims empty string at the end
    String[] columns = line.split(",", -1);
    String[] fullname = columns[0].split(" ");
    String name = fullname[0];
    String surname = fullname[1];
    LocalDate birthdate = LocalDate.parse(columns[1], date_parser);
    // LocalDate death;
    // if (columns[2] == "") {
    // death = null;
    // } else {
    // death = LocalDate.parse(columns[2], date_parser);
    // }
    try {
      return new Person(name, surname, birthdate, LocalDate.parse(columns[2], date_parser));
    } catch (DateTimeParseException ignored) {
      return new Person(name, surname, birthdate, null);
    }
  }

  public static List<Person> fromCsv(String filepath) throws IOException, NegativeLifespanException, AmbiguousPersonException{
    List<Person> people = new ArrayList<Person>();
    BufferedReader file = new BufferedReader(new FileReader(filepath));
    // FileReader f = new FileReader(filepath);
    // read the headers line
    file.readLine();
    String line;
    // what a nice syntax
    while ((line = file.readLine()) != null) {
      // calling static method without class it belongs to while call is within that
      // class... lovely...
      try {
        Person new_person = fromCsvLine(line);
        for(Person person: people) {
          if (person.name.equals(new_person.name)&&person.surname.equals(new_person.surname)) {
            throw new AmbiguousPersonException(person,new_person);
          }
        }
        people.add(new_person);
      } catch (NegativeLifespanException e) {
        System.err.println(e);
      }
    }
    file.close();
    return people;

  }

  String negativeLifespanExceptionMessage() {
    return String.format("Person '%s %s' has death date %s earlier than birth date %s", this.name, this.surname,
        this.death, this.birthdate);
  }

  String ambiguousPersonExceptionMessage(Person person) {
    return String.format("Least two people with names '%s %s' exist",this.name,this.surname);
  }

  public String getName() {
    return this.name;
  }

  public String getSurname() {
    return this.surname;
  }

  public String getFullname() {
    return String.format("%s %s",this.name,this.surname);
  }

  boolean adopt(Person child) {
    return this.children.add(child);
  }

  // Moje pierwsze rozwiązanie
  // Person getYoungestChild() {
  // if (this.children.isEmpty()) {
  // return null;
  // }
  // Iterator<Person> iter = this.children.iterator();
  // Person youngest = iter.next();
  // Person now = youngest;
  // while (true) {
  // if (youngest.compareTo(now) > 0) {
  // youngest = now;
  // }
  // try {
  // now = iter.next();
  // } catch (NoSuchElementException e) {
  // break;
  // }
  // }
  // return youngest;
  // }

  // drugie rozwiązanie, nie używa try catch
  Person getYoungestChild() {
    if (this.children.isEmpty()) {
      return null;
    }
    Iterator<Person> iter = this.children.iterator();
    Person youngest = iter.next();
    Person now = youngest;
    while (true) {
      if (youngest.compareTo(now) > 0) {
        youngest = now;
      }
      if (iter.hasNext()) {
        now = iter.next();
      } else {
        break;
      }
    }
    return youngest;
  }

  // Rozwiązanie dr Dmitruka, nie wprowadza try catch, ale porównuje pierwszą
  // osobę
  // public Person getYoungestChild() {
  // if (this.children.isEmpty()) {
  // return null;
  // }
  // Person youngest = this.children.iterator().next();
  // for(Person person: children) {
  // if (youngest.compareTo(person)>0) {
  // youngest= person;
  // }
  // }
  // return youngest;
  // }

  public String toString() {
    return String.format("Person{name=%s surname=%s birthdate=%s death=%s children=%s}", this.name, this.surname,
        this.birthdate, this.death, this.children);
  }

  public LocalDate getBirthdate() {
    return birthdate;
  }

  public LocalDate getDeath() {
    return death;
  }

  @Override
  public int compareTo(Person arg0) {
    return this.birthdate.compareTo(arg0.birthdate);
  }

  public List<Person> getChildren() {
    List<Person> children = new ArrayList<Person>(this.children);
    // List<Person> children = new ArrayList<Person>();
    children.sort(Person::compareTo);
    return children;
  }
}
