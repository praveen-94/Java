package concepts.advance.Generics;
import java.util.Arrays;

//We bound T to Number only, i.e. T can only be replaced by superclass, or subclasses of superclass.
class boundedNumberGeneric<T extends Number>
{ T[] num;  //num is an array of type T

  boundedNumberGeneric(T[] o)
  { num = o;  //Pass the constructor a reference to an array of type T.
    System.out.print("boundedNumberGeneric Object Created with Type '" + num.getClass().getSimpleName() + "' variable value: " + Arrays.toString(this.num));
  }

  double average()
  { double sum = 0.0;      //Return type double in all cases.
    for(T num : num)
      sum += num.doubleValue();
    return sum/num.length;
  }

  //Determine if two averages are the same. Notice the use of the WILDCARD(?)
  boolean sameAvg(boundedNumberGeneric<?> ob)
  { if(average() == ob.average())
      return true;
    return false;
  }
}

public class boundedGenericClass
{ public void boundedGenericClassMain()
  { Integer[] intNum = {1, 2, 3, 4, 5};
    boundedNumberGeneric<Integer> iob = new boundedNumberGeneric<Integer>(intNum);
    double v = iob.average();
    System.out.println(" and its average is " + v);

    Long[] LongNum = {1L, 2L, 3L, 4L, 5L};
    boundedNumberGeneric<Long> Lob = new boundedNumberGeneric<Long>(LongNum);
    double L = Lob.average();
    System.out.println(" and its average is " + L);

    Double[] doubleNum = {1.1, 2.2, 3.3, 4.4, 5.5};
    boundedNumberGeneric<Double> dob = new boundedNumberGeneric<Double>(doubleNum);
    double w = dob.average();
    System.out.println(" and its average is " + w);

    System.out.print("Averages of integerList and LongList are: ");      // See which arrays have same average.
    if (iob.sameAvg(Lob))
      System.out.println("same.");
    else
      System.out.println("differ.");

    System.out.print("Averages of integerList and doubleList are: ");     // See which arrays have same average.
    if (iob.sameAvg(dob))
      System.out.println("same.");
    else
      System.out.println("differ.");

    /*
    This won't compile because String is not a subclass of Number.
    String str[] = { "1", "2", "3", "4", "5" };
    boundedNumberGeneric<String> strObj = new boundedNumberGeneric<String>(str);
    double x = strObj.average();
    System.out.println("strObj average is " + v);
    */
  }
}
