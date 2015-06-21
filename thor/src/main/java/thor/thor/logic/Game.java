package thor.thor.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import thor.thor.character.Obstacle;
import thor.thor.character.Thor;
import thor.thor.ui.Manager;

/**
 * Main logic of the game.
 */
public class Game extends Timer implements ActionListener {

    private final Manager manager;
    private final CollisionDetector collisionDetector;

    private final Thor thor;
    private final ArrayList<Obstacle> obstacles;

    private int currentLocation;
    private int score;

    public Game(Manager man) {
        super(200, null);

        this.manager = man;
        this.collisionDetector = new CollisionDetector();

        this.thor = new Thor(50, 250);
        this.obstacles = new ArrayList<>();

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

            if (this.collisionDetector.checkCollisions(this.thor, this.obstacles)) {
                this.manager.stopTimers();
                gameOver();
            }

        }

        if (this.thor.hitTheGround()) {
            this.manager.stopTimers();
            gameOver();
        }

    }

    private void gameOver() {
        System.out.println("GAME OVER POOR YOU :(");
    }

}
