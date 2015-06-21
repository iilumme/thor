package thor.thor.logic;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.Timer;
import thor.thor.character.Obstacle;

/**
 * A thread which takes care of the obstacles.
 */
public class ObstacleHandler extends Thread {

    private final ArrayList<Obstacle> allObstacles;
    private final Timer timer;

    public ObstacleHandler() {
        this.allObstacles = new ArrayList<>();
//        this.timer = new Timer(3000, new ObstacleCreator(this));
        this.timer = new Timer(3000, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Obstacle> obstacles = new ArrayList<>();

                Random r = new Random();
                int number = r.nextInt(8);

                int y = 500;

                for (int i = 0; i < 10; i++) {
                    if (i != number && i != number + 1) {
                        Obstacle o = new Obstacle(1200, y);
                        obstacles.add(o);
                    }
                    y -= 50;
                }

                ObstacleHandler.this.setObstacles(obstacles);
            }
        });

    }

    public void setObstacles(ArrayList<Obstacle> al) {
        this.allObstacles.addAll(al);
    }

    public ArrayList<Obstacle> getAllObstacles() {
        return this.allObstacles;
    }

    public void removeObstacles(ArrayList<Obstacle> removableObstacles) {
        this.allObstacles.removeAll(removableObstacles);
    }

    @Override
    public void run() {
        this.timer.start();
    }

    public void stopTimer() {
        this.timer.stop();
    }

}
