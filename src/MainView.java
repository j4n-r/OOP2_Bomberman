import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainView extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameView());
    }
}
