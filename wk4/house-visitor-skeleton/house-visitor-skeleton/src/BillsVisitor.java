public class BillsVisitor<Integer> implements House.Visitor<java.lang.Integer> {

    public java.lang.Integer visit(StrawHouse sr){
        return 3;
    }
    public java.lang.Integer visit(StickHouse si){
        return 10;
    }
    public java.lang.Integer visit(BrickHouse bi){
        return 2;
    }

}
