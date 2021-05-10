// Jacob Schwartz - 9/23/2020
// This project will draw 12 strings, one for each of the 12 standard colors
// This is the Component

import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class ColorNameComponent extends JComponent{
  public void paintComponent(Graphics g){
    Graphics2D g2 = (Graphics2D) g;

    Rectangle box = new Rectangle(300, 325, 50, 25);
    Random rand = new Random();

   String[] strings = {"Black", "Blue", "Cyan", "Gray", "Dark_Gray",
   "Light_Gray", "Green", "Magenta", "Orange", "Pink", "Red", "Yellow"};
    Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY, Color.DARK_GRAY,
       Color.LIGHT_GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW};

    for(int i = 0; i < strings.length; i++){
      g2.setColor(colors[i]);
      g2.drawString(strings[i], 300, 25*i+25);
    }

    g2.setColor(colors[0]);
    g2.draw(box);
    g2.drawString("Random color generator:", 300, 320);

    int randNum = rand.nextInt(11);
    g2.setColor(colors[randNum]);
    g2.drawString(strings[randNum], 300, 325);


  }
}
