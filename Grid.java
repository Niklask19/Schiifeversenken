
public class Grid {
    private CellState[][] grid;

    public Grid() {
        this.grid = new CellState[10][10];
        createGrid();

    }

    public CellState[][] getGrid() {
        return grid;
    }

    public void createGrid() {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {

                grid[i][j] = CellState.WATER;
            }
        }

    }

    public void printGrid(boolean fogOfWar) {
      char letterRow = 'A';
        System.out.print("  ");
        for (int i = 1; i <= 10; i++){
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            System.out.print(letterRow + " ");
            for (int j = 0; j < grid.length; j++) {
                CellState state = grid[i][j];

                if (fogOfWar && state == CellState.SHIP) {
                    System.out.print("~ ");
                } else {
                    System.out.print(state.getSymbol() + " ");
                }
            }
            System.out.println();
            letterRow++;
        }
    }


    public void placeOnGrid(Coordinates[] cArray, Ships currentShip) {
        int row1 = changeLetterToNum(cArray[0]);
        int row2 = changeLetterToNum(cArray[1]);
        int col1 = cArray[0].getCol();
        int col2 = cArray[1].getCol();

        int minRow = Math.min(row1, row2);
        int maxRow = Math.max(row1, row2);
        int minCol = Math.min(col1, col2);
        int maxCol = Math.max(col1, col2);

        for (int i = minRow; i <= maxRow; i++) {
            for (int j = minCol; j <= maxCol; j++) {

                this.grid[i][j] = CellState.SHIP;

                currentShip.setNumCords(i, j);
            }
        }
    }

    public boolean checkIfShipNearBy(Coordinates[] cArray, Player player) {
        int count = 0;
        if(cArray[0].getRow() == cArray[1].getRow()) {
            int tempRow = changeLetterToNum(cArray[0]);
            int tempCol = Math.min(cArray[0].getCol(), cArray[1].getCol());


           while(count < player.ships[player.getIndexForMenu()].getLength()) {
               for(int i = tempRow - 1; i <= tempRow + 1; i++) {
                   for(int j = tempCol - 1; j <= tempCol + 1; j++ ) {
                       if(i >= 0 && i <= 9 && j >= 0 && j <= 9) {
                           if(this.grid[i][j] == CellState.SHIP) {
                               return false;
                           }
                       }
                   }
               }
               tempCol++;
               count++;
           }
        }

        if(cArray[0].getCol() == cArray[1].getCol()) {
            int tempCol = cArray[0].getCol();
            int c1 = changeLetterToNum(cArray[0]);
            int c2 = changeLetterToNum(cArray[1]);
            int tempRow = Math.min(c1,c2);


            while(count < player.ships[player.getIndexForMenu()].getLength()) {
                for(int i = tempRow - 1; i <= tempRow + 1; i++) {
                    for(int j = tempCol - 1; j <= tempCol + 1; j++ ) {
                        if(i >= 0 && i <= 9 && j >= 0 && j <= 9) {
                            if(this.grid[i][j] == CellState.SHIP) {
                                return false;
                            }
                        }
                    }
                }
                tempRow++;
                count++;
            }

        }

        return true;
    }

    public boolean shoot(Coordinates c) {
        int row = changeLetterToNum(c);
        int col = c.getCol();

        if(this.grid[row][col] == CellState.SHIP || this.grid[row][col] == CellState.HIT) {
            this.grid[row][col] = CellState.HIT;
            return true;
        }

        this.grid[row][col] = CellState.MISS;
        return false;
    }

    public static int changeLetterToNum(Coordinates c) {
        if (c.getRow() == 'A') {
            return 0;
        }
        if (c.getRow() == 'B') {
            return 1;
        }
        if (c.getRow() == 'C') {
            return 2;
        }
        if (c.getRow() == 'D') {
            return 3;
        }
        if (c.getRow() == 'E') {
            return 4;
        }
        if (c.getRow() == 'F') {
            return 5;
        }
        if (c.getRow() == 'G') {
            return 6;
        }
        if (c.getRow() == 'H') {
            return 7;
        }
        if (c.getRow() == 'I') {
            return 8;
        }
        if (c.getRow() == 'J') {
            return 9;
        }
        return 10;
    }
}
