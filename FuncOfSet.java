import java.util.*;

class FuncOfSet
{
  public static boolean isMember(int x,Set<Integer> num)
  {
    return num.contains(x);
  }

  public static int Size(Set<Integer> num)
  {
    return num.size();
  }

  public static boolean isSubset(Set<Integer> num,Set<Integer> test)
  {
    return num.containsAll(test);
  }

  public static Set<Integer> getComplement(Set<Integer> num,Set<Integer> test)
  {
    Set<Integer> ans=new HashSet<Integer>();
    Integer myarray[]=new Integer[num.size()];
    num.toArray(myarray);
    for(int i=0;i<myarray.length;i++)
    {
      if(!test.contains(myarray[i]))
      	ans.add(myarray[i]);
    }
    return ans;
  }

 public static Set<Integer> Union(Set<Integer> num,Set<Integer> test)
  {
    Set<Integer> ans=new HashSet<Integer>();
    ans.addAll(num);
    ans.addAll(test);
    return ans;
  }
  
  public static void main(String...arg)
  {    
    Set<Integer> num=new HashSet<Integer>();
    Scanner sc=new Scanner(System.in);
    Integer j,ch;
    System.out.println("Enter Values in Set ");
    for(int i=0;i<6;i++)
    {
      j=sc.nextInt();
      num.add(j);
    }
    Set<Integer> unm=Collections.unmodifiableSet(num);
    String url;
    do
    {
      System.out.println("1: isMember ");
      System.out.println("2: Size ");
      System.out.println("3: isSubset ");
      System.out.println("4: getComplement ");
      System.out.println("5: union ");
      System.out.println("Enter Choice : ");
      ch=sc.nextInt();
      switch(ch)
      {
        case 1:System.out.println("Enter Number to be Searched : ");
               Integer x=sc.nextInt();
               System.out.println(isMember(x,unm));
               break;
        case 2:System.out.println(Size(unm));
               break;
        case 3:Set<Integer> test1=new HashSet<Integer>();
               System.out.println("Enter Value in New Set ");
               Integer y;
               for(int i=0;i<4;i++)
               {
                 y=sc.nextInt();
                 test1.add(y);
               }
               System.out.println(isSubset(unm,test1));
               break;
        case 4:Set<Integer> test2=new HashSet<Integer>();
               System.out.println("Enter Value in New Set ");
               Integer z;
               for(int i=0;i<4;i++)
               {
                 z=sc.nextInt();
                 test2.add(z);
               }
               System.out.println(getComplement(unm,test2));
               System.out.println(num);
               break;
        case 5:Set<Integer> test3=new HashSet<Integer>();
               System.out.println("Enter Value in New Set ");
               Integer a;
               for(int i=0;i<4;i++)
               {
                 a=sc.nextInt();
                 test3.add(a);
               }
               System.out.println(Union(unm,test3));
               break;
        default:System.out.println("Invalid Choice.."); 
      }
      System.out.println("Want to Enter More ?(Y/N) ");
      url=sc.next();
    }while(url.equals("Y")||url.equals("y"));
  }
} 

    
      
