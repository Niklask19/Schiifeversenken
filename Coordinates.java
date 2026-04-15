
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

        if(column > 10) {
            return false;
        }
        String forbiddenLetters = "KLMNOPQRSTUVWXYZ";

        for (int i = 0; i < forbiddenLetters.length(); i++) {
            if (row == forbiddenLetters.charAt(i)) {
                return false;
            }
        }




        return true;
    }
}
