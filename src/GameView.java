import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class GameView extends JPanel {
    private Cell[][] cellGrid;
    private JPanel mapPanel;
    private int MAP_HEIGHT;
    private int MAP_WIDTH;
    private int CELL_SIZE;

    public GameView(int MAP_HEIGHT, int MAP_WIDTH, int CELL_SIZE) {
        super();
        this.MAP_WIDTH = MAP_WIDTH;
        this.MAP_HEIGHT = MAP_HEIGHT;
        this.CELL_SIZE = CELL_SIZE;
        // initialize 2D array
        cellGrid = new Cell[MAP_HEIGHT][MAP_WIDTH];
        // set layout based on number of cells
        this.setLayout(new GridLayout(MAP_HEIGHT, MAP_WIDTH));

        initcellGrid();

    }

    private void initcellGrid() {
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
        int playerNumber = 0;
        for (int i = 0; i < MAP_HEIGHT; i++) {
            for (int j = 0; j < MAP_WIDTH; j++) {
                switch (layout[i][j]) {
                    case 'P': // cell where a player starts
                        Player player = new Player(i, j, playerNumber);
                        new PlayerController(player);
                        playerNumber++;
                        // set cell size,maybe pass this in the constructor
                        player.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
                        cellGrid[i][j] = player;
                        break;
                    case '#': // unbreakableCell
                        Cell unbreakableCell = new UnbreakableCell(i, j);
                        unbreakableCell.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
                        cellGrid[i][j] = unbreakableCell;
                        break;

                    case 'V': // normal Cell
                        Cell voidCell = new Cell(i, j);
                        voidCell.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
                        cellGrid[i][j] = voidCell;
                        break;
                    case 'X': // breakableCell
                        Cell breakableCell = new BreakableCell(i, j);
                        breakableCell.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
                        cellGrid[i][j] = breakableCell;
                        break;
                }
                // add the cell to the grid layout of the mapPanel
                this.add(cellGrid[i][j]);
            }
        }
    }

    public Cell[][] getCellGrid() {
        return cellGrid;
    }

    public JPanel getMapPanel() {
        return mapPanel;
    }
}
