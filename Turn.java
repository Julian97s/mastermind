public class Turn {
    private String input = new String();
    private boolean is_valid;
    private String[] input_array = new String[4];
    private Passcode guess_pass;
    
    
    public Turn(String given_input){
        this.input_array = given_input.split(" ");
        standarizeInput(this.input_array);
        this.is_valid = false;
    }

    private void standarizeInput(String[] given_input){
        for(String color : this.input_array){
            color.toLowerCase().trim();
        }
    }

    private void saveGuess(String[] given_guess){
        Game.addGuess(given_guess);
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
        Game.addGuess(this.input_array);
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
        int match = 0;
        int contains = 0;
        String output = "matches";
        for(GuessCell cell : pass){
            if (cell.equals(guess_pass.getPasscode()[i])){
                match += 1;
            }
            i++;
        }
        String guess = this.guess_pass.toString();
        

        return String.format("%s (You got %d matches to the secret passcode) %n", guess, match);

        
    }





}
