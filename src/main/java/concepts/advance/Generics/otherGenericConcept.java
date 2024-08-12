package concepts.advance.Generics;

/* Generic Class Hierarchies
    key difference between is that in a generic hierarchy, any type arguments needed by a generic superclass must be passed up the hierarchy by all subclasses.
    subclass of a generic superclass not need to be generic, but it still must specify the type parameter(s) required by its generic superclass.
*/

class Gen1<T>
{ T ob;
  Gen1(T o)
  { ob = o;
    System.out.println("Gen1 Constructor invoked");
  }

  T getTobj()
  { System.out.print("Gen1 'getTobj' method invoke, Gen1 'T ob' variable Type is '" + ob.getClass().getSimpleName() + "' and value: ");
    return ob;
  }
}

class Gen2<T> extends Gen1<T>  //type is passed to Gen2 (Gen2 not use type parameter T except to pass it to Gen superclass) will also be passed to Gen.
{ Gen2(T o)
  { super(o);
    System.out.println("Gen2 Constructor invoked");
   }

   @Override
   T getTobj()     //A method in a generic class can be overridden just like any other method.
   {  System.out.print("Gen2 'getTobj' method invoke, Gen2 not have any variable, Gen1 ob value: ");
      return ob;
   }
}

class Gen3<T, V> extends Gen1<T>  //subclass is free to add its own type parameters, if needed.
{ V ob2;
  Gen3(T o, V o2)
  { super(o);
    ob2 = o2;
    System.out.println("Gen3 Constructor invoked");
  }

  V getVobj()
  { System.out.print("Gen3 'getVobj' method invoke, Gen3 'V ob2' variable Type is '" + ob2.getClass().getSimpleName() + "' and value: " );
    return ob2;
  }
}

class NonGen1   //A Generic Subclass, It is perfectly acceptable for a non-generic class to be the superclass of a generic subclass.
{   int num;
    NonGen1(int i)
    {  num = i;
       System.out.println("NonGen1 Constructor invoked");
    }
    void getNum()
    { System.out.println("NonGen1 'getNum' method invoke, NonGen1 'int num' variable Type is 'int' and value: " + num);
    }
}

class NonGen2<S> extends NonGen1
{   S ob;
    NonGen2(S o, int i)
    {  super(i);
       ob = o;
       System.out.println("NonGen2 Constructor invoked");
    }

    S getSobj()
    {  System.out.print("NonGen2 'getSobj' method invoke, NonGen2 'T ob' variable Type is '" + ob.getClass().getSimpleName() + "' and value: ");
       return ob;
    }
}

public class otherGenericConcept
{ public void otherGenericConceptMain()
  { Gen1<String> w = new Gen1<String>("Gen");
    System.out.println(w.getTobj());
    Gen2<String> x = new Gen2<String>("Gen2");
    System.out.println(x.getTobj());
    Gen3<String, Integer> y = new Gen3<String, Integer>("Gen", 3);
    System.out.println(y.getVobj());
    NonGen2<String> z = new NonGen2<String>("NonGen", 2);
    System.out.print(z.getSobj());

/* Casting
  cast one instance of a generic class into another only if the two are otherwise compatible and
  their type arguments are the same.
  (Gen<Integer>) iOb2        // legal because iOb2 is an instance of Gen<Integer>
  (Gen<Long>) iOb2           // illegal is not legal because iOb2 is not an instance of Gen<Long>
*/

}
}
