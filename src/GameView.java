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
    private static final int MAP_WIDTH = 15;
    private static final int MAP_HEIGHT = 15;
    private static final int CELL_SIZE = 40;
    private Cell[][] cellGrid;

    public GameView() {
        setTitle("Bomberman");
        setSize(MAP_WIDTH * CELL_SIZE, MAP_HEIGHT * CELL_SIZE); // Platz für den Rand hinzugefügt
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        cellGrid = new Cell[MAP_HEIGHT][MAP_WIDTH];

        JPanel mapPanel = new JPanel();
        mapPanel.setLayout(new GridLayout(MAP_HEIGHT, MAP_WIDTH));

        initializeAndDisplayMap(mapPanel);
        add(mapPanel);
        setVisible(true);

        // Rufen Sie die Methode zum Initialisieren und Anzeigen der Bomberman-Karte auf
    }

    private void initializeAndDisplayMap(JPanel mapPanel) {
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

        for (int i = 0; i < MAP_HEIGHT; i++) {
            for (int j = 0; j < MAP_WIDTH; j++) {
                switch (layout[i][j]) {
                    case 'P':
                        Cell cell = new Cell(i, j);
                        cell.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
                        cellGrid[i][j] = cell;

                        break;
                    case '#':
                        Cell unbreakableCell = new UnbreakableCell(i, j);
                        unbreakableCell.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
                        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
                        unbreakableCell.setBorder(blackBorder);
                        try {
                            Icon wallIcon = new ImageIcon("assets/images/wall.png");
                            unbreakableCell.setIcon(wallIcon);
                        } catch (Exception error) {
                            System.err.println(error);
                            System.out.println("Image not found");
                        }
                        cellGrid[i][j] = unbreakableCell;
                        break;
                    case 'V':
                        Cell voidCell = new Cell(i, j);
                        voidCell.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
                        cellGrid[i][j] = voidCell;
                        try {
                            Icon grassIcon = new ImageIcon("assets/images/grass.png");
                            voidCell.setIcon(grassIcon);
                        } catch (Exception error) {
                            System.err.println(error);
                            System.out.println("Image not found");
                        }
                        voidCell.setBorder(null);
                        break;
                    case 'X':
                        Cell breakableCell = new BreakableCell(i, j);
                        breakableCell.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
                        breakableCell.setBackground(Color.GRAY);
                        breakableCell.setBorder(null);
                        try {
                            Icon brickIcon = new ImageIcon("assets/images/brick.png");
                            breakableCell.setIcon(brickIcon);
                        } catch (Exception error) {
                            System.err.println(error);
                            System.out.println("Image not found");
                        }
                        cellGrid[i][j] = breakableCell;
                        break;
                }
                mapPanel.add(cellGrid[i][j]);
            }
        }
    }
}
