// Jacob Schwartz - 8/17/2020
// Testing out 2D graphics in Java using java.awt.Canvas and java.awt.Graphics

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;

public class Drawing extends Canvas {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    static Color green = new Color(0, 100, 30);

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Drawing");
        Canvas canvas = new Drawing();
        canvas.setSize(650, 400);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        canvas.setBackground(Color.white);
        // int w = frame.getContentPane().getWidth();
    }

    public void paint(Graphics g) {
        g.setColor(Color.red);
        System.out.println("frame width : " + getWidth());
        g.fillOval(getWidth() / 2 - 100, getHeight() / 2 - 100, 200, 200);
        g.fillRoundRect(10, 10, 30, 70, 20, 10);
        g.drawString("Hi", 70, 30);
    }

}