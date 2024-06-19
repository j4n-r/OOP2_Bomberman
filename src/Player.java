import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Player extends Cell {
    private int xPos;
    private int yPos;
    private int playerNumber;

    public Player(int xPos, int yPos, int playerNumber) {
        super(xPos, yPos);
        this.xPos = xPos;
        this.yPos = yPos;
        this.playerNumber = playerNumber;

        try {
            Icon brickIcon = new ImageIcon(getClass().getResource("assets/images/playerIcon.png"));
            this.setIcon(brickIcon);
        } catch (Exception error) {
            System.err.println(error);
            System.out.println("Image not found");
        }
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }
}
