// RuntimeException also exists... has differences doesn't seem to require 'throws' and just kills the process
public class NegativeLifespanException extends Exception {
  // @Override
  // public String getMessage() {
  //   return "birthdate cannot be later than death";
  // }
  public NegativeLifespanException(Person person) {
   super(person.negativeLifespanExceptionMessage());
  }
}
