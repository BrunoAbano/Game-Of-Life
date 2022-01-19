public class Main {
    public static void main(String[] args) {
        int cols = 40;
        int rows = 40;
        int cellSize = 15;

        Canvas canvas = new Canvas(cols, rows, cellSize);

        canvas.setup();

        while (true){
            canvas.draw();
        }
    }
}