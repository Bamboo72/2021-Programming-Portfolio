// Jacob Schwartz - 3/22/2021
// This is a program to practice mouse click detection in Swing
// Code copied and modified from my Maze Game project.

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MouseClickTester extends JFrame {

    static MouseClickTester mct;
    static char dir;
    static JFrame frame = new JFrame();
    Container con = this.getContentPane();

    public MouseClickTester() {
        this.dir = 'N';
        this.setBounds(0, 0, 1295, 748);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void tester() {

        JPanel mazePanel = new JPanel();
        mazePanel.setBackground(new Color(50, 190, 0));
        mazePanel.setBounds(0, 0, 700, 300);
        frame.setSize(700, 300);
        frame.pack();

        ImageIcon characterImage = new ImageIcon(".//res//tlink.jpg");
        JLabel characterLabel = new JLabel(characterImage);
        JPanel characterPanel = new JPanel();
        characterPanel.setBackground(new Color(0, 0, 0, 0));
        characterPanel.setBounds(350, 150, 64, 74);
        characterPanel.add(characterLabel);
        con.add(characterPanel);

        MousePressListener mpl = new MousePressListener();
        mazePanel.addMouseListener(mpl);

        con.add(mazePanel);
    }

    // This will refresh the frame when it is called
    public void refresh() {
        validate();
        repaint();
    }

    public static void main(String[] args) {

        mct = new MouseClickTester();
        mct.tester();
        mct.refresh();

    }
}

// This is the MouseListener that moves the character
class MousePressListener implements MouseListener {

    public void mouseClicked(MouseEvent event) {
        int x = event.getX();
        int y = event.getY();

        if (MouseClickTester.dir == 'N' && x >= 350) {
            System.out.println("Now Facing Right");
            MouseClickTester.dir = 'E';
            MouseClickTester.frame.validate();
        } else if (MouseClickTester.dir == 'E' && y >= 150) {
            System.out.println("Now Facing Down");
            MouseClickTester.dir = 'S';
            MouseClickTester.frame.validate();
        } else if (MouseClickTester.dir == 'S' && x < 350) {
            System.out.println("Now Facing Left");
            MouseClickTester.dir = 'W';
            MouseClickTester.frame.validate();
        } else if (MouseClickTester.dir == 'W' && y < 150) {
            System.out.println("Now Facing Up");
            MouseClickTester.dir = 'N';
            MouseClickTester.frame.validate();
        }

    }

    public void mouseEntered(MouseEvent event) {
    }

    public void mouseExited(MouseEvent event) {
    }

    public void mousePressed(MouseEvent event) {
    }

    public void mouseReleased(MouseEvent event) {
    }

}