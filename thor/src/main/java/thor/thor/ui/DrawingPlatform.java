package thor.thor.ui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import thor.thor.character.Obstacle;
import thor.thor.logic.Game;
import thor.thor.ui.listeners.PlayButtonListener;

/**
 * All the drawing happens here.
 */
public class DrawingPlatform extends JPanel {

    private final Manager manager;
    private final Game game;

    private static final String firstpage = "Images/flyingthor2.jpg";
    private static final String asgard = "Images/asgard.jpg";
    private static final String midgard = "Images/midgard.png";
    private static final String jotunheim = "Images/jotunheim.png";
    private static final String vanaheim = "Images/vanaheim.jpg";
    private static final String bifrost = "Images/bifrost.jpg";

    private Image pic;
    private final JLabel firstPagePic;
    private final InfoPanel infoPanel;

    public DrawingPlatform(Manager manager) {
        super.setSize(600, 600);
        super.setLayout(new BorderLayout());
        this.manager = manager;
        this.game = this.manager.getGame();

        /*Background pictures*/
        this.pic = null;
        this.firstPagePic = new JLabel(new ImageIcon(ClassLoader.getSystemResource(firstpage)));

        /*Infopanel*/
        this.infoPanel = new InfoPanel(this.game);
        infoPanel.setVisible(false);

        add(this.firstPagePic, BorderLayout.CENTER);
        add(this.infoPanel, BorderLayout.SOUTH);
    }

    public void hideFirstPage() {
        remove(this.firstPagePic);
    }

    public void setInfoPanelVisible() {
        this.infoPanel.setVisible(true);
        this.infoPanel.update();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(this.pic, 0, 0, null);

        this.game.getThor().draw(g);
        for (Obstacle obstacle : this.game.getObstacles()) {
            obstacle.draw(g);
        }
        this.infoPanel.update();
    }

    public void update() {
        super.repaint();
    }

    /*Changings of background*/
    public void changeToAsgard() {
        try {
            this.pic = ImageIO.read(new java.net.URL(ClassLoader.getSystemResource(asgard), "asgard.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(DrawingPlatform.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.game.setCurrentLocation(1);
    }

    public void changeToMidgard() {
        try {
            this.pic = ImageIO.read(new java.net.URL(ClassLoader.getSystemResource(midgard), "midgard.png"));
        } catch (IOException ex) {
            Logger.getLogger(DrawingPlatform.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.game.setCurrentLocation(2);
    }

    public void changeToJotunheim() {
        try {
            this.pic = ImageIO.read(new java.net.URL(ClassLoader.getSystemResource(jotunheim), "jotunheim.png"));
        } catch (IOException ex) {
            Logger.getLogger(DrawingPlatform.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.game.setCurrentLocation(3);
    }

    public void changeToVanaheim() {
        try {
            this.pic = ImageIO.read(new java.net.URL(ClassLoader.getSystemResource(vanaheim), "vanaheim.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(DrawingPlatform.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.game.setCurrentLocation(4);
    }

    public void changeToBifrost() {
        try {
            this.pic = ImageIO.read(new java.net.URL(ClassLoader.getSystemResource(bifrost), "bifrost.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(DrawingPlatform.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.game.setCurrentLocation(5);
    }

}
