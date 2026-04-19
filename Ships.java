public class Ships {
    private String name;
    private final int length;
    private boolean horizontal;
    private String[] coordinates;
    private int[][] numCords;
    private int countIndexForNumCords;

    public Ships(String name, int length) {
        this.name = name;
        this.length = length;
        this.coordinates = new String[length];
        this.numCords = new int[length][2];
        this.countIndexForNumCords = 0;
    }

    public int getLength() {
        return length;
    }

    public void setCoordinatesIntoShipField(String coordinates) {

        this.coordinates = coordinates.split(" ");
    }

    public String[] getCoordinates() {
        return coordinates;
    }

    public void setNumCords(int x, int y) {
        this.numCords[this.countIndexForNumCords][0] = x;
        this.numCords[this.countIndexForNumCords][1] = y;
        this.countIndexForNumCords++;
    }

    public int[][] getNumCords() {
        return numCords;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }
}

