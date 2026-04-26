public class Player {
    protected Grid grid;
    protected Ships[] ships;
    private int indexForMenu;

    public Player() {
        this.grid = new Grid();
        this.ships = new Ships[5];
        initializeShips();
        this.indexForMenu = 0;
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
}
