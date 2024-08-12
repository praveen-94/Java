package concepts.advance.Generics;
import java.lang.Double;
import java.util.Arrays;
/*
static <T, V extends T> boolean isIn(T x, V[] y) {}
   First: The type parameters are declared before the return type of the method.
   Second:  notice that the type V is upper-bounded by T. V must type same as T, or a subclass of T.
isIn() is static, enabling it to be called independently of any object.
generic methods can be either static or non-static. There is no restriction in this regard.
 */
//It is also possible for constructors to be generic, even if their class is not.

class GenCons
{ private double val;
  <T extends Number> GenCons(T arg)
  { val = arg.doubleValue();
    System.out.println("Calling a bounded generic constructor which accept only Number type parameter.......");
    System.out.println("initialize 'private double val' variable of Non-Generic class 'GenCons' with receive value of Type '" + arg.getClass().getSimpleName() + "' and value: " + arg + ", after converting it into double type: " + val);
  }
}

public class genericMethod
{  static <T, V extends T> boolean isIn(T x, V[] y)   // Determine if an object is present in an array.
   { System.out.println("Calling a static bounded generic method which accept two parameter of Type T and V with upperBound T (V extends T) .......");
     System.out.print("Checking " + x + " is present or not in array " + Arrays.toString(y) + ": ");

     for(V v : y)
      if(x.equals(v))
        return true;
     return false;
   }

   public void genericMethodMain()
   { GenCons test1 = new GenCons(100);
     GenCons test2 = new GenCons(123.5F);

     Double[] nums1 = {1.0, 2.0, 3.0, 4.0, 5.0};            // Use isIn() on Integers.
     Number[] nums2 = {1, 2.0, 30.00, 4, 5};
     Double dob = 2.0;
     Integer Iob = 2;
     if(isIn(Iob, nums1))
       System.out.println("Present");
     else
       System.out.println("absent");

     if(isIn(dob, nums1))
       System.out.println("Present");
     else
       System.out.println("absent");

     if(isIn(Iob, nums2))
       System.out.println("Present");
     else
       System.out.println("absent");

     if(isIn(dob, nums2))
       System.out.println("Present");
     else
       System.out.println("absent");

     String[] strs = {"one", "two", "three", "four", "five"};       // Use isIn() on Strings.
     if(isIn("two", strs))
       System.out.println("Present");
     else
       System.out.println("absent");
     /*
     this part is not work because 'two' is not a member of subclass of Number
     if(isIn("two", nums))
      System.out.println("two is in nums");
      */
   }
}

