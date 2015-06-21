package thor.thor.ui;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import thor.thor.logic.Game;

/**
 * A JPanel for showing information, scores etc.
 */
public class InfoPanel extends JPanel {

    private final Game game;

    public InfoPanel(Game g) {
        setSize(1200, 20);
        setLayout(new GridLayout(1, 3));

        this.game = g;

        int cL = this.game.getCurrentLocation();
        String currentLocation = "";

        switch (cL) {
            case 1:
                currentLocation = "ASGARD";
                break;
            case 2:
                currentLocation = "MIDGARD";
                break;
            case 3:
                currentLocation = "JOTUNHEIM";
                break;
            case 4:
                currentLocation = "VANAHEIM";
                break;
            case 5:
                currentLocation = "BIFROST";
                break;
        }

        add(new JLabel());
        add(new JLabel("YOU ARE IN " + currentLocation));
        add(new JLabel("SCORE " + this.game.getScore()));
    }

    public void update() {
        repaint();
    }

}
