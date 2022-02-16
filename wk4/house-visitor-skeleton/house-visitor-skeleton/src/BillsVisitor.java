public class BillsVisitor<Integer> implements House.Visitor<java.lang.Integer> {

    public Integer visit(StrawHouse sr){
        return 3;
    }
    public Integer visit(StickHouse si){
        return 10;
    }
    public Integer visit(BrickHouse bi){
        return 2;
    }

}
