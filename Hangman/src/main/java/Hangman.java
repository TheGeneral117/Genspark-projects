import java.util.ArrayList;
import java.util.Arrays;

public class Hangman {
    private String ans,guess;
    private ArrayList<Character> answer;



    public void setString(String input){
        ans = input;
    }

    public boolean guessCheck(String guess){
        if(ans.contains(guess))
            return true;
        return false;
    }
}
