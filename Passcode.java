public class Passcode {

    GuessCell[] pass;

    public Passcode(){
        pass = new GuessCell[4]; 
        setPasscode();
    }


    // setPasscode will populate the 4 array slots with random colors
    private void setPasscode(){
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
