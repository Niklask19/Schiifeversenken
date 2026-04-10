package battleship;

public class Main {

    public static void main(String[] args) {
        Grid grid1 = new Grid();
        grid1.printGrid();

        String input = Menu.menu();
        Menu.checkInput(input);
        Coordinates[] coordinatesObjArr = Menu.splitCoordinates(input);

    }
}
