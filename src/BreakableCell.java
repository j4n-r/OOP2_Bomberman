import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class BreakableCell extends Cell {

    public BreakableCell(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        this.setBackground(Color.GRAY);
        this.setBorder(null);
        try {
            Icon brickIcon = new ImageIcon(getClass().getResource("assets/images/brick.png"));
            this.setIcon(brickIcon);
        } catch (Exception error) {
            System.err.println(error);
            System.out.println("Image not found");
        }
    }
}
