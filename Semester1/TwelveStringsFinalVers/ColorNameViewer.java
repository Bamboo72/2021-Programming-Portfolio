// Jacob Schwartz - 9/23/2020
// This project will draw 12 strings, one for each of the 12 standard colors
// This is the Viewer

import javax.swing.*;
import java.awt.Color;

public class ColorNameViewer {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setSize(840, 600);
    frame.setTitle("Twelve Strings");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ColorNameComponent component = new ColorNameComponent();
    frame.add(component);

    Color lightYellow = new Color(255,255,255);
    frame.getContentPane().setBackground(lightYellow);

    frame.setVisible(true);
  }

}
