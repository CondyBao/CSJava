package pokemon;

public class Bulbasaur extends Pokemon {
    public Bulbasaur() {
        super("Bulbasaur", 2, 150, "bulbasaur.png", new Move[]{new Move("Breathe", 2, 50, 3), new Move("Hypnotize", 2, 30, 1), new Move("Eat", 2, 70, 0), new Move("Combustion", 2, 150, 0)});
    }
}
