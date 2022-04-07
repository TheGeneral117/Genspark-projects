import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;

public class Hangman {
    private String ans,guess;
    private ArrayList<Character> answer;
    private ArrayList<Character> wrong = new ArrayList<>();
    private char[] correct;
    private Random rand = new Random();
    private Scanner scan = new Scanner(new File("..\\resources\\hangmanWords.txt"));

    public void setAnswer(String input){
        ans = input;
        correct = new char[ans.length()];
        for (int i = 0; i < ans.length(); i++) {
            correct[i]='_';
        }
    }

    public boolean guessCheck(char guess){
        if(ans.contains(String.valueOf(guess))) {
            for (int i = 0; i < answer.size(); i++) {
                if(answer.get(i) == guess)
                    correct[i] = guess;
            }
            return true;
        }
        return false;
    }

    public void setUpGame(){

    }

}
