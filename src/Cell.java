
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Icon;

public class Cell extends JButton {
    int xCoordinate;
    int yCoordinate;

    public Cell(int xCoordinate, int yCoordinate) {
        super();
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

    }
}
