class IntBox {
    private int x;

    IntBox(int x){
        this.x = x;
    }
    IntBox(IntBox that){ this.x = that.x; }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public IntBox add(int v) {
        return new IntBox(x + v);
    }

    public IntBox sub(int v){
        return new IntBox(x - v);
    }

    public IntBox multiply(int v) {
        x = x * v;
        return this;
    }

    @Override
    public String toString() {
        String output = "IntBox(" + x + ")";
        return output;
    }


}
