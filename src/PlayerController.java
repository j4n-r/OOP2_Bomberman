import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class PlayerController implements KeyListener {
    Player player;
    HashMap<String,Integer> player1Controls = new HashMap<>();
    HashMap<String,Integer> player2Controls = new HashMap<>();
    public PlayerController(Player player) {
        this.player = player;
        // Initialize player1Controls
        player1Controls.put("move_left", KeyEvent.VK_A);
        player1Controls.put("move_right", KeyEvent.VK_D);
        player1Controls.put("move_up", KeyEvent.VK_W);
        player1Controls.put("move_down", KeyEvent.VK_S);

        // Initialize player2Controls
        player2Controls.put("move_left", KeyEvent.VK_LEFT);
        player2Controls.put("move_right", KeyEvent.VK_RIGHT);
        player2Controls.put("move_up", KeyEvent.VK_UP);
        player2Controls.put("move_down", KeyEvent.VK_DOWN);
    }

    // Implement the keyPressed method
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        // Handle key pressed event
        // Handle player 1 controls
        if (player.getPlayerNumber() == 1) {
            // TODO change the cell array to the new player position
            switch (keyCode) {
                case KeyEvent.VK_A:
                    System.out.println("Player 1: Move left");
                    break;
                case KeyEvent.VK_D:
                    System.out.println("Player 1: Move right");
                    break;
                case KeyEvent.VK_W:
                    System.out.println("Player 1: Move up");
                    break;
                case KeyEvent.VK_S:
                    System.out.println("Player 1: Move down");
                    break;
            }
        }

        // TODO change the cell array to the new player position
        if (player.getPlayerNumber() == 2) {
            // Handle player 2 controls
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    System.out.println("Player 2: Move left");
                    break;
                case KeyEvent.VK_RIGHT:
                    System.out.println("Player 2: Move right");
                    break;
                case KeyEvent.VK_UP:
                    System.out.println("Player 2: Move up");
                    break;
                case KeyEvent.VK_DOWN:
                    System.out.println("Player 2: Move down");
                    break;
            }
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
