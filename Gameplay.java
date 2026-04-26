import java.util.Scanner;

public class Gameplay {
    private static int countSankShips = 0;
    private static int[] listSankShips = new int[5];

    public static void gameplay(Grid[] grid, Coordinates[] cArray, Ships[] ships) {
        Scanner sc2 = new Scanner(System.in);
        String inputShoot;
        System.out.println("The game starts!");
        grid[0].printGrid(true);
        System.out.println("Take a shot!");

        while (countSankShips < 5) {
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
                determineWhichShipGotHit(cArray[0], ships);
                boolean sankShip = checkIfShipGotSank(ships);
                if(sankShip) {
                    if(countSankShips != 5) {
                        System.out.println("You sank a ship! Specify a new target:");
                    }

                } else {
                    System.out.println("You hit a ship! Try again:");
                }
            } else {
                System.out.println("You missed! Try again:");
            }
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
            if (ship[i].getLength() == ship[i].getHits() && listSankShips[i] == 0) {
                listSankShips[i] = 1;
                countSankShips++;
                return true;
            }
        }
        return false;
    }
}
