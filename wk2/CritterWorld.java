class CritterWorld {
    public static void main(String[] args) {
        Critter cow = new Critter("cow");
        Critter rabbit = new Critter("rabbit");

        cow.poke();
        cow.eat(rabbit);
    }
}