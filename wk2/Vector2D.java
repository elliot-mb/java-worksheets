class Vector2D {
    private double x;
    private double y;

    Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Vector2D v){
        double xSqr = (this.x + v.x) * (this.x + v.x);
        double ySqr = (this.y + v.y) * (this.y + v.y);
        return Math.sqrt(xSqr + ySqr);
    }

    public Vector2D add(Vector2D v) {
        return new Vector2D(this.x + v.getX(), this.y + v.getY());;
    }

    public Vector2D scale(double f){
        return new Vector2D(this.x * f, this.y * f);
    }

    public String toString() {
        System.out.println("Vector2D(" + x + ", " + y + ")");
    }
}