public class AmbiguousPersonException extends Exception {
  final Person person1;
  final Person person2;

  AmbiguousPersonException(Person person1, Person person2) {
    this.person1 = person1;
    this.person2 = person2;
  }

  @Override
  public String getMessage() {
    return person1.ambiguousPersonExceptionMessage(person2);
  }
}
