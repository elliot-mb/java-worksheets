package sheet2;

public class Chocolate extends Food {

    public String eaten(Animal animal) {return "animal eats chocolate"; }
    public String eaten(Dog d) { return "dog eats chocolate"; }
    public String eaten(Cat c) { return "cat eats chocolate"; }
}
