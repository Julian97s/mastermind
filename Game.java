import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public  static List<String> guesses = new ArrayList<String>();
    public static int turns;
    private int turn;
    private boolean is_correct = false;
    private boolean repeat = false;
    private String last_input = "";

    Scanner s = new Scanner(System.in);

    public Game(int num_turns){
        Game.turns = num_turns;
        this.turn = 0;
    }

    public static void addGuess(String guess){
        Game.guesses.add(guess);
    }

    public void Play(Game game,Passcode hidden_pass){
        while (turn < Game.turns) { 
            if(is_correct){
                System.out.println("Congratulations you won the game!");
                turn = 7;// to exit the while loop
                repeat = true;
            } else{
            System.out.println(String.format("You have %d turns left",7-turn));
            System.out.println("please type 4-color passcode");
            last_input = s.nextLine();
            Turn current_turn = new Turn(last_input);
            if (current_turn.isValidInput()){
                System.out.println(current_turn.compareToPasscode(hidden_pass.getPasscode()));                
                turn++;
            }
            is_correct = current_turn.isFullMatch();}        
        }
        

        if(is_correct){
            if(!repeat){
                System.out.println("Congratulations you won the game!");
            }
        } else{
            System.out.println(String.format("You didn't guess the passcode,%n%n it was %s better luck next time! ",hidden_pass));
        }
    }
}
