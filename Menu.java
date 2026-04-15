
import java.util.Scanner;

public class Menu {
    public static String menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the coordinates of the ship:");
        return sc.nextLine();
    }

    public static Coordinates[] splitCoordinates(String coordinates) {
        Coordinates c1 = new Coordinates();
        Coordinates c2 = new Coordinates();
        String[] array = coordinates.split(" ");

        char row1 = array[0].charAt(0);
        int column1 = Integer.parseInt(array[0].substring(1));
        boolean quit1 = c1.checkCoordinates(row1, column1);

        if(!quit1) {
            System.out.println("Error!");
            return new Coordinates[]{c1, c2};
        }

        char row2 = array[1].charAt(0);
        int column2 = Integer.parseInt(array[1].substring(1));
        boolean quit2 = c2.checkCoordinates(row2, column2);

        if (!quit2) {
            System.out.println("Error!");
            return new Coordinates[]{c1, c2};
        }
        return new Coordinates[]{c1, c2};
    }


}
