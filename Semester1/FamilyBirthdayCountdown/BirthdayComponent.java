// Jacob Schwartz - 9/17/2020
// A component that draws two rectangles

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class BirthdayComponent extends JComponent{
  public void paintComponent(Graphics g){
    Graphics2D g2 = (Graphics2D) g;

    Day today = new Day();
    int year = today.getYear();
    // Everyone's birthdays
    Day dad = new Day(year, 5, 25);
    Day mom = new Day(year, 4, 18);
    Day kelsey = new Day(year, 10, 17);
    Day emily = new Day(year, 4, 27);
    Day jacob = new Day(year, 12, 17);
    Day brooke = new Day(year, 3, 22);
    Day megan = new Day(year, 1, 8);


    Day[] birthdays = {dad, mom, kelsey, emily, jacob, brooke, megan};

  for(int i = 0; i < 7; i++){

    int countdown = today.daysFrom(birthdays[i]);
    if(countdown < 0){
      countdown = countdown * -1;
    }
    System.out.println(countdown);
    Rectangle box = new Rectangle(5, 10, 20, 30);
    g2.draw(box);
  }

  // box.translate(15, 25);
  // g2.draw(box);

  }

}
