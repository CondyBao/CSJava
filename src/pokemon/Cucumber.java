package pokemon;

public class Cucumber extends Pokemon{
    public Cucumber() {
        super("Cucumber", 3, 40, "cucumber.png", new Move[]{new Move("Sleep", 3, 20, 0), new Move("Tell Jokes", 3, 30, 0), new Move("Laugh", 3, 20, 0), new Move("Combustion", 3, 100, 0)});
    }
}