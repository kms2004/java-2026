import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class CustomList<T> extends AbstractList<T> {
  private Node<T> head;
  private Node<T> tail;

  CustomList() {

  }

  public void addLast(T value) {
    if (head == null) {
      head = new Node<T>(value);
      tail = head;
    } else {
      tail.next = new Node<T>(value);
      tail = tail.next;
    }
  }

  public T getLast() throws NoSuchElementException {

    if (tail == null) {
      throw new NoSuchElementException();
    } else {
      return tail.value;
    }
  }

  public void addFirst(T value) {
    if (head == null) {
      head = new Node<T>(value);
      tail = head;
    } else {
      Node<T> second = head;
      head = new Node<T>(value);
      head.next = second;
    }
  }

  public T getFirst() throws NoSuchElementException {
    if (head == null) {
      throw new NoSuchElementException();
    } else {
      return head.value;
    }
  }

  public T removeFirst() throws NoSuchElementException {
    if (head == null) {
      throw new NoSuchElementException();
    } else if (head == tail) {
      T ret = head.value;
      head = null;
      tail = null;
      return ret;
    } else {
      T ret = head.value;
      head = head.next;
      return ret;
    }
  }

  public T removeLast() throws NoSuchElementException {
    if (tail == null) {
      throw new NoSuchElementException();
    } else if (tail == head) {
      T ret = tail.value;
      head = null;
      tail = null;
      return ret;
    }
    T ret = tail.value;
    Node<T> walker = head;
    while (walker.next != tail) {
      walker = walker.next;
    }
    walker.next = null;
    tail = walker;
    return ret;
  }

  @Override
  public int size() {
    if (head == null) {
      return 0;
    }
    int a = 1;
    Node<T> current = head;
    while (current.next != null) {
      current = current.next;
      a += 1;
    }
    return a;
  }

  @Override
  public T get(int i) {
    if (head == null) {
      return null;
    } else {
      Node<T> current = head;
      for (int j = 0; j < i; j++) {
        if (current.next == null) {
          return null;
        } else {
          current = current.next;
        }
      }
      return current.value;
    }
  }

  @Override
  public boolean add(T value) {
    addLast(value);
    return true;
  }

  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private Node<T> current = head;

      @Override
      public boolean hasNext() {
        return current.next != null;
      }

      @Override
      public T next() {
        /// najwyraźniej zwraca aktualny wyraz i wykonuje krok dalej
        T value = current.value;
        current = current.next;
        return value;
      }
    };
  }

  @Override
  public Stream<T> stream() {
    Stream.Builder<T> builder = Stream.builder();
    for (T value : this) {
      builder.accept(value);
    }
    return builder.build();
  }
}
