package thor.thor.logic;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Timer;
import thor.thor.character.Obstacle;
import thor.thor.ui.Manager;

public class ObstacleMover extends Thread {

    private final Manager manager;
    private final Timer timer;

    public ObstacleMover(Manager m) {

        this.manager = m;
        this.timer = new Timer(10, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Obstacle> removables = new ArrayList<>();

                for (Obstacle obstacle : ObstacleMover.this.manager.getObstacleHandler().getAllObstacles()) {
                    obstacle.move();

                    if (obstacle.getX() < -50) {
                        removables.add(obstacle);
                    }
                }

                ObstacleMover.this.manager.getObstacleHandler().removeObstacles(removables);

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
