package thor.thor.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import thor.thor.character.Obstacle;
import thor.thor.character.Thor;
import thor.thor.ui.Manager;

/**
 * Main logic of the game. Moves the characters.
 */
public class Game extends Timer implements ActionListener {

    private final Thor thor;
    private final ArrayList<Obstacle> obstacles;
    private final Manager manager;
    private final CollisionDetector collisionDetector;
    private int currentLocation;
    private int score;

    public Game(Manager m) {
        super(200, null);
        this.thor = new Thor(50, 250);
        this.obstacles = new ArrayList<>();
        this.manager = m;
        this.collisionDetector = new CollisionDetector();
        this.currentLocation = 1;
        this.score = 0;

        addActionListener(this);
        setInitialDelay(500);
    }

    public Thor getThor() {
        return this.thor;
    }

    public int getCurrentLocation() {
        return this.currentLocation;
    }

    public void setCurrentLocation(int currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<Obstacle> getObstacles() {
        return this.obstacles;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!this.thor.hitTheGround()) {

            this.obstacles.addAll(this.manager.getObstacleHandler().getAllObstacles());

            this.thor.gravityMove();
            ArrayList<Obstacle> removableObstacles = new ArrayList<>();

            for (Obstacle o : this.obstacles) {
                if (collisionDetector.collided(thor, o)) {
                    this.manager.stopTimers();
                    gameOver();
                } else if (collisionDetector.passedObstacles(thor, o)) {
                    this.score += 1;
                }
            }

            this.obstacles.removeAll(removableObstacles);
            this.manager.getObstacleHandler().removeObstacles(removableObstacles);

            this.manager.getDrawingPlatform().update();
        }

        if (this.thor.hitTheGround()) {
            this.manager.stopTimers();
            gameOver();
        }

        this.manager.getDrawingPlatform().update();

    }

    private void gameOver() {
        System.out.println("GAME OVER POOR YOU :(");
    }

}
