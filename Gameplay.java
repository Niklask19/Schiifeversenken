import java.util.Scanner;

public class Gameplay {

    public static void gameplay(Coordinates[] cArray, Player[] playerObjArr) {
        Scanner sc2 = new Scanner(System.in);
        String inputShoot;
        int currentPlayer = 0;
        int nextPlayer = 1;

        while (true) {
            playerObjArr[nextPlayer].grid.printGrid(true);
            System.out.println("---------------------");
            playerObjArr[currentPlayer].grid.printGrid(false);
            if (currentPlayer == 0) {
                System.out.println("Player 1, it's your turn:");
            } else {
                System.out.println("Player 2, it's your turn:");
            }

            while (true) {
                inputShoot = sc2.next();
                if (!(Menu.splitCoordinates(inputShoot, cArray))) {
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                    continue;
                }
                break;
            }

            boolean hit = playerObjArr[nextPlayer].grid.shoot(cArray[0]);

            if (hit) {
                playerObjArr[nextPlayer].determineWhichShipGotHit(cArray[0]);
                boolean sankShip = playerObjArr[nextPlayer].checkIfShipGotSank();

                if (playerObjArr[nextPlayer].getCountSankShips() == 5) {
                    System.out.println("You sank the last ship. You won. Congratulations!");
                    break;
                } else if (sankShip) {
                    System.out.println("You sank a ship!");
                } else {
                    System.out.println("You hit a ship!");
                }
            } else {
                System.out.println("You missed!");
            }
            int temp = currentPlayer;
            currentPlayer = nextPlayer;
            nextPlayer = temp;

            Menu.changePlayersAndClearScreen();
        }
    }
}
