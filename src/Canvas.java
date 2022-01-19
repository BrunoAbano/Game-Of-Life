import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Canvas {

    int[][] grid;
    int[][] next;
    Rectangle[][] cells;
    int PADDING = 10;
    int cols;
    int rows;
    int cellSize;
    int width;
    int height;

    public Canvas(int cols,int rows, int cellSize){
        this.grid = new int[cols][rows];
        this.next = new int[cols][rows];
        this.cols = cols;
        this.rows = rows;
        this.cellSize = cellSize;
        this.width = cols * cellSize;
        this.height = rows * cellSize;
        this.cells = new Rectangle[cols][rows];
    }

    public void setup(){
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                grid[i][j] = (int) (Math.random() * (2));

                int x = cellSize * i + PADDING;
                int y = cellSize * j + PADDING;
                cells[i][j] = new Rectangle(x, y, cellSize, cellSize);
            }
        }
    }

    public void draw(){
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if(grid[i][j] == 1){
                    this.cells[i][j].setColor(Color.BLACK);
                    this.cells[i][j].fill();
                }else {
                    this.cells[i][j].setColor(Color.BLACK);
                    this.cells[i][j].draw();
                }
            }
        }

        next = new int[cols][rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                int state = grid[i][j];
                int neighbors = countNeighbors(grid, i, j);

                if (state == 0 && neighbors == 3) {
                    next[i][j] = 1;
                } else if (state == 1 && (neighbors < 2 || neighbors > 3)) {
                    next[i][j] = 0;
                } else {
                    next[i][j] = state;
                }

            }
        }

        grid = next;
    }

    private int countNeighbors(int[][]grid, int x, int y){
        int sum = 0;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int col = (x + i + cols) % cols;
                int row = (y + j + rows) % rows;
                sum += grid[col][row];
            }
        }
        sum -= grid[x][y];

        return sum;
    }

}