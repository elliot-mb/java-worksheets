public class BigBadWolf implements House.Visitor<String> {
    public String name;
    
    BigBadWolf(String name) {
        this.name = name;
    }
    
    public String visit(StrawHouse house) {
        return name + " blows "+ house.occupant.name + "'s house down!";
    }
    public String visit(StickHouse house) {
        return name + "'s huffed and he puffed and he blew " +  house.occupant.name + "'s house down!";
    }
    public String visit(BrickHouse house) {
        return name + " huffed and he puffed but he couldn't blow " + house.occupant.name + "'s house down!";
    }

}
