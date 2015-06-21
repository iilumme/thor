package thor.thor.logic;

import java.util.ArrayList;
import thor.thor.character.Obstacle;
import thor.thor.character.Thor;

/**
 * Detects all the collisions.
 */
public class CollisionDetector {

    public boolean collided(Thor thor, Obstacle obstacle) {
        if (thor.getBorders().intersects(obstacle.getBorders())) {
            return true;
        }
        return false;
    }
    
    public boolean checkCollisions(Thor thor, ArrayList<Obstacle> obstacles) {
        for (Obstacle obstacle : obstacles) {
            if (collided(thor, obstacle)) {
                return true;
            }
        }
        return false;
    }

    public boolean passedObstacles(Thor thor, Obstacle obstacle) {
        if (thor.getX() == obstacle.getX() && !collided(thor, obstacle)) {
            return true;
        }

        return false;
    }

}
