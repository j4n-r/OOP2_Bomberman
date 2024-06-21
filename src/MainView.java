import javax.swing.JFrame;

public class MainView {

    public static void main(String[] args) {

        final int MAP_WIDTH = 15;
        final int MAP_HEIGHT = 15;
        // set the zell size in px
        final int CELL_SIZE = 32;

        JFrame frame = new JFrame();
        frame.setTitle("Bomberman");
        frame.setSize(MAP_WIDTH * CELL_SIZE, MAP_HEIGHT * CELL_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        // changed to normal init since invokeLater() is only needed for multithreaded
        // applications
        GameView gameView = new GameView(MAP_HEIGHT, MAP_WIDTH, CELL_SIZE);
        GameController gameController = new GameController(gameView);
        frame.add(gameView);
        frame.setVisible(true);
    }

}
