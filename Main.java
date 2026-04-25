
public class Main {

    public static void main(String[] args) {
        Grid grid1 = new Grid();
        Grid grid2 = new Grid();
        Coordinates c1 = new Coordinates();
        Coordinates c2 = new Coordinates();
        Grid[] gridObjArr = {grid1, grid2};
        Coordinates[] coordinatesObjArr = {c1, c2};
        Ships airCraftCarrier = new Ships("Aircraft Carrier",5);
        Ships battleship = new Ships("Battleship",4);
        Ships submarine = new Ships("Submarine",3);
        Ships cruiser = new Ships("Cruiser",3);
        Ships destroyer = new Ships("Destroyer", 2);
        Ships[] shipsObjArr = {airCraftCarrier, battleship, submarine, cruiser, destroyer};

        Menu.menu(coordinatesObjArr, gridObjArr, shipsObjArr);
    }
}
