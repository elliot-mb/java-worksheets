public class BillsVisitor implements House.Visitor<Integer> {

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
