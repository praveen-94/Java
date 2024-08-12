package concepts.advance;
import java.util.Scanner;
import concepts.advance.Generics.*;

public class Main
{ public static void main(String[] args)
  { Scanner in = new Scanner(System.in);
    int choice;
    String str = """
    
    Choose Topic from below List:
    -------------------------------------
    | 1) Generics
    -------------------------------------
    | 2) Collection
    -------------------------------------
    Enter your choice or press 0 to exit:\s""";

    do
    { System.out.print(str);
      choice = in.nextInt();
      if(choice == 1)
      { genericsRun.GenericsRunMain();
      }
      System.out.println("******************************************************************************************************************************");
    }while(choice!=0);
  }
}