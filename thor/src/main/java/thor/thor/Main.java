package thor.thor;

import javax.swing.SwingUtilities;
import thor.thor.ui.UserInterface;

/**
 * The main-loop of the game. Starts GUI.
 * @author iilumme
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new UserInterface());
    }

}
