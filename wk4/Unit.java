public class Unit {
    
    private Unit() {}

    static Unit onlyUnit;

    static Unit getUnit() {
        if (onlyUnit == null) {
            onlyUnit = new Unit();
        }
        return onlyUnit;
    }
}
