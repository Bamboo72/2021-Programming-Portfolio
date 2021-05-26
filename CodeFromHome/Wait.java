import java.io.IOException;

// Jacob Schwartz - 9/12/2020
// This is a test to see how I can wait for an input from the user (key press or mouse press)

// For mouse detection, I think I need JFrame stuff.
// As for keys, I could simply use System.in.read() and then press Enter.
// Nothing too exciting here...

public class Wait {

    public static void main(String[] args) throws IOException {

        System.out.println("Once upon a time...");
        System.in.read();
        System.out.println("In a land far, far, away...");

    }

}
