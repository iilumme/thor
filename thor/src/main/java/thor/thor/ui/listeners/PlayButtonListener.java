package thor.thor.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import thor.thor.ui.Manager;

public class PlayButtonListener implements ActionListener {

    private final Manager manager;

    public PlayButtonListener(Manager m) {
        this.manager = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.manager.getDrawingPlatform().hideFirstPage();
        this.manager.getDrawingPlatform().changeToJotunheim();
        this.manager.getUserInterface().playSetVisibleFalse();
        this.manager.getDrawingPlatform().setInfoPanelVisible();
        this.manager.startTimers();
    }

}
