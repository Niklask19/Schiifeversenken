
public class Grid {
    private String[][] grid;

    public Grid() {
        this.grid = new String[11][11];
        createGrid();
    }

    public String[][] getGrid() {
        return grid;
    }

    public void createGrid() {
        int num = 1;
        char c = 65;
        grid[0][0] = " ";

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {

                if(i == 0 && j == 0) {
                    grid[i][j] = " ";
                    continue;
                }

                if (i == 0 && j != 0) {
                    grid[i][j] = Integer.toString(num);
                    num++;
                    continue;
                }

                if (i != 0 && j == 0) {
                    grid[i][j] = Character.toString(c);
                    c++;
                    continue;
                }


                grid[i][j] = "~";

            }
        }

    }

    public void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
