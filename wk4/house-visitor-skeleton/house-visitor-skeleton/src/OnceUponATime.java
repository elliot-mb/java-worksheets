public class OnceUponATime {

    public static Integer estimateRentPCM(House house) {
        ChartedSurveyor billy = new ChartedSurveyor();
        return house.accept(billy);
    }

    public static Integer estimateHeatingBillPCM(House house) {
        /*
        BillsVisitor bobby = new BillsVisitor();
        return house.accept(bobby);*/
        class UnwantedBillsVisitor implements House.Visitor<Integer>{
            public Integer visit(StrawHouse sr){
                return 4;
            }
            public Integer visit(StickHouse si){
                return 11;
            }
            public Integer visit(BrickHouse bi){
                return 3;
            }
        }
        UnwantedBillsVisitor bobby = new UnwantedBillsVisitor();
        return house.accept(bobby);
    }

    public static String letMeComeIn(House house) {
        BigBadWolf wolf = new BigBadWolf("Wolf");
        return house.accept(wolf);
    }

    public static void main(String[] args) {

        House[] houses = new House[]{new StrawHouse(), new StickHouse(), new BrickHouse()};

        for (House house : houses) {
            System.out.println("Calling functions on: " + house.toString());
            System.out.println( "Estimating rent: " + estimateRentPCM(house) );
            System.out.println( "Estimating heating bill: " + estimateHeatingBillPCM(house) );
            System.out.println( "Here comes the Big Bad Wolf: " + letMeComeIn(house) );
        }

    }

}
