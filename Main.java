public class Main {
    public static void main(String[] args){

        String intro_message = "Welcome to mastermind!\nYou will have 7 guesses to macth the hidden passcode,\nthe hidden passcode is composed by 4 colors, you can choose from:\n\nblue\tred\tyellow\tgreen";
        intro_message += "\n\nGood luck!";

        Game game = new Game(7);

        String[] fixed_pass = new String[] {"red","blue","yellow","green"}; // used to text fixed combinations
        
        Passcode new_passcode = new Passcode();

        System.out.println(intro_message);

        game.Play(game,new_passcode);
        
    }
}
