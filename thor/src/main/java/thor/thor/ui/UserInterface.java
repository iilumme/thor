package thor.thor.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import thor.thor.ui.listeners.KeyboardListener;
import thor.thor.ui.listeners.PlayButtonListener;

/**
 * Graphic UI of the game.
 */
public class UserInterface implements Runnable {

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 600;

    private JFrame frame;
    private final Manager manager;
    private JButton play;

    public UserInterface() {
        this.manager = new Manager(this);
    }

    @Override
    public void run() {

        frame = new JFrame("Flying Thor");
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());
        frame.setFocusable(true);
        frame.addKeyListener(new KeyboardListener(this.manager));

        frame.pack();
        frame.setVisible(true);

    }

    private void createComponents(Container c) {

        c.setLayout(new BorderLayout());
        c.setBackground(new Color(0, 128, 255));

        this.play = new JButton("PLAY");
        this.play.addActionListener(new PlayButtonListener(this.manager));

        c.add(this.manager.getDrawingPlatform(), BorderLayout.CENTER);
        c.add(this.play, BorderLayout.SOUTH);

    }

    public void playSetVisibleFalse() {
        this.play.setVisible(false);
    }

}
