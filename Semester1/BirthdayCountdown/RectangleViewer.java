// Jacob Schwartz - 9/17/2020
// This is the first graphical project for Programming 2

import javax.swing.*;
import java.awt.Color;

public class RectangleViewer {
  public static void main(String[] args){
    JFrame frame = new JFrame();
    frame.setSize(1000, 400);
    frame.setTitle("2.1 Intro to Java Graphics");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    BirthdayComponent component = new BirthdayComponent();

    Color lightYellow = new Color(255,255,150);
    frame.getContentPane().setBackground(lightYellow);

    frame.add(component);

    frame.setVisible(true);

  }
}
