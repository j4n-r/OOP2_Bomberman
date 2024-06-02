import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GameView extends JFrame {
    // set the grid width and height
    private static final int MAP_WIDTH = 15;
    private static final int MAP_HEIGHT = 15;
    // set the zell size in px
    private static final int CELL_SIZE = 40;
    private Cell[][] cellGrid;

    public GameView() {
        setTitle("Bomberman");
        setSize(MAP_WIDTH * CELL_SIZE, MAP_HEIGHT * CELL_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // initialize 2D array
        cellGrid = new Cell[MAP_HEIGHT][MAP_WIDTH];

        JPanel mapPanel = new JPanel();
        // set layout based on number of cells
        mapPanel.setLayout(new GridLayout(MAP_HEIGHT, MAP_WIDTH));

        initializeAndDisplayMap(mapPanel);
        // add mapPanel to Jfram
        add(mapPanel);
        setVisible(true);

    }

    private void initializeAndDisplayMap(JPanel mapPanel) {
        // 2D array to set cell type hardcoded for now because later we could load maps
        // from a csv or txt file
        // feel free to set a better layout, this is just symmetrical
        char[][] layout = {
                { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
                { '#', 'P', 'V', 'V', 'X', 'V', 'X', 'V', 'X', 'V', 'X', 'V', 'V', 'V', '#' },
                { '#', 'V', '#', 'V', '#', 'V', '#', 'V', '#', 'V', '#', 'V', '#', 'V', '#' },
                { '#', 'V', 'V', 'X', 'V', 'X', 'V', 'X', 'V', 'X', 'V', 'X', 'V', 'V', '#' },
                { '#', 'X', '#', 'V', '#', 'V', '#', 'V', '#', 'V', '#', 'V', '#', 'X', '#' },
                { '#', 'V', 'V', 'X', 'V', 'X', 'V', 'X', 'V', 'X', 'V', 'X', 'V', 'V', '#' },
                { '#', 'X', '#', 'V', '#', 'V', '#', 'V', '#', 'V', '#', 'V', '#', 'X', '#' },
                { '#', 'V', 'V', 'X', 'V', 'X', 'V', 'X', 'V', 'X', 'V', 'X', 'V', 'V', '#' },
                { '#', 'X', '#', 'V', '#', 'V', '#', 'V', '#', 'V', '#', 'V', '#', 'X', '#' },
                { '#', 'V', 'V', 'X', 'V', 'X', 'V', 'X', 'V', 'X', 'V', 'X', 'V', 'V', '#' },
                { '#', 'X', '#', 'V', '#', 'V', '#', 'V', '#', 'V', '#', 'V', '#', 'X', '#' },
                { '#', 'V', 'V', 'X', 'V', 'X', 'V', 'X', 'V', 'X', 'V', 'X', 'V', 'V', '#' },
                { '#', 'V', '#', 'V', '#', 'V', '#', 'V', '#', 'V', '#', 'V', '#', 'V', '#' },
                { '#', 'V', 'V', 'V', 'X', 'V', 'X', 'V', 'X', 'V', 'X', 'V', 'V', 'P', '#' },
                { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
        };

        // loop to populate the cellGrid based on the layut
        for (int i = 0; i < MAP_HEIGHT; i++) {
            for (int j = 0; j < MAP_WIDTH; j++) {
                switch (layout[i][j]) {
                    case 'P': // cell where a player starts
                        Cell cell = new Cell(i, j);
                        // set cell size,maybe pass this in the constructor
                        cell.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
                        cellGrid[i][j] = cell;
                        break;
                    case '#': // unbreakableCell
                        Cell unbreakableCell = new UnbreakableCell(i, j);
                        unbreakableCell.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
                        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
                        unbreakableCell.setBorder(blackBorder);
                        // laod image (maybe also move this part into the constructor)
                        try {
                            Icon wallIcon = new ImageIcon(getClass().getResource("/assets/images/wall.png"));
                            unbreakableCell.setIcon(wallIcon);
                        } catch (Exception error) {
                            System.err.println(error);
                            System.out.println("Image not found");
                        }
                        cellGrid[i][j] = unbreakableCell;
                        break;
                    case 'V': // normal Cell
                        Cell voidCell = new Cell(i, j);
                        voidCell.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
                        cellGrid[i][j] = voidCell;
                        try {
                            Icon grassIcon = new ImageIcon(getClass().getResource("/assets/images/grass.png"));
                            voidCell.setIcon(grassIcon);
                        } catch (Exception error) {
                            System.err.println(error);
                            System.out.println("Image not found");
                        }
                        voidCell.setBorder(null);
                        break;
                    case 'X': // breakableCell
                        Cell breakableCell = new BreakableCell(i, j);
                        breakableCell.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
                        breakableCell.setBackground(Color.GRAY);
                        breakableCell.setBorder(null);
                        try {
                            Icon brickIcon = new ImageIcon(getClass().getResource("assets/images/brick.png"));
                            breakableCell.setIcon(brickIcon);
                        } catch (Exception error) {
                            System.err.println(error);
                            System.out.println("Image not found");
                        }
                        cellGrid[i][j] = breakableCell;
                        break;
                }
                // add the cell to the grid layout of the mapPanel
                mapPanel.add(cellGrid[i][j]);
            }
        }
    }
}
