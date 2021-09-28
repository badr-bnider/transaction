package data;

import java.util.*;
import java.io.*;

public class Storage
{
  List < String > descriptionList = new ArrayList ();
  List < Double > amountList = new ArrayList ();
  String filePath = "";

  Storage(String _file){
    filePath = _file;
    File file = new File(filePath);
    if(!(file.exists())){
      try{
        file.createNewFile();
      }
      catch (IOException e){
        System.out.println("ERROR");
      }
    }
    try{
      Scanner fileReader = new Scanner(file);
      while(fileReader.hasNextLine()){
        String line = fileReader.nextLine();
        line.split(", ");
        descriptionList.add(line.split(", ")[0]);
        amountList.add(Double.parseDouble(line.split(", ")[1]));
      }
      fileReader.close();
    }
    catch (IOException e){
      System.out.println("ERROR");
    }
  }

  public void save(){
    try {
      FileWriter file = new FileWriter(filePath);
      for(int k=0;k<descriptionList.size();k++){
        file.write(descriptionList.get(k)+", "+ amountList.get(k)+"\n");
      }
      file.close();
    } catch (IOException e) {
      System.out.println("ERROR");
    }
  }

  public double sum(){
    double amountSum = 0;
    for(double x : amountList){
      amountSum += x;
    }
    return amountSum;
  }

  public void append (Transaction _transaction)
  {
    descriptionList.add (_transaction.description);
    amountList.add (_transaction.amount);
  }

  public String read ()
  {
    String toReturn = "";
    for (int i = 0; i < amountList.size (); i++)
      {
	toReturn +=
	  descriptionList.get (i) + " | " + amountList.get (i) + " dhs\n";
      }
    toReturn += "Sum: " + sum()+" dhs\n";
    return toReturn;
  }

  //User Interface functions

  public void appendByUser(int n){
    Scanner input = new Scanner (System.in);
    for (int j=0; j < n; j++)
      {
	Transaction tr =
	  new Transaction (input.nextLine (),
    input.nextDouble ());
    input.nextLine();
	    append (tr);
    }
  }
}