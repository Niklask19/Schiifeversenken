public class Ships {
    private final int length;
    private String[] coordinates;
    private int[][] numCords;
    private int countIndexForNumCords;

    public Ships(int length) {
        this.length = length;
        this.coordinates = new String[length];
        this.numCords = new int[length][1];
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
}

