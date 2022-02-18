package pokemon;

public class Pikachu extends Pokemon{
    public Pikachu() {
        super("Pikachu", 0, 60, "pikachu.png", new Move[]{new Move("Thunder", 0, 50, 0), new Move("Skull Bash", 0, 100, 0), new Move("Lightning Rod", 0, 150, 4), new Move("Thunder Jolt", 0, 50, 0)});
    }
}
