// Jacob Schwartz - 4/12/2021
// This is a test for using fonts on JLabels

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Container;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
// import java.net.MalformedURLException;
// import java.net.URL;
import java.awt.GraphicsEnvironment;

public class FontTest extends JFrame {

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    Container con = frame.getContentPane();

    frame.setBounds(10, 10, 1285, 760);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    // Various attempts:
    // ______________________________________________________________________

    // Font norseFont = new loadFont(".//res//Norse-Bold.otf", 24p);

    // try {
    // Font myFont = Font.createFont(Font.TRUETYPE_FONT,
    // Launcher.class.getResourceAsStream(".//res//Norse-Bold.otf"));
    // } catch (FontFormatException | IOException e) {
    // e.printStackTrace();
    // }

    // getClass().getResource(".//res//Norse-Bold.otf")
    // ______________________________________________________________________
    // try {
    // URL fontUrl = new URL(".//res//Norse-Bold.otf"); //
    // "file:///F:/Computer_Science/TexasLED.ttf"
    // } catch (MalformedURLException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // ______________________________________________________________________

    // Code from
    // https://stackoverflow.com/questions/5652344/how-can-i-use-a-custom-font-in-java
    Font customFont = new Font("Verdana", Font.BOLD, 20);

    try {
      // create the font to use. Specify the size!
      customFont = Font.createFont(Font.TRUETYPE_FONT, new File(".//res//Norse-Bold.otf")).deriveFont(50f);
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      // register the font
      ge.registerFont(customFont);
    } catch (IOException | FontFormatException e) {
      e.printStackTrace();
    }

    JLabel label = new JLabel("Wow, I finally got this to work!");
    // label.setFont(new Font("Verdana", Font.BOLD, 20 ) );
    label.setFont(customFont);

    JPanel panel = new JPanel();
    panel.add(label);

    con.add(panel);

    frame.validate();
  }

}
