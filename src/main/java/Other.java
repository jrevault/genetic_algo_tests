import java.util.*;
import java.io.*;
import java.math.*;

class Other {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    char f = in.nextLine().charAt(1);
    String a = in.nextLine();
    char m = a.charAt(0);
    char d = a.charAt(1);
    char b = in.nextLine().charAt(1);
    System.err.println("f : " + f);
    System.err.println("m : " + m + " d : " + d);
    System.err.println("b : " + b);
    System.out.println(m <= f && m >= b && (d == '|' || Integer.valueOf(d) != m));
  }
}