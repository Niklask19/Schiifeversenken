
import java.util.Scanner;

public class Menu {
    public static void menu(Coordinates[] coordinatesObjArr, Grid[] gridObjArr, Ships[] shipsObjArr) {


        gridObjArr[0].printGrid();
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
        inputMenu(coordinatesObjArr, shipsObjArr);



    }

    public static void inputMenu(Coordinates[] coordinatesObjArr,Ships[] shipsObjArr) {
        Scanner sc = new Scanner(System.in);
        int index = 0;
        while (true) {
            String coordinates = sc.nextLine();
            boolean con1 = splitCoordinates(coordinates, coordinatesObjArr);
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

            index++;
            break;
        }
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
}
