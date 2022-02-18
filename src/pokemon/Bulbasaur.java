package pokemon;

public class Bulbasaur extends Pokemon {
    public Bulbasaur() {
        super("Bulbasaur", 2, 70, "bulbasaur.png", new Move[]{new Move("Breathe", 2, 20, 3), new Move("Hypnotize", 2, 20, 1), new Move("Eat", 2, 30, 0), new Move("Combustion", 2, 80, 0)});
    }
}
