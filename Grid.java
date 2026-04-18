
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

                if (i == 0 && j == 0) {
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

    public void placeCoordinates(Coordinates[] cArray) {
        int numRow = changeLetterToNum(cArray);

        if (cArray[0].getRow() == cArray[1].getRow()) {

            if (cArray[0].getCol() > cArray[1].getCol()) {
                int temp = cArray[0].getCol();
                while (temp >= cArray[1].getCol()) {
                    this.grid[numRow][temp] = "0";
                    temp--;
                }
            }

            if (cArray[0].getCol() < cArray[1].getCol()) {
                int temp = cArray[0].getCol();
                while (temp <= cArray[1].getCol()) {
                    this.grid[numRow][temp] = "0";
                    temp++;
                }
            }
        }

        if (cArray[0].getCol() == cArray[1].getCol()) {
            int numCol = cArray[0].getCol();
            int tempNumRow = numRow;

            if (cArray[0].getRow() > cArray[1].getRow()) {
                int count = 0;
                while (count < cArray[0].getLength(cArray[1])) {
                    this.grid[tempNumRow][numCol] = "0";
                    tempNumRow--;
                    count++;
                }
            }

            if (cArray[0].getRow() < cArray[1].getRow()) {
                int count = 0;
                while (count < cArray[0].getLength(cArray[1])) {
                    this.grid[tempNumRow][numCol] = "0";
                    tempNumRow++;
                    count++;
                }
            }
        }
    }

    public static int changeLetterToNum(Coordinates[] cArray) {
        if (cArray[0].getRow() == 'A') {
            return 1;
        }
        if (cArray[0].getRow() == 'B') {
            return 2;
        }
        if (cArray[0].getRow() == 'C') {
            return 3;
        }
        if (cArray[0].getRow() == 'D') {
            return 4;
        }
        if (cArray[0].getRow() == 'E') {
            return 5;
        }
        if (cArray[0].getRow() == 'F') {
            return 6;
        }
        if (cArray[0].getRow() == 'G') {
            return 7;
        }
        if (cArray[0].getRow() == 'H') {
            return 8;
        }
        if (cArray[0].getRow() == 'I') {
            return 9;
        }
        if (cArray[0].getRow() == 'J') {
            return 10;
        }
        return 0;
    }
}
