import java.util.Scanner;

public class Gameplay {

    public static void gameplay(Grid[] grid, Coordinates[] c) {
        Scanner sc2 = new Scanner(System.in);
        System.out.println("\nThe game starts!\n");
        grid[0].printGrid();
        System.out.println("\nTake a shot!\n");

        while (true) {
            String inputShoot = sc2.next();
            if (!(Menu.splitCoordinates(inputShoot, c))) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                continue;
            }
            break;
        }

        boolean hit = grid[0].shoot(c[0]);
        grid[0].printGrid();
        if(hit) {
            System.out.println("\nYou hit a ship!");
        } else {
            System.out.println("\nYou missed!");
        }

    }
}
