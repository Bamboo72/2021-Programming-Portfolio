// THIS IS NOT MY CODE
// This is from https://stackoverflow.com/questions/18037576/how-do-i-check-if-the-user-is-pressing-a-key
// I'm trying to figure out how to test for a key input while in terminal
// I can't get this to work... I think it would work with a window or frame, but not in terminal. Consoles have no events?

// At the bottom I've included a thing I think would work, but it's meant for leJOS NXJ 0.7 which is some LEGO coding thing?
// http://www.lejos.org/nxt/nxj/tutorial/ListenersAndEvents/Listeners_Events.htm

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class KeyPressTester {
    private static volatile boolean wPressed = false;
    public static boolean isWPressed() {
        synchronized (KeyPressTester.class) {
            return wPressed;
        }
    }

    public static void main(String[] args) {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                synchronized (KeyPressTester.class) {
                    switch (ke.getID()) {
                    case KeyEvent.KEY_PRESSED:
                        if (ke.getKeyCode() == KeyEvent.VK_W) {
                            wPressed = true;
                        }
                        break;

                    case KeyEvent.KEY_RELEASED:
                        if (ke.getKeyCode() == KeyEvent.VK_W) {
                            wPressed = false;
                        }
                        break;
                    }
                    return false;
                }
            }
        });

        boolean done = false;
        while(!done){
            if(KeyPressTester.isWPressed()){
                System.out.println("pressed!");
                done = true;
            }
        }
       

    }
}

// import lejos.nxt.Button;
// import lejos.nxt.ButtonListener;
// import lejos.nxt.LCD;

// public class ListenForButtons {
//   public static void main(String[] args) throws Exception {
//     Button.ENTER.addButtonListener(new ButtonListener() {
//       public void buttonPressed(Button b) {
//         LCD.drawString("ENTER pressed", 0, 0);
//       }

//       public void buttonReleased(Button b) {
//         LCD.clear();
//       }
//     });

//     Button.ESCAPE.waitForPressAndRelease();
//   }
// }