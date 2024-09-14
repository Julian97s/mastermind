public class Main {
    public static void main(String[] args){

        String intro_message = "Welcome to mastermind!\nYou will have 7 guesses to macth the hidden passcode,\nthe hidden passcode is composed by 4 colors, you can choose from:\n\nblue\tred\tyellow\tgreen";
        intro_message += "\n\nGood luck!";

        Game game = new Game(7);

        String[] fixed_pass = new String[] {"red","blue","yellow","green"}; // used to text fixed combinations
        
        Passcode new_passcode = new Passcode(fixed_pass);

        System.out.println(intro_message);

        game.Play(game,new_passcode);
        
    }
}


/*
 * im not 100% sure its working with no bus, i believe that sometimes it counts an match AND right color.
 * im tired and im not going to do no more, maybe tomorrow with a fresh mind
 */