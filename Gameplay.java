import java.util.Scanner;

public class Gameplay {
    private static int countSankShips = 0;

    public static void gameplay(Grid[] grid, Coordinates[] cArray, Ships[] ships) {
        Scanner sc2 = new Scanner(System.in);
        String inputShoot;
        System.out.println("\nThe game starts!\n");
        grid[0].printGrid(true);
        System.out.println("\nTake a shot!\n");

      while(countSankShips < 5) {
          while (true) {
              inputShoot = sc2.next();
              if (!(Menu.splitCoordinates(inputShoot, cArray))) {
                  System.out.println("Error! You entered the wrong coordinates! Try again:");
                  continue;
              }
              break;
          }

          boolean hit = grid[0].shoot(cArray[0]);
          grid[0].printGrid(true);
          if (hit) {
              System.out.println("\nYou hit a ship!\n");
              determineWhichShipGotHit(cArray[0], ships);
          } else {
              System.out.println("\nYou missed!\n");
          }
          grid[0].printGrid(false);
      }
        System.out.println("You sank the last ship. You won. Congratulations!");
    }


    public static void determineWhichShipGotHit(Coordinates c, Ships[] ship) {
        for (int i = 0; i < ship.length; i++) {
            ship[i].determineIfShipGotHit(c);
        }
    }

    public static boolean checkIfShipGotSank(Ships[] ship) {
        for (int i = 0; i < ship.length; i++) {
            if(ship[i].getLength() == ship[i].getHits()) {
                countSankShips++;
                return true;
            }
        }
        return false;
    }
}
