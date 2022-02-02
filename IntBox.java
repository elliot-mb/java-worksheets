class IntBox {
    private int x;

    IntBox(int x){
        this.x = x;
    }

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
        return new String("IntBox(" + x + ")");
    }


}
