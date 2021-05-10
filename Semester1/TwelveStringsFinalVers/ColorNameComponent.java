// Jacob Schwartz - 9/23/2020
// This project will draw 12 strings, one for each of the 12 standard colors
// This is the Component

import java.util.Random;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class ColorNameComponent extends JComponent {
  public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    Rectangle box = new Rectangle(95, 355, 115, 27);
    Random rand = new Random();
    g2.setFont(new Font("", Font.BOLD, 20));

    g2.drawString("These are the twelve preset colors for JSwing (Not including white)", 100, 25);

    // String and color arrays
    String[] strings = { "Black", "Blue", "Cyan", "Gray", "Dark_Gray", "Light_Gray", "Green", "Magenta", "Orange",
        "Pink", "Red", "Yellow" };
    Color[] colors = { Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY, Color.DARK_GRAY, Color.LIGHT_GRAY, Color.GREEN,
        Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW };

    // This for loop runs through the arrays and draws the strings in the right
    // colors
    for (int i = 0; i < strings.length; i++) {
      g2.setColor(colors[i]);
      g2.drawString(strings[i], 100, 25 * i + 50);
    }

    // I felt like adding a random color generator.
    int randNum = rand.nextInt(12);
    g2.setColor(colors[0]);
    g2.drawString("Random color generator:", 100, 350);
    g2.drawString("(TIP: adjust the window size to generate another random color!)", 100, 410);
    g2.draw(box);
    g2.setColor(colors[randNum]);
    g2.drawString(strings[randNum], 100, 375);

  }
}
