package thor.thor.ui;

import thor.thor.character.Thor;
import thor.thor.logic.Game;
import thor.thor.logic.ObstacleHandler;
import thor.thor.logic.ObstacleMover;

/**
 * A class to help with connections between classes.
 */
public class Manager {

    private final Game game;
    private final DrawingPlatform drawingPlatform;
    private final UserInterface userInterface;
    private final ObstacleHandler obstacleHandler;
    private final ObstacleMover obstacleMover;
    private final Updater updater;

    public Manager(Game g, DrawingPlatform d, UserInterface ui) {
        this.game = g;
        this.drawingPlatform = d;
        this.userInterface = ui;
        this.obstacleHandler = new ObstacleHandler();
        this.obstacleMover = new ObstacleMover(this);
        this.updater = new Updater(this);
    }

    public Game getGame() {
        return this.game;
    }

    public DrawingPlatform getDrawingPlatform() {
        return this.drawingPlatform;
    }

    public UserInterface getUserInterface() {
        return this.userInterface;
    }

    public Thor getThor() {
        return this.game.getThor();
    }

    public ObstacleHandler getObstacleHandler() {
        return this.obstacleHandler;
    }

    public ObstacleMover getObstacleMover() {
        return obstacleMover;
    }

    public Updater getUpdater() {
        return updater;
    }
    
    public void stopTimers() {
        this.game.stop();
        this.updater.stopTimer();
        this.obstacleHandler.stopTimer();
        this.obstacleMover.stopTimer();
    }

}
