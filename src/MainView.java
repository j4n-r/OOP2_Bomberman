import javax.swing.JFrame;

public class MainView {
    public static void main(String[] args) {
        // changed to normal init since invokeLater() is only needed for multithreaded
        // applications
        GameView gameView = new GameView();
        GameController gameController = new GameController(gameView);
    }

}
