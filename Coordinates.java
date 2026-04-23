
public class Coordinates {
    private char row;
    private int col;

    public Coordinates() {
        this.col = 0;
        this.row = 0;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean checkCoordinates(char row, int column) {

        if (column > 10 || column < 1) {
            return false;
        }
        String forbiddenLetters = "KLMNOPQRSTUVWXYZ";

        for (int i = 0; i < forbiddenLetters.length(); i++) { //check if coordinate contains letter A-J
            if (row == forbiddenLetters.charAt(i)) {
                return false;
            }
        }

        this.setRow(row);
        this.setCol(column);
        return true;
    }

    public boolean checkNearbyShips(int row, int col, Grid[] grids) {
        Grid grid1 = grids[0];
        String[][] tempGrid = grid1.getGrid();
        Grid grid2 = grids[1];

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {

                if (i >= 1 && i <= 10 && j >= 1 && j <= 10) {

                    if (tempGrid[i][j].equals("O")) {
                        return false;
                    }

                }

            }
        }

        return true;
    }

    public boolean sortOutDiagonals(Coordinates x) {
        if (this.row != x.row && this.col != x.col) {
            this.col = 0;
            this.row = 0;
            x.row = 0;
            x.col = 0;
            return false;
        }
        return true;
    }

    public int getLength(Coordinates x) {
        int count = 0;

        if (this.row == x.row) {
            if (this.col > x.col) {
                int tempCol = x.col;
                while (this.col >= tempCol) {
                    tempCol++;
                    count++;
                }                                   //horizontal
            }
            if (this.col < x.col) {
                int tempCol = this.col;
                while (x.col >= tempCol) {
                    tempCol++;
                    count++;
                }
            }
        }

        if (this.col == x.col) {
            if (this.row > x.row) {
                char tempRow = x.row;
                while (this.row >= tempRow) {
                    tempRow++;
                    count++;
                }
            }                                       //vertical
            if (this.row < x.row) {
                char tempRow = this.row;
                while (x.row >= tempRow) {
                    tempRow++;
                    count++;
                }
            }
        }
        return count;
    }

    public String getParts(Coordinates x) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.row).append(this.col).append(" ");

        if (this.row == x.row) {

            if (this.col > x.col) {
                int temp = this.col;
                while (temp > x.col) {
                    temp--;
                    sb.append(this.row).append(temp).append(" ");
                }
            }

            if (this.col < x.col) {
                int temp = this.col;
                while (temp < x.col) {
                    temp++;
                    sb.append(this.row).append(temp).append(" ");
                }
            }
        }

        if (this.col == x.col) {

            if (this.row > x.row) {
                char temp = this.row;
                while (temp > x.row) {
                    temp--;
                    sb.append(temp).append(this.col).append(" ");
                }
            }

            if (this.row < x.row) {
                char temp = this.row;
                while (temp < x.row) {
                    temp++;
                    sb.append(temp).append(this.col).append(" ");
                }
            }
        }
        return sb.toString();
    }

    public int getCol() {
        return col;
    }

    public char getRow() {
        return row;
    }
}
