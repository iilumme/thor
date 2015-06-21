package thor.thor.ui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Timer;

/**
 * Updates DrawingPlatform.
 */
public class Updater extends Thread {

    private final Timer timer;
    private final Manager manager;

    public Updater(Manager m) {

        this.manager = m;
        this.timer = new Timer(5, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Updater.this.manager.getDrawingPlatform().update();
            }
        });
    }

    @Override
    public void run() {
        this.timer.start();
    }

    public void stopTimer() {
        this.timer.stop();
    }

}
