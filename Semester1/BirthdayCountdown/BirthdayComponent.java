// Jacob Schwartz - 9/17/2020
// A component that draws the birthday countdown chart

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class BirthdayComponent extends JComponent {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    // Declaring all the Day objects
    Day today = new Day();
    int year = today.getYear();
    // Everyone's birthdays
    // Day dad = new Day(year, 5, 25);
    Day dad = new Day(year, 9, 18);
    Day mom = new Day(year, 4, 18);
    Day kelsey = new Day(year, 10, 17);
    Day emily = new Day(year, 4, 27);
    Day jacob = new Day(year, 12, 17);
    Day brooke = new Day(year, 3, 22);
    Day megan = new Day(year, 1, 8);

    Day[] birthdays = { dad, mom, kelsey, emily, jacob, brooke, megan };
    String[] names = { "Dad", "Mom", "Kelsey", "Emily", "Jacob", "Brooke", "Megan" };

    String summary = "";

    // Drawing the lines for the graph
    Line2D.Double l1 = new Line2D.Double(150, 40, 150, 230);
    g2.draw(l1);
    Line2D.Double l2 = new Line2D.Double(150, 230, 880, 230);
    g2.draw(l2);
    for (int j = 0; j < 720; j = j + 50) {
      Line2D.Double l3 = new Line2D.Double(j + 150, 45, j + 150, 230);
      g2.draw(l3);
      g2.drawString(Integer.toString(j/2), j+140, 250);
    }

    // Countdown logic (If the birthday hasn't happened yet, it will be the right number but a negative value.
    // If the birthday has already happened, it will be positive but needing to be subtracted from 365 to get the right number.)
    for (int i = 0; i < 7; i++) {

      int countdown = today.daysFrom(birthdays[i]);
      if (countdown < 0) {
        countdown = countdown * -1;
      } else {
        countdown = 365 - countdown;
      }

      // Drawing the bars, numbers, and labels for each person
      Rectangle box = new Rectangle(151, 25 * i + 50, countdown * 2, 20);
      Color fill = new Color(0, 25 * i + 100, 100);

      g2.setColor(fill);
      g2.draw(box);
      g2.fill(box);
      g2.setColor(Color.BLACK);
      g2.drawString(Integer.toString(countdown), countdown * 2 + 155, 25 * i + 65);
      g2.drawString(names[i], 105, 25 * i + 65);

      summary = summary + names[i] + ": " + Integer.toString(countdown) + "   ";

    }

    // Title and axis labels
    g2.drawString(summary, 260, 345);
    g2.setFont(new Font("", Font.PLAIN, 18));
    g2.drawString("Days", 480, 280);
    g2.drawString("Family", 15, 140);
    g2.drawString("Members", 10, 160);

    g2.setFont(new Font("", Font.CENTER_BASELINE, 25));
    g2.setColor(Color.magenta);
    g2.drawString("Birthday Countdown!", 370, 35);

  }

}
