package pokemon;

public class Pikachu extends Pokemon{
    public Pikachu() {
        super("Pikachu", 0, 100, "pikachu.png", new Move[]{new Move("Thunder", 0, 100, 0), new Move("Skull Bash", 0, 150, 0), new Move("Lightning Rod", 0, 200, 4), new Move("Thunder Jolt", 0, 100, 0)});
    }
}
