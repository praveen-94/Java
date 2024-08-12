package concepts.advance.Generics;
import java.util.Arrays;
/*
-----------------------------------------------------------------------------------------------------------------------------------------------------
To implemented generic interface, you must specify type arguments: class className<typeParamList> implements interfaceName<typeArgList>{}
The generic interface offers two benefits.
  1)it can be implemented for different types of data.
  2)put constraints (that is, bounds) on the types of data or interface for which the interface can be implemented.
------------------------------------------------------------------------------------------------------------------------------------------------------
Type parameter is T, and its upper bound is Comparable, which is an interface defined by java.lang.
A class that implements Comparable defines objects that can be ordered.
Thus, requiring an upper bound of Comparable ensures that MinMax can be used only with objects that are capable of being compared.
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
interface MinMax<T extends Comparable<T>>
{ T min();
  T max();
}

class MyClass<T extends Comparable<T>> implements MinMax<T>
{ T[] vals;
  MyClass(T[] o)
  { vals = o;
    System.out.println("Initialize parameter 'T[] vals' of Generic class 'MyClass' which implement generic interface bounded by Comparable interface 'MinMax' with:" );
    System.out.print("T Type: " + vals.getClass().getSimpleName() + ", values: " + Arrays.toString(vals));
  }
  public T min()
  { T v = vals[0];
    for(int i=1; i < vals.length; i++)
      if(vals[i].compareTo(v) < 0)
        v = vals[i];
     return v;
    }

  public T max()
  { T v = vals[0];
    for(int i=1; i < vals.length; i++)
      if(vals[i].compareTo(v) > 0)
        v = vals[i];
    return v;
  }
}

public class boundedGenericInterface
{ public void boundedGenericInterfaceMain()
  { Integer[] inums = {3, 6, 2, 8, 6 };
    Character[] chs = {'b', 'r', 'p', 'w' };
    String[] srt= {"hello", "and","welcome","to","java","world" };

    MyClass<Integer> iob = new MyClass<Integer>(inums);
    System.out.println(", Max value: " + iob.max() + ", Min value: " + iob.min());
    MyClass<Character> cob = new MyClass<Character>(chs);
    System.out.println(", Max value: " + cob.max() + ", Min value: " + cob.min());
    MyClass<String> sob = new MyClass<String>(srt);
    System.out.println(", Max value: " + sob.max() + ", Min value: " + sob.min());
  }
}



