
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Cell extends JButton {
    int xCoordinate;
    int yCoordinate;

    public Cell(int xCoordinate, int yCoordinate) {
        super();
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

        try {
            Icon grassIcon = new ImageIcon(getClass().getResource("/assets/images/grass.png"));
            this.setIcon(grassIcon);
        } catch (Exception error) {
            System.err.println(error);
            System.out.println("Image not found");
        }
        this.setBorder(null);
    }
}
