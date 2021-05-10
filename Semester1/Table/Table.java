/**
* @author Jacob Schwartz
* @version 1.0
* @since 2020-12-15
*/

/*
Tabular data are often saved in the CSV (comma-separated values) format.
 Each table row is stored in a line, and column entries are separated by commas.
  However, if an entry contains a comma or quotation marks, they enclosed in quotation marks,
   doubling any quotation marks of the entry. For example,

John Jacob Astor,1763,1848
"William Backhouse Astor, Jr.",1829,1892
"John Jacob ""Jakey"" Astor VI",1912,1992
Provide a class Table with methods

public void addLine(String line)
public String getEntry(int row, int column)
public int rows()
public int columns()
Solve this problem by producing progressively more complex intermediate versions of your class and a tester, similar to the approach in Section 8.5.
*/

import java.util.Scanner;
import java.util.ArrayList;

/**
* This class can create table objects that store data, separated by commas.
*/
public class Table{

  static Scanner input = new Scanner(System.in);
  static Table myTable = new Table();

  public Table(){
    ArrayList<String> data = new ArrayList<String>();
  }

  /**
  * This adds a line to the table
  * @param line This is the data that goes on the row
  */
  public void addLine(String line){
    data.add(line);
  }

  /**
  * This gets the entry at a given row and column
  * @param row This is the row searched
  * @param column This is the column searched
  */
  public String getEntry(int row, int column){

  }

  /**
  * This class returns the number of rows in the table
  * @return int This is the number of rows in the table
  */
  public int rows(){
    return myTable.size();
  }

  /**
  * This class returns the number of columns in the table
  * @return int This is the number of columns in the table
  */
  public int columns(){
    System.out.println("Not implemented yet :P");
    return 1;
  }

  public static void main(String[] args){



    String in = "";
    boolean run = true;

    while(run){
      // Add get row and collumn count
      System.out.println("What would you like to do? (1) Create new entry (2) View an entry (3) Print the table (4) Quit");
      in = input.next();

      if(in.equals("1")){
        System.out.println("Enter the data in CSV format:");
        in = input.next();
        myTable.addLine(in);
      } else if(in.equals("2")){
        System.out.println("Not implemented yet");
      } else if(in.equals("3")){
        System.out.println(myTable);
      } else if(in.equals("4")){
        run = false;
      } else {
        System.out.println("Error. Input not recognized.");
      }
    }





  }

}
