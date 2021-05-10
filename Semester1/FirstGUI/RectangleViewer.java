// Jacob Schwartz - 9/17/2020
// This is the first graphical project for Programming 2

import javax.swing.*;

public class RectangleViewer {
  public static void main(String[] args){
    JFrame frame = new JFrame();
    frame.setSize(300, 400);
    frame.setTitle("Rectangles");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    RectangleComponent component = new RectangleComponent();
    frame.add(component);

    frame.setVisible(true);

  }
}
