/**
* @author Jacob Schwartz
* @version 1.0
* @since 2020-12-9
*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Containter;

/**
* This is the class that handles all game graphics for the Isle of Laeso Game.
*/
public class Graphics extends JFrame{

  public Graphics(){

  }

  JFrame frame = new JFrame("The Isle of Laeso");
  Canvas canvas = new Graphics();
  canvas.setSize(400, 400);
          frame.add(canvas);
          frame.pack();
          frame.setVisible(true);



}
