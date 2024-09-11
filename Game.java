
import java.util.ArrayList;
import java.util.List;

public class Game {
    private static List<String[]> guesses = new ArrayList<String[]>();
    public static int turns;

    public Game(int num_turns){
        Game.turns = num_turns;
    }

    public static void addGuess(String[] guess){
        Game.guesses.add(guess);
    }
}
