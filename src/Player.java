import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Player extends Cell {
    private int xPos;
    private int yPos;

    public Player(int xPos, int yPos) {
        super(xPos, yPos);
        this.xPos = xPos;
        this.yPos = yPos;

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

}
