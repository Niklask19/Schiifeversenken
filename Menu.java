
import java.util.Scanner;

public class Menu {
    protected static int index = 0;

    public static void menu(Coordinates[] coordinatesObjArr, Grid[] gridObjArr, Ships[] shipsObjArr) {
        gridObjArr[0].printGrid(false);
        while (index < 5) {
            System.out.println("Enter the coordinates of the " + shipsObjArr[index].getName() + " " + "(" + shipsObjArr[index].getLength() + " cells):");
            if (inputMenu(coordinatesObjArr, shipsObjArr, gridObjArr)) {
                gridObjArr[0].printGrid(false);
            }
        }
        Gameplay.gameplay(gridObjArr, coordinatesObjArr, shipsObjArr);
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

            gridObjArr[0].placeOnGrid(coordinatesObjArr, shipsObjArr[index]);
            index++;
            break;
        }
        return true;
    }

    public static boolean splitCoordinates(String coordinates, Coordinates[] cArray) {
        boolean twoCoordinates = true;
        String[] array;
        if(!coordinates.contains(" ")) {
            twoCoordinates = false;
        }

        if(twoCoordinates) {
            array = coordinates.split(" ");
        } else {
            array = new String[]{coordinates};
        }


        char row1 = array[0].charAt(0);
        int column1 = Integer.parseInt(array[0].substring(1));
        column1--;
        boolean quit1 = cArray[0].checkCoordinates(row1, column1);

        if (!quit1) {
            return false;
        }

        if(twoCoordinates) {
            char row2 = array[1].charAt(0);
            int column2 = Integer.parseInt(array[1].substring(1));
            column2--;
            boolean quit2 = cArray[1].checkCoordinates(row2, column2);

            if (!quit2) {
                return false;
            }

            boolean quit3 = cArray[0].sortOutDiagonals(cArray[1]);

            if (!quit3) {
                return false;
            }
        }
        return true;
    }

}
