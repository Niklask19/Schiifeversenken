
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

    public void placeOnGrid(Coordinates[] cArray) {
        int numRow = changeLetterToNum(cArray[0]);

        if (cArray[0].getRow() == cArray[1].getRow()) {

            if (cArray[0].getCol() > cArray[1].getCol()) {
                int temp = cArray[0].getCol();
                while (temp >= cArray[1].getCol()) {

                    this.grid[numRow][temp] = "O";

                    temp--;
                }
            }

            if (cArray[0].getCol() < cArray[1].getCol()) {
                int temp = cArray[0].getCol();
                while (temp <= cArray[1].getCol()) {

                    this.grid[numRow][temp] = "O";
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

                    this.grid[tempNumRow][numCol] = "O";
                    tempNumRow--;
                    count++;
                }
            }

            if (cArray[0].getRow() < cArray[1].getRow()) {
                int count = 0;
                while (count < cArray[0].getLength(cArray[1])) {

                    this.grid[tempNumRow][numCol] = "O";
                    tempNumRow++;
                    count++;
                }
            }
        }

    }

    public boolean checkIfShipNearBy(Coordinates[] cArray, Ships[] ship) {
        if(cArray[0].getRow() == cArray[1].getRow()) {
            int tempRow = changeLetterToNum(cArray[0]);
            int tempCol = Math.min(cArray[0].getCol(), cArray[1].getCol());
            int count = 0;

           while(count < ship[Menu.index].getLength()) {
               for(int i = tempRow - 1; i <= tempRow + 1; i++) {
                   for(int j = tempCol - 1; j <= tempCol + 1; j++ ) {
                       if(i >= 1 && i <= 10 && j >= 1 && j <= 10) {
                           if(this.grid[i][j].equals("O")) {
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
            int count = 0;

            while(count < ship[Menu.index].getLength()) {
                for(int i = tempRow - 1; i <= tempRow + 1; i++) {
                    for(int j = tempCol - 1; j <= tempCol + 1; j++ ) {
                        if(i >= 1 && i <= 10 && j >= 1 && j <= 10) {
                            if(this.grid[i][j].equals("O")) {
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
