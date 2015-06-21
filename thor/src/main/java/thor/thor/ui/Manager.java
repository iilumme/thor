package thor.thor.ui;

import thor.thor.character.Thor;
import thor.thor.logic.Game;
import thor.thor.logic.ObstacleHandler;
import thor.thor.logic.ObstacleMover;

/**
 * A class to help with connections between classes.
 */
public class Manager {

    private final UserInterface userInterface;
    private final Game game;
    private final DrawingPlatform drawingPlatform;
    private final ObstacleHandler obstacleHandler;
    private final ObstacleMover obstacleMover;
    private final Updater updater;

    public Manager(UserInterface ui) {
        this.userInterface = ui;

        this.game = new Game(this);
        this.drawingPlatform = new DrawingPlatform(this);
        this.obstacleHandler = new ObstacleHandler();
        this.obstacleMover = new ObstacleMover(this);
        this.updater = new Updater(this);

    }

    public UserInterface getUserInterface() {
        return userInterface;
    }

    public Game getGame() {
        return game;
    }

    public DrawingPlatform getDrawingPlatform() {
        return drawingPlatform;
    }

    public ObstacleHandler getObstacleHandler() {
        return obstacleHandler;
    }

    public ObstacleMover getObstacleMover() {
        return obstacleMover;
    }

    public Updater getUpdater() {
        return updater;
    }

    public Thor getThor() {
        return game.getThor();
    }

    public void startTimers() {
        this.game.start();
        this.updater.start();
        this.obstacleHandler.start();
        this.obstacleMover.start();
    }

    public void stopTimers() {
        this.game.stop();
        this.updater.stopTimer();
        this.obstacleHandler.stopTimer();
        this.obstacleMover.stopTimer();
    }

}
