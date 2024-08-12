package concepts.advance.Generics;

class student
{ private int id;
  private String name;

  public student(int id, String name)
  { this.id = id;
    this.name = name;
  }

  @Override
  public String toString()
  { return "student ID: " + id + ",  student name: " + name;
  }
}

class Gen<T>
{ T ob;   // declare an object of type T

  Gen(T o) // Pass the constructor a reference to an object of type T.
  { ob = o;
    System.out.print("Gen Object Created with Type '" + ob.getClass().getSimpleName() + "' variable value: ");
  }

  Gen()  // Pass the constructor a reference to an object of type T.
  { System.out.print("Gen Object Created with Type and variable value: ");
  }

   T getOb()  // Return ob.
   { return ob;
   }
}

public class genericClass
{  public void genericClassMain()
   {  System.out.println("Creating class with integer data type from Generics class...... ");
      Gen<Integer> iOb;     // Create a Gen reference for Integers.
      iOb = new Gen<Integer>(88);        //Notice the use of autoboxing to encapsulate the value 88  within an Integer object.
      int v = iOb.getOb();       // Get the value in iOb. Notice that no cast is needed.
      System.out.println(v);
      System.out.println();

      System.out.println("Creating class with Character data type from Generics class...... ");
      Gen<Character> CharOb = new Gen<Character>('S');
      char c = CharOb.getOb();
      System.out.println(c);
      System.out.println();

      System.out.println("Creating class with String data type from Generics class...... ");
      Gen<String> strOb = new Gen<String>("Generics Test");     // Create a Gen object for Strings.
      String str = strOb.getOb();      // Get the value of strOb. Again, notice that no cast is needed
      System.out.println(str);
      System.out.println();

      System.out.println("Creating class with student(class) data type from Generics class...... ");
      student s1 = new student(1001, "PS");
      Gen<student> stdOb = new Gen<>(s1);
      student s2 = stdOb.getOb();
      System.out.println(s2.toString());
      Gen<student> stdOb2 = new Gen<>();
      System.out.print(stdOb2.getClass().getSimpleName() + ", ");
      student s3 = new student(1002, "SP");
      student s4 = stdOb2.getOb();
      System.out.println(s4 + " respectively");
   }
}
