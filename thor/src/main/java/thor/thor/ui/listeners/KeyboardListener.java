package thor.thor.ui.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import thor.thor.character.Thor;
import thor.thor.ui.Manager;

/**
 * Listener for keyboard (UP-arrow).
 */

public class KeyboardListener implements KeyListener{

    private final Manager manager;
    private final Thor thor;

    public KeyboardListener(Manager m) {
        this.manager = m;
        this.thor = this.manager.getThor();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("KENGURU");
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("KALAKISSA");
            this.thor.move();
            this.manager.getDrawingPlatform().update();
        }
    }
    
    
    //NOT USED

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported.");
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported.");
    }
    
}
