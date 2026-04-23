public class AmbiguousPersonException extends Exception {
  final PersonWithParentStrings person1;
  final PersonWithParentStrings person2;

  AmbiguousPersonException(PersonWithParentStrings person1, PersonWithParentStrings person2) {
    this.person1 = person1;
    this.person2 = person2;
  }

  @Override
  public String getMessage() {
    return person1.ambiguousPersonExceptionMessage(person2);
  }
}
