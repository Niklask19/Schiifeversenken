
public class Main {

    public static void main(String[] args) {

        Coordinates c1 = new Coordinates();
        Coordinates c2 = new Coordinates();
        Coordinates[] coordinatesObjArr = {c1, c2};
        Player player1 = new Player();
        Player player2 = new Player();
        Player[] playerObjArr = {player1, player2};

        Menu.menu(coordinatesObjArr, playerObjArr);
    }
}
