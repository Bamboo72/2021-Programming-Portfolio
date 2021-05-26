// Jacob Schwartz - 2/18/2021
/*

•• P11.3Using the mechanism described in Special Topic 11.1, write a program that reads all data from a web page and writes them to a file.
    Prompt the user for the web page URL and the file.

Special Topic 11.1

Reading Web Pages

You can read the contents of a web page with this sequence of commands:

String address = "http://horstmann.com/index.html";
URL pageLocation = new URL(address);
Scanner in = new Scanner(pageLocation.openStream());
Now simply read the contents of the web page with the Scanner in the usual way. 
The URL constructor and the openStream method can throw an IOException, so you need to tag the main method with throws IOException. (See Section 11.4.3 for more information on the throws clause.)

The URL class is contained in the java.net package.

*/

import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.net.URL;

public class WebPageReader {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        System.out.println("Type the website you would like to read from:"); // Samples: http://horstmann.com/index.html, https://schools.graniteschools.org/skylinehigh/, https://www.youtube.com/watch?v=DLzxrzFCyOs
        URL pageLocation = new URL(in.next());

        try(Scanner reader = new Scanner(pageLocation.openStream()); FileWriter writer = new FileWriter("websiteOutput.txt")){
           while(reader.hasNextLine()){
               String line = reader.nextLine() + "\n";
            writer.append(line);
           }
        }
        in.close();

    }

}
