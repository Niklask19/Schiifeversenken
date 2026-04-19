
public class Grid {
    private String[][] grid;
    private int countShipsOnGridIndex;

    public Grid() {
        this.grid = new String[11][11];
        createGrid();
        this.countShipsOnGridIndex = 0;
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

    public boolean placeOnGrid(Coordinates[] cArray, Ships[] ship) {

        int numRow = changeLetterToNum(cArray[0]);

        if (cArray[0].getRow() == cArray[1].getRow()) {

            ship[this.countShipsOnGridIndex].setHorizontal(true);

            int start = Math.min(cArray[0].getCol(), cArray[1].getCol());
            int end = Math.max(cArray[0].getCol(), cArray[1].getCol());

            int temp = start;
            while (temp <= end) {

                if (this.grid[numRow][temp].equals("0")) {
                    return false;
                }

                if (!cArray[0].checkNearbyShips(numRow, temp, new Grid[]{this, this})) {
                    return false;
                }

                temp++;
            }

            temp = start;
            while (temp <= end) {

                this.grid[numRow][temp] = "0";
                ship[this.countShipsOnGridIndex].setNumCords(numRow, temp);

                temp++;
            }

            this.countShipsOnGridIndex++;
        }

        if (cArray[0].getCol() == cArray[1].getCol()) {

            ship[this.countShipsOnGridIndex].setHorizontal(false);

            int numCol = cArray[0].getCol();

            int start = Math.min(
                    changeLetterToNum(new Coordinates(){{
                        setRow(cArray[0].getRow());
                    }}),
                    changeLetterToNum(new Coordinates(){{
                        setRow(cArray[1].getRow());
                    }})
            );

            int end = Math.max(
                    changeLetterToNum(new Coordinates(){{
                        setRow(cArray[0].getRow());
                    }}),
                    changeLetterToNum(new Coordinates(){{
                        setRow(cArray[1].getRow());
                    }})
            );


            int tempNumRow = numRow;

            int count = 0;
            while (count < cArray[0].getLength(cArray[1])) {

                if (this.grid[tempNumRow][numCol].equals("0")) {
                    return false;
                }

                if (!cArray[0].checkNearbyShips(tempNumRow, numCol, new Grid[]{this, this})) {
                    return false;
                }

                if (cArray[0].getRow() < cArray[1].getRow()) {
                    tempNumRow++;
                } else {
                    tempNumRow--;
                }

                count++;
            }


            tempNumRow = numRow;
            count = 0;

            while (count < cArray[0].getLength(cArray[1])) {

                this.grid[tempNumRow][numCol] = "0";
                ship[this.countShipsOnGridIndex].setNumCords(tempNumRow, numCol);

                if (cArray[0].getRow() < cArray[1].getRow()) {
                    tempNumRow++;
                } else {
                    tempNumRow--;
                }

                count++;
            }

            this.countShipsOnGridIndex++;
        }

        return true;
    }

    public static int changeLetterToNum(Coordinates c) {
        if (c.getRow() == 'A') {
            return 1;
        }
        if (c.getRow() == 'B') {
            return 2;
        }
        if (c.getRow() == 'C') {
            return 3;
        }
        if (c.getRow() == 'D') {
            return 4;
        }
        if (c.getRow() == 'E') {
            return 5;
        }
        if (c.getRow() == 'F') {
            return 6;
        }
        if (c.getRow() == 'G') {
            return 7;
        }
        if (c.getRow() == 'H') {
            return 8;
        }
        if (c.getRow() == 'I') {
            return 9;
        }
        if (c.getRow() == 'J') {
            return 10;
        }
        return 0;
    }
}
