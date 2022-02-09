package sheet2;

public class Fruit extends Food {

	//TODO:
    public String eaten(Animal animal) {
        return "animal eats fruit";
    }
    public String eaten(Dog d) { return "dog eats fruit"; }
    public String eaten(Cat c) { return "cat eats fruit"; }
}
