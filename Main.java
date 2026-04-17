
public class Main {

    public static void main(String[] args) {
        Grid grid1 = new Grid();
        Grid grid2 = new Grid();
        Coordinates c1 = new Coordinates();
        Coordinates c2 = new Coordinates();
        Grid[] gridObjArr = {grid1, grid2};
        Coordinates[] coordinatesObjArr = {c1, c2};
        Ships airCraftCarrier = new Ships(5);
        Ships Battleship = new Ships(4);
        Ships Submarine = new Ships(3);
        Ships Cruiser = new Ships(3);
        Ships Destroyer = new Ships(2);
        Ships[] shipsObjArr = {airCraftCarrier, Battleship, Submarine, Cruiser, Destroyer};

        Menu.menu(coordinatesObjArr, gridObjArr, shipsObjArr);


    }
}
