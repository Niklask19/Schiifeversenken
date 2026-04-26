
import java.util.Scanner;

public class Menu {
    private static int playersName = 1;
    private static int playerIndex = 0;

    public static void menu(Coordinates[] coordinatesObjArr, Player[] playerObjArr) {

        while (playerIndex < 2) {
            System.out.println("Player " + playersName + ", place your ships on the game field");
            playerObjArr[playerIndex].grid.printGrid(false);

            while (playerObjArr[playerIndex].getIndexForMenu() < 5) {
                System.out.println("Enter the coordinates of the " + playerObjArr[playerIndex].ships[playerObjArr[playerIndex].getIndexForMenu()].getName() + " " + "(" + playerObjArr[playerIndex].ships[playerObjArr[playerIndex].getIndexForMenu()].getLength() + " cells):");
                if (inputMenu(coordinatesObjArr, playerObjArr)) {
                    playerObjArr[playerIndex].grid.printGrid(false);
                }
            }
            playerIndex++;
            playersName++;
            changePlayersAndClearScreen();
        }

        Gameplay.gameplay(coordinatesObjArr, playerObjArr);
    }

    public static boolean inputMenu(Coordinates[] coordinatesObjArr, Player[] playerObjArr) {
        Scanner sc1 = new Scanner(System.in);

        while (true) {
            String coordinates = sc1.nextLine();
            boolean con1 = splitCoordinates(coordinates, coordinatesObjArr); //values set for coordinates objects fields via this method
            if (!con1) {
                System.out.println("Error! Wrong ship location! Try again:");
                continue;
            }
            int length = coordinatesObjArr[0].getLength(coordinatesObjArr[1]);
            boolean con2 = (length == playerObjArr[playerIndex].ships[playerObjArr[playerIndex].getIndexForMenu()].getLength());
            if (!con2) {
                System.out.println("Error! Wrong length of the Submarine! Try again:");
                continue;
            }

            boolean con3 = playerObjArr[playerIndex].grid.checkIfShipNearBy(coordinatesObjArr, playerObjArr[playerIndex]);
            if (!con3) {
                System.out.println("Error! You placed it too close to another one. Try again:");
                continue;
            }

            playerObjArr[playerIndex].grid.placeOnGrid(coordinatesObjArr, playerObjArr[playerIndex].ships[playerObjArr[playerIndex].getIndexForMenu()]);
            playerObjArr[playerIndex].incrementIndexForMenu(1);
            break;
        }
        return true;
    }

    public static boolean splitCoordinates(String coordinates, Coordinates[] cArray) {
        boolean twoCoordinates = true;
        String[] array;
        if (!coordinates.contains(" ")) {
            twoCoordinates = false;
        }

        if (twoCoordinates) {
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

        if (twoCoordinates) {
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

    public static void changePlayersAndClearScreen() {

        Scanner s = new Scanner(System.in);
        System.out.println("Press Enter and pass the move to another player");
        s.nextLine();
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

    }
}
