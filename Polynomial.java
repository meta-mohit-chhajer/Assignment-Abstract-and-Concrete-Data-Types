import java.util.*;
import java.io.*;
public class Polynomial 
{
  private final int[] coef;   
  private int degree;   
    
  public Polynomial(int a, int b) 
  {
    if(b<0) 
    {
      throw new IllegalArgumentException("exponent cannot be negative: " + b);
    }
    coef=new int[b+1];
    coef[b]=a;
    reduce();
  }

    
 private void reduce() 
  {
    degree=-1;
    for(int i=coef.length-1;i>=0;i--)
    {
      if(coef[i]!=0) 
      {
        degree=i;
        return;
      }
    }
  }

    
  public int degree() 
  {
    return degree;
  }

    
  public Polynomial plus(Polynomial that)
  {
    Polynomial poly=new Polynomial(0,Math.max(this.degree,that.degree));
    for (int i=0;i<=this.degree;i++) poly.coef[i]+=this.coef[i];
        for (int i=0;i<=that.degree;i++) poly.coef[i]+=that.coef[i];
        poly.reduce();
        return poly;
  }

    public Polynomial times(Polynomial that) {
        Polynomial poly = new Polynomial(0, this.degree + that.degree);
        for (int i = 0; i <= this.degree; i++)
            for (int j = 0; j <= that.degree; j++)
                poly.coef[i+j] += (this.coef[i] * that.coef[j]);
        poly.reduce();
        return poly;
    }


    @Override
    public String toString() {
        if      (degree == -1) return "0";
        else if (degree ==  0) return "" + coef[0];
        else if (degree ==  1) return coef[1] + "x + " + coef[0];
        String s = coef[degree] + "x^" + degree;
        for (int i = degree - 1; i >= 0; i--) {
            if      (coef[i] == 0) continue;
            else if (coef[i]  > 0) s = s + " + " + (coef[i]);
            else if (coef[i]  < 0) s = s + " - " + (-coef[i]);
            if      (i == 1) s = s + "x";
            else if (i >  1) s = s + "x^" + i;
        }
        return s;
    }

    
    public static void main(String...args)
    { 
        Polynomial zero=new Polynomial(0, 0);

        Polynomial p1=new Polynomial(4, 3);
        Polynomial p2=new Polynomial(3, 2);
        Polynomial p3=new Polynomial(1, 0);
        Polynomial p4=new Polynomial(2, 1);
        Polynomial p=p1.plus(p2).plus(p3).plus(p4);
        Polynomial q1=new Polynomial(3, 2);
        Polynomial q2=new Polynomial(5, 0);
        Polynomial q=q1.plus(q2);                    
        Polynomial r= p.plus(q);
        Polynomial s= p.times(q);
        

        System.out.println("zero(x)     = " + zero);
        System.out.println("p(x)        = " + p);
        System.out.println("q(x)        = " + q);
        System.out.println("p(x) + q(x) = " + r);
        System.out.println("p(x) * q(x) = " + s);
       
    }
}

