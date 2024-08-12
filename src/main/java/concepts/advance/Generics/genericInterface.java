package concepts.advance.Generics;

interface Pair<K extends Number, V>
{ K getKey();
  V getValue();
}

class OrderedPair<K extends Number,V> implements Pair<K,V>
{ private K key;
  private V value;

  public OrderedPair(K key, V value)
  { this.key = key;
    this.value = value;
    System.out.print("Initialize Generic class 'OrderedPair' which implement generic interface 'Pair' `s key, value with Type: ");
    System.out.println(key.getClass().getSimpleName() + ", " + value.getClass().getSimpleName() + " respectively");
  }

  @Override
  public K getKey()
  { return key;
  }

  @Override
  public V getValue()
  { return value;
  }
}

public class genericInterface
{ public void genericInterfaceMain()
  { Pair<Integer, String> pair = new OrderedPair<>(1,"One");
    System.out.println("Key: " + pair.getKey() + ", Value: " + pair.getValue());

    Pair<Long, String> anotherPair = new OrderedPair<>(2L, "Two");
    System.out.println("Key: " + anotherPair.getKey() + ", Value: " + anotherPair.getValue());
  }
}
