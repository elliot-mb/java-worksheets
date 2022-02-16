public class ChartedSurveyor implements House.VisitorInt {
    public Integer visit(StrawHouse house) {
        return 500;
    }

    public Integer visit(StickHouse house) {
        return 1000;
    }

    public Integer visit(BrickHouse house) {
        return 5000;
    }
}
