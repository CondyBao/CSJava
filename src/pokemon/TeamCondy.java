package pokemon;

import java.util.ArrayList;

public class TeamCondy extends PokeTeam{
    public TeamCondy() {
        super("PokeyPokemon");
    }

    @Override
    public ArrayList<Pokemon> createTeam() {
        ArrayList<Pokemon> TeamCondy = new ArrayList<Pokemon>();
        TeamCondy.add(new Pikachu());
        TeamCondy.add(new Bulbasaur());
        TeamCondy.add(new Cucumber());
        return TeamCondy;
    }
}
