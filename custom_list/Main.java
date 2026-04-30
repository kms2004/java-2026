public class Main {
  public static void main(String[] args) {
    CustomList<String> list = new CustomList<String>();
    list.addFirst("test");
    list.addLast("test2");
    list.add("test3");
    list.addFirst("test4");
    // list.removeLast();
    // list.removeFirst();
    System.out.println(list.get(1));
    System.out.println(list.getLast());
    System.out.println(list.size());


    /// BARDZO ŹŁE !!!!
    // Używaj iteratora lub strumieni
    // for(int i=0;i<list.size();i++) {
    //   System.out.println(list.get(i));
    // }

    // Mając iterator można użyć tego zapisu
    // for (String s: list ) {
    //   System.out.println(s);
    // }

    list.stream().sorted().forEach(System.out::println);;
  }
  
}

