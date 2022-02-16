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
        
        if (house.potBoiling) return name + " climbed down " + house.occupant.name + "'s chimney and fell into a pot of boiling water shooting him straight up and back into the woods!";
        else {
            house.occupant.hp = 0;
            return name + " climbed down " + house.occupant.name + "'s chimney and devoured the three pigs!";   
        }
    }

}
