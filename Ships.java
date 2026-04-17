public class Ships {
    private final int length;
    private String[] coordinates;

    public Ships(int length) {
        this.length = length;
        this.coordinates = new String[length];
    }

    public int getLength() {
        return length;
    }
}

