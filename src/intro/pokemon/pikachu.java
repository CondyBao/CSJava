package intro.pokemon;

public class pikachu extends Pokemon{
    private Move[] = new Move[]{{"Thunder", 0, 100, },{"Skull Bash", 0, 150, },{"Lightning Rod", 200, }, {"Thunder Jolt", 100, }};

    public pikachu() {
        super("Pikachu", 0, 100, "pikachu.png", moves);
    }
}
