// Jacob Schwartz 12/6/2020
// This is a replication of text or speech boxes seen in most RPGs. (Ex: Legend of Zelda, Stardew Valley, Undertale, etc)

import javax.swing.JFrame;
import java.awt.Canvas;

//import java.awt.Component;

import java.awt.Color;
import java.awt.Graphics;
//import java.io.IOException;
import java.awt.Font;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
//import javax.swing.JFrame;
import javax.swing.JLabel;

public class SpeechBox extends Canvas {

    Font f = new Font("serif", Font.PLAIN, 20);
    static String stay = "";
    static String s = "";
    static int w, h, cw, ch = 170;
    static boolean speaking = false;
    static Graphics g;

    // This is the default speak method (waits 50 ms between characters)
    public static void speak(String dialog) throws InterruptedException {
        speaking = true;
        for (int i = 0; i < dialog.length(); i++) {
            s = s + "" + String.valueOf(dialog.charAt(i));
            cw += i / 2;

            System.out.print(dialog.charAt(i));

            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

        }
        System.out.println();
        speaking = false;
    }

    // This speak method takes in an int for the spacing between characters
    // public static void speak(String dialog, int sec) throws InterruptedException
    // {
    // String s = "";
    // for (int i = 0; i < dialog.length(); i++) {
    // s = Character.toString(dialog.charAt(i));
    // System.out.print(dialog.charAt(i));
    // g.drawString(s, 70 + i, h - 170);
    // try {
    // Thread.sleep(sec);
    // } catch (InterruptedException ex) {
    // Thread.currentThread().interrupt();
    // }
    // }
    // System.out.println();
    // }

    JLabel label;
    JLabel label2;
    public void imageDisplay(JFrame frame) {

        ImageIcon image = new ImageIcon(getClass().getResource("res/tlink.jpg"));
        ImageIcon image2 = new ImageIcon(getClass().getResource("res/title.png"));
        // ImageIcon image2 = new
        // ImageIcon(getClass().getResource("res/OceanBackground.jpg"));

        label = new JLabel(image);
        label2 = new JLabel(image2);

        frame.add(label, BorderLayout.LINE_END);

        // setLayout(null);
        frame.add(label2, BorderLayout.PAGE_START);

        // label2.setLocation(0, 0);

    }

    static JFrame frame = new JFrame("Would ya look at this frame!");

    public static void main(String[] args) throws InterruptedException {
        Canvas canvas = new SpeechBox();
        frame.setSize(2000, 1000);
        canvas.setSize(650, 400);

        frame.add(canvas);
        //frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setVisible(true);
        canvas.setBackground(Color.BLACK);

        speak("Get ye flask?");
        speak("  Ye cannot get ye flask!");
        speak(" I wonder why...");

        // try {
        // Thread.sleep(1000);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // canvas.setSize(3000, 400);
        // frame.pack();

    }

    public void paint(Graphics g) {
        imageDisplay(frame);
        
        w = getWidth();
        h = getHeight();
        g.setFont(f);

        g.setColor(Color.WHITE);
        g.fillRoundRect(50, getHeight() - 200, getWidth() - 100, 150, 50, 50);

        g.setColor(Color.BLACK);
        g.setColor(Color.RED);

        if (cw > getWidth() - 80) {
            cw = 0;
            ch -= 30;
            stay = s ;
            g.drawString(stay, 60, getHeight() - ch);
            s = "";
            
        }
        if (ch > 470) {
            ch = 170;
        }
        
        g.drawString(s, 60, getHeight() - ch);
        g.drawString(stay, 60, getHeight() - 170);

        if (speaking) {
            repaint();
        }

        // g.drawString("Hi, my name is Jacob.", 70, getHeight()-170);

        // g.fillOval( getWidth()/2 - 100, getHeight()/2 - 100, 200, 200);

    }

}
