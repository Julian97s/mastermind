public class Turn {
    private String input = new String();
    private boolean is_valid;
    private String[] input_array = new String[4];
    private Passcode guess_pass;
    private int matches = 0;
    private boolean stop;
    
    
    public Turn(String given_input){
        this.input_array = given_input.split(" ");
        standarizeInput(this.input_array);
        this.is_valid = false;
        this.stop = false;
    }

    private void standarizeInput(String[] given_input){
        for(String color : this.input_array){
            color.toLowerCase().trim();
        }
    }

    public  boolean isValidInput(){
        if (this.input_array.length != 4){
            System.out.println("please provide a valid input");
            return is_valid;
        }
        for (String color : this.input_array) {
            if(GuessCell.checkColorValidity(color)){
                this.is_valid = true;
            } else {
                System.out.println("please provide a valid input");
                return is_valid = false;
            }
        }
        passcodeFromGuess(this.input_array); 
        return this.is_valid;
    }

    public String printGuessPasscode(){

        String pass_guess = new String();

        for (String color : input_array){
            pass_guess += GuessCell.createCell(color)+"\t";
        }

        return pass_guess;
    }

    private Passcode passcodeFromGuess(String[] given_input){
        return this.guess_pass = new Passcode(given_input);
    }

    public String compareToPasscode(GuessCell[] pass){
        int i =0;
        int contains = 0;
        String output = "matches";
        for(GuessCell cell : pass){
            if (cell.equals(guess_pass.getPasscode()[i])){
                this.matches += 1;
            }
            i++;
        }
        String guess = this.guess_pass.toString();
        String saved_turn = String.format("%s (You got %d matches to the secret passcode) %n", guess, this.matches);
        Game.addGuess(saved_turn);
        String all_guesses = printGuessList();

        return all_guesses;

        
    }

    public String printGuessList(){
        String output = "";
        for(String guess : Game.guesses){
            output += guess + "\n";
        }
        return output;
    }

    public boolean isFullMatch(){
        if (matches == 4){
            this.stop = true;
        }
        return this.stop;
    }



}
