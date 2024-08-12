package concepts.advance.Generics;

/*
Raw Types and Legacy Code
 Pre-generics code must be able to work with generics, and generic code must be able to work with pre-generic code.
 We create a raw type for the class. This raw type is compatible with legacy code, which has no knowledge of generics.
 The main drawback to using the raw type is that the type safety of generics is lost.
*/

public class rawType
{ public void rawTypeMain()
  { Gen rawInt = new Gen<Integer>(88);
    System.out.println(rawInt.getOb());
    Gen rawStr = new Gen("Generics Test");
    System.out.println(rawStr.getOb());
    Gen rawDouble = new Gen(98.6);      // Create a raw-type Gen object and give it a Double value.
    System.out.println(rawDouble.getOb());
    double d = (Double) rawDouble.getOb();         // Cast here is necessary because type is unknown.
    System.out.println("After casting raw Type to Double: " + d);

       /*The use of a raw type can lead to run-time exceptions. Here are some examples.
       int i = (Integer) raw.getOb();     // run-time error
       strOb = raw;     // OK, but potentially wrong
       String str = strOb.getOb();        // run-time error
       raw = iOb;         // OK, but potentially wrong
       d = (Double) raw.getOb();      // run-time error
       */
  }
}
