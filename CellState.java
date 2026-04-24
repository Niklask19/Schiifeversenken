public enum CellState {
    WATER("~"),
    SHIP("O"),
    HIT("X"),
    MISS("M");


    private String symbol;
    CellState(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
