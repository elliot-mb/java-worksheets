class Critter{

    private String name;

    Critter(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void poke(){
        System.out.println(this.name + " was poked");
    }

    public void eat(Critter c){
            System.out.println(this.name + " eats " + c.getName());
    }
}