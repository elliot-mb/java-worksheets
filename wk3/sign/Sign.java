public enum Sign {
    POSITIVE("+"), NEGATIVE("-");

    String symbol;

    Sign(String symbol){
        this.symbol = symbol;
    }

    public String toString(){
        String val = this.symbol;
        return val;
    }

    public Sign flip(){
        this.symbol = this.symbol == "-" ? "+" : "-";
        return this;
    }
}
