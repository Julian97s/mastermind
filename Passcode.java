
public class Passcode {

    private GuessCell[] pass;

    public Passcode(){
        pass = new GuessCell[4]; 
        setRandomPasscode();
    }

    /** provide an array of string with the desired colors to create a passcode */
    public Passcode(String[] given_pass){
        pass = new GuessCell[4];
        for (int i=0; i<given_pass.length; i++){
            pass[i] = GuessCell.createCell(given_pass[i]);
        }
    }



    // setPasscode will populate the 4 array slots with random colors
    private void setRandomPasscode(){
        for (int i=0; i<pass.length; i++){
            pass[i] = GuessCell.createRandomCell();
        }
    }

    public GuessCell[] getPasscode(){
        return pass;
    }

    @Override
    public String toString(){
        String color_pass = new String();
        for (GuessCell cell : pass) {
            color_pass += cell + "\t";
        }
        return color_pass;
    }

    // call each GuesCell to print it inside a for each loop 

}
