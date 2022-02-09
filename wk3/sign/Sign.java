public enum Sign {
    POSITIVE("+"), NEGATIVE("-");

    String symbol;

    Sign(String symbol){
        this.symbol = symbol;
    }

    public void tooString(){
        System.out.println(this.symbol);
    }

    public Sign flip(){
        this.symbol = this.symbol == "-" ? "+" : "-";
        return this;
    }
}
