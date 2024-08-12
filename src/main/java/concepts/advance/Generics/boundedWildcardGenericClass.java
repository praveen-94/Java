package concepts.advance.Generics;
/*
1) an upper bound for a wildcard, <? extends superclass>
   where: superclass is the name of the class that serves as the upper bound.
   Remember: this is an inclusive clause

2) a lower bound for a wildcard , <? super subclass>
   only classes that are superclasses of subclass are acceptable arguments.
   This is an exclusive clause
 */

class TwoD
{ int x, y;
  TwoD(int a, int b)
  { x = a;
    y = b;
  }
}

class ThreeD extends TwoD
{ int z;
  ThreeD(int a, int b, int c)
  { super(a, b);
    z = c;
  }
}

class FourD extends ThreeD
{ int t;
  FourD(int a, int b, int c, int d)
  { super(a, b, c);
    t = d;
  }
}

class genCoords<T extends TwoD>
{ T[] genCoords;
  genCoords(T[] o)
  { genCoords = o;
  }
}

public class boundedWildcardGenericClass
{  static void showXY(genCoords<?> c)    //Unbounded Wildcard, allow any class(TwoD, ThreeD, FourD)
   { System.out.println("Calling Unbounded Wildcard version of show method .....");
     System.out.println("X Y Coordinates:");
     for(int i=0; i < c.genCoords.length; i++)
       System.out.println(c.genCoords[i].x + " " + c.genCoords[i].y);
     System.out.println();
   }

    static void showXYZ(genCoords<? extends ThreeD> c)  //UpperBound Wildcard, allow only ThreeD and its subclass FourD
    { System.out.println("Calling UpperBounded to ThreeD version of show method.....");
      System.out.println("X Y Z Coordinates:");
      for(int i=0; i < c.genCoords.length; i++)
        System.out.println(c.genCoords[i].x + " " + c.genCoords[i].y + " " + c.genCoords[i].z);
      System.out.println();
    }

    static void showAll(genCoords<? extends FourD> c)   //LowerBound Wildcard, allow only FourD and its subclass
    { System.out.println("Calling UpperBounded to FourD version of show method.....");
      System.out.println("X Y Z T Coordinates:");
      for(int i=0; i < c.genCoords.length; i++)
       System.out.println(c.genCoords[i].x + " " + c.genCoords[i].y + " " + c.genCoords[i].z + " " + c.genCoords[i].t);
      System.out.println();
    }

    public void boundedWildcardGenericClassMain()
    { TwoD[] td = { new TwoD(0, 0),
                    new TwoD(7, 9),
                    new TwoD(18, 4),
                    new TwoD(-1, -23)
                  };
      genCoords<TwoD> tdlocs = new genCoords<TwoD>(td);
      showXY(tdlocs);      // OK, is a TwoD
      // showXYZ(tdlocs);  // Error, not a ThreeD
      // showAll(tdlocs);  // Error, not a FourD

      // Now, create some FourD objects.
      FourD[] fd = { new FourD(1, 2, 3, 4),
                     new FourD(6, 8, 14, 8),
                     new FourD(22, 9, 4, 9),
                     new FourD(3, -2, -23, 17)
                   };
      genCoords<FourD> fdlocs = new genCoords<FourD>(fd);
      showXY(fdlocs);
      showXYZ(fdlocs);   // These are all OK
      showAll(fdlocs);
    }
}
