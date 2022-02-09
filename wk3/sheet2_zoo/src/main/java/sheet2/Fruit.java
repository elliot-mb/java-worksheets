package sheet2;

public class Fruit extends Food {

	//TODO:
    @Override
    public String eaten(Animal animal) {
        return "animal eats fruit";
    }

    @Override
    public String eaten(Dog d) { return "dog eats fruit"; }

}
