
import java.util.Scanner;

public class Menu {
    protected static int index = 0;
    private static int countForSetShipsMenu = 0;

    public static void menu(Coordinates[] coordinatesObjArr, Grid[] gridObjArr, Ships[] shipsObjArr) {
        gridObjArr[0].printGrid();
        while (index < 5) {
            System.out.println("Enter the coordinates of the " + returnShipNamesForOutput());
            if (inputMenu(coordinatesObjArr, shipsObjArr, gridObjArr)) {
                gridObjArr[0].printGrid();
            }
        }
        Gameplay.gameplay(gridObjArr, coordinatesObjArr);
    }

    public static boolean inputMenu(Coordinates[] coordinatesObjArr, Ships[] shipsObjArr, Grid[] gridObjArr) {
        Scanner sc1 = new Scanner(System.in);

        while (true) {
            String coordinates = sc1.nextLine();
            boolean con1 = splitCoordinates(coordinates, coordinatesObjArr); //values set for coordinates objects fields via this method
            if (!con1) {
                System.out.println("Error! Wrong ship location! Try again:");
                continue;
            }
            int length = coordinatesObjArr[0].getLength(coordinatesObjArr[1]);
            boolean con2 = (length == shipsObjArr[index].getLength());
            if (!con2) {
                System.out.println("Error! Wrong length of the Submarine! Try again:");
                continue;
            }

            boolean con3 = gridObjArr[0].checkIfShipNearBy(coordinatesObjArr, shipsObjArr);
            if (!con3) {
                System.out.println("Error! You placed it too close to another one. Try again:");
                continue;
            }
            shipsObjArr[index].setCoordinatesIntoShipField(coordinatesObjArr[0].getParts(coordinatesObjArr[1]));
            gridObjArr[0].placeOnGrid(coordinatesObjArr);
            index++;
            break;
        }
        return true;
    }

    public static boolean splitCoordinates(String coordinates, Coordinates[] cArray) {

        String[] array = coordinates.split(" ");

        char row1 = array[0].charAt(0);
        int column1 = Integer.parseInt(array[0].substring(1));
        boolean quit1 = cArray[0].checkCoordinates(row1, column1);

        if (!quit1) {

            return false;
        }

        char row2 = array[1].charAt(0);
        int column2 = Integer.parseInt(array[1].substring(1));
        boolean quit2 = cArray[1].checkCoordinates(row2, column2);

        if (!quit2) {

            return false;
        }

        boolean quit3 = cArray[0].sortOutDiagonals(cArray[1]);

        if (!quit3) {

            return false;
        }

        return true;
    }

    private static String returnShipNamesForOutput() {
        countForSetShipsMenu++;

        if (countForSetShipsMenu == 1) {
            return "Aircraft Carrier (5 cells):";
        }
        if (countForSetShipsMenu == 2) {
            return "Battleship (4 cells):";
        }
        if (countForSetShipsMenu == 3) {
            return "Submarine (3 cells):";
        }
        if (countForSetShipsMenu == 4) {
            return "Cruiser (3 cells):";
        }
        if (countForSetShipsMenu == 5) {
            return "Destroyer (2 cells):";
        }
        return null;
    }
}
