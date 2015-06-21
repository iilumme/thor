package thor.thor.ui.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import thor.thor.character.Thor;
import thor.thor.ui.Manager;

/**
 * Listener for keyboard (UP-arrow).
 */
public class KeyboardListener implements KeyListener {

    private final Manager manager;
    private final Thor thor;

    public KeyboardListener(Manager m) {
        this.manager = m;
        this.thor = this.manager.getThor();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.thor.move();
        }
    }

    /*Won't be used*/
    @Override
    public void keyReleased(KeyEvent e) {
       
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

}
