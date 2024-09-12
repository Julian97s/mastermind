import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        int turn = 0;
        String intro_message = "Welcome to mastermind!\nYou will have 7 guesses to macth the hidden passcode,\nthe hidden passcode is composed by 4 colors, you can choose from:\n\nblue\tred\tyellow\tgreen";
        intro_message += "\n\nGood luck!";
        String last_input = new String();
        boolean is_correct = false;
        boolean repeat = false;

        Game game = new Game(7);

        String[] fixed_pass = new String[] {"red","blue","yellow","green"};
        

        //first ill have to create a passcode when i run the initial program
        Passcode new_passcode = new Passcode();

        Scanner s = new Scanner(System.in);

        System.out.println(intro_message);
        
        
        // should i aim for no logic on main or can i do it for this lab?

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
                System.out.println(current_turn.compareToPasscode(new_passcode.getPasscode()));                
                turn++;
            }
            is_correct = current_turn.isFullMatch();}        
        }
        // send string to Turn, split string at space and store in an array, do a for each loop to check validity of color provided        

        if(is_correct){
            if(!repeat){
                System.out.println("Congratulations you won the game!");
            }
        } else{
            System.out.println(String.format("You didn't guess the passcode,%n%n it was %s better luck next time! ",new_passcode));
        }
        
    }
}
