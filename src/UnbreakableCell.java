import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

public class UnbreakableCell extends Cell {

    public UnbreakableCell(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate);
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        this.setBorder(blackBorder);
        // laod image (maybe also move this part into the constructor)
        try {
            Icon wallIcon = new ImageIcon(getClass().getResource("/assets/images/wall.png"));
            this.setIcon(wallIcon);
        } catch (Exception error) {
            System.err.println(error);
            System.out.println("Image not found");
        }
    }

}
