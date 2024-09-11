import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        int turn = 0;
        String intro_message = "Welcome to mastermind!\nYou will have 7 guesses to macth the hidden passcode,\nthe hidden passcode is composed by 4 colors, you can choose from:\n\nblue\tred\tyellow\tgreen";
        intro_message += "\n\nGood luck!";
        String last_input = new String();

        Game game = new Game(7);

        String[] fixed_pass = new String[] {"red","blue","yellow","green"};
        

        //first ill have to create a passcode when i run the initial program
        Passcode new_passcode = new Passcode(fixed_pass);

        Scanner s = new Scanner(System.in);

        System.out.println(intro_message);
        
        
        // should i aim for no logic on main or can i do it for this lab?

        while (turn < Game.turns) { 
            System.out.println("please type 4-color passcode");
            last_input = s.nextLine();
            Turn current_turn = new Turn(last_input);
            if (current_turn.isValidInput()){
                System.out.println(current_turn.compareToPasscode(new_passcode.getPasscode()));
                turn++;
            }
        }

        // send string to Turn, split string at space and store in an array, do a for each loop to check validity of color provided        


        

        // System.out.println(new_passcode);

        //
    }
}
