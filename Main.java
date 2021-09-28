import java.util.*;
import data.*;

public class Main
{
  public static void main (String[]args)
  {
    Storage db = new Storage ("files/file.csv");
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    input.nextLine();
    db.appendByUser(n);
    db.save();
    System.out.println (db.read());
  }
}
