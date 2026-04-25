public class Ships {
    private String name;
    private final int length;
    private int[][] numCords;
    private int hits;
    private int countNumCords;

    public Ships(String name, int length) {
        this.name = name;
        this.length = length;
        this.numCords = new int[length][2];
        this.hits = 0;
        this.countNumCords = 0;
    }

    public int getLength() {
        return length;
    }

    public void setNumCords(int x, int y) {
        this.numCords[this.countNumCords][0] = x;
        this.numCords[this.countNumCords][1] = y;
        countNumCords++;
    }

    public int[][] getNumCords() {
        return numCords;
    }

    public String getName() {
        return name;
    }

    public int getHits() {
        return hits;
    }

    public void determineIfShipGotHit(Coordinates c) {
        int row = Grid.changeLetterToNum(c);
        int col = c.getCol();

        for (int i = 0; i < this.numCords.length; i++) {
            if (this.numCords[i][0] == row && this.numCords[i][1] == col) {
                this.hits++;
            }
        }
    }

}


