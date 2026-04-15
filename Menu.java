
import java.util.Scanner;

public class Menu {
    public static String menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the coordinates of the ship:");
        String input = sc.nextLine();
        return input;
    }

    public static void splitCoordinates(String coordinates, Coordinates[] cArray) {

        String[] array = coordinates.split(" ");

        char row1 = array[0].charAt(0);
        int column1 = Integer.parseInt(array[0].substring(1));
        boolean quit1 = cArray[0].checkCoordinates(row1, column1);

        if (!quit1) {
            System.out.println("Error!");
            return;
        }

        char row2 = array[1].charAt(0);
        int column2 = Integer.parseInt(array[1].substring(1));
        boolean quit2 = cArray[1].checkCoordinates(row2, column2);

        if (!quit2) {
            System.out.println("Error!");
            return;
        }

        boolean quit3 = cArray[0].sortOutDiagonals(cArray[1]);

        if (!quit3) {
            System.out.println("Error!");
            return;
        }

        outputLengthAndParts(cArray);
    }

    public static void outputLengthAndParts(Coordinates[] cArray) {
        int length = cArray[0].getLength(cArray[1]);
        System.out.println("Length: " + length);
    }

}
