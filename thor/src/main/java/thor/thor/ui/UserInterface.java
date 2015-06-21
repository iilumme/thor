package thor.thor.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import thor.thor.logic.Game;
import thor.thor.ui.listeners.KeyboardListener;
import thor.thor.ui.listeners.PlayButtonListener;

/**
 * Graphic UI of the game.
 */
public class UserInterface implements Runnable {

    private JFrame frame;
    private Game game;
    private DrawingPlatform drawingPlatform;
    private Manager manager;
    private JButton play;

    public UserInterface() {
        this.game = new Game();
    }

    @Override
    public void run() {

        frame = new JFrame("Flying Thor");
        frame.setPreferredSize(new Dimension(1200, 600));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private void createComponents(Container c) {

        c.setLayout(new BorderLayout());
        c.setBackground(new Color(0, 128, 255));

        this.drawingPlatform = new DrawingPlatform(this.game);
        this.manager = new Manager(this.game, this.drawingPlatform, this);
        this.game.setManager(this.manager);

        KeyboardListener kl = new KeyboardListener(this.manager);
        frame.addKeyListener(kl);

        this.play = new JButton("PLAY");
        play.addActionListener(new PlayButtonListener(this.manager));

        c.add(this.drawingPlatform, BorderLayout.CENTER);
        c.add(play, BorderLayout.SOUTH);

    }

    public void playSetVisibleFalse() {
        this.play.setVisible(false);
    }

}
