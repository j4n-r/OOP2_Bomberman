import java.awt.Graphics;

public class GameController implements Runnable {
    public GameView gameView;
    Thread gameThread;
    private int FPS;

    public GameController(GameView gameView) {
        this.gameView = gameView;
        this.FPS = 60;
        startGameThread();
        run();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {

                // System.out.println("Game Loop is running");
                repaint();
                delta--;
            }
        }

    }

    private void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    private void repaint() {
        System.out.println("repaint");
    }

}
