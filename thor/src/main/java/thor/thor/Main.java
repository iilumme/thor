package thor.thor;

import javax.swing.SwingUtilities;
import thor.thor.ui.UserInterface;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new UserInterface());
    }
    
}
