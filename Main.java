
public class Main {

    public static void main(String[] args) {
        Grid grid1 = new Grid();
        Coordinates c1 = new Coordinates();
        Coordinates c2 = new Coordinates();
        grid1.printGrid();
        Coordinates[] coordinatesObjArr = {c1, c2};

        String coordinates = Menu.menu();
        Menu.splitCoordinates(coordinates, coordinatesObjArr);



    }
}
