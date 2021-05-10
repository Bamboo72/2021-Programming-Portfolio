// Jacob Schwartz - 4/12/2021
// This is a test for using fonts on JLabels

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Container;

import java.awt.Font;

public class FontTest extends JFrame {

  public static void main(String[] args){
    JFrame frame = new JFrame();
    Container con = frame.getContentPane();

    frame.setBounds(10, 10, 1285, 760);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    JLabel label = new JLabel("Da BOIS");
    JPanel panel = new JPanel();
    panel.add(label);

    con.add(panel);

    frame.validate();
  }

}
