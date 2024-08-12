package concepts.advance.Generics;
import java.util.Scanner;

public class genericsRun
{ public static void GenericsRunMain()
  { Scanner in = new Scanner(System.in);
    int choice;
    String str = """
    
    Choose programme:
    -------------------------------------
    | 1) Generics Creation
    -------------------------------------
    | 2) Bounded Generics
    -------------------------------------
    | 3) Bounded WildCard
    -------------------------------------
    | 4) Bounded Generic Method
    -------------------------------------
    | 5) Generic Interface
    -------------------------------------
    | 6) Bounded Generic Interface
    -------------------------------------
    | 7) Raw Type
    -------------------------------------
    | 8) Other Concept
    -------------------------------------
    Enter your choice or press 0 for main manu:\s""";
    do
    { System.out.print(str);
      choice = in.nextInt();
      if(choice==1)
      { System.out.println("Running 1st programme which create a generic class and implement it with different data types..........");
        new genericClass().genericClassMain();
      }
      else if(choice==2)
      { System.out.println("Running 2nd programme which create a bounded generic class, which uses wildcards(?)..........");
        new boundedGenericClass().boundedGenericClassMain();
      }
      else if(choice==3)
      { System.out.println("Running 3rd programme which create a bounded generic class, which uses bounded wildcards(?)..........");
        new boundedWildcardGenericClass().boundedWildcardGenericClassMain();
      }
      else if(choice==4)
      { System.out.println("Running 4th programme which create and execute two bounded generic methods..........");
        new genericMethod().genericMethodMain();
      }
      else if(choice==5)
      { System.out.println("Running 5th programme which show working of generic interface bounded by a Type ..........");
        new genericInterface().genericInterfaceMain();
      }
      else if(choice==6)
      { System.out.println("Running 6th programme which show working of bounded generic interface bounded by a Interface ..........");
        new boundedGenericInterface().boundedGenericInterfaceMain();
      }
      else if(choice==7)
      { System.out.println("Running 7th programme which show working of raw Type ..........");
        new rawType().rawTypeMain();
      }
      else if(choice==8)
      { System.out.println("Running 8th programme which show working of other generic concept..........");
        new otherGenericConcept().otherGenericConceptMain();
      }
    }while(choice!=0);
}
}
