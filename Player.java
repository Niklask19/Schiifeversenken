public class Player {
    protected Grid grid;
    protected Ships[] ships;
    private int indexForMenu;
    private int countSankShips;
    private boolean[] listSankShips;

    public Player() {
        this.grid = new Grid();
        this.ships = new Ships[5];
        initializeShips();
        this.indexForMenu = 0;
        this.countSankShips = 0;
        this.listSankShips = new boolean[5];
    }

    private void initializeShips() {
        this.ships[0] = new Ships("Aircraft Carrier", 5);
        this.ships[1] = new Ships("Battleship", 4);
        this.ships[2] = new Ships("Submarine", 3);
        this.ships[3] = new Ships("Cruiser", 3);
        this.ships[4] = new Ships("Destroyer", 2);
    }

    public int getIndexForMenu() {
        return indexForMenu;
    }

    public void incrementIndexForMenu(int x) {
        this.indexForMenu = this.indexForMenu + x;
    }

    public boolean checkIfShipGotSank() {

        for (int i = 0; i < this.ships.length; i++) {
            if (this.ships[i].getLength() == this.ships[i].getHits() && !this.listSankShips[i]) {
                this.listSankShips[i] = true;
                this.countSankShips++;
                return true;
            }
        }
        return false;
    }

    public int getCountSankShips() {
        return countSankShips;
    }

    public void determineWhichShipGotHit(Coordinates c) {
        for (int i = 0; i < this.ships.length; i++) {
            this.ships[i].determineIfShipGotHit(c);
        }
    }
}
