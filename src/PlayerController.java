import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener {
    Player player;

    public PlayerController(Player player) {
        this.player = player;
    }

    // Implement the keyPressed method
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        // Handle key pressed event
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                System.out.println("Left arrow key pressed");
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Right arrow key pressed");
                break;
            case KeyEvent.VK_UP:
                System.out.println("Up arrow key pressed");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Down arrow key pressed");
                break;
            case KeyEvent.VK_W:
                System.out.println("W key pressed");
                break;
            case KeyEvent.VK_A:
                System.out.println("A key pressed");
                break;
            case KeyEvent.VK_S:
                System.out.println("S key pressed");
                break;
            case KeyEvent.VK_D:
                System.out.println("D key pressed");
                break;
        }
    }

    // Implement the keyReleased method
    @Override
    public void keyReleased(KeyEvent e) {
        // You can add custom logic here if needed
    }

    // Implement the keyTyped method
    @Override
    public void keyTyped(KeyEvent e) {

    }
}
